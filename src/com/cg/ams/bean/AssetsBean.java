package com.cg.ams.bean;

public class AssetsBean {
	private int assetId;
	private String assetName;
	private int quantity;
	public AssetsBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AssetsBean(int assetId, String assetName, int quantity) {
		super();
		this.assetId = assetId;
		this.assetName = assetName;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "AssetsBean [assetId=" + assetId + ", assetName=" + assetName + ", quantity=" + quantity + "]";
	}
	public int getAssetId() {
		return assetId;
	}
	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
		
}
