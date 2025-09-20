package xyz.denvo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private static final int PORT = 8000;
    private static final Map<String, String> expressMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        // 初始化一些测试数据
        initializeExpressData();
        // 创建HTTP服务器，监听指定端口
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
        // 设置路由和处理程序
        server.createContext("/query", new QueryHandler());
        // 启动服务器
        server.start();
        System.out.println("Server started on port " + PORT);
    }

    private static void initializeExpressData() {
        // 添加一些测试数据
        //键的构成是  快递单号_手机号
        expressMap.put("SF123456789_13005433678", "1234");
        expressMap.put("JD987654321_19805433168", "5678");
        expressMap.put("YT456789123_13905479698", "9012");
        expressMap.put("ZT789123456_18505433664", "3456");
    }

    static class QueryHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("POST".equals(exchange.getRequestMethod())) {
                // 读取请求体
                InputStream inputStream = exchange.getRequestBody();
                String body = new  String(inputStream.readAllBytes());
                inputStream.close();
                try {
                    // 解析JSON请求（例如：{"trackingNumber":"SF123456789"}）获得单号
                    RequestJson receivedData = JSON.parseObject(body, RequestJson.class);
                    String queryData = receivedData.getTrackingNumber() + "_" + receivedData.getPhone();
                    // 在expressMap中查询取件码，
                    ResponseJson responseJson = new ResponseJson();
                    if (expressMap.containsKey(queryData)) {
                        responseJson.setPick_code(expressMap.get(queryData));
                        responseJson.setMsg("success");
                    } else {
                        responseJson.setPick_code(null);
                        expressMap.keySet().stream().iterator().forEachRemaining(key -> {
                            String[] values = key.split("_");
                            if (values[0].equals(receivedData.getTrackingNumber())) {
                                responseJson.setMsg("手机号不正确或该快递不是您的快递，请检查快递单号和手机号是否正确");
                            } else if (values[1].equals(receivedData.getPhone())) {
                                responseJson.setMsg("快递单号不正确或输入了错误的手机号，请检查快递单号和手机号是否正确");
                            }
                        });
                        if (responseJson.getMsg() == null) {
                            responseJson.setMsg("快递单号不正确且该手机号无快递可取，请检查快递单号和手机号是否正确");
                        }
                    }
                    /*
                    构建响应的json
                    例如：{"pick_code":4096,"msg":"success"}
                    如果找不到快递则是{"pick_code":null,"msg":"根据各种情况写提示信息"}
                    */
                    byte[] response = JSON.toJSONString(responseJson, SerializerFeature.WriteMapNullValue).getBytes();
                    // 发送响应
                    exchange.sendResponseHeaders(200, response.length);
                    try (OutputStream outputStream = exchange.getResponseBody()) {
                        outputStream.write(response);
                    }
                } catch (Exception e) {
                    // 处理异常，返回400状态码(Bad Request)
                    exchange.sendResponseHeaders(400, -1);
                }
            } else {
                // 非POST请求返回405 Method Not Allowed
                exchange.sendResponseHeaders(405, -1);
            }
        }
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