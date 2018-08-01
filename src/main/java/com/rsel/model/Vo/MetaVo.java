package com.rsel.model.Vo;

import java.io.Serializable;

/**
 * @author 
 */
public class MetaVo implements Serializable {
	/**
	     * Project primary key
	     */
    private Integer mid;

    /**
         * Name
         */
    private String name;

    /**
         * Project abbreviated name
         */
    private String slug;

    /**
     * 项目类型
     */
    private String type;

    /**
         * Option description
         */
    private String description;

    /**
         * Item sorting
         */
    private Integer sort;

    private Integer parent;

    private static final long serialVersionUID = 1L;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }
}