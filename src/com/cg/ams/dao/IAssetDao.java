package com.cg.ams.dao;

import java.util.List;

import com.cg.ams.bean.AssetAllocationBean;
import com.cg.ams.bean.AssetsBean;
import com.cg.ams.exception.AMSException;

public interface IAssetDao {

	String getuserType(String userName, String password) throws AMSException;

	int allocateAsset(int empId, String assetname) throws AMSException;

	int deallocateAsset(int empId1, String assetname1) throws AMSException;

	int insertDetails(AssetsBean assetbean) throws AMSException;

	List<AssetAllocationBean> viewRequest(AssetAllocationBean assetallocation) throws AMSException;

     int approve(AssetAllocationBean assetallocation) throws AMSException;

	int viewQuantity(String assetName) throws AMSException;

	int decrementQuantity(String assetName) throws AMSException;

	int increase(String assetName) throws AMSException;

	int incrementQuantity(String assetName) throws AMSException;

	int deleteRequest(int empNo) throws AMSException;

	//int approve(String assetName, int empNo) throws AMSException;

}
