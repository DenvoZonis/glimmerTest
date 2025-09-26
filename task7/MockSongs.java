import java.util.ArrayList;
import java.util.List;

public class MockSongs {
    public static List<String> getSongStrings(){
        List<String> songs = new ArrayList<>();
        //模拟将要处理的列表
        songs.add("sunrise");
        songs.add("thanks");
        songs.add("$100");
        songs.add("havana");
        songs.add("114514");
        //TODO
        //在这里完成你的代码
        songs.sort((s1, s2) -> {
            //按长度排序
            int compare = Integer.compare(s1.length(), s2.length());
            if (compare != 0) return compare;
            //字母排在数字前面，数字排在其他符号前面
            for (int i = 0; i < s1.length(); i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                //逐字符比较，先判断类别
                if (Character.isLetter(c1)) {
                    if (Character.isLetter(c2)) {
                        compare = Character.compare(c1, c2);
                        if (compare != 0) return compare;
                    } else {
                        //-1就是s1排在前,1就是s2排在前,0就是相等
                        return -1;
                    }
                } else if (Character.isDigit(c1)) {
                    if (Character.isLetter(c2)) {
                        return 1;
                    } else if (Character.isDigit(c2)) {
                        compare = Character.compare(c1, c2);
                        if (compare != 0) return compare;
                    } else {
                        return -1;
                    }
                } else {
                    if (Character.isLetter(c2) || Character.isDigit(c2)) {
                        return 1;
                    } else {
                        compare = Character.compare(c1, c2);
                        if (compare != 0) return compare;
                    }
                }
            }
            //完全相同
            return 0;
        });
        //END
        return songs;
    }

    public static void main(String[] args) {
        System.out.println(getSongStrings());
    }
}