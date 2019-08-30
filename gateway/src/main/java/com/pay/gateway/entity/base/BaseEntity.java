package com.pay.gateway.entity.base;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BaseEntity {
	/**
	 * <p>数据id</p>
	 * 数据库自动生成
	 * <strong><u>主键,唯一索引</u></strong>
	 */
    private Integer id;
    /**
   	 * <p>用户数据创建时间</p>
   	 */
    private Timestamp createTime =  createTime();
    /**
	 * <p>用户提交时间</p>
	 */
    private Timestamp submitTime  = createTime();
    /**
   	 * <p>提交系统</p>
   	 * <strong><u>全局索引</u></strong>
   	 * <div>该字段用户区分系统数据</div>
   	 */
    private String submitSystem  = "PP";
    
    /**
     * <p>数据状态</p>
     * <li>状态:1可使用；0不可使用</li>
     */
    private Integer status = 1;
    
    
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(Timestamp submitTime) {
		this.submitTime = submitTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSubmitSystem() {
		return submitSystem;
	}
	public void setSubmitSystem(String submitSystem) {
		this.submitSystem = submitSystem;
	}
	Timestamp createTime()  {
		String nowtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date m_time1;
		try {
			m_time1 = sdf.parse(nowtime);
			Timestamp m_time2 = new Timestamp(m_time1.getTime());
			return m_time2;
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		return new Timestamp(new Date().getTime());
	}


}
