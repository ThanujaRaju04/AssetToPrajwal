package com.cg.ams.presentation;

import java.util.List;
import java.util.Scanner;

import com.cg.ams.bean.AssetAllocationBean;
import com.cg.ams.bean.AssetsBean;
import com.cg.ams.bean.EmployeeBean;
import com.cg.ams.exception.AMSException;
import com.cg.ams.service.AssetServiceImpl;
import com.cg.ams.service.IAssetService;

public class AdminConsole {

	IAssetService service= new AssetServiceImpl();
	AssetAllocationBean assetallocation=new AssetAllocationBean();
	AssetsBean assetbean=new AssetsBean();
	EmployeeBean employeeBean=new EmployeeBean();
	Scanner scanner=new Scanner(System.in);
	public void start(String userName) throws AMSException {
	  System.out.println("1. Insert asset if required");
      System.out.println("2. View Pending Requests");
      System.out.println("3. Approve Request"); 
      System.out.println("4. Approve remove");
      System.out.println("5. Exit");
      int option=scanner.nextInt();
      scanner.nextLine();
      switch(option)
      {
      case 1:
    	  System.out.println("enter the AssetId");
    	  int assetId=scanner.nextInt();
    	  scanner.nextLine();
    	  System.out.println("enter the AssetName");
    	  String assetName=scanner.nextLine();
    	  System.out.println("enter quantity");
    	  int quantity=scanner.nextInt();
    	  scanner.nextLine();
    	  assetbean.setAssetId(assetId);
    	  assetbean.setAssetName(assetName);
    	  assetbean.setQuantity(quantity);
    	  service.insertDetails(assetbean);
    	  System.out.println("asset inserted with assetId "+assetbean.getAssetId());
    	  
    	  break;
      case 2:
    	  List<AssetAllocationBean> list=service.viewRequest(assetallocation);
    	 System.out.println(list); 
    	  
    	  break;
      case 3:
    	  System.out.println("enter empId");
    	  int empNo=scanner.nextInt();
    	  scanner.nextLine();
    	  System.out.println("enter assetName");
    	  String assetsName=scanner.nextLine();
    	  assetallocation.setEmpNo(empNo);
    	  assetallocation.setAssetName(assetsName);
    	  System.out.println("Request to allocate asset: "+assetallocation.getAssetName()+" to employee Id: "+assetallocation.getEmpNo() );
			
			
			int Quantity=service.viewQuantity(assetallocation.getAssetName());
			if(Quantity>0)
			{
				System.out.println(assetallocation.getAssetName()+"is approved to" +assetallocation.getEmpNo());
				service.decrementQuantity(assetallocation.getAssetName());
				service.deleteRequest(assetallocation.getEmpNo());
			}
			else
			{
				int delete=service.deleteAsset(assetallocation.getAssetName());
				System.out.println(delete);
			    System.out.println("Rejected");
			
			
			
			}
    	  break;
      case 4:
    	  System.out.println("enter empId");
    	  int empNo1=scanner.nextInt();
    	  scanner.nextLine();
    	  System.out.println("enter assetName");
    	  String assetsName1=scanner.nextLine();
    	  assetallocation.setEmpNo(empNo1);
    	  assetallocation.setAssetName(assetsName1);
    	  System.out.println("Request to deallocate asset: "+assetallocation.getAssetName()+" to employee Id: "+assetallocation.getEmpNo() );
			
			
			int Quantity1=service.viewQuantity(assetallocation.getAssetName());
			if(Quantity1>0)
			{
				System.out.println(assetallocation.getAssetName()+"is removed from " +assetallocation.getEmpNo());
				service.incrementQuantity(assetallocation.getAssetName());
				service.deleteRequest(assetallocation.getEmpNo());
				
			}
			else
			{
				
			    System.out.println("Rejected");
			
			
			
			}
    	  break;
      case 5:System.out.println("Exited from admin");
      System.exit(0);
    	  break;
    	  
      }
      
      
      
	}

}
