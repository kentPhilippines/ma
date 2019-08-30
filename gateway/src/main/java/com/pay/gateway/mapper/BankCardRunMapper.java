package com.pay.gateway.mapper;

import com.pay.gateway.entity.BankCardRun;
import com.pay.gateway.entity.BankCardRunExample;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface BankCardRunMapper {
    int countByExample(BankCardRunExample example);

    int deleteByExample(BankCardRunExample example);

    int deleteByPrimaryKey(@Param("id") Integer id, @Param("createTime") Date createTime);

    int insert(BankCardRun record);

    int insertSelective(BankCardRun record);

    List<BankCardRun> selectByExample(BankCardRunExample example);

    BankCardRun selectByPrimaryKey(@Param("id") Integer id, @Param("createTime") Date createTime);

    int updateByExampleSelective(@Param("record") BankCardRun record, @Param("example") BankCardRunExample example);

    int updateByExample(@Param("record") BankCardRun record, @Param("example") BankCardRunExample example);

    int updateByPrimaryKeySelective(BankCardRun record);

    int updateByPrimaryKey(BankCardRun record);
}