package com.rsel.dto;

public enum Types {
    TAG("tag"),
    CATEGORY("category"),
    ARTICLE("post"),
    PUBLISH("publish"),
    PAGE("page"),
    DRAFT("draft"),
    LINK("link"),
    IMAGE("image"),
    FILE("file"),
    CSRF_TOKEN("csrf_token"),
    COMMENTS_FREQUENCY("comments:frequency"),
    HITS_FREQUENCY("hits:frequency"),

    /**
         * The URL of the attachment is the default website address. If the third party is integrated, it is a third-party CDN domain name.
         */
    ATTACH_URL("attach_url"),

    /**
         * Website to be filtered, ip list forbidden to access
         */
    BLOCK_IPS("site_block_ips");


    private String type;

    public java.lang.String getType() {
        return type;
    }

    public void setType(java.lang.String type) {
        this.type = type;
    }

    Types(java.lang.String type) {
        this.type = type;
    }
}
