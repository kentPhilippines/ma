package com.pay.gateway.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankCardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BankCardExample() {
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

        public Criteria andBankIdIsNull() {
            addCriterion("bankId is null");
            return (Criteria) this;
        }

        public Criteria andBankIdIsNotNull() {
            addCriterion("bankId is not null");
            return (Criteria) this;
        }

        public Criteria andBankIdEqualTo(Integer value) {
            addCriterion("bankId =", value, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdNotEqualTo(Integer value) {
            addCriterion("bankId <>", value, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdGreaterThan(Integer value) {
            addCriterion("bankId >", value, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bankId >=", value, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdLessThan(Integer value) {
            addCriterion("bankId <", value, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdLessThanOrEqualTo(Integer value) {
            addCriterion("bankId <=", value, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdIn(List<Integer> values) {
            addCriterion("bankId in", values, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdNotIn(List<Integer> values) {
            addCriterion("bankId not in", values, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdBetween(Integer value1, Integer value2) {
            addCriterion("bankId between", value1, value2, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bankId not between", value1, value2, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankTypeIsNull() {
            addCriterion("bankType is null");
            return (Criteria) this;
        }

        public Criteria andBankTypeIsNotNull() {
            addCriterion("bankType is not null");
            return (Criteria) this;
        }

        public Criteria andBankTypeEqualTo(Integer value) {
            addCriterion("bankType =", value, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeNotEqualTo(Integer value) {
            addCriterion("bankType <>", value, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeGreaterThan(Integer value) {
            addCriterion("bankType >", value, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("bankType >=", value, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeLessThan(Integer value) {
            addCriterion("bankType <", value, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeLessThanOrEqualTo(Integer value) {
            addCriterion("bankType <=", value, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeIn(List<Integer> values) {
            addCriterion("bankType in", values, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeNotIn(List<Integer> values) {
            addCriterion("bankType not in", values, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeBetween(Integer value1, Integer value2) {
            addCriterion("bankType between", value1, value2, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("bankType not between", value1, value2, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankCardIsNull() {
            addCriterion("bankCard is null");
            return (Criteria) this;
        }

        public Criteria andBankCardIsNotNull() {
            addCriterion("bankCard is not null");
            return (Criteria) this;
        }

        public Criteria andBankCardEqualTo(String value) {
            addCriterion("bankCard =", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardNotEqualTo(String value) {
            addCriterion("bankCard <>", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardGreaterThan(String value) {
            addCriterion("bankCard >", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardGreaterThanOrEqualTo(String value) {
            addCriterion("bankCard >=", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardLessThan(String value) {
            addCriterion("bankCard <", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardLessThanOrEqualTo(String value) {
            addCriterion("bankCard <=", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardLike(String value) {
            addCriterion("bankCard like", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardNotLike(String value) {
            addCriterion("bankCard not like", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardIn(List<String> values) {
            addCriterion("bankCard in", values, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardNotIn(List<String> values) {
            addCriterion("bankCard not in", values, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardBetween(String value1, String value2) {
            addCriterion("bankCard between", value1, value2, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardNotBetween(String value1, String value2) {
            addCriterion("bankCard not between", value1, value2, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("bankName is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("bankName is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("bankName =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("bankName <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("bankName >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("bankName >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("bankName <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("bankName <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("bankName like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("bankName not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("bankName in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("bankName not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("bankName between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("bankName not between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andCardholderIsNull() {
            addCriterion("cardholder is null");
            return (Criteria) this;
        }

        public Criteria andCardholderIsNotNull() {
            addCriterion("cardholder is not null");
            return (Criteria) this;
        }

        public Criteria andCardholderEqualTo(String value) {
            addCriterion("cardholder =", value, "cardholder");
            return (Criteria) this;
        }

        public Criteria andCardholderNotEqualTo(String value) {
            addCriterion("cardholder <>", value, "cardholder");
            return (Criteria) this;
        }

        public Criteria andCardholderGreaterThan(String value) {
            addCriterion("cardholder >", value, "cardholder");
            return (Criteria) this;
        }

        public Criteria andCardholderGreaterThanOrEqualTo(String value) {
            addCriterion("cardholder >=", value, "cardholder");
            return (Criteria) this;
        }

        public Criteria andCardholderLessThan(String value) {
            addCriterion("cardholder <", value, "cardholder");
            return (Criteria) this;
        }

        public Criteria andCardholderLessThanOrEqualTo(String value) {
            addCriterion("cardholder <=", value, "cardholder");
            return (Criteria) this;
        }

        public Criteria andCardholderLike(String value) {
            addCriterion("cardholder like", value, "cardholder");
            return (Criteria) this;
        }

        public Criteria andCardholderNotLike(String value) {
            addCriterion("cardholder not like", value, "cardholder");
            return (Criteria) this;
        }

        public Criteria andCardholderIn(List<String> values) {
            addCriterion("cardholder in", values, "cardholder");
            return (Criteria) this;
        }

        public Criteria andCardholderNotIn(List<String> values) {
            addCriterion("cardholder not in", values, "cardholder");
            return (Criteria) this;
        }

        public Criteria andCardholderBetween(String value1, String value2) {
            addCriterion("cardholder between", value1, value2, "cardholder");
            return (Criteria) this;
        }

        public Criteria andCardholderNotBetween(String value1, String value2) {
            addCriterion("cardholder not between", value1, value2, "cardholder");
            return (Criteria) this;
        }

        public Criteria andTreasurerIsNull() {
            addCriterion("treasurer is null");
            return (Criteria) this;
        }

        public Criteria andTreasurerIsNotNull() {
            addCriterion("treasurer is not null");
            return (Criteria) this;
        }

        public Criteria andTreasurerEqualTo(String value) {
            addCriterion("treasurer =", value, "treasurer");
            return (Criteria) this;
        }

        public Criteria andTreasurerNotEqualTo(String value) {
            addCriterion("treasurer <>", value, "treasurer");
            return (Criteria) this;
        }

        public Criteria andTreasurerGreaterThan(String value) {
            addCriterion("treasurer >", value, "treasurer");
            return (Criteria) this;
        }

        public Criteria andTreasurerGreaterThanOrEqualTo(String value) {
            addCriterion("treasurer >=", value, "treasurer");
            return (Criteria) this;
        }

        public Criteria andTreasurerLessThan(String value) {
            addCriterion("treasurer <", value, "treasurer");
            return (Criteria) this;
        }

        public Criteria andTreasurerLessThanOrEqualTo(String value) {
            addCriterion("treasurer <=", value, "treasurer");
            return (Criteria) this;
        }

        public Criteria andTreasurerLike(String value) {
            addCriterion("treasurer like", value, "treasurer");
            return (Criteria) this;
        }

        public Criteria andTreasurerNotLike(String value) {
            addCriterion("treasurer not like", value, "treasurer");
            return (Criteria) this;
        }

        public Criteria andTreasurerIn(List<String> values) {
            addCriterion("treasurer in", values, "treasurer");
            return (Criteria) this;
        }

        public Criteria andTreasurerNotIn(List<String> values) {
            addCriterion("treasurer not in", values, "treasurer");
            return (Criteria) this;
        }

        public Criteria andTreasurerBetween(String value1, String value2) {
            addCriterion("treasurer between", value1, value2, "treasurer");
            return (Criteria) this;
        }

        public Criteria andTreasurerNotBetween(String value1, String value2) {
            addCriterion("treasurer not between", value1, value2, "treasurer");
            return (Criteria) this;
        }

        public Criteria andLiabilitiesIsNull() {
            addCriterion("liabilities is null");
            return (Criteria) this;
        }

        public Criteria andLiabilitiesIsNotNull() {
            addCriterion("liabilities is not null");
            return (Criteria) this;
        }

        public Criteria andLiabilitiesEqualTo(String value) {
            addCriterion("liabilities =", value, "liabilities");
            return (Criteria) this;
        }

        public Criteria andLiabilitiesNotEqualTo(String value) {
            addCriterion("liabilities <>", value, "liabilities");
            return (Criteria) this;
        }

        public Criteria andLiabilitiesGreaterThan(String value) {
            addCriterion("liabilities >", value, "liabilities");
            return (Criteria) this;
        }

        public Criteria andLiabilitiesGreaterThanOrEqualTo(String value) {
            addCriterion("liabilities >=", value, "liabilities");
            return (Criteria) this;
        }

        public Criteria andLiabilitiesLessThan(String value) {
            addCriterion("liabilities <", value, "liabilities");
            return (Criteria) this;
        }

        public Criteria andLiabilitiesLessThanOrEqualTo(String value) {
            addCriterion("liabilities <=", value, "liabilities");
            return (Criteria) this;
        }

        public Criteria andLiabilitiesLike(String value) {
            addCriterion("liabilities like", value, "liabilities");
            return (Criteria) this;
        }

        public Criteria andLiabilitiesNotLike(String value) {
            addCriterion("liabilities not like", value, "liabilities");
            return (Criteria) this;
        }

        public Criteria andLiabilitiesIn(List<String> values) {
            addCriterion("liabilities in", values, "liabilities");
            return (Criteria) this;
        }

        public Criteria andLiabilitiesNotIn(List<String> values) {
            addCriterion("liabilities not in", values, "liabilities");
            return (Criteria) this;
        }

        public Criteria andLiabilitiesBetween(String value1, String value2) {
            addCriterion("liabilities between", value1, value2, "liabilities");
            return (Criteria) this;
        }

        public Criteria andLiabilitiesNotBetween(String value1, String value2) {
            addCriterion("liabilities not between", value1, value2, "liabilities");
            return (Criteria) this;
        }

        public Criteria andBankAmountIsNull() {
            addCriterion("bankAmount is null");
            return (Criteria) this;
        }

        public Criteria andBankAmountIsNotNull() {
            addCriterion("bankAmount is not null");
            return (Criteria) this;
        }

        public Criteria andBankAmountEqualTo(BigDecimal value) {
            addCriterion("bankAmount =", value, "bankAmount");
            return (Criteria) this;
        }

        public Criteria andBankAmountNotEqualTo(BigDecimal value) {
            addCriterion("bankAmount <>", value, "bankAmount");
            return (Criteria) this;
        }

        public Criteria andBankAmountGreaterThan(BigDecimal value) {
            addCriterion("bankAmount >", value, "bankAmount");
            return (Criteria) this;
        }

        public Criteria andBankAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bankAmount >=", value, "bankAmount");
            return (Criteria) this;
        }

        public Criteria andBankAmountLessThan(BigDecimal value) {
            addCriterion("bankAmount <", value, "bankAmount");
            return (Criteria) this;
        }

        public Criteria andBankAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bankAmount <=", value, "bankAmount");
            return (Criteria) this;
        }

        public Criteria andBankAmountIn(List<BigDecimal> values) {
            addCriterion("bankAmount in", values, "bankAmount");
            return (Criteria) this;
        }

        public Criteria andBankAmountNotIn(List<BigDecimal> values) {
            addCriterion("bankAmount not in", values, "bankAmount");
            return (Criteria) this;
        }

        public Criteria andBankAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bankAmount between", value1, value2, "bankAmount");
            return (Criteria) this;
        }

        public Criteria andBankAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bankAmount not between", value1, value2, "bankAmount");
            return (Criteria) this;
        }

        public Criteria andBankPhoneIsNull() {
            addCriterion("bankPhone is null");
            return (Criteria) this;
        }

        public Criteria andBankPhoneIsNotNull() {
            addCriterion("bankPhone is not null");
            return (Criteria) this;
        }

        public Criteria andBankPhoneEqualTo(String value) {
            addCriterion("bankPhone =", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneNotEqualTo(String value) {
            addCriterion("bankPhone <>", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneGreaterThan(String value) {
            addCriterion("bankPhone >", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("bankPhone >=", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneLessThan(String value) {
            addCriterion("bankPhone <", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneLessThanOrEqualTo(String value) {
            addCriterion("bankPhone <=", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneLike(String value) {
            addCriterion("bankPhone like", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneNotLike(String value) {
            addCriterion("bankPhone not like", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneIn(List<String> values) {
            addCriterion("bankPhone in", values, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneNotIn(List<String> values) {
            addCriterion("bankPhone not in", values, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneBetween(String value1, String value2) {
            addCriterion("bankPhone between", value1, value2, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneNotBetween(String value1, String value2) {
            addCriterion("bankPhone not between", value1, value2, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andCardholderIdIsNull() {
            addCriterion("cardholderId is null");
            return (Criteria) this;
        }

        public Criteria andCardholderIdIsNotNull() {
            addCriterion("cardholderId is not null");
            return (Criteria) this;
        }

        public Criteria andCardholderIdEqualTo(String value) {
            addCriterion("cardholderId =", value, "cardholderId");
            return (Criteria) this;
        }

        public Criteria andCardholderIdNotEqualTo(String value) {
            addCriterion("cardholderId <>", value, "cardholderId");
            return (Criteria) this;
        }

        public Criteria andCardholderIdGreaterThan(String value) {
            addCriterion("cardholderId >", value, "cardholderId");
            return (Criteria) this;
        }

        public Criteria andCardholderIdGreaterThanOrEqualTo(String value) {
            addCriterion("cardholderId >=", value, "cardholderId");
            return (Criteria) this;
        }

        public Criteria andCardholderIdLessThan(String value) {
            addCriterion("cardholderId <", value, "cardholderId");
            return (Criteria) this;
        }

        public Criteria andCardholderIdLessThanOrEqualTo(String value) {
            addCriterion("cardholderId <=", value, "cardholderId");
            return (Criteria) this;
        }

        public Criteria andCardholderIdLike(String value) {
            addCriterion("cardholderId like", value, "cardholderId");
            return (Criteria) this;
        }

        public Criteria andCardholderIdNotLike(String value) {
            addCriterion("cardholderId not like", value, "cardholderId");
            return (Criteria) this;
        }

        public Criteria andCardholderIdIn(List<String> values) {
            addCriterion("cardholderId in", values, "cardholderId");
            return (Criteria) this;
        }

        public Criteria andCardholderIdNotIn(List<String> values) {
            addCriterion("cardholderId not in", values, "cardholderId");
            return (Criteria) this;
        }

        public Criteria andCardholderIdBetween(String value1, String value2) {
            addCriterion("cardholderId between", value1, value2, "cardholderId");
            return (Criteria) this;
        }

        public Criteria andCardholderIdNotBetween(String value1, String value2) {
            addCriterion("cardholderId not between", value1, value2, "cardholderId");
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