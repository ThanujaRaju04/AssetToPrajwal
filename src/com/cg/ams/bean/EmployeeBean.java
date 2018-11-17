package com.cg.ams.bean;

import java.util.Date;

public class EmployeeBean {
	private int empNo;
	private String empName;
	private String job;
	private int mgr;
	private Date hireDate;
	private int deptId;

	public EmployeeBean() {
		super();
	}

	public EmployeeBean(int empNo, String empName, String job, int mgr,
			Date hireDate, int deptId) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.job = job;
		this.mgr = mgr;
		this.hireDate = hireDate;
		this.deptId = deptId;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

}
