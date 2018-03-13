package com.zhoulin.demo.mapper;

import com.zhoulin.demo.bean.TypeRelation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TypeRelationMapper {

    public TypeRelation getInfoByTRId(long id) throws Exception;

    public Integer addTypeRelation(TypeRelation typeRelation) throws Exception;

    public Integer updateTypeRelationByInfoId(TypeRelation typeRelation) throws Exception;

}
