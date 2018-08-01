package com.rsel.service;

import com.github.pagehelper.PageInfo;
import com.rsel.model.Bo.CommentBo;
import com.rsel.model.Vo.CommentVo;
import com.rsel.model.Vo.CommentVoExample;

/**
 * Created by BlueT on 2017/3/16.
 */
public interface ICommentService {

	/**
	     * Save the object
	     * @param commentVo
	     */
    String insertComment(CommentVo commentVo);

    /**
         * Get comments under the article
         * @param cid
         * @param page
         * @param limit
         * @return CommentBo
         */
    PageInfo<CommentBo> getComments(Integer cid, int page, int limit);

    /**
     * Get comments under the article
     * @param commentVoExample
     * @param page
     * @param limit
     * @return CommentVo
     */
    PageInfo<CommentVo> getCommentsWithPage(CommentVoExample commentVoExample, int page, int limit);


    /**
         * Query comments based on primary key
         * @param coid
         * @return
         */
    CommentVo getCommentById(Integer coid);


    /**
         * Delete comments, temporarily useless
         * @param coid
         * @param cid
         * @throws Exception
         */
    void delete(Integer coid, Integer cid);

    /**
         * Update comment status
         * @param comments
         */
    void update(CommentVo comments);

}
