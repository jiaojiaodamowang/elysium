package com.kiddz.elysium.tutorial;

public class StringInterning {

    public static void main(String[] args) {
        String str1 = new String("aaa");
        str1.intern();
        String str2 = "aaa";
        System.out.println("str1 == str2 ? : " + (str1 == str2));

        String str3 = new String("bbb");
        String str4 = "bbb";
        str3.intern();
        System.out.println("str3 == str4 ? : " + (str3 == str4));

        String str5 = new String("cc") + new String("dd");
        str5.intern();
        String str6 = "ccdd";
        System.out.println("str5 == str6 ? : " + (str5 == str6));

        String str7 = new String("ee") + new String("ff");
        String str8 = "eeff";
        str7.intern();
        System.out.println("str7 == str8 ? : " + (str7 == str8));
    }
}
