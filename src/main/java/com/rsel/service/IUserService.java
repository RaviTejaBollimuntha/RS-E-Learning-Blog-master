package com.rsel.service;

import com.rsel.model.Vo.UserVo;

/**
 * Created by BlueT on 2017/3/3.
 */
public interface IUserService {

	/**
	     * Save user data
	     *
	     * @param userVo user data
	     * @return primary key
	     */

    Integer insertUser(UserVo userVo);

    /**
         * Find objects by uid
         * @param uid
         * @return
         */
    UserVo queryUserById(Integer uid);

    /**
         * User login
         * @param username
         * @param password
         * @return
         */
    UserVo login(String username, String password);

    /**
         * Update the user object based on the primary key
         * @param userVo
         * @return
         */
    void updateByUid(UserVo userVo);
}
