package com.pay.gateway.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pay.gateway.config.common.Common;
import com.pay.gateway.entity.Account;
import com.pay.gateway.entity.AccountExample;
import com.pay.gateway.entity.AccountExample.Criteria;
import com.pay.gateway.entity.AccountInfo;
import com.pay.gateway.entity.AccountInfoExample;
import com.pay.gateway.entity.DayAll;
import com.pay.gateway.entity.DayAllExample;
import com.pay.gateway.mapper.AccountInfoMapper;
import com.pay.gateway.mapper.AccountMapper;
import com.pay.gateway.mapper.DayAllMapper;
import com.pay.gateway.service.AccountService;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountMapper accountDao;
	@Autowired
	AccountInfoMapper accountInfoDao;
	@Autowired
	DayAllMapper dayAllDao;
	@Override
	public Account findAccountByAppId(String appid) {
		AccountExample example = new AccountExample();
		Criteria criteria = example.createCriteria();
		criteria.andAccountIdEqualTo(appid);
		List<Account> selectByExample = accountDao.selectByExample(example);
		if(CollUtil.isNotEmpty(selectByExample))
			return CollUtil.getFirst(selectByExample);
		return null;
	}
	@Override
	public AccountInfo findAccountInfoByAppId(String appid) {
		AccountInfoExample example = new AccountInfoExample();
		com.pay.gateway.entity.AccountInfoExample.Criteria criteria = example.createCriteria();
		criteria.andAccountIdEqualTo(appid);
		List<AccountInfo> selectByExample = accountInfoDao.selectByExample(example);
		if(CollUtil.isNotEmpty(selectByExample))
			return CollUtil.getFirst(selectByExample);
		return null;
	}
	@Override
	public boolean updataAccountByAcoountId(Account account) {
		AccountExample example = new AccountExample();
		Criteria criteria = example.createCriteria();
		criteria.andAccountIdEqualTo(account.getAccountId());
		int updateByExample = accountDao.updateByExampleSelective(account, example);
		return updateByExample > 0 && updateByExample < 2;
	}
	@Override
	public void updataAccountAmount() {
		/**
		 * <p>修改邏輯為</p>
		 * 1,如果今天為工作日,修改所有T1和D1 凍結的金錢到  可取現餘額字段
		 * 2,如果今天為非工作日 修改D1的餘額到 可取現 字段
		 */
		DayAllExample example = new DayAllExample();
		com.pay.gateway.entity.DayAllExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andReqDateEqualTo(new Date());
		List<DayAll> selectByExample = dayAllDao.selectByExample(example);
		DayAll day = new DayAll();
		if(CollUtil.isNotEmpty(selectByExample)) {
			day = CollUtil.getFirst(selectByExample);
		if(ObjectUtil.isNull(day.getReqdayType())) {//查詢不到今天是否為工作時間時
			day.setReqdayType(Common.DAY_ALL_WORK);//就儅今天為工作日
		}
		int updataByAccountMoney  ; 
		if(day.getReqdayType().equals(Common.DAY_ALL_WORK)) {//工作日  清空T1 和  D1的數據,
			 updataByAccountMoney = accountDao.updataByAccountMoney("YES");
		}else{//非工作日   清空D1數據
			 updataByAccountMoney = accountDao.updataByAccountMoney(null);
		};
		// TODO 這裏要記錄修改資金的日志操作  目前沒有時間先不要寫
		//記錄日志
		}
	}
}
