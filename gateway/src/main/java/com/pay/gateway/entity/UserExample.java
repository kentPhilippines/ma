package com.pay.gateway.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("userId =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("userId <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("userId >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("userId >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("userId <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("userId <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("userId like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("userId not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("userId in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("userId not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("userId between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("userId not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("userName is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("userName is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("userName =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("userName <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("userName >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("userName >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("userName <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("userName <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("userName like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("userName not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("userName in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("userName not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("userName between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("userName not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNull() {
            addCriterion("userPassword is null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNotNull() {
            addCriterion("userPassword is not null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordEqualTo(String value) {
            addCriterion("userPassword =", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotEqualTo(String value) {
            addCriterion("userPassword <>", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThan(String value) {
            addCriterion("userPassword >", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("userPassword >=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThan(String value) {
            addCriterion("userPassword <", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThanOrEqualTo(String value) {
            addCriterion("userPassword <=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLike(String value) {
            addCriterion("userPassword like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotLike(String value) {
            addCriterion("userPassword not like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIn(List<String> values) {
            addCriterion("userPassword in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotIn(List<String> values) {
            addCriterion("userPassword not in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordBetween(String value1, String value2) {
            addCriterion("userPassword between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotBetween(String value1, String value2) {
            addCriterion("userPassword not between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserSaltIsNull() {
            addCriterion("userSalt is null");
            return (Criteria) this;
        }

        public Criteria andUserSaltIsNotNull() {
            addCriterion("userSalt is not null");
            return (Criteria) this;
        }

        public Criteria andUserSaltEqualTo(String value) {
            addCriterion("userSalt =", value, "userSalt");
            return (Criteria) this;
        }

        public Criteria andUserSaltNotEqualTo(String value) {
            addCriterion("userSalt <>", value, "userSalt");
            return (Criteria) this;
        }

        public Criteria andUserSaltGreaterThan(String value) {
            addCriterion("userSalt >", value, "userSalt");
            return (Criteria) this;
        }

        public Criteria andUserSaltGreaterThanOrEqualTo(String value) {
            addCriterion("userSalt >=", value, "userSalt");
            return (Criteria) this;
        }

        public Criteria andUserSaltLessThan(String value) {
            addCriterion("userSalt <", value, "userSalt");
            return (Criteria) this;
        }

        public Criteria andUserSaltLessThanOrEqualTo(String value) {
            addCriterion("userSalt <=", value, "userSalt");
            return (Criteria) this;
        }

        public Criteria andUserSaltLike(String value) {
            addCriterion("userSalt like", value, "userSalt");
            return (Criteria) this;
        }

        public Criteria andUserSaltNotLike(String value) {
            addCriterion("userSalt not like", value, "userSalt");
            return (Criteria) this;
        }

        public Criteria andUserSaltIn(List<String> values) {
            addCriterion("userSalt in", values, "userSalt");
            return (Criteria) this;
        }

        public Criteria andUserSaltNotIn(List<String> values) {
            addCriterion("userSalt not in", values, "userSalt");
            return (Criteria) this;
        }

        public Criteria andUserSaltBetween(String value1, String value2) {
            addCriterion("userSalt between", value1, value2, "userSalt");
            return (Criteria) this;
        }

        public Criteria andUserSaltNotBetween(String value1, String value2) {
            addCriterion("userSalt not between", value1, value2, "userSalt");
            return (Criteria) this;
        }

        public Criteria andUserMailIsNull() {
            addCriterion("userMail is null");
            return (Criteria) this;
        }

        public Criteria andUserMailIsNotNull() {
            addCriterion("userMail is not null");
            return (Criteria) this;
        }

        public Criteria andUserMailEqualTo(String value) {
            addCriterion("userMail =", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailNotEqualTo(String value) {
            addCriterion("userMail <>", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailGreaterThan(String value) {
            addCriterion("userMail >", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailGreaterThanOrEqualTo(String value) {
            addCriterion("userMail >=", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailLessThan(String value) {
            addCriterion("userMail <", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailLessThanOrEqualTo(String value) {
            addCriterion("userMail <=", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailLike(String value) {
            addCriterion("userMail like", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailNotLike(String value) {
            addCriterion("userMail not like", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailIn(List<String> values) {
            addCriterion("userMail in", values, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailNotIn(List<String> values) {
            addCriterion("userMail not in", values, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailBetween(String value1, String value2) {
            addCriterion("userMail between", value1, value2, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailNotBetween(String value1, String value2) {
            addCriterion("userMail not between", value1, value2, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNull() {
            addCriterion("userPhone is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("userPhone is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(String value) {
            addCriterion("userPhone =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(String value) {
            addCriterion("userPhone <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(String value) {
            addCriterion("userPhone >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("userPhone >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(String value) {
            addCriterion("userPhone <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("userPhone <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLike(String value) {
            addCriterion("userPhone like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotLike(String value) {
            addCriterion("userPhone not like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<String> values) {
            addCriterion("userPhone in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<String> values) {
            addCriterion("userPhone not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("userPhone between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("userPhone not between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserQQIsNull() {
            addCriterion("userQQ is null");
            return (Criteria) this;
        }

        public Criteria andUserQQIsNotNull() {
            addCriterion("userQQ is not null");
            return (Criteria) this;
        }

        public Criteria andUserQQEqualTo(String value) {
            addCriterion("userQQ =", value, "userQQ");
            return (Criteria) this;
        }

        public Criteria andUserQQNotEqualTo(String value) {
            addCriterion("userQQ <>", value, "userQQ");
            return (Criteria) this;
        }

        public Criteria andUserQQGreaterThan(String value) {
            addCriterion("userQQ >", value, "userQQ");
            return (Criteria) this;
        }

        public Criteria andUserQQGreaterThanOrEqualTo(String value) {
            addCriterion("userQQ >=", value, "userQQ");
            return (Criteria) this;
        }

        public Criteria andUserQQLessThan(String value) {
            addCriterion("userQQ <", value, "userQQ");
            return (Criteria) this;
        }

        public Criteria andUserQQLessThanOrEqualTo(String value) {
            addCriterion("userQQ <=", value, "userQQ");
            return (Criteria) this;
        }

        public Criteria andUserQQLike(String value) {
            addCriterion("userQQ like", value, "userQQ");
            return (Criteria) this;
        }

        public Criteria andUserQQNotLike(String value) {
            addCriterion("userQQ not like", value, "userQQ");
            return (Criteria) this;
        }

        public Criteria andUserQQIn(List<String> values) {
            addCriterion("userQQ in", values, "userQQ");
            return (Criteria) this;
        }

        public Criteria andUserQQNotIn(List<String> values) {
            addCriterion("userQQ not in", values, "userQQ");
            return (Criteria) this;
        }

        public Criteria andUserQQBetween(String value1, String value2) {
            addCriterion("userQQ between", value1, value2, "userQQ");
            return (Criteria) this;
        }

        public Criteria andUserQQNotBetween(String value1, String value2) {
            addCriterion("userQQ not between", value1, value2, "userQQ");
            return (Criteria) this;
        }

        public Criteria andUserWecharIsNull() {
            addCriterion("userWechar is null");
            return (Criteria) this;
        }

        public Criteria andUserWecharIsNotNull() {
            addCriterion("userWechar is not null");
            return (Criteria) this;
        }

        public Criteria andUserWecharEqualTo(String value) {
            addCriterion("userWechar =", value, "userWechar");
            return (Criteria) this;
        }

        public Criteria andUserWecharNotEqualTo(String value) {
            addCriterion("userWechar <>", value, "userWechar");
            return (Criteria) this;
        }

        public Criteria andUserWecharGreaterThan(String value) {
            addCriterion("userWechar >", value, "userWechar");
            return (Criteria) this;
        }

        public Criteria andUserWecharGreaterThanOrEqualTo(String value) {
            addCriterion("userWechar >=", value, "userWechar");
            return (Criteria) this;
        }

        public Criteria andUserWecharLessThan(String value) {
            addCriterion("userWechar <", value, "userWechar");
            return (Criteria) this;
        }

        public Criteria andUserWecharLessThanOrEqualTo(String value) {
            addCriterion("userWechar <=", value, "userWechar");
            return (Criteria) this;
        }

        public Criteria andUserWecharLike(String value) {
            addCriterion("userWechar like", value, "userWechar");
            return (Criteria) this;
        }

        public Criteria andUserWecharNotLike(String value) {
            addCriterion("userWechar not like", value, "userWechar");
            return (Criteria) this;
        }

        public Criteria andUserWecharIn(List<String> values) {
            addCriterion("userWechar in", values, "userWechar");
            return (Criteria) this;
        }

        public Criteria andUserWecharNotIn(List<String> values) {
            addCriterion("userWechar not in", values, "userWechar");
            return (Criteria) this;
        }

        public Criteria andUserWecharBetween(String value1, String value2) {
            addCriterion("userWechar between", value1, value2, "userWechar");
            return (Criteria) this;
        }

        public Criteria andUserWecharNotBetween(String value1, String value2) {
            addCriterion("userWechar not between", value1, value2, "userWechar");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("userType is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("userType is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(Integer value) {
            addCriterion("userType =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(Integer value) {
            addCriterion("userType <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(Integer value) {
            addCriterion("userType >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("userType >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(Integer value) {
            addCriterion("userType <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(Integer value) {
            addCriterion("userType <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<Integer> values) {
            addCriterion("userType in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<Integer> values) {
            addCriterion("userType not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(Integer value1, Integer value2) {
            addCriterion("userType between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("userType not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserAddressIsNull() {
            addCriterion("userAddress is null");
            return (Criteria) this;
        }

        public Criteria andUserAddressIsNotNull() {
            addCriterion("userAddress is not null");
            return (Criteria) this;
        }

        public Criteria andUserAddressEqualTo(String value) {
            addCriterion("userAddress =", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotEqualTo(String value) {
            addCriterion("userAddress <>", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressGreaterThan(String value) {
            addCriterion("userAddress >", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressGreaterThanOrEqualTo(String value) {
            addCriterion("userAddress >=", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressLessThan(String value) {
            addCriterion("userAddress <", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressLessThanOrEqualTo(String value) {
            addCriterion("userAddress <=", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressLike(String value) {
            addCriterion("userAddress like", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotLike(String value) {
            addCriterion("userAddress not like", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressIn(List<String> values) {
            addCriterion("userAddress in", values, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotIn(List<String> values) {
            addCriterion("userAddress not in", values, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressBetween(String value1, String value2) {
            addCriterion("userAddress between", value1, value2, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotBetween(String value1, String value2) {
            addCriterion("userAddress not between", value1, value2, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserCityIsNull() {
            addCriterion("userCity is null");
            return (Criteria) this;
        }

        public Criteria andUserCityIsNotNull() {
            addCriterion("userCity is not null");
            return (Criteria) this;
        }

        public Criteria andUserCityEqualTo(String value) {
            addCriterion("userCity =", value, "userCity");
            return (Criteria) this;
        }

        public Criteria andUserCityNotEqualTo(String value) {
            addCriterion("userCity <>", value, "userCity");
            return (Criteria) this;
        }

        public Criteria andUserCityGreaterThan(String value) {
            addCriterion("userCity >", value, "userCity");
            return (Criteria) this;
        }

        public Criteria andUserCityGreaterThanOrEqualTo(String value) {
            addCriterion("userCity >=", value, "userCity");
            return (Criteria) this;
        }

        public Criteria andUserCityLessThan(String value) {
            addCriterion("userCity <", value, "userCity");
            return (Criteria) this;
        }

        public Criteria andUserCityLessThanOrEqualTo(String value) {
            addCriterion("userCity <=", value, "userCity");
            return (Criteria) this;
        }

        public Criteria andUserCityLike(String value) {
            addCriterion("userCity like", value, "userCity");
            return (Criteria) this;
        }

        public Criteria andUserCityNotLike(String value) {
            addCriterion("userCity not like", value, "userCity");
            return (Criteria) this;
        }

        public Criteria andUserCityIn(List<String> values) {
            addCriterion("userCity in", values, "userCity");
            return (Criteria) this;
        }

        public Criteria andUserCityNotIn(List<String> values) {
            addCriterion("userCity not in", values, "userCity");
            return (Criteria) this;
        }

        public Criteria andUserCityBetween(String value1, String value2) {
            addCriterion("userCity between", value1, value2, "userCity");
            return (Criteria) this;
        }

        public Criteria andUserCityNotBetween(String value1, String value2) {
            addCriterion("userCity not between", value1, value2, "userCity");
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

        public Criteria andPayPasswordIsNull() {
            addCriterion("payPassword is null");
            return (Criteria) this;
        }

        public Criteria andPayPasswordIsNotNull() {
            addCriterion("payPassword is not null");
            return (Criteria) this;
        }

        public Criteria andPayPasswordEqualTo(String value) {
            addCriterion("payPassword =", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordNotEqualTo(String value) {
            addCriterion("payPassword <>", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordGreaterThan(String value) {
            addCriterion("payPassword >", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("payPassword >=", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordLessThan(String value) {
            addCriterion("payPassword <", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordLessThanOrEqualTo(String value) {
            addCriterion("payPassword <=", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordLike(String value) {
            addCriterion("payPassword like", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordNotLike(String value) {
            addCriterion("payPassword not like", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordIn(List<String> values) {
            addCriterion("payPassword in", values, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordNotIn(List<String> values) {
            addCriterion("payPassword not in", values, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordBetween(String value1, String value2) {
            addCriterion("payPassword between", value1, value2, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordNotBetween(String value1, String value2) {
            addCriterion("payPassword not between", value1, value2, "payPassword");
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

        public Criteria andRetain10IsNull() {
            addCriterion("retain10 is null");
            return (Criteria) this;
        }

        public Criteria andRetain10IsNotNull() {
            addCriterion("retain10 is not null");
            return (Criteria) this;
        }

        public Criteria andRetain10EqualTo(String value) {
            addCriterion("retain10 =", value, "retain10");
            return (Criteria) this;
        }

        public Criteria andRetain10NotEqualTo(String value) {
            addCriterion("retain10 <>", value, "retain10");
            return (Criteria) this;
        }

        public Criteria andRetain10GreaterThan(String value) {
            addCriterion("retain10 >", value, "retain10");
            return (Criteria) this;
        }

        public Criteria andRetain10GreaterThanOrEqualTo(String value) {
            addCriterion("retain10 >=", value, "retain10");
            return (Criteria) this;
        }

        public Criteria andRetain10LessThan(String value) {
            addCriterion("retain10 <", value, "retain10");
            return (Criteria) this;
        }

        public Criteria andRetain10LessThanOrEqualTo(String value) {
            addCriterion("retain10 <=", value, "retain10");
            return (Criteria) this;
        }

        public Criteria andRetain10Like(String value) {
            addCriterion("retain10 like", value, "retain10");
            return (Criteria) this;
        }

        public Criteria andRetain10NotLike(String value) {
            addCriterion("retain10 not like", value, "retain10");
            return (Criteria) this;
        }

        public Criteria andRetain10In(List<String> values) {
            addCriterion("retain10 in", values, "retain10");
            return (Criteria) this;
        }

        public Criteria andRetain10NotIn(List<String> values) {
            addCriterion("retain10 not in", values, "retain10");
            return (Criteria) this;
        }

        public Criteria andRetain10Between(String value1, String value2) {
            addCriterion("retain10 between", value1, value2, "retain10");
            return (Criteria) this;
        }

        public Criteria andRetain10NotBetween(String value1, String value2) {
            addCriterion("retain10 not between", value1, value2, "retain10");
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