package com.rsel.constant;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by BlueT on 2017/3/3.
 */
@Component
public class WebConst {
    public static Map<String, String> initConfig = new HashMap<>();


    public static String LOGIN_SESSION_KEY = "login_user";

    public static final String USER_IN_COOKIE = "S_L_ID";

    /**
         * aes encryption plus salt
         */
    public static String AES_SALT = "0123456789abcdef";

    /**
         * Maximum number of articles obtained
         */
    public static final int MAX_POSTS = 9999;

    /**
         * Maximum page number
         */
    public static final int MAX_PAGE = 100;

    /**
         * The maximum number of characters that can be entered in the article
         */
    public static final int MAX_TEXT_COUNT = 200000;

    /**
         * The maximum number of words that can be entered in the article title
         */
    public static final int MAX_TITLE_COUNT = 200;

    /**
         * How many more clicks are updated to the database
         */
    public static final int HIT_EXCEED = 10;

    /**
         * Upload file up to 1M
         */
    public static Integer MAX_FILE_SIZE = 1048576;

    /**
         * Successful return
         */
    public static String SUCCESS_RESULT = "SUCCESS";

    /**
         * The same article counts only once in 2 hours, no matter how many times you click.
         */
    public static Integer HITS_LIMIT_TIME = 7200;
}
