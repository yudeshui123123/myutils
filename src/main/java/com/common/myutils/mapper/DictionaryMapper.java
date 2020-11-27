package com.common.myutils.mapper;

import com.common.myutils.entity.Dictionary;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/9/4 16:59
 * @description:
 * 字典数据层
 */
@Repository
public interface DictionaryMapper {

    /**
     * 查询字典列表
     * @param dictionary
     * @return
     */
    List<Dictionary> queryByDictionaryAll(Dictionary dictionary);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    Dictionary queryDictionaryById(@Param("id") String id);

    /**
     * 根据pId查询SortNum大于等于SortNum的数据
     * @param pId
     * @param sortNum
     * @return
     */
    List<String> queryGreaterOrEqualToByPId(@Param("pId")String pId,@Param("sortNum")Integer sortNum);

    /**
     * 查询在smallSortNum-bigSortNum之间的sortNum数据
     * @param pId
     * @param smallSortNum
     * @param bigSortNum
     * @return
     */
    List<String> queryIntervalByPId(@Param("pId")String pId,@Param("smallSortNum")Integer smallSortNum,@Param("bigSortNum")Integer bigSortNum);

    /**
     * 根据pid查询数量
     * @param pId
     * @return
     */
    Integer queryMaxByPId(@Param("pId")String pId);

    /**
     * 新增字典数据
     * @param dictionary
     * @return
     */
    Integer insertByDictionary(Dictionary dictionary);

    /**
     * 修改字典数据
     * @param dictionary
     * @return
     */
    Integer updateByDictionary(Dictionary dictionary);

    /**
     * 根据id修改排序值
     * @param ids
     * @param type 0 值 -1 ，1 值 +1
     * @return
     */
    Integer updateByDictionaryByIds(@Param("ids") List<String> ids,@Param("type")Integer type);

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    Integer delByDictionaryId(@Param("id")String id);
}
