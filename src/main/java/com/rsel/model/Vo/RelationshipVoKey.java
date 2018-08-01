package com.rsel.model.Vo;

import java.io.Serializable;

/**
 * @author 
 */
public class RelationshipVoKey implements Serializable {
	/**
	     * Content primary key
	     */
    private Integer cid;

    /**
         * Project primary key
         */
    private Integer mid;

    private static final long serialVersionUID = 1L;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }
}