package com.cg.ams.dao;

public interface QueryConstants {

public static final String Query1 = "Select userType from User_Master where userName=? and userpassword=?";
public static final String Query2 = "insert into assetallocation values(allocationid.nextval,?,?,'Allocation Request Pending')";
public static final String Query3 = "select allocationid.currval from dual";
public static final String Query4 = "insert into assetallocation values(allocationid.nextval,?,?,'Deallocation Request Pending')";
public static final String Query5 = "select allocationid.currval from dual";
public static final String Query6 = "insert into asset values(?,?,?)";
public static final String Query7 = "select * from assetallocation";
public static final String Query8 = "update assetAllocation set status='approved' where empNo=?" ;
public static final String Query9 = "select quantity from Asset where assetName=?";
public static final String Query10 = "update asset set quantity=quantity-1 where assetname=?";
public static final String Query11 = "delete from asset where assetName=?";
public static final String Query12 = "update asset set quantity=quantity+1 where assetname=?";
public static final String Query13 = "delete from assetallocation where empNo=?";

}
