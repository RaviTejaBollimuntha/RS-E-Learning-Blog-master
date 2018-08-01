package com.rsel.utils;


import com.github.pagehelper.PageInfo;
import com.rsel.constant.WebConst;
import com.rsel.model.Vo.ContentVo;
import com.vdurmont.emoji.EmojiParser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Theme public function
 * <p>
 * Created by 13 on 2017/2/21.
 */
@Component
public final class Commons {

    public static String THEME = "themes/default";

    /**
         * Determine if there is data in the page
         *
         * @param paginator
         * @return
         */
    public static boolean is_empty(PageInfo paginator) {
        return paginator == null || (paginator.getList() == null) || (paginator.getList().size() == 0);
    }

    /**
         * Website link
         *
         * @return
         */
    public static String site_url() {
        return site_url("");
    }

    /**
         * Return to the full address under the website link
         *
         * @param sub appended address
         * @return
         */
    public static String site_url(String sub) {
        return site_option("site_url") + sub;
    }

    /**
         * Website title
         *
         * @return
         */
    public static String site_title() {
        return site_option("site_title");
    }

    /**
         * Website configuration item
         *
         * @param key
         * @return
         */
    public static String site_option(String key) {
        return site_option(key, "");
    }

    /**
         * Website configuration item
         *
         * @param key
         * @param defalutValue default value
         * @return
         */
    public static String site_option(String key, String defalutValue) {
        if (StringUtils.isBlank(key)) {
            return "";
        }
        String str = WebConst.initConfig.get(key);
        if (StringUtils.isNotBlank(str)) {
            return str;
        } else {
            return defalutValue;
        }
    }

    /**
         * Intercept string
         *
         * @param str
         * @param len
         * @return
         */
    public static String substr(String str, int len) {
        if (str.length() > len) {
            return str.substring(0, len);
        }
        return str;
    }

    /**
         * Return to topic URL
         *
         * @return
         */
    public static String theme_url() {
        return site_url(Commons.THEME);
    }

    /**
         * Return to the file path under the theme
         *
         * @param sub
         * @return
         */
    public static String theme_url(String sub) {
        return site_url(Commons.THEME + sub);
    }

    /**
         * Return to github avatar address
         *
         * @param email
         * @return
         */
    public static String gravatar(String email) {
        String avatarUrl = "https://github.com/identicons/";
        if (StringUtils.isBlank(email)) {
            email = "user@hanshuai.xin";
        }
        String hash = TaleUtils.MD5encode(email.trim().toLowerCase());
        return avatarUrl + hash + ".png";
    }

    /**
         * Return to article link address
         *
         * @param contents
         * @return
         */
    public static String permalink(ContentVo contents) {
        return permalink(contents.getCid(), contents.getSlug());
    }


    /**
         * Get random numbers
         *
         * @param max
         * @param str
         * @return
         */
    public static String random(int max, String str) {
        return UUID.random(1, max) + str;
    }

    /**
         * Return to article link address
         *
         * @param cid
         * @param slug
         * @return
         */
    public static String permalink(Integer cid, String slug) {
        return site_url("/article/" + (StringUtils.isNotBlank(slug) ? slug : cid.toString()));
    }

    /**
         * Format unix timestamp as date
         *
         * @param unixTime
         * @return
         */
    public static String fmtdate(Integer unixTime) {
        return fmtdate(unixTime, "yyyy-MM-dd");
    }

    /**
         * Format unix timestamp as date
         *
         * @param unixTime
         * @param patten
         * @return
         */
    public static String fmtdate(Integer unixTime, String patten) {
        if (null != unixTime && StringUtils.isNotBlank(patten)) {
            return DateKit.formatDateByUnixTime(unixTime, patten);
        }
        return "";
    }

    /**
         * Display classification
         *
         * @param categories
         * @return
         */
    public static String show_categories(String categories) throws UnsupportedEncodingException {
        if (StringUtils.isNotBlank(categories)) {
            String[] arr = categories.split(",");
            StringBuffer sbuf = new StringBuffer();
            for (String c : arr) {
                sbuf.append("<a href=\"/category/" + URLEncoder.encode(c, "UTF-8") + "\">" + c + "</a>");
            }
            return sbuf.toString();
        }
        return show_categories("default category");
    }

    /**
         * Display label
         *
         * @param tags
         * @return
         */
    public static String show_tags(String tags) throws UnsupportedEncodingException {
        if (StringUtils.isNotBlank(tags)) {
            String[] arr = tags.split(",");
            StringBuffer sbuf = new StringBuffer();
            for (String c : arr) {
                sbuf.append("<a href=\"/tag/" + URLEncoder.encode(c, "UTF-8") + "\">" + c + "</a>");
            }
            return sbuf.toString();
        }
        return "";
    }

    /**
         * Intercept the abstract
         *
         * @param value Article content
         * @param len The number of words to be intercepted
         * @return
         */
    public static String intro(String value, int len) {
        int pos = value.indexOf("<!--more-->");
        if (pos != -1) {
            String html = value.substring(0, pos);
            return TaleUtils.htmlToText(TaleUtils.mdToHtml(html));
        } else {
            String text = TaleUtils.htmlToText(TaleUtils.mdToHtml(value));
            if (text.length() > len) {
                return text.substring(0, len);
            }
            return text;
        }
    }

    /**
         * Display article content, convert markdown to html
         *
         * @param value
         * @return
         */
    public static String article(String value) {
        if (StringUtils.isNotBlank(value)) {
            value = value.replace("<!--more-->", "\r\n");
            return TaleUtils.mdToHtml(value);
        }
        return "";
    }

    /**
         * Display article thumbnails in the order: the first image of the article -> Random access
         *
         * @return
         */
    public static String show_thumb(ContentVo contents) {
        int cid = contents.getCid();
        int size = cid % 20;
        size = size == 0 ? 1 : size;
        return "/user/img/rand/" + size + ".jpg";
    }


    /**
         * An :grinning:awesome :smiley:string &#128516;with a few :wink:emojis!
         * <p>
         * Characters in this format are converted to emoji emoticons
         *
         * @param value
         * @return
         */
    public static String emoji(String value) {
        return EmojiParser.parseToUnicode(value);
    }

    /**
         * Get the first picture of the article
         *
         * @return
         */
    public static String show_thumb(String content) {
        content = TaleUtils.mdToHtml(content);
        if (content.contains("<img")) {
            String img = "";
            String regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>";
            Pattern p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
            Matcher m_image = p_image.matcher(content);
            if (m_image.find()) {
                img = img + "," + m_image.group();
                // Match src
                Matcher m = Pattern.compile("src\\s*=\\s*\'?\"?(.*?)(\'|\"|>|\\s+)").matcher(img);
                if (m.find()) {
                    return m.group(1);
                }
            }
        }
        return "";
    }

    private static final String[] ICONS = {"bg-ico-book", "bg-ico-game", "bg-ico-note", "bg-ico-chat", "bg-ico-code", "bg-ico-image", "bg-ico-web", "bg-ico-link", "bg-ico-design", "bg-ico-lock"};

    /**
         * Show article icon
         *
         * @param cid
         * @return
         */
    public static String show_icon(int cid) {
        return ICONS[cid % ICONS.length];
    }

    /**
         * Get social link address
         *
         * @return
         */
    public static Map<String, String> social() {
        final String prefix = "social_";
        Map<String, String> map = new HashMap<>();
        map.put("weibo", WebConst.initConfig.get(prefix + "weibo"));
        map.put("zhihu", WebConst.initConfig.get(prefix + "zhihu"));
        map.put("github", WebConst.initConfig.get(prefix + "github"));
        map.put("twitter", WebConst.initConfig.get(prefix + "twitter"));
        return map;
    }

}
