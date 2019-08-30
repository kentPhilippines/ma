package com.pay.gateway.mapper;

import com.pay.gateway.entity.ExceptionOrderEntity;
import com.pay.gateway.entity.ExceptionOrderEntityExample;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ExceptionOrderEntityMapper {
    int countByExample(ExceptionOrderEntityExample example);

    int deleteByExample(ExceptionOrderEntityExample example);

    int deleteByPrimaryKey(@Param("id") Integer id, @Param("createTime") Date createTime);

    int insert(ExceptionOrderEntity record);

    int insertSelective(ExceptionOrderEntity record);

    List<ExceptionOrderEntity> selectByExampleWithBLOBs(ExceptionOrderEntityExample example);

    List<ExceptionOrderEntity> selectByExample(ExceptionOrderEntityExample example);

    ExceptionOrderEntity selectByPrimaryKey(@Param("id") Integer id, @Param("createTime") Date createTime);

    int updateByExampleSelective(@Param("record") ExceptionOrderEntity record, @Param("example") ExceptionOrderEntityExample example);

    int updateByExampleWithBLOBs(@Param("record") ExceptionOrderEntity record, @Param("example") ExceptionOrderEntityExample example);

    int updateByExample(@Param("record") ExceptionOrderEntity record, @Param("example") ExceptionOrderEntityExample example);

    int updateByPrimaryKeySelective(ExceptionOrderEntity record);

    int updateByPrimaryKeyWithBLOBs(ExceptionOrderEntity record);

    int updateByPrimaryKey(ExceptionOrderEntity record);
}