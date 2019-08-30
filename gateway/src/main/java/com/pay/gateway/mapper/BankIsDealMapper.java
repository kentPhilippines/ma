package com.pay.gateway.mapper;

import com.pay.gateway.entity.BankIsDeal;
import com.pay.gateway.entity.BankIsDealExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface BankIsDealMapper {
    int countByExample(BankIsDealExample example);

    int deleteByExample(BankIsDealExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BankIsDeal record);

    int insertSelective(BankIsDeal record);

    List<BankIsDeal> selectByExample(BankIsDealExample example);

    BankIsDeal selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BankIsDeal record, @Param("example") BankIsDealExample example);

    int updateByExample(@Param("record") BankIsDeal record, @Param("example") BankIsDealExample example);

    int updateByPrimaryKeySelective(BankIsDeal record);

    int updateByPrimaryKey(BankIsDeal record);
}