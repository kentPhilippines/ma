package com.pay.gateway.mapper;

import com.pay.gateway.entity.RunningOrder;
import com.pay.gateway.entity.RunningOrderExample;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RunningOrderMapper {
    int countByExample(RunningOrderExample example);

    int deleteByExample(RunningOrderExample example);

    int deleteByPrimaryKey(@Param("id") Integer id, @Param("createTime") Date createTime);

    int insert(RunningOrder record);

    int insertSelective(RunningOrder record);

    List<RunningOrder> selectByExampleWithBLOBs(RunningOrderExample example);

    List<RunningOrder> selectByExample(RunningOrderExample example);

    RunningOrder selectByPrimaryKey(@Param("id") Integer id, @Param("createTime") Date createTime);

    int updateByExampleSelective(@Param("record") RunningOrder record, @Param("example") RunningOrderExample example);

    int updateByExampleWithBLOBs(@Param("record") RunningOrder record, @Param("example") RunningOrderExample example);

    int updateByExample(@Param("record") RunningOrder record, @Param("example") RunningOrderExample example);

    int updateByPrimaryKeySelective(RunningOrder record);

    int updateByPrimaryKeyWithBLOBs(RunningOrder record);

    int updateByPrimaryKey(RunningOrder record);
}