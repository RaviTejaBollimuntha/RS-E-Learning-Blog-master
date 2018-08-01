package com.rsel.service;

import java.util.List;

import com.rsel.model.Vo.LogVo;

/**
 * Created by BlueT on 2017/3/4.
 */
public interface ILogService {

	/**
	     * Save the operation log
	     *
	     * @param logVo
	     */
    void insertLog(LogVo logVo);

    /**
         * Save
         * @param action
         * @param data
         * @param ip
         * @param authorId
         */
    void insertLog(String action, String data, String ip, Integer authorId);

    /**
         * Get log paging
         * @param page current page
         * @param limit number of pages per page
         * @return log
         */
    List<LogVo> getLogs(int page,int limit);
}
