package com.rsel.utils;

/**
 * Created by BlueT on 2017/3/16.
 */

import java.util.regex.Pattern;

/**
 * Regular tools
 * Provide verification email, mobile phone number, phone number, ID number, number, etc.
 *
 */
public final class PatternKit {

	/**
	     * Verify Email
	     * @param email email address, format: zhangsan@sina.com, zhangsan@xxx.com.cn, xxx represents the mail service provider
	     * @return returns true if validation succeeds, false returns if validation fails
	     */
    public static boolean isEmail(String email) {
        String regex = "\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?";
        return Pattern.matches(regex, email);
    }

    /**
         * Verify ID card number
         * @param idCard Resident ID number 15 or 18, the last digit may be a number or letter
         * @return returns true if validation succeeds, false returns if validation fails
         */
    public static boolean isIdCard(String idCard) {
        String regex = "[1-9]\\d{13,16}[a-zA-Z0-9]{1}";
        return Pattern.matches(regex,idCard);
    }

    public static boolean isImage(String suffix) {
        if(null != suffix && !"".equals(suffix)){
            String regex = "(.*?)(?i)(jpg|jpeg|png|gif|bmp|webp)";
            return Pattern.matches(regex, suffix);
        }
        return false;
    }

    /**
         * Verify mobile phone number (support international format, +86135xxxx... (Chinese mainland), +00852137xxxx... (Hong Kong, China))
         * @param mobile Mobile, Unicom, and telecom carrier number segments
         *<p>Number of moves: 134 (0-8), 135, 136, 137, 138, 139, 147 (expected for TD network card)
         *, 150, 151, 152, 157 (for TD), 158, 159, 187 (not enabled), 188 (for TD)</p>
         *<p>Unicom's number segments: 130, 131, 132, 155, 156 (for world wind), 185 (not enabled), 186 (3g)</p>
         *<p>Telecom segment: 133, 153, 180 (not enabled), 189</p>
         * @return returns true if validation succeeds, false returns if validation fails
         */
    public static boolean isMobile(String mobile) {
        String regex = "(\\+\\d+)?1[34578]\\d{9}$";
        return Pattern.matches(regex,mobile);
    }

    /**
         * Verify fixed phone number
         * @param phone Phone number, format: country (region) phone code + area code (city code) + phone number, such as: +8602085588447
         * <p><b>Country Code:</b> The country code of the country (region) that identifies the phone number. It contains one or more digits from 0 to 9.
         * The number is followed by a space-separated country code. </p>
         * <p><b>Area code (city code):</b> This may contain one or more numbers from 0 to 9, with the region or city code in parentheses -
         * For countries that do not use a region or city code, omit the component. </p>
         * <p><b>Phone number:</b> This contains one or more numbers from 0 to 9 </p>
         * @return returns true if validation succeeds, false returns if validation fails
         */
    public static boolean isPhone(String phone) {
        String regex = "(\\+\\d+)?(\\d{3,4}\\-?)?\\d{7,8}$";
        return Pattern.matches(regex, phone);
    }

    /**
         * Verify integers (positive and negative integers)
         * @param digit An integer between one or more digits 0-9
         * @return returns true if validation succeeds, false returns if validation fails
         */
    public static boolean isDigit(String digit) {
        String regex = "\\-?[1-9]\\d+";
        return Pattern.matches(regex,digit);
    }

    /**
         * Verify integers and floating point numbers (positive and negative integers and positive and negative floating point numbers)
         * @param decimals One or more floating point numbers between 0-9, such as: 1.23, 233.30
         * @return returns true if validation succeeds, false returns if validation fails
         */
    public static boolean isDecimals(String decimals) {
        String regex = "\\-?[1-9]\\d+(\\.\\d+)?";
        return Pattern.matches(regex,decimals);
    }

    /**
         * Verify blank characters
         * @param blankSpace Blank characters, including: spaces, \t, \n, \r, \f, \x0B
         * @return returns true if validation succeeds, false returns if validation fails
         */
    public static boolean isBlankSpace(String blankSpace) {
        String regex = "\\s+";
        return Pattern.matches(regex,blankSpace);
    }

    /**
         * Verify Chinese
         * @param chinese Chinese characters
         * @return returns true if validation succeeds, false returns if validation fails
         */
    public static boolean isChinese(String chinese) {
        String regex = "^[\u4E00-\u9FA5]+$";
        return Pattern.matches(regex,chinese);
    }

    /**
         * Verify Chinese alphanumeric spaces
         * @param chinese Chinese characters
         * @return returns true if validation succeeds, false returns if validation fails
         */
    public static boolean isRealName(String chinese) {
        String regex = "^[A-Za-z0-9\\s\u4E00-\u9FA5]+$";
        return Pattern.matches(regex,chinese);
    }

    /**
         * Check if it is a number
         * @param str
         * @return
         */
    public static boolean isNumber(String str) {
        String regex = "^[1-9]\\d*$";
        return Pattern.matches(regex,str);
    }

    /**
         * Verify student ID number
         * @param num
         * @return
         */
    public static boolean isStudentNum(String num) {
        String regex = "^[A-Za-z0-9-_]+$";
        return Pattern.matches(regex,num);
    }

    /**
         * Verification date (year, month, day)
         * @param birthday Date, format: 1992-09-03, or 1992.09.03
         * @return returns true if validation succeeds, false returns if validation fails
         */
    public static boolean isBirthday(String birthday) {
        String regex = "^(\\d{4})-(\\d{2})-(\\d{2})$";
        return Pattern.matches(regex,birthday);
    }

    /**
         * Verify URL address
         * @param url Format: http://blog.csdn.net:80/xyang81/article/details/7705960? or http://www.csdn.net:80
         * @return returns true if validation succeeds, false returns if validation fails
         */
    public static boolean isURL(String url) {
        String regex = "(https?://(w{3}\\.)?)?\\w+\\.\\w+(\\.[a-zA-Z]+)*(:\\d{1,5})?(/\\w*)*(\\??(.+=.*)?(&.+=.*)?)?";
        return Pattern.matches(regex, url);
    }

    /**
         * Match Chinese postal code
         * @param postcode postal code
         * @return returns true if validation succeeds, false returns if validation fails
         */
    public static boolean isPostcode(String postcode) {
        String regex = "[1-9]\\d{5}";
        return Pattern.matches(regex, postcode);
    }

    /**
         * Match IP address (simple match, format, such as: 192.168.1.1, 127.0.0.1, no matching IP segment size)
         * @param ipAddress IPv4 standard address
         * @return returns true if validation succeeds, false returns if validation fails
         */
    public static boolean isIpAddress(String ipAddress) {
        String regex = "[1-9](\\d{1,2})?\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))";
        return Pattern.matches(regex, ipAddress);
    }
}
