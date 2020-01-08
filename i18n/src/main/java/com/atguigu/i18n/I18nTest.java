package com.atguigu.i18n;

import org.junit.Test;

import java.util.Locale;

public class I18nTest{

    @Test
    public void testLocal(){
        Locale locale = Locale.CHINA;
        //zh
        System.out.println(locale.getLanguage());
        //中国
        System.out.println(locale.getDisplayCountry());

        //自己指定语言，国家
        locale = new Locale("en", "US");
        //en
        System.out.println(locale.getLanguage());
        //美国
        System.out.println(locale.getDisplayCountry());
    }
}
