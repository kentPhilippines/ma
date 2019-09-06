package com.pay.gateway.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DayAllExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DayAllExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andReqDateIsNull() {
            addCriterion("reqDate is null");
            return (Criteria) this;
        }

        public Criteria andReqDateIsNotNull() {
            addCriterion("reqDate is not null");
            return (Criteria) this;
        }

        public Criteria andReqDateEqualTo(Date value) {
            addCriterionForJDBCDate("reqDate =", value, "reqDate");
            return (Criteria) this;
        }

        public Criteria andReqDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("reqDate <>", value, "reqDate");
            return (Criteria) this;
        }

        public Criteria andReqDateGreaterThan(Date value) {
            addCriterionForJDBCDate("reqDate >", value, "reqDate");
            return (Criteria) this;
        }

        public Criteria andReqDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("reqDate >=", value, "reqDate");
            return (Criteria) this;
        }

        public Criteria andReqDateLessThan(Date value) {
            addCriterionForJDBCDate("reqDate <", value, "reqDate");
            return (Criteria) this;
        }

        public Criteria andReqDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("reqDate <=", value, "reqDate");
            return (Criteria) this;
        }

        public Criteria andReqDateIn(List<Date> values) {
            addCriterionForJDBCDate("reqDate in", values, "reqDate");
            return (Criteria) this;
        }

        public Criteria andReqDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("reqDate not in", values, "reqDate");
            return (Criteria) this;
        }

        public Criteria andReqDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("reqDate between", value1, value2, "reqDate");
            return (Criteria) this;
        }

        public Criteria andReqDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("reqDate not between", value1, value2, "reqDate");
            return (Criteria) this;
        }

        public Criteria andReqYearIsNull() {
            addCriterion("reqYear is null");
            return (Criteria) this;
        }

        public Criteria andReqYearIsNotNull() {
            addCriterion("reqYear is not null");
            return (Criteria) this;
        }

        public Criteria andReqYearEqualTo(Integer value) {
            addCriterion("reqYear =", value, "reqYear");
            return (Criteria) this;
        }

        public Criteria andReqYearNotEqualTo(Integer value) {
            addCriterion("reqYear <>", value, "reqYear");
            return (Criteria) this;
        }

        public Criteria andReqYearGreaterThan(Integer value) {
            addCriterion("reqYear >", value, "reqYear");
            return (Criteria) this;
        }

        public Criteria andReqYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("reqYear >=", value, "reqYear");
            return (Criteria) this;
        }

        public Criteria andReqYearLessThan(Integer value) {
            addCriterion("reqYear <", value, "reqYear");
            return (Criteria) this;
        }

        public Criteria andReqYearLessThanOrEqualTo(Integer value) {
            addCriterion("reqYear <=", value, "reqYear");
            return (Criteria) this;
        }

        public Criteria andReqYearIn(List<Integer> values) {
            addCriterion("reqYear in", values, "reqYear");
            return (Criteria) this;
        }

        public Criteria andReqYearNotIn(List<Integer> values) {
            addCriterion("reqYear not in", values, "reqYear");
            return (Criteria) this;
        }

        public Criteria andReqYearBetween(Integer value1, Integer value2) {
            addCriterion("reqYear between", value1, value2, "reqYear");
            return (Criteria) this;
        }

        public Criteria andReqYearNotBetween(Integer value1, Integer value2) {
            addCriterion("reqYear not between", value1, value2, "reqYear");
            return (Criteria) this;
        }

        public Criteria andReqMonthIsNull() {
            addCriterion("reqMonth is null");
            return (Criteria) this;
        }

        public Criteria andReqMonthIsNotNull() {
            addCriterion("reqMonth is not null");
            return (Criteria) this;
        }

        public Criteria andReqMonthEqualTo(Integer value) {
            addCriterion("reqMonth =", value, "reqMonth");
            return (Criteria) this;
        }

        public Criteria andReqMonthNotEqualTo(Integer value) {
            addCriterion("reqMonth <>", value, "reqMonth");
            return (Criteria) this;
        }

        public Criteria andReqMonthGreaterThan(Integer value) {
            addCriterion("reqMonth >", value, "reqMonth");
            return (Criteria) this;
        }

        public Criteria andReqMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("reqMonth >=", value, "reqMonth");
            return (Criteria) this;
        }

        public Criteria andReqMonthLessThan(Integer value) {
            addCriterion("reqMonth <", value, "reqMonth");
            return (Criteria) this;
        }

        public Criteria andReqMonthLessThanOrEqualTo(Integer value) {
            addCriterion("reqMonth <=", value, "reqMonth");
            return (Criteria) this;
        }

        public Criteria andReqMonthIn(List<Integer> values) {
            addCriterion("reqMonth in", values, "reqMonth");
            return (Criteria) this;
        }

        public Criteria andReqMonthNotIn(List<Integer> values) {
            addCriterion("reqMonth not in", values, "reqMonth");
            return (Criteria) this;
        }

        public Criteria andReqMonthBetween(Integer value1, Integer value2) {
            addCriterion("reqMonth between", value1, value2, "reqMonth");
            return (Criteria) this;
        }

        public Criteria andReqMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("reqMonth not between", value1, value2, "reqMonth");
            return (Criteria) this;
        }

        public Criteria andReqDayIsNull() {
            addCriterion("reqDay is null");
            return (Criteria) this;
        }

        public Criteria andReqDayIsNotNull() {
            addCriterion("reqDay is not null");
            return (Criteria) this;
        }

        public Criteria andReqDayEqualTo(Integer value) {
            addCriterion("reqDay =", value, "reqDay");
            return (Criteria) this;
        }

        public Criteria andReqDayNotEqualTo(Integer value) {
            addCriterion("reqDay <>", value, "reqDay");
            return (Criteria) this;
        }

        public Criteria andReqDayGreaterThan(Integer value) {
            addCriterion("reqDay >", value, "reqDay");
            return (Criteria) this;
        }

        public Criteria andReqDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("reqDay >=", value, "reqDay");
            return (Criteria) this;
        }

        public Criteria andReqDayLessThan(Integer value) {
            addCriterion("reqDay <", value, "reqDay");
            return (Criteria) this;
        }

        public Criteria andReqDayLessThanOrEqualTo(Integer value) {
            addCriterion("reqDay <=", value, "reqDay");
            return (Criteria) this;
        }

        public Criteria andReqDayIn(List<Integer> values) {
            addCriterion("reqDay in", values, "reqDay");
            return (Criteria) this;
        }

        public Criteria andReqDayNotIn(List<Integer> values) {
            addCriterion("reqDay not in", values, "reqDay");
            return (Criteria) this;
        }

        public Criteria andReqDayBetween(Integer value1, Integer value2) {
            addCriterion("reqDay between", value1, value2, "reqDay");
            return (Criteria) this;
        }

        public Criteria andReqDayNotBetween(Integer value1, Integer value2) {
            addCriterion("reqDay not between", value1, value2, "reqDay");
            return (Criteria) this;
        }

        public Criteria andReqWeekIsNull() {
            addCriterion("reqWeek is null");
            return (Criteria) this;
        }

        public Criteria andReqWeekIsNotNull() {
            addCriterion("reqWeek is not null");
            return (Criteria) this;
        }

        public Criteria andReqWeekEqualTo(Integer value) {
            addCriterion("reqWeek =", value, "reqWeek");
            return (Criteria) this;
        }

        public Criteria andReqWeekNotEqualTo(Integer value) {
            addCriterion("reqWeek <>", value, "reqWeek");
            return (Criteria) this;
        }

        public Criteria andReqWeekGreaterThan(Integer value) {
            addCriterion("reqWeek >", value, "reqWeek");
            return (Criteria) this;
        }

        public Criteria andReqWeekGreaterThanOrEqualTo(Integer value) {
            addCriterion("reqWeek >=", value, "reqWeek");
            return (Criteria) this;
        }

        public Criteria andReqWeekLessThan(Integer value) {
            addCriterion("reqWeek <", value, "reqWeek");
            return (Criteria) this;
        }

        public Criteria andReqWeekLessThanOrEqualTo(Integer value) {
            addCriterion("reqWeek <=", value, "reqWeek");
            return (Criteria) this;
        }

        public Criteria andReqWeekIn(List<Integer> values) {
            addCriterion("reqWeek in", values, "reqWeek");
            return (Criteria) this;
        }

        public Criteria andReqWeekNotIn(List<Integer> values) {
            addCriterion("reqWeek not in", values, "reqWeek");
            return (Criteria) this;
        }

        public Criteria andReqWeekBetween(Integer value1, Integer value2) {
            addCriterion("reqWeek between", value1, value2, "reqWeek");
            return (Criteria) this;
        }

        public Criteria andReqWeekNotBetween(Integer value1, Integer value2) {
            addCriterion("reqWeek not between", value1, value2, "reqWeek");
            return (Criteria) this;
        }

        public Criteria andReqdayTypeIsNull() {
            addCriterion("reqdayType is null");
            return (Criteria) this;
        }

        public Criteria andReqdayTypeIsNotNull() {
            addCriterion("reqdayType is not null");
            return (Criteria) this;
        }

        public Criteria andReqdayTypeEqualTo(Integer value) {
            addCriterion("reqdayType =", value, "reqdayType");
            return (Criteria) this;
        }

        public Criteria andReqdayTypeNotEqualTo(Integer value) {
            addCriterion("reqdayType <>", value, "reqdayType");
            return (Criteria) this;
        }

        public Criteria andReqdayTypeGreaterThan(Integer value) {
            addCriterion("reqdayType >", value, "reqdayType");
            return (Criteria) this;
        }

        public Criteria andReqdayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("reqdayType >=", value, "reqdayType");
            return (Criteria) this;
        }

        public Criteria andReqdayTypeLessThan(Integer value) {
            addCriterion("reqdayType <", value, "reqdayType");
            return (Criteria) this;
        }

        public Criteria andReqdayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("reqdayType <=", value, "reqdayType");
            return (Criteria) this;
        }

        public Criteria andReqdayTypeIn(List<Integer> values) {
            addCriterion("reqdayType in", values, "reqdayType");
            return (Criteria) this;
        }

        public Criteria andReqdayTypeNotIn(List<Integer> values) {
            addCriterion("reqdayType not in", values, "reqdayType");
            return (Criteria) this;
        }

        public Criteria andReqdayTypeBetween(Integer value1, Integer value2) {
            addCriterion("reqdayType between", value1, value2, "reqdayType");
            return (Criteria) this;
        }

        public Criteria andReqdayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("reqdayType not between", value1, value2, "reqdayType");
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