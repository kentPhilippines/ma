package com.pay.gateway.mapper;

import com.pay.gateway.entity.Account;
import com.pay.gateway.entity.AccountExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AccountMapper {
    int countByExample(AccountExample example);
    int deleteByExample(AccountExample example);
    int deleteByPrimaryKey(Integer id);
    int insert(Account record);
    int insertSelective(Account record);
    List<Account> selectByExample(AccountExample example);
    Account selectByPrimaryKey(Integer id);
    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);
    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);
    int updateByPrimaryKeySelective(Account record);
    int updateByPrimaryKey(Account record);
    /**
     * <p>修改資金凍結表數據</p>
     * @param freezeType 傳入任意數據全部清空
     * @return
     */
    int updataByAccountMoney(@Param("isAll")String isAll);
}