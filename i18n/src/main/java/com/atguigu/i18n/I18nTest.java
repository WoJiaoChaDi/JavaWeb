package com.atguigu.i18n;

import org.junit.Test;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

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
     * 4. 可以获取既格式化 Date, 也格式化 Time 的 DateFormat 对象:getDateTimeInstance(int dateStyle, int timeStyle, Locale aLocale)
     * 5. 其中 style 可以取值为: DateFormat 的常量: SHORT, MEDIUM, LONG, FULL. Locale 则为代表国家地区的 Locale 对象
     * 6. 通过 DateFormat 的 format 方法来格式化个 Date 对象到字符串.
     *
     * 7. 若有一个字符串, 如何解析为一个 Date 对象呢 ?
     * I. 先创建 DateFormat 对象: 创建 DateFormat 的子类 SimpleDateFormat 对象 SimpleDateFormat(String pattern).
     *          其中 pattern 为日期, 时间的格式, 例如: yyyy-MM-dd hh:mm:ss
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

    /**
     * NumberFormat: 格式化数字到数字字符串, 或货币字符串的工具类
     * 1. 通过工厂方法获取 NumberFormat 对象
     * NumberFormat.getNumberInstance(locale); //仅格式化为数字的字符串
     * NumberFormat.getCurrencyInstance(locale); //格式为货币的字符串
     *
     * 2. 通过 format 方法来进行格式化
     * 3. 通过 parse 方法把一个字符串解析为一个 Number 类型.
     */
    @Test
    public void testNumberFormat() throws ParseException {
        double d = 123456789.12345d;
        //Locale locale = Locale.US;
        //Locale locale = Locale.CHINA;
        Locale locale = Locale.FRANCE;

        //按照地区，数字格式化
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
        String str = numberFormat.format(d);
        System.out.println(str);

        //按照地区，货币格式化
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
        str = currencyFormat.format(d);
        System.out.println(str);

        //字符串转数字
        str = "123,456,789.123";
        Number num = numberFormat.parse(str);
        System.out.println(num);

        str = "123 456 789,12 €";
        Number currency = currencyFormat.parse(str);
        System.out.println(currency);
    }

    /**
     * MessageFormat: 可以格式化模式字符串
     * 模式字符串: 带占位符的字符串: "Date: {0}, Salary: {1}"
     * 可以通过 format 方法会模式字符串进行格式化
     */
    @Test
    public void testMessageFormat() {
        String str = "Date：{0}， Salary：{1}";

        Date date = new Date();
        double sal = 12345.12;

        String result = MessageFormat.format(str, date, sal);
        System.out.println(result);

        Locale locale = Locale.CHINA;
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);

        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(locale);

        String result2 = MessageFormat.format(str, dateFormat.format(date), currencyInstance.format(sal));
        System.out.println(result2);
    }

    /**
     * ResourceBundle: 资源包类.
     *
     * 1. 在类路径下需要有对应的资源文件: baseName.properties. 其中 baseName 是基名.
     * 2. 可以使用 基名_语言代码_国家代码.properties 来添加不同国家或地区的资源文件. i18n_zh_CN.properties
     * 3. 要求所有基名相同的资源文件的 key 必须完全一致.
     * 4. 可以使用 native2ascii 命令来得到 汉字 对一个的 asc 码. Eclipse 内置了工具
     * 5. 可以调用 ResourceBundle 的 getBundle(基名, Locale 实例) 获取获取 ResourceBundle 对象
     * 6. 可以调用 ResourceBundle 的 getString(key) 来获取资源文件的 value 字符串的值.
     * 7. 结合 DateFormat, NumberFormat, MessageFormat 即可实现国际化.
     *
     */
    @Test
    public void testResourceBundle() {
        //Locale locale = Locale.US;
        Locale locale = Locale.CHINA;
        ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n", locale);
        System.out.println(resourceBundle.getString("date"));
        System.out.println(resourceBundle.getString("salary"));

        //各种国际化联合起来
        String dateLabel = resourceBundle.getString("date");
        String salLabel = resourceBundle.getString("salary");

        String str = "{0}:{1}，{2}:{3}";

        Date date = new Date();
        double sal = 12345.12;

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
        String dateStr = dateFormat.format(date);

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        String salStr = numberFormat.format(sal);

        String result = MessageFormat.format(str, dateLabel, dateStr, salLabel, salStr);
        System.out.println(result);
    }

}
