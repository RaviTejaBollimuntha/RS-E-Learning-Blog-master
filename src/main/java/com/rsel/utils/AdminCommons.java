package com.rsel.utils;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.rsel.model.Vo.MetaVo;

/**
 * Background public function
 * <p>
 * Created by 13 on 2017/2/21.
 */
@Component
public final class AdminCommons {

	/**
	     * Determine the intersection of category and cat
	     *
	     * @param cats
	     * @return
	     */
    public static boolean exist_cat(MetaVo category, String cats) {
        String[] arr = StringUtils.split(cats, ",");
        if (null != arr && arr.length > 0) {
            for (String c : arr) {
                if (c.trim().equals(category.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static final String[] COLORS = {"default", "primary", "success", "info", "warning", "danger", "inverse", "purple", "pink"};

    public static String rand_color() {
        int r = Tools.rand(0, COLORS.length - 1);
        return COLORS[r];
    }

}
