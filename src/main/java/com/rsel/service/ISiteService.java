package com.rsel.service;

import com.rsel.dto.MetaDto;
import com.rsel.model.Bo.ArchiveBo;
import com.rsel.model.Bo.BackResponseBo;
import com.rsel.model.Bo.StatisticsBo;
import com.rsel.model.Vo.CommentVo;
import com.rsel.model.Vo.ContentVo;

import java.util.List;

/**
 * Site service
 *
 * Created by 13 on 2017/2/23.
 */
public interface ISiteService {


	/**
	     * Latest comments received
	     *
	     * @param limit
	     * @return
	     */
    List<CommentVo> recentComments(int limit);

    /**
         * Latest published articles
         *
         * @param limit
         * @return
         */
    List<ContentVo> recentContents(int limit);

    /**
         * Query a comment
         * @param coid
         * @return
         */
    CommentVo getComment(Integer coid);

    /**
         * System backup
         * @param bk_type
         * @param bk_path
         * @param fmt
         * @return
         */
    BackResponseBo backup(String bk_type, String bk_path, String fmt) throws Exception;


    /**
         * Get background statistics
         *
         * @return
         */
    StatisticsBo getStatistics();

    /**
         * Query article archive
         *
         * @return
         */
    List<ArchiveBo> getArchives();

    /**
         * Get classification/tag list
         * @return
         */
    List<MetaDto> metas(String type, String orderBy, int limit);

}
