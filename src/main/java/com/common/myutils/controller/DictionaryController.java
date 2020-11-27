package com.common.myutils.controller;

import com.common.myutils.common.ResultData;
import com.common.myutils.entity.Dictionary;
import com.common.myutils.mapper.DictionaryMapper;
import com.common.myutils.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/9/8 15:31
 * @description:
 */
@Controller
@RequestMapping("/dictionary")
public class DictionaryController{

    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("/dictionarys")
    @ResponseBody
    public ResultData queryBydictionaryAll(Dictionary dictionary){
        List<Dictionary> dictionaries = dictionaryService.queryByDictionaryAll(dictionary);
        return ResultData.build(ResultData.CODE_STATE_SUCCESS,"返回成功",dictionaries);
    }
}
