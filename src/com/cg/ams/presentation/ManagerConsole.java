package com.cg.ams.presentation;

import java.util.Scanner;

import com.cg.ams.bean.AssetAllocationBean;
import com.cg.ams.bean.EmployeeBean;
import com.cg.ams.exception.AMSException;
import com.cg.ams.service.AssetServiceImpl;
import com.cg.ams.service.IAssetService;

public class ManagerConsole {
IAssetService service= new AssetServiceImpl();
AssetAllocationBean allocationbean=new AssetAllocationBean();
EmployeeBean employeeBean=new EmployeeBean();
Scanner scanner=new Scanner(System.in);
int adminFlag=0;
	public void start(String userName) throws AMSException {
		System.out.println("1.Allocate The request");
		System.out.println("2.Deallocate the Request");
		System.out.println("3.Exit");
		int option=scanner.nextInt();
		scanner.nextLine();
		switch(option)
		{
		case 1:
			System.out.println("Enter the Employee id.");
			int empId=scanner.nextInt();
			scanner.nextLine();
			System.out.println("enter asset name");
			String assetname=scanner.nextLine();
			employeeBean.setEmpNo(empId);
			allocationbean.setAssetName(assetname);
			int allocationId=service.allocateAsset(empId,assetname);
			allocationbean.setAllocationId(allocationId);
			
			if(allocationId>0)
			{
				
				System.out.println("Allocation request generated for employee number: "+empId+" with request id: "+allocationbean.getAllocationId());
			    adminFlag = 1;
			}
			else {
				System.out.println("Request can not be generated at the moment");
			}
			
			
			
			break;
		case 2:System.out.println("Enter the Employee id.");
		int empId1=scanner.nextInt();
		scanner.nextLine();
		System.out.println("enter asset name");
		String assetname1=scanner.nextLine();
		employeeBean.setEmpNo(empId1);
		allocationbean.setAssetName(assetname1);
		int allocationId1=service.deallocateAsset(empId1,assetname1);
		allocationbean.setAllocationId(allocationId1);
		
		if(allocationId1>0)
		{
			
			System.out.println("Deallocation request generated for employee number: "+empId1+" with request id: "+allocationbean.getAllocationId());
		    adminFlag = -1;
		}
		else {
			System.out.println("Request can not be generated at the moment");
		}
			break;
			
		
	
		case 3:System.out.println("Exited from manager");
		System.exit(0);
			break;
		}
	}

}
