package com.pay.gateway.mapper;

import com.pay.gateway.entity.WithdrawalsOrder;
import com.pay.gateway.entity.WithdrawalsOrderExample;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface WithdrawalsOrderMapper {
    int countByExample(WithdrawalsOrderExample example);

    int deleteByExample(WithdrawalsOrderExample example);

    int deleteByPrimaryKey(@Param("id") Integer id, @Param("createTime") Date createTime);

    int insert(WithdrawalsOrder record);

    int insertSelective(WithdrawalsOrder record);

    List<WithdrawalsOrder> selectByExample(WithdrawalsOrderExample example);

    WithdrawalsOrder selectByPrimaryKey(@Param("id") Integer id, @Param("createTime") Date createTime);

    int updateByExampleSelective(@Param("record") WithdrawalsOrder record, @Param("example") WithdrawalsOrderExample example);

    int updateByExample(@Param("record") WithdrawalsOrder record, @Param("example") WithdrawalsOrderExample example);

    int updateByPrimaryKeySelective(WithdrawalsOrder record);

    int updateByPrimaryKey(WithdrawalsOrder record);
}