package com.rsel.service;

import java.util.List;

import com.rsel.model.Vo.RelationshipVoKey;

/**
 * Created by BlueT on 2017/3/18.
 */
public interface IRelationshipService {
	/**
	     * Hold down the key to delete
	     * @param cid
	     * @param mid
	     */
    void deleteById(Integer cid, Integer mid);

    /**
         * Press the primary key to count the number of bars
         * @param cid
         * @param mid
         * @return
         */
    Long countById(Integer cid, Integer mid);


    /**
         * Save the object
         * @param relationshipVoKey
         */
    void insertVo(RelationshipVoKey relationshipVoKey);

    /**
         * Search by id
         * @param cid
         * @param mid
         * @return
         */
    List<RelationshipVoKey> getRelationshipById(Integer cid, Integer mid);
}
