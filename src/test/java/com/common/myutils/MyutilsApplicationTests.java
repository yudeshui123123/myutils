package com.common.myutils;

import com.common.myutils.entity.Dictionary;
import com.common.myutils.service.DictionaryService;
import com.common.myutils.utils.tool;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.tools.Tool;
import java.util.Date;
import java.util.List;

@SpringBootTest
class MyutilsApplicationTests {

    @Autowired
    private DictionaryService dictionaryService;

    @Test
    void contextLoads() {
        System.out.println();
    }

    @Test
    void query(){
        Dictionary dictionary = new Dictionary();
        dictionary.setPId("0");
        List<Dictionary> dictionaries = dictionaryService.queryByDictionaryAll(dictionary);
        System.out.println(123);
    }

    @Test
    void insert(){
        Dictionary dictionary = new Dictionary();
        dictionary.setId(tool.getUuId());
        dictionary.setDataTypeCode("hardwareStore");
        dictionary.setDataType("五金百货");
        Boolean aBoolean = dictionaryService.insertByDictionary(dictionary);
        System.out.println(aBoolean);
    }

    @Test
    void insert2(){
        Dictionary dictionary = new Dictionary();
        dictionary.setId(tool.getUuId());
        dictionary.setPId("631e4dbaca0a4777a4ec1bf6dec675f2");
        dictionary.setDataTypeCode("articlesForDailyUse");
        dictionary.setDataType("生活用品");
        dictionary.setDataValue("3");
        dictionary.setDataText("aaaa8");
        dictionary.setSortNum(11);
        Boolean aBoolean = dictionaryService.insertByDictionary(dictionary);
        System.out.println(aBoolean);
    }

    @Test
    void update(){
        Dictionary dictionary = new Dictionary();
        dictionary.setId("ed55f29f105648cea27c16a198b33eb0");
        dictionary.setSortNum(20);
        dictionaryService.updateByDictionary(dictionary);
    }

    @Test
    void delete(){
        dictionaryService.delByDictionaryId("f998a3b79cb043209a5072664b3c0a14");
        System.out.println(123);
    }

}
