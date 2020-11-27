package com.common.myutils.service.impl;

import com.common.myutils.entity.Dictionary;
import com.common.myutils.mapper.DictionaryMapper;
import com.common.myutils.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/9/7 10:26
 * @description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private DictionaryMapper dictionaryMapper;

    /**
     * 查询字典列表
     *
     * @param dictionary
     * @return
     */
    @Override
    public List<Dictionary> queryByDictionaryAll(Dictionary dictionary) {
        return dictionaryMapper.queryByDictionaryAll(dictionary);
    }


    /**
     * 根据id查询字典数据
     * @param id
     * @return
     */
    @Override
    public Dictionary queryByDictionaryId(String id) {
        return dictionaryMapper.queryDictionaryById(id);
    }

    /**
     * 新增字典数据
     * 判断排序是否有值，如果没有值，查询数据库数据pId为dictionary.getPid()的数据排序到几，然后+1
     * 如果有值，则需要查询的数据排序小于等于dictionary.getOrderNo()的值，将小于等于的数据的orderNo值+1
     *
     * @param dictionary
     * @return
     */
    @Override
    public Boolean insertByDictionary(Dictionary dictionary) {
        Integer integer = 0;
        //判断pid是否有值，如果没有赋值为0
        if(dictionary.getPId() == null || dictionary.getPId().equals("")){
            dictionary.setPId("0");
        }
        //判断排序是否有值，如果没有直接插入数据
        if(dictionary.getSortNum() != null){
            //如果sortNum等于0，设置其结果为1
            if(dictionary.getSortNum() == 0){
                dictionary.setSortNum(1);
            }
            //如果入参的序号大于数据库里最大的序号且大于1,修改序号为最大值+1
            Integer integer1 = dictionaryMapper.queryMaxByPId(dictionary.getPId());
            if(dictionary.getSortNum()-integer1 > 1){
                dictionary.setSortNum(integer1+1);
            }else if(dictionary.getSortNum()-integer1 < 1){
                //修改大于等于此类别的排序
                List<String> strings = dictionaryMapper.queryGreaterOrEqualToByPId(dictionary.getPId(), dictionary.getSortNum());
                dictionaryMapper.updateByDictionaryByIds(strings,1);
            }
        }
        integer = dictionaryMapper.insertByDictionary(dictionary);
        if(integer > 0){
            return true;
        }
        return false;
    }


    /**
     * 修改字典数据
     *
     * @param dictionary
     * @return
     */
    @Override
    public Boolean updateByDictionary(Dictionary dictionary) {
        //判断排序值是否修改，如果修改则需修改其他的排序值
        if(dictionary.getSortNum()!=null){
            Dictionary dictionary1 = dictionaryMapper.queryDictionaryById(dictionary.getId());
            //如果不相等，代表修改了排序值
            if(dictionary1.getSortNum() != dictionary.getSortNum()){
                Integer smallSortNum = null,bigSortNum = null,type = null;

                //判断修改的值是否大于数据库里的最大值，如果打于且大于1，修改要修改的值为数据库最大值
                Integer integer1 = dictionaryMapper.queryMaxByPId(dictionary1.getPId());
                if(dictionary.getSortNum()-integer1 > 1){
                    dictionary.setSortNum(integer1);
                }
                if(dictionary.getSortNum() < dictionary1.getSortNum()){
                    smallSortNum = dictionary.getSortNum();
                    bigSortNum = dictionary1.getSortNum();
                    //执行+1 sql
                    type = 1;
                }
                if(dictionary.getSortNum() > dictionary1.getSortNum()){
                    smallSortNum = dictionary1.getSortNum();
                    bigSortNum = dictionary.getSortNum();
                    //执行-1 sql
                    type = 0;
                }
                //修改大于等于此类别的排序，让排序+1
                List<String> strings = dictionaryMapper.queryIntervalByPId(dictionary1.getPId(), smallSortNum,bigSortNum);
                dictionaryMapper.updateByDictionaryByIds(strings,type);
            }
        }
        //最后执行此条修改
        Integer integer = dictionaryMapper.updateByDictionary(dictionary);
        if(integer > 0){
            return true;
        }
        return false;
    }

    /**
     * 根据id删除数据
     *
     * @param id
     * @return
     */
    @Override
    public Boolean delByDictionaryId(String id) {
        //查询此条要删除的排序值，然后根据pid查询此类型中最大的排序值
        Dictionary dictionary = queryByDictionaryId(id);
        if(dictionary == null){
            return false;
        }
        Integer integer1 = dictionaryMapper.queryMaxByPId(dictionary.getPId());
        //如果相等直接删除，如果不相等让大于等于此排序值的值-1
        if(integer1 != dictionary.getSortNum()){
            //修改大于等于此类别的排序
            List<String> strings = dictionaryMapper.queryGreaterOrEqualToByPId(dictionary.getPId(), dictionary.getSortNum());
            dictionaryMapper.updateByDictionaryByIds(strings,0);
        }
        Integer integer = dictionaryMapper.delByDictionaryId(id);
        if(integer > 0){
            return true;
        }
        return false;
    }
}
