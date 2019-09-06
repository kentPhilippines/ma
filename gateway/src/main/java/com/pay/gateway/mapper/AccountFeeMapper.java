package com.pay.gateway.mapper;

import com.pay.gateway.entity.AccountFee;
import com.pay.gateway.entity.AccountFeeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AccountFeeMapper {
    int countByExample(AccountFeeExample example);

    int deleteByExample(AccountFeeExample example);

    int deleteByPrimaryKey(@Param("id") Integer id, @Param("withdrawalCost") String withdrawalCost);

    int insert(AccountFee record);

    int insertSelective(AccountFee record);

    List<AccountFee> selectByExample(AccountFeeExample example);

    AccountFee selectByPrimaryKey(@Param("id") Integer id, @Param("withdrawalCost") String withdrawalCost);

    int updateByExampleSelective(@Param("record") AccountFee record, @Param("example") AccountFeeExample example);

    int updateByExample(@Param("record") AccountFee record, @Param("example") AccountFeeExample example);

    int updateByPrimaryKeySelective(AccountFee record);

    int updateByPrimaryKey(AccountFee record);
}