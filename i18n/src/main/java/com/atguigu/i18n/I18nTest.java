package com.atguigu.i18n;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class I18nTest{

    /**
     * Locale: Java 中表示国家或地区的类. JDK 中提供了很多常量.
     * 也可以通过 Locale(languageCode, countryCode) 的方式来创建
     * 在 WEB 应用中可以通过 request.getLocale() 方法来获取.
     */
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

    /**
     * DateFormat: 格式化日期的工具类.
     * DateFormate 本身是一个抽象类.
     *
     * 1. 若只希望通过 DateFormat 把一个 Date 对象转为一个字符串, 则可以通过 DateFormat 的工厂方法来获取 DateFormat 对象
     * 2. 可以获取只格式化 Date 的 DateFormat 对象: getDateInstance(int style, Locale aLocale)
     * 3. 可以获取只格式化 Time 的 DateFormat 对象: getTimeInstance(int style, Locale aLocale)
     * 4. 可以获取既格式化 Date, 也格式化 Time 的 DateFormat 对象:
     * getDateTimeInstance(int dateStyle, int timeStyle, Locale aLocale)
     * 5. 其中 style 可以取值为: DateFormat 的常量: SHORT, MEDIUM, LONG, FULL. Locale 则为代表国家地区的 Locale 对象
     * 6. 通过 DateFormat 的 format 方法来格式化个 Date 对象到字符串.
     *
     * 7. 若有一个字符串, 如何解析为一个 Date 对象呢 ?
     * I. 先创建 DateFormat 对象: 创建 DateFormat 的子类 SimpleDateFormat 对象
     * SimpleDateFormat(String pattern).
     * 其中 pattern 为日期, 时间的格式, 例如: yyyy-MM-dd hh:mm:ss
     * II. 调用 DateFormat 的 parse 方法来解析字符串到 Date 对象.
     *
     */
    @Test
    public void testDateFormat() {
        //Date对象转字符串

        //定义地区
        Locale locale = Locale.CHINA;
        //Locale locale = Locale.US;

        Date date = new Date();
        System.out.println(date);

        //创建 DateFormat 对象，分别定义 日期风格、时间风格、地区 的DateFormat对象
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, locale);
        String str = dateFormat.format(date);
        System.out.println(str);

        dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        str = dateFormat.format(date);
        System.out.println(str);

        dateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, locale);
        str = dateFormat.format(date);
        System.out.println(str);
    }

    @Test
    public void testDateFormat2() throws ParseException {
        //字符串转Date对象
        String str = "1990-12-12 12:12:12";
        DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = dateFormat.parse(str);
        System.out.println(date);
    }



}
