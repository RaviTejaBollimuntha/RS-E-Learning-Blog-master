package com.rsel.model.Vo;

import java.io.Serializable;

/**
 * @author 
 */
public class CommentVo implements Serializable {
	/**
	     * comment table primary key
	     */
    private Integer coid;

    /**
         * post table primary key, associated field
         */
    private Integer cid;

    /**
         * GMT unix timestamp when comment is generated
         */
    private Integer created;

    /**
         * Review author
         */
    private String author;

    /**
         * Comment user id
         */
    private Integer authorId;

    /**
         * Comment content author id
         */
    private Integer ownerId;

    /**
         * Commenter Mail
         */
    private String mail;

    /**
         * Commenter URL
         */
    private String url;

    /**
         * Commenter ip address
         */
    private String ip;

    /**
         * Reviewer client
         */
    private String agent;

    /**
         * Comment type
         */
    private String type;

    /**
         * Comment status
         */
    private String status;

    /**
         * Parent review
         */
    private Integer parent;

    /**
         * comments
         */
    private String content;

    private static final long serialVersionUID = 1L;

    public Integer getCoid() {
        return coid;
    }

    public void setCoid(Integer coid) {
        this.coid = coid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
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

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}