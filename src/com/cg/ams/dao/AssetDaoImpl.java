package com.cg.ams.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.ams.bean.AssetAllocationBean;
import com.cg.ams.bean.AssetsBean;
import com.cg.ams.exception.AMSException;
import com.cg.ams.exception.AMSExceptionList;
import com.cg.ams.utility.JdbcUtility;

public class AssetDaoImpl implements IAssetDao {
Connection connection=null;
PreparedStatement preparedstatement=null;
ResultSet resultSet=null;

	@Override
	public String getuserType(String userName, String password) throws AMSException {
        connection=JdbcUtility.getConnection();
        String userType=null;
        try {
			preparedstatement=connection.prepareStatement(QueryConstants.Query1);
			preparedstatement.setString(1, userName);
			preparedstatement.setString(2, password);
			ResultSet resultSet = preparedstatement.executeQuery();
			if (resultSet.next()) {
				userType = resultSet.getString(1);
			} else {
				userType = "Invalid Credintials or Username Does not exists";
			}
		} catch (SQLException e) {
throw new AMSException(AMSExceptionList.Error6);		
}
		
		
		return userType;
	}

	@Override
	public int allocateAsset(int empId, String assetname) throws AMSException {

		connection=JdbcUtility.getConnection();
		
		
		int result=0;
		try {
			preparedstatement=connection.prepareStatement(QueryConstants.Query2);
			preparedstatement.setString(1, assetname);
			preparedstatement.setInt(2, empId);
		    preparedstatement.executeUpdate();
		
			preparedstatement = connection.prepareStatement(QueryConstants.Query3);
			resultSet = preparedstatement.executeQuery();
			
			resultSet.next();
			
			result=resultSet.getInt(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deallocateAsset(int empId1, String assetname1) throws AMSException {

		connection=JdbcUtility.getConnection();
		int result1=0;
		try {
			preparedstatement=connection.prepareStatement(QueryConstants.Query4);
			preparedstatement.setString(1, assetname1);
			preparedstatement.setInt(2, empId1);
			preparedstatement.executeUpdate();
			preparedstatement = connection.prepareStatement(QueryConstants.Query5);
			resultSet = preparedstatement.executeQuery();
			
			resultSet.next();
			
			result1=resultSet.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result1;
	}

	@Override
	public int insertDetails(AssetsBean assetbean) throws AMSException {

		connection=JdbcUtility.getConnection();
		int insert=0;
		try {
			preparedstatement=connection.prepareStatement(QueryConstants.Query6);
			preparedstatement.setInt(1, assetbean.getAssetId());
			preparedstatement.setString(2, assetbean.getAssetName());
			preparedstatement.setInt(3, assetbean.getQuantity());
			insert =preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return insert;
	}

	@Override
	public List<AssetAllocationBean> viewRequest(AssetAllocationBean assetallocation) throws AMSException {
 
		connection=JdbcUtility.getConnection();
		List<AssetAllocationBean> list=new ArrayList<>();
		try {
			preparedstatement=connection.prepareStatement(QueryConstants.Query7);
			resultSet=preparedstatement.executeQuery();
			if(resultSet.next())
			{
			int allocationId=resultSet.getInt(1);
			String assetName=resultSet.getString(2);
			int empNo=resultSet.getInt(3);
			String status=resultSet.getString(4);
			AssetAllocationBean allocationBean=new AssetAllocationBean(allocationId, assetName, empNo, status);
			list.add(allocationBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public int approve(AssetAllocationBean assetallocation) throws AMSException {

		connection=JdbcUtility.getConnection();
		int update=0;
		try {
			preparedstatement=connection.prepareStatement(QueryConstants.Query8);
			preparedstatement.setInt(2, assetallocation.getEmpNo());
			
			update=preparedstatement.executeUpdate();
			System.out.println("11111111111111111111");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return update;
	}

	@Override
	public int viewQuantity(String assetName) throws AMSException {
		connection =JdbcUtility.getConnection();
		int quantity=0;
		try {
			preparedstatement=connection.prepareStatement(QueryConstants.Query9);
			preparedstatement.setString(1, assetName);
			resultSet=preparedstatement.executeQuery();
			if(resultSet.next())
			{
				quantity=resultSet.getInt(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return quantity;
	}

	@Override
	public int decrementQuantity(String assetName) throws AMSException {

		connection=JdbcUtility.getConnection();
		int decrease=0;
		try {
			preparedstatement=connection.prepareStatement(QueryConstants.Query10);
			preparedstatement.setString(1, assetName);
			decrease =preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return decrease;
	}

	@Override
	public int increase(String assetName) throws AMSException {

		connection=JdbcUtility.getConnection();
		int delete=0;
		try {
			preparedstatement=connection.prepareStatement(QueryConstants.Query11);
			delete=preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return delete;
	}

	@Override
	public int incrementQuantity(String assetName) throws AMSException {
		connection=JdbcUtility.getConnection();
		int increase=0;
		try {
			preparedstatement=connection.prepareStatement(QueryConstants.Query12);
			preparedstatement.setString(1, assetName);
			increase =preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return increase;
	}

	@Override
	public int deleteRequest(int empNo) throws AMSException {

		connection=JdbcUtility.getConnection();
		int update=0;
		try {
			preparedstatement=connection.prepareStatement(QueryConstants.Query13);
			preparedstatement.setInt(1, empNo);
			update=preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return update;
	}

	/*@Override
	public int approve(String assetName,int empNo) throws AMSException {
        AssetAllocationBean allocation=new AssetAllocationBean()
		connection=JdbcUtility.getConnection();
		int update=0;
		try {
			preparedstatement=connection.prepareStatement(QueryConstants.Query8);
			preparedstatement.setString(1, allocation.getAssetName());
			preparedstatement.setInt(2, allocation.getEmpNo());
			update=preparedstatement.executeUpdate();
			System.out.println(update);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return update;
	}*/

}
