package com.cg.ams.service;

import java.util.List;

import com.cg.ams.bean.AssetAllocationBean;
import com.cg.ams.bean.AssetsBean;
import com.cg.ams.dao.AssetDaoImpl;
import com.cg.ams.dao.IAssetDao;
import com.cg.ams.exception.AMSException;

public class AssetServiceImpl implements IAssetService {
IAssetDao assetDao=new AssetDaoImpl();
	@Override
	public String getuserType(String userName, String password) throws AMSException {
		// TODO Auto-generated method stub
		return assetDao.getuserType(userName,password);
	}
	@Override
	public int allocateAsset(int empId, String assetname) throws AMSException {
		// TODO Auto-generated method stub
		return assetDao.allocateAsset(empId,assetname);
	}
	@Override
	public int deallocateAsset(int empId1, String assetname1) throws AMSException {
		// TODO Auto-generated method stub
		return assetDao.deallocateAsset(empId1,assetname1);
	}
	@Override
	public int insertDetails(AssetsBean assetbean) throws AMSException {
		// TODO Auto-generated method stub
		return assetDao.insertDetails(assetbean);
	}
	@Override
	public List<AssetAllocationBean> viewRequest(AssetAllocationBean assetallocation) throws AMSException {
		// TODO Auto-generated method stub
		return assetDao.viewRequest(assetallocation);
	}
	/*@Override
	public int approve(String assetName,int empNo) throws AMSException {
		// TODO Auto-generated method stub
		return assetDao.approve(assetName,empNo);
	}*/
	@Override
	public int approve(AssetAllocationBean assetallocation) throws AMSException {
		// TODO Auto-generated method stub
		return assetDao.approve(assetallocation);
	}
	@Override
	public int viewQuantity(String assetName) throws AMSException {
		// TODO Auto-generated method stub
		return assetDao.viewQuantity(assetName);
	}
	@Override
	public int decrementQuantity(String assetName) throws AMSException {
		// TODO Auto-generated method stub
		return assetDao.decrementQuantity(assetName);
	}
	@Override
	public int deleteAsset(String assetName) throws AMSException {
		// TODO Auto-generated method stub
		return assetDao.increase(assetName);
	}
	@Override
	public int incrementQuantity(String assetName) throws AMSException {
		// TODO Auto-generated method stub
		return assetDao.incrementQuantity(assetName);
	}
	@Override
	public int deleteRequest(int empNo) throws AMSException {
		// TODO Auto-generated method stub
		return assetDao.deleteRequest(empNo);
	}

}
