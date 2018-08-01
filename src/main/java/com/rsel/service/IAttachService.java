package com.rsel.service;

import com.github.pagehelper.PageInfo;
import com.rsel.model.Vo.AttachVo;

/**
 * Created by wangq on 2017/3/20.
 */
public interface IAttachService {
	/**
	     * Page Query Attachment
	     * @param page
	     * @param limit
	     * @return
	     */
    PageInfo<AttachVo> getAttachs(Integer page,Integer limit);

    /**
         * Save attachments
         *
         * @param fname
         * @param fkey
         * @param ftype
         * @param author
         */
    void save(String fname, String fkey, String ftype, Integer author);

    /**
         * Query attachments based on attachment id
         * @param id
         * @return
         */
    AttachVo selectById(Integer id);

    /**
         * Remove attachments
         * @param id
         */
    void deleteById(Integer id);
}
