package xyz.denvo;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Client {
    private static final String SERVER_URL = "http://localhost:8000/query";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            //读取用户输入的快递单号和手机号
            System.out.println("请输入快递单号:");
            String order = scanner.nextLine();
            System.out.println("请输入手机号:");
            String phone = scanner.nextLine();
            try {
                /*
                用fastjson这个依赖构造json格式，构造的样例为
                {"trackingNumber":"SF123456789","phone":"19867653558"}
                */
                RequestJson requestJson = new RequestJson();
                requestJson.setTrackingNumber(order);
                requestJson.setPhone(phone);
                // 将这个json格式的数据写入请求体并发送HTTP POST请求
                HttpURLConnection connection = (HttpURLConnection) new URL(SERVER_URL).openConnection();
                connection.setRequestMethod("POST");
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                try (OutputStream os = connection.getOutputStream()) {
                    os.write(JSON.toJSONString(requestJson).getBytes());
                }
                // 读取响应，状态码是200才是响应成功
                if (connection.getResponseCode() == 200) {
                   /*
                   解析服务端响应的json格式，拿到取件码，拿不到就显示msg的内容
                   样例：
                   例如：{"pick_code":4096,"msg":"success"}
                   		{"pick_code":null,"msg":"手机号不正确"}
                   */
                    try (InputStream is = connection.getInputStream()) {
                        ResponseJson responseJson = JSON.parseObject(new String(is.readAllBytes()), ResponseJson.class);
                        if (responseJson.getPick_code() != null) {
                            System.out.println("取件码:" + responseJson.getPick_code());
                            break;
                        } else {
                            System.out.println("取件发生错误!消息:" + responseJson.getMsg());
                        }
                    }

                } else {
                    System.out.println("查询失败，状态码: " + connection.getResponseCode());
                }
            } catch (IOException e) {
                System.out.println("请求发生错误: " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("客户端已退出");
    }

    //以下为json对象
    private static class RequestJson {
        String trackingNumber, phone;

        public String getTrackingNumber() {
            return trackingNumber;
        }

        public void setTrackingNumber(String trackingNumber) {
            this.trackingNumber = trackingNumber;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
    private static class ResponseJson {
        String pick_code, msg;

        public String getPick_code() {
            return pick_code;
        }

        public void setPick_code(String pick_code) {
            this.pick_code = pick_code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}