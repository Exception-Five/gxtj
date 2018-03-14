package com.zhoulin.demo.mapper;

import com.zhoulin.demo.bean.Info;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InfoMapper {

    public Info getInfoByInfoId(long infoId) throws Exception;

    public Integer updateInfo(Info info) throws Exception;

    public Integer deleteInfoById(long infoId) throws Exception;

    public List<Info> findAll() throws Exception;

    public List<Info> findInfoByDate(int limitNum) throws Exception;

}
