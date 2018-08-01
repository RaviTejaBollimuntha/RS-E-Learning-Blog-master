package com.rsel.model.Vo;

import java.io.Serializable;

/**
 * @author 
 */
public class ContentVo implements Serializable {
	/**
	     * post table primary key
	     */
    private Integer cid;

    /**
         * Content title
         */
    private String title;

    /**
         * Content abbreviated name
         */
    private String slug;

    /**
         * GMT unix timestamp when content is generated
         */
    private Integer created;

    /**
         * GMT unix timestamp when content changes
         */
    private Integer modified;

    /**
         * User id of content
         */
    private Integer authorId;

    /**
         * Content category
         */
    private String type;

    /**
         * Content status
         */
    private String status;

    /**
         * Label list
         */
    private String tags;

    /**
         * Category List
         */
    private String categories;

    /**
         * The number of clicks
         */
    private Integer hits;

    /**
         * The number of comments to which the content belongs
         */
    private Integer commentsNum;

    /**
         * Whether to allow comments
         */
    private Boolean allowComment;

    /**
         * Whether to allow ping
         */
    private Boolean allowPing;

    /**
         * Allowed to appear in the aggregate
         */
    private Boolean allowFeed;

    /**
         * Content text
         */
    private String content;

    private static final long serialVersionUID = 1L;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public Integer getModified() {
        return modified;
    }

    public void setModified(Integer modified) {
        this.modified = modified;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Integer getCommentsNum() {
        return commentsNum;
    }

    public void setCommentsNum(Integer commentsNum) {
        this.commentsNum = commentsNum;
    }

    public Boolean getAllowComment() {
        return allowComment;
    }

    public void setAllowComment(Boolean allowComment) {
        this.allowComment = allowComment;
    }

    public Boolean getAllowPing() {
        return allowPing;
    }

    public void setAllowPing(Boolean allowPing) {
        this.allowPing = allowPing;
    }

    public Boolean getAllowFeed() {
        return allowFeed;
    }

    public void setAllowFeed(Boolean allowFeed) {
        this.allowFeed = allowFeed;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}