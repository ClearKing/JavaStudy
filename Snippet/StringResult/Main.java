

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<List<String>> fatherList = new LinkedList<>();
        List<String> childList = new ArrayList<>();
        childList.add("before add child list");
        fatherList.add(childList);
        childList.add("after add child list");
        System.out.println(fatherList);

        String s1 = "hello";
        String s2 = "world";
        System.out.println(s1 +"-----" + s2);
//        change(s1, s2);

    }

    public static void change (StringBuffer sb1, StringBuffer sb2) {
        sb1 = sb2;
        sb2.append(sb1);
    }

//    public static void change(String s1, String s2){
//          s1 = s2;
//          s2 = s1 + s2
//    }
}
