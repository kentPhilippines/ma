package com.pay.gateway.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AccountFeeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccountFeeExample() {
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
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

        public Criteria andWithdrawalCostIsNull() {
            addCriterion("withdrawalCost is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalCostIsNotNull() {
            addCriterion("withdrawalCost is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalCostEqualTo(String value) {
            addCriterion("withdrawalCost =", value, "withdrawalCost");
            return (Criteria) this;
        }

        public Criteria andWithdrawalCostNotEqualTo(String value) {
            addCriterion("withdrawalCost <>", value, "withdrawalCost");
            return (Criteria) this;
        }

        public Criteria andWithdrawalCostGreaterThan(String value) {
            addCriterion("withdrawalCost >", value, "withdrawalCost");
            return (Criteria) this;
        }

        public Criteria andWithdrawalCostGreaterThanOrEqualTo(String value) {
            addCriterion("withdrawalCost >=", value, "withdrawalCost");
            return (Criteria) this;
        }

        public Criteria andWithdrawalCostLessThan(String value) {
            addCriterion("withdrawalCost <", value, "withdrawalCost");
            return (Criteria) this;
        }

        public Criteria andWithdrawalCostLessThanOrEqualTo(String value) {
            addCriterion("withdrawalCost <=", value, "withdrawalCost");
            return (Criteria) this;
        }

        public Criteria andWithdrawalCostLike(String value) {
            addCriterion("withdrawalCost like", value, "withdrawalCost");
            return (Criteria) this;
        }

        public Criteria andWithdrawalCostNotLike(String value) {
            addCriterion("withdrawalCost not like", value, "withdrawalCost");
            return (Criteria) this;
        }

        public Criteria andWithdrawalCostIn(List<String> values) {
            addCriterion("withdrawalCost in", values, "withdrawalCost");
            return (Criteria) this;
        }

        public Criteria andWithdrawalCostNotIn(List<String> values) {
            addCriterion("withdrawalCost not in", values, "withdrawalCost");
            return (Criteria) this;
        }

        public Criteria andWithdrawalCostBetween(String value1, String value2) {
            addCriterion("withdrawalCost between", value1, value2, "withdrawalCost");
            return (Criteria) this;
        }

        public Criteria andWithdrawalCostNotBetween(String value1, String value2) {
            addCriterion("withdrawalCost not between", value1, value2, "withdrawalCost");
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

        public Criteria andAccountChannelIsNull() {
            addCriterion("accountChannel is null");
            return (Criteria) this;
        }

        public Criteria andAccountChannelIsNotNull() {
            addCriterion("accountChannel is not null");
            return (Criteria) this;
        }

        public Criteria andAccountChannelEqualTo(String value) {
            addCriterion("accountChannel =", value, "accountChannel");
            return (Criteria) this;
        }

        public Criteria andAccountChannelNotEqualTo(String value) {
            addCriterion("accountChannel <>", value, "accountChannel");
            return (Criteria) this;
        }

        public Criteria andAccountChannelGreaterThan(String value) {
            addCriterion("accountChannel >", value, "accountChannel");
            return (Criteria) this;
        }

        public Criteria andAccountChannelGreaterThanOrEqualTo(String value) {
            addCriterion("accountChannel >=", value, "accountChannel");
            return (Criteria) this;
        }

        public Criteria andAccountChannelLessThan(String value) {
            addCriterion("accountChannel <", value, "accountChannel");
            return (Criteria) this;
        }

        public Criteria andAccountChannelLessThanOrEqualTo(String value) {
            addCriterion("accountChannel <=", value, "accountChannel");
            return (Criteria) this;
        }

        public Criteria andAccountChannelLike(String value) {
            addCriterion("accountChannel like", value, "accountChannel");
            return (Criteria) this;
        }

        public Criteria andAccountChannelNotLike(String value) {
            addCriterion("accountChannel not like", value, "accountChannel");
            return (Criteria) this;
        }

        public Criteria andAccountChannelIn(List<String> values) {
            addCriterion("accountChannel in", values, "accountChannel");
            return (Criteria) this;
        }

        public Criteria andAccountChannelNotIn(List<String> values) {
            addCriterion("accountChannel not in", values, "accountChannel");
            return (Criteria) this;
        }

        public Criteria andAccountChannelBetween(String value1, String value2) {
            addCriterion("accountChannel between", value1, value2, "accountChannel");
            return (Criteria) this;
        }

        public Criteria andAccountChannelNotBetween(String value1, String value2) {
            addCriterion("accountChannel not between", value1, value2, "accountChannel");
            return (Criteria) this;
        }

        public Criteria andChannelProductIsNull() {
            addCriterion("ChannelProduct is null");
            return (Criteria) this;
        }

        public Criteria andChannelProductIsNotNull() {
            addCriterion("ChannelProduct is not null");
            return (Criteria) this;
        }

        public Criteria andChannelProductEqualTo(String value) {
            addCriterion("ChannelProduct =", value, "channelProduct");
            return (Criteria) this;
        }

        public Criteria andChannelProductNotEqualTo(String value) {
            addCriterion("ChannelProduct <>", value, "channelProduct");
            return (Criteria) this;
        }

        public Criteria andChannelProductGreaterThan(String value) {
            addCriterion("ChannelProduct >", value, "channelProduct");
            return (Criteria) this;
        }

        public Criteria andChannelProductGreaterThanOrEqualTo(String value) {
            addCriterion("ChannelProduct >=", value, "channelProduct");
            return (Criteria) this;
        }

        public Criteria andChannelProductLessThan(String value) {
            addCriterion("ChannelProduct <", value, "channelProduct");
            return (Criteria) this;
        }

        public Criteria andChannelProductLessThanOrEqualTo(String value) {
            addCriterion("ChannelProduct <=", value, "channelProduct");
            return (Criteria) this;
        }

        public Criteria andChannelProductLike(String value) {
            addCriterion("ChannelProduct like", value, "channelProduct");
            return (Criteria) this;
        }

        public Criteria andChannelProductNotLike(String value) {
            addCriterion("ChannelProduct not like", value, "channelProduct");
            return (Criteria) this;
        }

        public Criteria andChannelProductIn(List<String> values) {
            addCriterion("ChannelProduct in", values, "channelProduct");
            return (Criteria) this;
        }

        public Criteria andChannelProductNotIn(List<String> values) {
            addCriterion("ChannelProduct not in", values, "channelProduct");
            return (Criteria) this;
        }

        public Criteria andChannelProductBetween(String value1, String value2) {
            addCriterion("ChannelProduct between", value1, value2, "channelProduct");
            return (Criteria) this;
        }

        public Criteria andChannelProductNotBetween(String value1, String value2) {
            addCriterion("ChannelProduct not between", value1, value2, "channelProduct");
            return (Criteria) this;
        }

        public Criteria andAccountFeeIsNull() {
            addCriterion("accountFee is null");
            return (Criteria) this;
        }

        public Criteria andAccountFeeIsNotNull() {
            addCriterion("accountFee is not null");
            return (Criteria) this;
        }

        public Criteria andAccountFeeEqualTo(String value) {
            addCriterion("accountFee =", value, "accountFee");
            return (Criteria) this;
        }

        public Criteria andAccountFeeNotEqualTo(String value) {
            addCriterion("accountFee <>", value, "accountFee");
            return (Criteria) this;
        }

        public Criteria andAccountFeeGreaterThan(String value) {
            addCriterion("accountFee >", value, "accountFee");
            return (Criteria) this;
        }

        public Criteria andAccountFeeGreaterThanOrEqualTo(String value) {
            addCriterion("accountFee >=", value, "accountFee");
            return (Criteria) this;
        }

        public Criteria andAccountFeeLessThan(String value) {
            addCriterion("accountFee <", value, "accountFee");
            return (Criteria) this;
        }

        public Criteria andAccountFeeLessThanOrEqualTo(String value) {
            addCriterion("accountFee <=", value, "accountFee");
            return (Criteria) this;
        }

        public Criteria andAccountFeeLike(String value) {
            addCriterion("accountFee like", value, "accountFee");
            return (Criteria) this;
        }

        public Criteria andAccountFeeNotLike(String value) {
            addCriterion("accountFee not like", value, "accountFee");
            return (Criteria) this;
        }

        public Criteria andAccountFeeIn(List<String> values) {
            addCriterion("accountFee in", values, "accountFee");
            return (Criteria) this;
        }

        public Criteria andAccountFeeNotIn(List<String> values) {
            addCriterion("accountFee not in", values, "accountFee");
            return (Criteria) this;
        }

        public Criteria andAccountFeeBetween(String value1, String value2) {
            addCriterion("accountFee between", value1, value2, "accountFee");
            return (Criteria) this;
        }

        public Criteria andAccountFeeNotBetween(String value1, String value2) {
            addCriterion("accountFee not between", value1, value2, "accountFee");
            return (Criteria) this;
        }

        public Criteria andAccountCostIsNull() {
            addCriterion("accountCost is null");
            return (Criteria) this;
        }

        public Criteria andAccountCostIsNotNull() {
            addCriterion("accountCost is not null");
            return (Criteria) this;
        }

        public Criteria andAccountCostEqualTo(String value) {
            addCriterion("accountCost =", value, "accountCost");
            return (Criteria) this;
        }

        public Criteria andAccountCostNotEqualTo(String value) {
            addCriterion("accountCost <>", value, "accountCost");
            return (Criteria) this;
        }

        public Criteria andAccountCostGreaterThan(String value) {
            addCriterion("accountCost >", value, "accountCost");
            return (Criteria) this;
        }

        public Criteria andAccountCostGreaterThanOrEqualTo(String value) {
            addCriterion("accountCost >=", value, "accountCost");
            return (Criteria) this;
        }

        public Criteria andAccountCostLessThan(String value) {
            addCriterion("accountCost <", value, "accountCost");
            return (Criteria) this;
        }

        public Criteria andAccountCostLessThanOrEqualTo(String value) {
            addCriterion("accountCost <=", value, "accountCost");
            return (Criteria) this;
        }

        public Criteria andAccountCostLike(String value) {
            addCriterion("accountCost like", value, "accountCost");
            return (Criteria) this;
        }

        public Criteria andAccountCostNotLike(String value) {
            addCriterion("accountCost not like", value, "accountCost");
            return (Criteria) this;
        }

        public Criteria andAccountCostIn(List<String> values) {
            addCriterion("accountCost in", values, "accountCost");
            return (Criteria) this;
        }

        public Criteria andAccountCostNotIn(List<String> values) {
            addCriterion("accountCost not in", values, "accountCost");
            return (Criteria) this;
        }

        public Criteria andAccountCostBetween(String value1, String value2) {
            addCriterion("accountCost between", value1, value2, "accountCost");
            return (Criteria) this;
        }

        public Criteria andAccountCostNotBetween(String value1, String value2) {
            addCriterion("accountCost not between", value1, value2, "accountCost");
            return (Criteria) this;
        }

        public Criteria andWithdrawalIsNull() {
            addCriterion("withdrawal is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalIsNotNull() {
            addCriterion("withdrawal is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalEqualTo(String value) {
            addCriterion("withdrawal =", value, "withdrawal");
            return (Criteria) this;
        }

        public Criteria andWithdrawalNotEqualTo(String value) {
            addCriterion("withdrawal <>", value, "withdrawal");
            return (Criteria) this;
        }

        public Criteria andWithdrawalGreaterThan(String value) {
            addCriterion("withdrawal >", value, "withdrawal");
            return (Criteria) this;
        }

        public Criteria andWithdrawalGreaterThanOrEqualTo(String value) {
            addCriterion("withdrawal >=", value, "withdrawal");
            return (Criteria) this;
        }

        public Criteria andWithdrawalLessThan(String value) {
            addCriterion("withdrawal <", value, "withdrawal");
            return (Criteria) this;
        }

        public Criteria andWithdrawalLessThanOrEqualTo(String value) {
            addCriterion("withdrawal <=", value, "withdrawal");
            return (Criteria) this;
        }

        public Criteria andWithdrawalLike(String value) {
            addCriterion("withdrawal like", value, "withdrawal");
            return (Criteria) this;
        }

        public Criteria andWithdrawalNotLike(String value) {
            addCriterion("withdrawal not like", value, "withdrawal");
            return (Criteria) this;
        }

        public Criteria andWithdrawalIn(List<String> values) {
            addCriterion("withdrawal in", values, "withdrawal");
            return (Criteria) this;
        }

        public Criteria andWithdrawalNotIn(List<String> values) {
            addCriterion("withdrawal not in", values, "withdrawal");
            return (Criteria) this;
        }

        public Criteria andWithdrawalBetween(String value1, String value2) {
            addCriterion("withdrawal between", value1, value2, "withdrawal");
            return (Criteria) this;
        }

        public Criteria andWithdrawalNotBetween(String value1, String value2) {
            addCriterion("withdrawal not between", value1, value2, "withdrawal");
            return (Criteria) this;
        }

        public Criteria andFeeStautusIsNull() {
            addCriterion("FeeStautus is null");
            return (Criteria) this;
        }

        public Criteria andFeeStautusIsNotNull() {
            addCriterion("FeeStautus is not null");
            return (Criteria) this;
        }

        public Criteria andFeeStautusEqualTo(Integer value) {
            addCriterion("FeeStautus =", value, "feeStautus");
            return (Criteria) this;
        }

        public Criteria andFeeStautusNotEqualTo(Integer value) {
            addCriterion("FeeStautus <>", value, "feeStautus");
            return (Criteria) this;
        }

        public Criteria andFeeStautusGreaterThan(Integer value) {
            addCriterion("FeeStautus >", value, "feeStautus");
            return (Criteria) this;
        }

        public Criteria andFeeStautusGreaterThanOrEqualTo(Integer value) {
            addCriterion("FeeStautus >=", value, "feeStautus");
            return (Criteria) this;
        }

        public Criteria andFeeStautusLessThan(Integer value) {
            addCriterion("FeeStautus <", value, "feeStautus");
            return (Criteria) this;
        }

        public Criteria andFeeStautusLessThanOrEqualTo(Integer value) {
            addCriterion("FeeStautus <=", value, "feeStautus");
            return (Criteria) this;
        }

        public Criteria andFeeStautusIn(List<Integer> values) {
            addCriterion("FeeStautus in", values, "feeStautus");
            return (Criteria) this;
        }

        public Criteria andFeeStautusNotIn(List<Integer> values) {
            addCriterion("FeeStautus not in", values, "feeStautus");
            return (Criteria) this;
        }

        public Criteria andFeeStautusBetween(Integer value1, Integer value2) {
            addCriterion("FeeStautus between", value1, value2, "feeStautus");
            return (Criteria) this;
        }

        public Criteria andFeeStautusNotBetween(Integer value1, Integer value2) {
            addCriterion("FeeStautus not between", value1, value2, "feeStautus");
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

        public Criteria andAccountSetteIsNull() {
            addCriterion("accountSette is null");
            return (Criteria) this;
        }

        public Criteria andAccountSetteIsNotNull() {
            addCriterion("accountSette is not null");
            return (Criteria) this;
        }

        public Criteria andAccountSetteEqualTo(String value) {
            addCriterion("accountSette =", value, "accountSette");
            return (Criteria) this;
        }

        public Criteria andAccountSetteNotEqualTo(String value) {
            addCriterion("accountSette <>", value, "accountSette");
            return (Criteria) this;
        }

        public Criteria andAccountSetteGreaterThan(String value) {
            addCriterion("accountSette >", value, "accountSette");
            return (Criteria) this;
        }

        public Criteria andAccountSetteGreaterThanOrEqualTo(String value) {
            addCriterion("accountSette >=", value, "accountSette");
            return (Criteria) this;
        }

        public Criteria andAccountSetteLessThan(String value) {
            addCriterion("accountSette <", value, "accountSette");
            return (Criteria) this;
        }

        public Criteria andAccountSetteLessThanOrEqualTo(String value) {
            addCriterion("accountSette <=", value, "accountSette");
            return (Criteria) this;
        }

        public Criteria andAccountSetteLike(String value) {
            addCriterion("accountSette like", value, "accountSette");
            return (Criteria) this;
        }

        public Criteria andAccountSetteNotLike(String value) {
            addCriterion("accountSette not like", value, "accountSette");
            return (Criteria) this;
        }

        public Criteria andAccountSetteIn(List<String> values) {
            addCriterion("accountSette in", values, "accountSette");
            return (Criteria) this;
        }

        public Criteria andAccountSetteNotIn(List<String> values) {
            addCriterion("accountSette not in", values, "accountSette");
            return (Criteria) this;
        }

        public Criteria andAccountSetteBetween(String value1, String value2) {
            addCriterion("accountSette between", value1, value2, "accountSette");
            return (Criteria) this;
        }

        public Criteria andAccountSetteNotBetween(String value1, String value2) {
            addCriterion("accountSette not between", value1, value2, "accountSette");
            return (Criteria) this;
        }

        public Criteria andSettleTimeIsNull() {
            addCriterion("settleTime is null");
            return (Criteria) this;
        }

        public Criteria andSettleTimeIsNotNull() {
            addCriterion("settleTime is not null");
            return (Criteria) this;
        }

        public Criteria andSettleTimeEqualTo(Date value) {
            addCriterionForJDBCTime("settleTime =", value, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("settleTime <>", value, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("settleTime >", value, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("settleTime >=", value, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeLessThan(Date value) {
            addCriterionForJDBCTime("settleTime <", value, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("settleTime <=", value, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeIn(List<Date> values) {
            addCriterionForJDBCTime("settleTime in", values, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("settleTime not in", values, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("settleTime between", value1, value2, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("settleTime not between", value1, value2, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeIsNull() {
            addCriterion("settlementType is null");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeIsNotNull() {
            addCriterion("settlementType is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeEqualTo(String value) {
            addCriterion("settlementType =", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeNotEqualTo(String value) {
            addCriterion("settlementType <>", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeGreaterThan(String value) {
            addCriterion("settlementType >", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeGreaterThanOrEqualTo(String value) {
            addCriterion("settlementType >=", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeLessThan(String value) {
            addCriterion("settlementType <", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeLessThanOrEqualTo(String value) {
            addCriterion("settlementType <=", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeLike(String value) {
            addCriterion("settlementType like", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeNotLike(String value) {
            addCriterion("settlementType not like", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeIn(List<String> values) {
            addCriterion("settlementType in", values, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeNotIn(List<String> values) {
            addCriterion("settlementType not in", values, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeBetween(String value1, String value2) {
            addCriterion("settlementType between", value1, value2, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeNotBetween(String value1, String value2) {
            addCriterion("settlementType not between", value1, value2, "settlementType");
            return (Criteria) this;
        }

        public Criteria andRetain1IsNull() {
            addCriterion("retain1 is null");
            return (Criteria) this;
        }

        public Criteria andRetain1IsNotNull() {
            addCriterion("retain1 is not null");
            return (Criteria) this;
        }

        public Criteria andRetain1EqualTo(String value) {
            addCriterion("retain1 =", value, "retain1");
            return (Criteria) this;
        }

        public Criteria andRetain1NotEqualTo(String value) {
            addCriterion("retain1 <>", value, "retain1");
            return (Criteria) this;
        }

        public Criteria andRetain1GreaterThan(String value) {
            addCriterion("retain1 >", value, "retain1");
            return (Criteria) this;
        }

        public Criteria andRetain1GreaterThanOrEqualTo(String value) {
            addCriterion("retain1 >=", value, "retain1");
            return (Criteria) this;
        }

        public Criteria andRetain1LessThan(String value) {
            addCriterion("retain1 <", value, "retain1");
            return (Criteria) this;
        }

        public Criteria andRetain1LessThanOrEqualTo(String value) {
            addCriterion("retain1 <=", value, "retain1");
            return (Criteria) this;
        }

        public Criteria andRetain1Like(String value) {
            addCriterion("retain1 like", value, "retain1");
            return (Criteria) this;
        }

        public Criteria andRetain1NotLike(String value) {
            addCriterion("retain1 not like", value, "retain1");
            return (Criteria) this;
        }

        public Criteria andRetain1In(List<String> values) {
            addCriterion("retain1 in", values, "retain1");
            return (Criteria) this;
        }

        public Criteria andRetain1NotIn(List<String> values) {
            addCriterion("retain1 not in", values, "retain1");
            return (Criteria) this;
        }

        public Criteria andRetain1Between(String value1, String value2) {
            addCriterion("retain1 between", value1, value2, "retain1");
            return (Criteria) this;
        }

        public Criteria andRetain1NotBetween(String value1, String value2) {
            addCriterion("retain1 not between", value1, value2, "retain1");
            return (Criteria) this;
        }

        public Criteria andRetain2IsNull() {
            addCriterion("retain2 is null");
            return (Criteria) this;
        }

        public Criteria andRetain2IsNotNull() {
            addCriterion("retain2 is not null");
            return (Criteria) this;
        }

        public Criteria andRetain2EqualTo(String value) {
            addCriterion("retain2 =", value, "retain2");
            return (Criteria) this;
        }

        public Criteria andRetain2NotEqualTo(String value) {
            addCriterion("retain2 <>", value, "retain2");
            return (Criteria) this;
        }

        public Criteria andRetain2GreaterThan(String value) {
            addCriterion("retain2 >", value, "retain2");
            return (Criteria) this;
        }

        public Criteria andRetain2GreaterThanOrEqualTo(String value) {
            addCriterion("retain2 >=", value, "retain2");
            return (Criteria) this;
        }

        public Criteria andRetain2LessThan(String value) {
            addCriterion("retain2 <", value, "retain2");
            return (Criteria) this;
        }

        public Criteria andRetain2LessThanOrEqualTo(String value) {
            addCriterion("retain2 <=", value, "retain2");
            return (Criteria) this;
        }

        public Criteria andRetain2Like(String value) {
            addCriterion("retain2 like", value, "retain2");
            return (Criteria) this;
        }

        public Criteria andRetain2NotLike(String value) {
            addCriterion("retain2 not like", value, "retain2");
            return (Criteria) this;
        }

        public Criteria andRetain2In(List<String> values) {
            addCriterion("retain2 in", values, "retain2");
            return (Criteria) this;
        }

        public Criteria andRetain2NotIn(List<String> values) {
            addCriterion("retain2 not in", values, "retain2");
            return (Criteria) this;
        }

        public Criteria andRetain2Between(String value1, String value2) {
            addCriterion("retain2 between", value1, value2, "retain2");
            return (Criteria) this;
        }

        public Criteria andRetain2NotBetween(String value1, String value2) {
            addCriterion("retain2 not between", value1, value2, "retain2");
            return (Criteria) this;
        }

        public Criteria andRetain3IsNull() {
            addCriterion("retain3 is null");
            return (Criteria) this;
        }

        public Criteria andRetain3IsNotNull() {
            addCriterion("retain3 is not null");
            return (Criteria) this;
        }

        public Criteria andRetain3EqualTo(String value) {
            addCriterion("retain3 =", value, "retain3");
            return (Criteria) this;
        }

        public Criteria andRetain3NotEqualTo(String value) {
            addCriterion("retain3 <>", value, "retain3");
            return (Criteria) this;
        }

        public Criteria andRetain3GreaterThan(String value) {
            addCriterion("retain3 >", value, "retain3");
            return (Criteria) this;
        }

        public Criteria andRetain3GreaterThanOrEqualTo(String value) {
            addCriterion("retain3 >=", value, "retain3");
            return (Criteria) this;
        }

        public Criteria andRetain3LessThan(String value) {
            addCriterion("retain3 <", value, "retain3");
            return (Criteria) this;
        }

        public Criteria andRetain3LessThanOrEqualTo(String value) {
            addCriterion("retain3 <=", value, "retain3");
            return (Criteria) this;
        }

        public Criteria andRetain3Like(String value) {
            addCriterion("retain3 like", value, "retain3");
            return (Criteria) this;
        }

        public Criteria andRetain3NotLike(String value) {
            addCriterion("retain3 not like", value, "retain3");
            return (Criteria) this;
        }

        public Criteria andRetain3In(List<String> values) {
            addCriterion("retain3 in", values, "retain3");
            return (Criteria) this;
        }

        public Criteria andRetain3NotIn(List<String> values) {
            addCriterion("retain3 not in", values, "retain3");
            return (Criteria) this;
        }

        public Criteria andRetain3Between(String value1, String value2) {
            addCriterion("retain3 between", value1, value2, "retain3");
            return (Criteria) this;
        }

        public Criteria andRetain3NotBetween(String value1, String value2) {
            addCriterion("retain3 not between", value1, value2, "retain3");
            return (Criteria) this;
        }

        public Criteria andRetain4IsNull() {
            addCriterion("retain4 is null");
            return (Criteria) this;
        }

        public Criteria andRetain4IsNotNull() {
            addCriterion("retain4 is not null");
            return (Criteria) this;
        }

        public Criteria andRetain4EqualTo(String value) {
            addCriterion("retain4 =", value, "retain4");
            return (Criteria) this;
        }

        public Criteria andRetain4NotEqualTo(String value) {
            addCriterion("retain4 <>", value, "retain4");
            return (Criteria) this;
        }

        public Criteria andRetain4GreaterThan(String value) {
            addCriterion("retain4 >", value, "retain4");
            return (Criteria) this;
        }

        public Criteria andRetain4GreaterThanOrEqualTo(String value) {
            addCriterion("retain4 >=", value, "retain4");
            return (Criteria) this;
        }

        public Criteria andRetain4LessThan(String value) {
            addCriterion("retain4 <", value, "retain4");
            return (Criteria) this;
        }

        public Criteria andRetain4LessThanOrEqualTo(String value) {
            addCriterion("retain4 <=", value, "retain4");
            return (Criteria) this;
        }

        public Criteria andRetain4Like(String value) {
            addCriterion("retain4 like", value, "retain4");
            return (Criteria) this;
        }

        public Criteria andRetain4NotLike(String value) {
            addCriterion("retain4 not like", value, "retain4");
            return (Criteria) this;
        }

        public Criteria andRetain4In(List<String> values) {
            addCriterion("retain4 in", values, "retain4");
            return (Criteria) this;
        }

        public Criteria andRetain4NotIn(List<String> values) {
            addCriterion("retain4 not in", values, "retain4");
            return (Criteria) this;
        }

        public Criteria andRetain4Between(String value1, String value2) {
            addCriterion("retain4 between", value1, value2, "retain4");
            return (Criteria) this;
        }

        public Criteria andRetain4NotBetween(String value1, String value2) {
            addCriterion("retain4 not between", value1, value2, "retain4");
            return (Criteria) this;
        }

        public Criteria andRetain5IsNull() {
            addCriterion("retain5 is null");
            return (Criteria) this;
        }

        public Criteria andRetain5IsNotNull() {
            addCriterion("retain5 is not null");
            return (Criteria) this;
        }

        public Criteria andRetain5EqualTo(String value) {
            addCriterion("retain5 =", value, "retain5");
            return (Criteria) this;
        }

        public Criteria andRetain5NotEqualTo(String value) {
            addCriterion("retain5 <>", value, "retain5");
            return (Criteria) this;
        }

        public Criteria andRetain5GreaterThan(String value) {
            addCriterion("retain5 >", value, "retain5");
            return (Criteria) this;
        }

        public Criteria andRetain5GreaterThanOrEqualTo(String value) {
            addCriterion("retain5 >=", value, "retain5");
            return (Criteria) this;
        }

        public Criteria andRetain5LessThan(String value) {
            addCriterion("retain5 <", value, "retain5");
            return (Criteria) this;
        }

        public Criteria andRetain5LessThanOrEqualTo(String value) {
            addCriterion("retain5 <=", value, "retain5");
            return (Criteria) this;
        }

        public Criteria andRetain5Like(String value) {
            addCriterion("retain5 like", value, "retain5");
            return (Criteria) this;
        }

        public Criteria andRetain5NotLike(String value) {
            addCriterion("retain5 not like", value, "retain5");
            return (Criteria) this;
        }

        public Criteria andRetain5In(List<String> values) {
            addCriterion("retain5 in", values, "retain5");
            return (Criteria) this;
        }

        public Criteria andRetain5NotIn(List<String> values) {
            addCriterion("retain5 not in", values, "retain5");
            return (Criteria) this;
        }

        public Criteria andRetain5Between(String value1, String value2) {
            addCriterion("retain5 between", value1, value2, "retain5");
            return (Criteria) this;
        }

        public Criteria andRetain5NotBetween(String value1, String value2) {
            addCriterion("retain5 not between", value1, value2, "retain5");
            return (Criteria) this;
        }

        public Criteria andRetain6IsNull() {
            addCriterion("retain6 is null");
            return (Criteria) this;
        }

        public Criteria andRetain6IsNotNull() {
            addCriterion("retain6 is not null");
            return (Criteria) this;
        }

        public Criteria andRetain6EqualTo(String value) {
            addCriterion("retain6 =", value, "retain6");
            return (Criteria) this;
        }

        public Criteria andRetain6NotEqualTo(String value) {
            addCriterion("retain6 <>", value, "retain6");
            return (Criteria) this;
        }

        public Criteria andRetain6GreaterThan(String value) {
            addCriterion("retain6 >", value, "retain6");
            return (Criteria) this;
        }

        public Criteria andRetain6GreaterThanOrEqualTo(String value) {
            addCriterion("retain6 >=", value, "retain6");
            return (Criteria) this;
        }

        public Criteria andRetain6LessThan(String value) {
            addCriterion("retain6 <", value, "retain6");
            return (Criteria) this;
        }

        public Criteria andRetain6LessThanOrEqualTo(String value) {
            addCriterion("retain6 <=", value, "retain6");
            return (Criteria) this;
        }

        public Criteria andRetain6Like(String value) {
            addCriterion("retain6 like", value, "retain6");
            return (Criteria) this;
        }

        public Criteria andRetain6NotLike(String value) {
            addCriterion("retain6 not like", value, "retain6");
            return (Criteria) this;
        }

        public Criteria andRetain6In(List<String> values) {
            addCriterion("retain6 in", values, "retain6");
            return (Criteria) this;
        }

        public Criteria andRetain6NotIn(List<String> values) {
            addCriterion("retain6 not in", values, "retain6");
            return (Criteria) this;
        }

        public Criteria andRetain6Between(String value1, String value2) {
            addCriterion("retain6 between", value1, value2, "retain6");
            return (Criteria) this;
        }

        public Criteria andRetain6NotBetween(String value1, String value2) {
            addCriterion("retain6 not between", value1, value2, "retain6");
            return (Criteria) this;
        }

        public Criteria andRetain7IsNull() {
            addCriterion("retain7 is null");
            return (Criteria) this;
        }

        public Criteria andRetain7IsNotNull() {
            addCriterion("retain7 is not null");
            return (Criteria) this;
        }

        public Criteria andRetain7EqualTo(String value) {
            addCriterion("retain7 =", value, "retain7");
            return (Criteria) this;
        }

        public Criteria andRetain7NotEqualTo(String value) {
            addCriterion("retain7 <>", value, "retain7");
            return (Criteria) this;
        }

        public Criteria andRetain7GreaterThan(String value) {
            addCriterion("retain7 >", value, "retain7");
            return (Criteria) this;
        }

        public Criteria andRetain7GreaterThanOrEqualTo(String value) {
            addCriterion("retain7 >=", value, "retain7");
            return (Criteria) this;
        }

        public Criteria andRetain7LessThan(String value) {
            addCriterion("retain7 <", value, "retain7");
            return (Criteria) this;
        }

        public Criteria andRetain7LessThanOrEqualTo(String value) {
            addCriterion("retain7 <=", value, "retain7");
            return (Criteria) this;
        }

        public Criteria andRetain7Like(String value) {
            addCriterion("retain7 like", value, "retain7");
            return (Criteria) this;
        }

        public Criteria andRetain7NotLike(String value) {
            addCriterion("retain7 not like", value, "retain7");
            return (Criteria) this;
        }

        public Criteria andRetain7In(List<String> values) {
            addCriterion("retain7 in", values, "retain7");
            return (Criteria) this;
        }

        public Criteria andRetain7NotIn(List<String> values) {
            addCriterion("retain7 not in", values, "retain7");
            return (Criteria) this;
        }

        public Criteria andRetain7Between(String value1, String value2) {
            addCriterion("retain7 between", value1, value2, "retain7");
            return (Criteria) this;
        }

        public Criteria andRetain7NotBetween(String value1, String value2) {
            addCriterion("retain7 not between", value1, value2, "retain7");
            return (Criteria) this;
        }

        public Criteria andRetain8IsNull() {
            addCriterion("retain8 is null");
            return (Criteria) this;
        }

        public Criteria andRetain8IsNotNull() {
            addCriterion("retain8 is not null");
            return (Criteria) this;
        }

        public Criteria andRetain8EqualTo(String value) {
            addCriterion("retain8 =", value, "retain8");
            return (Criteria) this;
        }

        public Criteria andRetain8NotEqualTo(String value) {
            addCriterion("retain8 <>", value, "retain8");
            return (Criteria) this;
        }

        public Criteria andRetain8GreaterThan(String value) {
            addCriterion("retain8 >", value, "retain8");
            return (Criteria) this;
        }

        public Criteria andRetain8GreaterThanOrEqualTo(String value) {
            addCriterion("retain8 >=", value, "retain8");
            return (Criteria) this;
        }

        public Criteria andRetain8LessThan(String value) {
            addCriterion("retain8 <", value, "retain8");
            return (Criteria) this;
        }

        public Criteria andRetain8LessThanOrEqualTo(String value) {
            addCriterion("retain8 <=", value, "retain8");
            return (Criteria) this;
        }

        public Criteria andRetain8Like(String value) {
            addCriterion("retain8 like", value, "retain8");
            return (Criteria) this;
        }

        public Criteria andRetain8NotLike(String value) {
            addCriterion("retain8 not like", value, "retain8");
            return (Criteria) this;
        }

        public Criteria andRetain8In(List<String> values) {
            addCriterion("retain8 in", values, "retain8");
            return (Criteria) this;
        }

        public Criteria andRetain8NotIn(List<String> values) {
            addCriterion("retain8 not in", values, "retain8");
            return (Criteria) this;
        }

        public Criteria andRetain8Between(String value1, String value2) {
            addCriterion("retain8 between", value1, value2, "retain8");
            return (Criteria) this;
        }

        public Criteria andRetain8NotBetween(String value1, String value2) {
            addCriterion("retain8 not between", value1, value2, "retain8");
            return (Criteria) this;
        }

        public Criteria andRetain9IsNull() {
            addCriterion("retain9 is null");
            return (Criteria) this;
        }

        public Criteria andRetain9IsNotNull() {
            addCriterion("retain9 is not null");
            return (Criteria) this;
        }

        public Criteria andRetain9EqualTo(String value) {
            addCriterion("retain9 =", value, "retain9");
            return (Criteria) this;
        }

        public Criteria andRetain9NotEqualTo(String value) {
            addCriterion("retain9 <>", value, "retain9");
            return (Criteria) this;
        }

        public Criteria andRetain9GreaterThan(String value) {
            addCriterion("retain9 >", value, "retain9");
            return (Criteria) this;
        }

        public Criteria andRetain9GreaterThanOrEqualTo(String value) {
            addCriterion("retain9 >=", value, "retain9");
            return (Criteria) this;
        }

        public Criteria andRetain9LessThan(String value) {
            addCriterion("retain9 <", value, "retain9");
            return (Criteria) this;
        }

        public Criteria andRetain9LessThanOrEqualTo(String value) {
            addCriterion("retain9 <=", value, "retain9");
            return (Criteria) this;
        }

        public Criteria andRetain9Like(String value) {
            addCriterion("retain9 like", value, "retain9");
            return (Criteria) this;
        }

        public Criteria andRetain9NotLike(String value) {
            addCriterion("retain9 not like", value, "retain9");
            return (Criteria) this;
        }

        public Criteria andRetain9In(List<String> values) {
            addCriterion("retain9 in", values, "retain9");
            return (Criteria) this;
        }

        public Criteria andRetain9NotIn(List<String> values) {
            addCriterion("retain9 not in", values, "retain9");
            return (Criteria) this;
        }

        public Criteria andRetain9Between(String value1, String value2) {
            addCriterion("retain9 between", value1, value2, "retain9");
            return (Criteria) this;
        }

        public Criteria andRetain9NotBetween(String value1, String value2) {
            addCriterion("retain9 not between", value1, value2, "retain9");
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