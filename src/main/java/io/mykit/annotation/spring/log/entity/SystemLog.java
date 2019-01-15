package io.mykit.annotation.spring.log.entity;

import java.util.Date;

/**
 * ������־��ʵ����Ϣ
 * @author whl
 *
 */
public class SystemLog {

	private String id;
	private String description;
	 
	private String method;
 
	private Long logType;
 
	private String requestIp;
 
	private String exceptioncode;
 
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Long getLogType() {
		return logType;
	}

	public void setLogType(Long logType) {
		this.logType = logType;
	}

	public String getRequestIp() {
		return requestIp;
	}

	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp;
	}

	public String getExceptioncode() {
		return exceptioncode;
	}

	public void setExceptioncode(String exceptioncode) {
		this.exceptioncode = exceptioncode;
	}

	public String getExceptionDetail() {
		return exceptionDetail;
	}

	public void setExceptionDetail(String exceptionDetail) {
		this.exceptionDetail = exceptionDetail;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	private String exceptionDetail;
 
	private String params;
 
	private String createBy;
 
	private Date createDate;

	

}
