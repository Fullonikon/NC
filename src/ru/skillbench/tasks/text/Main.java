package ru.skillbench.tasks.text;


import ru.skillbench.tasks.javaapi.collections.StringFilterImpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
/*        StringFilterImpl impl = new StringFilterImpl();

        impl.add("aaa");
        impl.add("bbb");
        impl.add("ccc");
        impl.add("ccc");
        impl.add(null);


        System.out.println(impl.getStringsContaining("a").next());*/
        Pattern p = Pattern.compile("price");

        var a = p.matcher("pro*");

        System.out.println(a.find());

    }

}
