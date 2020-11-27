package com.common.myutils.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/9/4 16:57
 * @description:
 * 字典实体类
 */
@Data
public class Dictionary {
    private String id;
    private String pId;
    private String dataTypeCode;
    private String dataType;
    private String dataValue;
    private String dataText;
    private Integer sortNum;
    private String status;
    private String dataDescribe;
    @DateTimeFormat(pattern ="yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern ="yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @DateTimeFormat(pattern ="yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern ="yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date modifyTime;

    private List<Dictionary> dictionaryList;
}
