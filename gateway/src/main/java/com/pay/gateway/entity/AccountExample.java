package com.pay.gateway.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccountExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNull() {
            addCriterion("accountId is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("accountId is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(String value) {
            addCriterion("accountId =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(String value) {
            addCriterion("accountId <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(String value) {
            addCriterion("accountId >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("accountId >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(String value) {
            addCriterion("accountId <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(String value) {
            addCriterion("accountId <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLike(String value) {
            addCriterion("accountId like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotLike(String value) {
            addCriterion("accountId not like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<String> values) {
            addCriterion("accountId in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<String> values) {
            addCriterion("accountId not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(String value1, String value2) {
            addCriterion("accountId between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(String value1, String value2) {
            addCriterion("accountId not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountNameIsNull() {
            addCriterion("accountName is null");
            return (Criteria) this;
        }

        public Criteria andAccountNameIsNotNull() {
            addCriterion("accountName is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNameEqualTo(String value) {
            addCriterion("accountName =", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotEqualTo(String value) {
            addCriterion("accountName <>", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameGreaterThan(String value) {
            addCriterion("accountName >", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("accountName >=", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLessThan(String value) {
            addCriterion("accountName <", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLessThanOrEqualTo(String value) {
            addCriterion("accountName <=", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLike(String value) {
            addCriterion("accountName like", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotLike(String value) {
            addCriterion("accountName not like", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameIn(List<String> values) {
            addCriterion("accountName in", values, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotIn(List<String> values) {
            addCriterion("accountName not in", values, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameBetween(String value1, String value2) {
            addCriterion("accountName between", value1, value2, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotBetween(String value1, String value2) {
            addCriterion("accountName not between", value1, value2, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIsNull() {
            addCriterion("accountType is null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIsNotNull() {
            addCriterion("accountType is not null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeEqualTo(Integer value) {
            addCriterion("accountType =", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotEqualTo(Integer value) {
            addCriterion("accountType <>", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThan(Integer value) {
            addCriterion("accountType >", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("accountType >=", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThan(Integer value) {
            addCriterion("accountType <", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThanOrEqualTo(Integer value) {
            addCriterion("accountType <=", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIn(List<Integer> values) {
            addCriterion("accountType in", values, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotIn(List<Integer> values) {
            addCriterion("accountType not in", values, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeBetween(Integer value1, Integer value2) {
            addCriterion("accountType between", value1, value2, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("accountType not between", value1, value2, "accountType");
            return (Criteria) this;
        }

        public Criteria andCashBalanceIsNull() {
            addCriterion("cashBalance is null");
            return (Criteria) this;
        }

        public Criteria andCashBalanceIsNotNull() {
            addCriterion("cashBalance is not null");
            return (Criteria) this;
        }

        public Criteria andCashBalanceEqualTo(BigDecimal value) {
            addCriterion("cashBalance =", value, "cashBalance");
            return (Criteria) this;
        }

        public Criteria andCashBalanceNotEqualTo(BigDecimal value) {
            addCriterion("cashBalance <>", value, "cashBalance");
            return (Criteria) this;
        }

        public Criteria andCashBalanceGreaterThan(BigDecimal value) {
            addCriterion("cashBalance >", value, "cashBalance");
            return (Criteria) this;
        }

        public Criteria andCashBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cashBalance >=", value, "cashBalance");
            return (Criteria) this;
        }

        public Criteria andCashBalanceLessThan(BigDecimal value) {
            addCriterion("cashBalance <", value, "cashBalance");
            return (Criteria) this;
        }

        public Criteria andCashBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cashBalance <=", value, "cashBalance");
            return (Criteria) this;
        }

        public Criteria andCashBalanceIn(List<BigDecimal> values) {
            addCriterion("cashBalance in", values, "cashBalance");
            return (Criteria) this;
        }

        public Criteria andCashBalanceNotIn(List<BigDecimal> values) {
            addCriterion("cashBalance not in", values, "cashBalance");
            return (Criteria) this;
        }

        public Criteria andCashBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cashBalance between", value1, value2, "cashBalance");
            return (Criteria) this;
        }

        public Criteria andCashBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cashBalance not between", value1, value2, "cashBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceIsNull() {
            addCriterion("freezeBalance is null");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceIsNotNull() {
            addCriterion("freezeBalance is not null");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceEqualTo(BigDecimal value) {
            addCriterion("freezeBalance =", value, "freezeBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceNotEqualTo(BigDecimal value) {
            addCriterion("freezeBalance <>", value, "freezeBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceGreaterThan(BigDecimal value) {
            addCriterion("freezeBalance >", value, "freezeBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("freezeBalance >=", value, "freezeBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceLessThan(BigDecimal value) {
            addCriterion("freezeBalance <", value, "freezeBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("freezeBalance <=", value, "freezeBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceIn(List<BigDecimal> values) {
            addCriterion("freezeBalance in", values, "freezeBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceNotIn(List<BigDecimal> values) {
            addCriterion("freezeBalance not in", values, "freezeBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("freezeBalance between", value1, value2, "freezeBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("freezeBalance not between", value1, value2, "freezeBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceIsNull() {
            addCriterion("accountBalance is null");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceIsNotNull() {
            addCriterion("accountBalance is not null");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceEqualTo(BigDecimal value) {
            addCriterion("accountBalance =", value, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceNotEqualTo(BigDecimal value) {
            addCriterion("accountBalance <>", value, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceGreaterThan(BigDecimal value) {
            addCriterion("accountBalance >", value, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("accountBalance >=", value, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceLessThan(BigDecimal value) {
            addCriterion("accountBalance <", value, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("accountBalance <=", value, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceIn(List<BigDecimal> values) {
            addCriterion("accountBalance in", values, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceNotIn(List<BigDecimal> values) {
            addCriterion("accountBalance not in", values, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("accountBalance between", value1, value2, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("accountBalance not between", value1, value2, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andDayDealAmountMaxIsNull() {
            addCriterion("dayDealAmountMax is null");
            return (Criteria) this;
        }

        public Criteria andDayDealAmountMaxIsNotNull() {
            addCriterion("dayDealAmountMax is not null");
            return (Criteria) this;
        }

        public Criteria andDayDealAmountMaxEqualTo(BigDecimal value) {
            addCriterion("dayDealAmountMax =", value, "dayDealAmountMax");
            return (Criteria) this;
        }

        public Criteria andDayDealAmountMaxNotEqualTo(BigDecimal value) {
            addCriterion("dayDealAmountMax <>", value, "dayDealAmountMax");
            return (Criteria) this;
        }

        public Criteria andDayDealAmountMaxGreaterThan(BigDecimal value) {
            addCriterion("dayDealAmountMax >", value, "dayDealAmountMax");
            return (Criteria) this;
        }

        public Criteria andDayDealAmountMaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dayDealAmountMax >=", value, "dayDealAmountMax");
            return (Criteria) this;
        }

        public Criteria andDayDealAmountMaxLessThan(BigDecimal value) {
            addCriterion("dayDealAmountMax <", value, "dayDealAmountMax");
            return (Criteria) this;
        }

        public Criteria andDayDealAmountMaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dayDealAmountMax <=", value, "dayDealAmountMax");
            return (Criteria) this;
        }

        public Criteria andDayDealAmountMaxIn(List<BigDecimal> values) {
            addCriterion("dayDealAmountMax in", values, "dayDealAmountMax");
            return (Criteria) this;
        }

        public Criteria andDayDealAmountMaxNotIn(List<BigDecimal> values) {
            addCriterion("dayDealAmountMax not in", values, "dayDealAmountMax");
            return (Criteria) this;
        }

        public Criteria andDayDealAmountMaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dayDealAmountMax between", value1, value2, "dayDealAmountMax");
            return (Criteria) this;
        }

        public Criteria andDayDealAmountMaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dayDealAmountMax not between", value1, value2, "dayDealAmountMax");
            return (Criteria) this;
        }

        public Criteria andDayDealAmountMinIsNull() {
            addCriterion("dayDealAmountMin is null");
            return (Criteria) this;
        }

        public Criteria andDayDealAmountMinIsNotNull() {
            addCriterion("dayDealAmountMin is not null");
            return (Criteria) this;
        }

        public Criteria andDayDealAmountMinEqualTo(BigDecimal value) {
            addCriterion("dayDealAmountMin =", value, "dayDealAmountMin");
            return (Criteria) this;
        }

        public Criteria andDayDealAmountMinNotEqualTo(BigDecimal value) {
            addCriterion("dayDealAmountMin <>", value, "dayDealAmountMin");
            return (Criteria) this;
        }

        public Criteria andDayDealAmountMinGreaterThan(BigDecimal value) {
            addCriterion("dayDealAmountMin >", value, "dayDealAmountMin");
            return (Criteria) this;
        }

        public Criteria andDayDealAmountMinGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dayDealAmountMin >=", value, "dayDealAmountMin");
            return (Criteria) this;
        }

        public Criteria andDayDealAmountMinLessThan(BigDecimal value) {
            addCriterion("dayDealAmountMin <", value, "dayDealAmountMin");
            return (Criteria) this;
        }

        public Criteria andDayDealAmountMinLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dayDealAmountMin <=", value, "dayDealAmountMin");
            return (Criteria) this;
        }

        public Criteria andDayDealAmountMinIn(List<BigDecimal> values) {
            addCriterion("dayDealAmountMin in", values, "dayDealAmountMin");
            return (Criteria) this;
        }

        public Criteria andDayDealAmountMinNotIn(List<BigDecimal> values) {
            addCriterion("dayDealAmountMin not in", values, "dayDealAmountMin");
            return (Criteria) this;
        }

        public Criteria andDayDealAmountMinBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dayDealAmountMin between", value1, value2, "dayDealAmountMin");
            return (Criteria) this;
        }

        public Criteria andDayDealAmountMinNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dayDealAmountMin not between", value1, value2, "dayDealAmountMin");
            return (Criteria) this;
        }

        public Criteria andSumDealAmountIsNull() {
            addCriterion("SumDealAmount is null");
            return (Criteria) this;
        }

        public Criteria andSumDealAmountIsNotNull() {
            addCriterion("SumDealAmount is not null");
            return (Criteria) this;
        }

        public Criteria andSumDealAmountEqualTo(BigDecimal value) {
            addCriterion("SumDealAmount =", value, "sumDealAmount");
            return (Criteria) this;
        }

        public Criteria andSumDealAmountNotEqualTo(BigDecimal value) {
            addCriterion("SumDealAmount <>", value, "sumDealAmount");
            return (Criteria) this;
        }

        public Criteria andSumDealAmountGreaterThan(BigDecimal value) {
            addCriterion("SumDealAmount >", value, "sumDealAmount");
            return (Criteria) this;
        }

        public Criteria andSumDealAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SumDealAmount >=", value, "sumDealAmount");
            return (Criteria) this;
        }

        public Criteria andSumDealAmountLessThan(BigDecimal value) {
            addCriterion("SumDealAmount <", value, "sumDealAmount");
            return (Criteria) this;
        }

        public Criteria andSumDealAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SumDealAmount <=", value, "sumDealAmount");
            return (Criteria) this;
        }

        public Criteria andSumDealAmountIn(List<BigDecimal> values) {
            addCriterion("SumDealAmount in", values, "sumDealAmount");
            return (Criteria) this;
        }

        public Criteria andSumDealAmountNotIn(List<BigDecimal> values) {
            addCriterion("SumDealAmount not in", values, "sumDealAmount");
            return (Criteria) this;
        }

        public Criteria andSumDealAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SumDealAmount between", value1, value2, "sumDealAmount");
            return (Criteria) this;
        }

        public Criteria andSumDealAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SumDealAmount not between", value1, value2, "sumDealAmount");
            return (Criteria) this;
        }

        public Criteria andSumDealToDayAmountIsNull() {
            addCriterion("SumDealToDayAmount is null");
            return (Criteria) this;
        }

        public Criteria andSumDealToDayAmountIsNotNull() {
            addCriterion("SumDealToDayAmount is not null");
            return (Criteria) this;
        }

        public Criteria andSumDealToDayAmountEqualTo(BigDecimal value) {
            addCriterion("SumDealToDayAmount =", value, "sumDealToDayAmount");
            return (Criteria) this;
        }

        public Criteria andSumDealToDayAmountNotEqualTo(BigDecimal value) {
            addCriterion("SumDealToDayAmount <>", value, "sumDealToDayAmount");
            return (Criteria) this;
        }

        public Criteria andSumDealToDayAmountGreaterThan(BigDecimal value) {
            addCriterion("SumDealToDayAmount >", value, "sumDealToDayAmount");
            return (Criteria) this;
        }

        public Criteria andSumDealToDayAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SumDealToDayAmount >=", value, "sumDealToDayAmount");
            return (Criteria) this;
        }

        public Criteria andSumDealToDayAmountLessThan(BigDecimal value) {
            addCriterion("SumDealToDayAmount <", value, "sumDealToDayAmount");
            return (Criteria) this;
        }

        public Criteria andSumDealToDayAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SumDealToDayAmount <=", value, "sumDealToDayAmount");
            return (Criteria) this;
        }

        public Criteria andSumDealToDayAmountIn(List<BigDecimal> values) {
            addCriterion("SumDealToDayAmount in", values, "sumDealToDayAmount");
            return (Criteria) this;
        }

        public Criteria andSumDealToDayAmountNotIn(List<BigDecimal> values) {
            addCriterion("SumDealToDayAmount not in", values, "sumDealToDayAmount");
            return (Criteria) this;
        }

        public Criteria andSumDealToDayAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SumDealToDayAmount between", value1, value2, "sumDealToDayAmount");
            return (Criteria) this;
        }

        public Criteria andSumDealToDayAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SumDealToDayAmount not between", value1, value2, "sumDealToDayAmount");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("createTime <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIsNull() {
            addCriterion("submitTime is null");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIsNotNull() {
            addCriterion("submitTime is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeEqualTo(Date value) {
            addCriterion("submitTime =", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotEqualTo(Date value) {
            addCriterion("submitTime <>", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeGreaterThan(Date value) {
            addCriterion("submitTime >", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("submitTime >=", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeLessThan(Date value) {
            addCriterion("submitTime <", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeLessThanOrEqualTo(Date value) {
            addCriterion("submitTime <=", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIn(List<Date> values) {
            addCriterion("submitTime in", values, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotIn(List<Date> values) {
            addCriterion("submitTime not in", values, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeBetween(Date value1, Date value2) {
            addCriterion("submitTime between", value1, value2, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotBetween(Date value1, Date value2) {
            addCriterion("submitTime not between", value1, value2, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitSystemIsNull() {
            addCriterion("submitSystem is null");
            return (Criteria) this;
        }

        public Criteria andSubmitSystemIsNotNull() {
            addCriterion("submitSystem is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitSystemEqualTo(String value) {
            addCriterion("submitSystem =", value, "submitSystem");
            return (Criteria) this;
        }

        public Criteria andSubmitSystemNotEqualTo(String value) {
            addCriterion("submitSystem <>", value, "submitSystem");
            return (Criteria) this;
        }

        public Criteria andSubmitSystemGreaterThan(String value) {
            addCriterion("submitSystem >", value, "submitSystem");
            return (Criteria) this;
        }

        public Criteria andSubmitSystemGreaterThanOrEqualTo(String value) {
            addCriterion("submitSystem >=", value, "submitSystem");
            return (Criteria) this;
        }

        public Criteria andSubmitSystemLessThan(String value) {
            addCriterion("submitSystem <", value, "submitSystem");
            return (Criteria) this;
        }

        public Criteria andSubmitSystemLessThanOrEqualTo(String value) {
            addCriterion("submitSystem <=", value, "submitSystem");
            return (Criteria) this;
        }

        public Criteria andSubmitSystemLike(String value) {
            addCriterion("submitSystem like", value, "submitSystem");
            return (Criteria) this;
        }

        public Criteria andSubmitSystemNotLike(String value) {
            addCriterion("submitSystem not like", value, "submitSystem");
            return (Criteria) this;
        }

        public Criteria andSubmitSystemIn(List<String> values) {
            addCriterion("submitSystem in", values, "submitSystem");
            return (Criteria) this;
        }

        public Criteria andSubmitSystemNotIn(List<String> values) {
            addCriterion("submitSystem not in", values, "submitSystem");
            return (Criteria) this;
        }

        public Criteria andSubmitSystemBetween(String value1, String value2) {
            addCriterion("submitSystem between", value1, value2, "submitSystem");
            return (Criteria) this;
        }

        public Criteria andSubmitSystemNotBetween(String value1, String value2) {
            addCriterion("submitSystem not between", value1, value2, "submitSystem");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}