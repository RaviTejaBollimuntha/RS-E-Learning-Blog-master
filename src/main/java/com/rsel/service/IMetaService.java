package com.rsel.service;

import com.rsel.dto.MetaDto;
import com.rsel.model.Vo.MetaVo;

import java.util.List;

/**
 * Classification information service interface
 * Created by BlueT on 2017/3/17.
 */
public interface IMetaService {
	/**
	     * Query items by type and name
	     *
	     * @param type
	     * @param name
	     * @return
	     */
    MetaDto getMeta(String type, String name);

    /**
         * Get the number of items based on the article id
         * @param mid
         * @return
         */
    Integer countMeta(Integer mid);

    /**
         * Query item list by type
         * @param types
         * @return
         */
    List<MetaVo> getMetas(String types);


    /**
         * Save multiple projects
         * @param cid
         * @param names
         * @param type
         */
    void saveMetas(Integer cid, String names, String type);

    /**
         * Save project
         * @param type
         * @param name
         * @param mid
         */
    void saveMeta(String type, String name, Integer mid);

    /**
         * Query the list of items according to the type, with the number of articles below the item
         * @return
         */
    List<MetaDto> getMetaList(String type, String orderby, int limit);

    /**
         * Delete item
         * @param mid
         */
    void delete(int mid);
    /**
         * Save project
         * @param metas
         */
    void saveMeta(MetaVo metas);

    /**
         * Update project
         * @param metas
         */
    void update(MetaVo metas);
}
