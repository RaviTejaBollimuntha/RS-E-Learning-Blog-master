package com.rsel.service;

import java.util.List;
import java.util.Map;

import com.rsel.model.Vo.OptionVo;

/**
 * options interface
 * Created by BlueT on 2017/3/7.
 */
public interface IOptionService {

    void insertOption(OptionVo optionVo);

    void insertOption(String name, String value);

    List<OptionVo> getOptions();

    /**
         * Save a set of configurations
         *
         * @param options
         */
    void saveOptions(Map<String, String> options);

    OptionVo getOptionByName(String name);
}
