package com.rsel.service;

import com.github.pagehelper.PageInfo;
import com.rsel.model.Vo.ContentVo;
import com.rsel.model.Vo.ContentVoExample;

/**
 * Created by Administrator on 2017/3/13 013.
 */
public interface IContentService {

	/**
	* Save the article
	 * @param contentVo contentVo
	 */
	// void insertContent(ContentVo contentVo);
        /**
	     * post article
	     * @param contents
	     */
    String publish(ContentVo contents);

    /**
         *Query article returns multiple pieces of data
         * @param p current page
         * @param limit number of pages per page
         * @return ContentVo
         */
    PageInfo<ContentVo> getContents(Integer p, Integer limit);


    /**
         * Get articles based on id or slug
         *
         * @param id id
         * @return ContentVo
         */
    ContentVo getContents(String id);

    /**
         * Updated according to the primary key
         * @param contentVo contentVo
         */
    void updateContentByCid(ContentVo contentVo);


    /**
         * Query article archive under category/label
         * @param mid mid
         * @param page page
         * @param limit limit
         * @return ContentVo
         */
    PageInfo<ContentVo> getArticles(Integer mid, int page, int limit);

    /**
         * Search, page
         * @param keyword keyword
         * @param page page
         * @param limit limit
         * @return ContentVo
         */
    PageInfo<ContentVo> getArticles(String keyword,Integer page,Integer limit);


    /**
     * @param commentVoExample
     * @param page
     * @param limit
     * @return
     */
    PageInfo<ContentVo> getArticlesWithpage(ContentVoExample commentVoExample, Integer page, Integer limit);
    /**
         * Deleted according to the article id
         * @param cid
         */
    String deleteByCid(Integer cid);

    /**
         * Edit article
         * @param contents
         */
    String updateArticle(ContentVo contents);


    /**
         * Update the category of the original article
         * @param ordinal
         * @param newCatefory
         */
    void updateCategory(String ordinal,String newCatefory);
}
