package com.common.myutils.service;

import com.common.myutils.entity.Dictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/9/7 10:25
 * @description:
 */
public interface DictionaryService {

    /**
     * 查询字典列表
     * @param dictionary
     * @return
     */
    List<Dictionary> queryByDictionaryAll(Dictionary dictionary);

    /**
     * 根据id查询字典数据
     * @param id
     * @return
     */
    Dictionary queryByDictionaryId(String id);

    /**
     * 新增字典数据
     * @param dictionary
     * @return
     */
    Boolean insertByDictionary(Dictionary dictionary);

    /**
     * 修改字典数据
     * @param dictionary
     * @return
     */
    Boolean updateByDictionary(Dictionary dictionary);

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    Boolean delByDictionaryId(String id);
}
