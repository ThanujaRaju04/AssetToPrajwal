package com.cg.ams.bean;

public class AssetAllocationBean {
	private int allocationId;
	private String assetName;
	private int empNo;
    private String status;
	public AssetAllocationBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AssetAllocationBean(int allocationId, String assetName, int empNo, String status) {
		super();
		this.allocationId = allocationId;
		this.assetName = assetName;
		this.empNo = empNo;
		this.status = status;
	}
	@Override
	public String toString() {
		return "AssetAllocationBean [allocationId=" + allocationId + ", assetName=" + assetName + ", empNo=" + empNo
				+ ", status=" + status + "]";
	}
	public int getAllocationId() {
		return allocationId;
	}
	public void setAllocationId(int allocationId) {
		this.allocationId = allocationId;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
