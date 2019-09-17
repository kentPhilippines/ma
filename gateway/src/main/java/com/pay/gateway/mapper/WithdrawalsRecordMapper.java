package com.pay.gateway.mapper;

import com.pay.gateway.entity.WithdrawalsRecord;
import com.pay.gateway.entity.WithdrawalsRecordExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface WithdrawalsRecordMapper {
    int countByExample(WithdrawalsRecordExample example);

    int deleteByExample(WithdrawalsRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WithdrawalsRecord record);

    int insertSelective(WithdrawalsRecord record);

    List<WithdrawalsRecord> selectByExampleWithBLOBs(WithdrawalsRecordExample example);

    List<WithdrawalsRecord> selectByExample(WithdrawalsRecordExample example);

    WithdrawalsRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WithdrawalsRecord record, @Param("example") WithdrawalsRecordExample example);

    int updateByExampleWithBLOBs(@Param("record") WithdrawalsRecord record, @Param("example") WithdrawalsRecordExample example);

    int updateByExample(@Param("record") WithdrawalsRecord record, @Param("example") WithdrawalsRecordExample example);

    int updateByPrimaryKeySelective(WithdrawalsRecord record);

    int updateByPrimaryKeyWithBLOBs(WithdrawalsRecord record);

    int updateByPrimaryKey(WithdrawalsRecord record);
}