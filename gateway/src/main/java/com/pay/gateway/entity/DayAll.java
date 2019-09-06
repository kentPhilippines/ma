package com.pay.gateway.entity;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class DayAll {
	/**
	 * <p>年份</p>
	 */
    private Date reqDate;
    /**
     * <p>年</p>
     */
    private Integer reqYear;
    /**
     * <p>月</p>
     */
    private Integer reqMonth;
    /**
     * <p>日</p>
     */
    private Integer reqDay;
    /**
     * <p>周</p>
     */
    private Integer reqWeek;
    /**
     * <p>0:工作日;1:非工作日</p>
     */
    private Integer reqdayType;
    public Date getReqDate() {
        return reqDate;
    }
    public void setReqDate(Date reqDate) {
        this.reqDate = reqDate;
    }
    public Integer getReqYear() {
        return reqYear;
    }
    public void setReqYear(Integer reqYear) {
        this.reqYear = reqYear;
    }
    public Integer getReqMonth() {
        return reqMonth;
    }
    public void setReqMonth(Integer reqMonth) {
        this.reqMonth = reqMonth;
    }
    public Integer getReqDay() {
        return reqDay;
    }
    public void setReqDay(Integer reqDay) {
        this.reqDay = reqDay;
    }
    public Integer getReqWeek() {
        return reqWeek;
    }
    public void setReqWeek(Integer reqWeek) {
        this.reqWeek = reqWeek;
    }
    public Integer getReqdayType() {
        return reqdayType;
    }
    public void setReqdayType(Integer reqdayType) {
        this.reqdayType = reqdayType;
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}