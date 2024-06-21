package org.jsp.customeraddressapp.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.customeraddressapp.AdressConfig;
import org.jsp.customeraddressapp.dao.AddressDao;
import org.jsp.customeraddressapp.dto.Address;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AddressController {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(AdressConfig.class);
		AddressDao addressDao=context.getBean("addressDao",AddressDao.class);
		System.out.println("1.Save Address");
		System.out.println("2.Update Address");
		System.out.println("3.Find Address By Id");
		System.out.println("4.Find Address By Customer Id");
		System.out.println("5.Find Address By Customer Phone no and Password");
		Scanner sc=new Scanner(System.in);
		switch(sc.nextInt()) {
		case 1:{
			System.out.println("Enter Id,HouseNumber,Buildingname,landmark,city,state,country,pincode to save");
			int customer_id=sc.nextInt();
			Address address=new Address();
			address.setHousenumber(sc.next());
			address.setBuilding_name(sc.next());
			address.setLandmark(sc.next());
			address.setCity(sc.next());
			address.setState(sc.next());
			address.setCountry(sc.next());
			address.setPincode(sc.nextInt());
			address=addressDao.saveAddress(address, customer_id);
			if(address!=null) {
				System.out.println("Order placed with id: "+address.getId());
			}
			else {
				System.err.println("cannont place an order as customer id is invalid");
			}
		}
		break;
		
		case 2:{
			System.out.println("Enter Id,HouseNumber,Buildingname,landmark,city,state,country,pincode to update");
			Address address=new Address();
			address.setId(sc.nextInt());
			address.setHousenumber(sc.next());
			address.setBuilding_name(sc.next());
			address.setLandmark(sc.next());
			address.setCity(sc.next());
			address.setState(sc.next());
			address.setCountry(sc.next());
			address.setPincode(sc.nextInt());
			address=addressDao.updateAddress(address);
			if(address!=null) {
				System.out.println("Your address Id:"+address.getId()+"updated Successfully");
			}
			else {
				System.err.println("cannot update the order as Id is invalid ");
			}
		}
		break;
		
		case 3:{
			System.out.println("Enter Address Id to display details");
			Address address=addressDao.findById(sc.nextInt());
			if(address!=null) {
				System.out.println("Address Found");
				System.out.println(address);
			}
			else {
				System.out.println("Cannot display your address as id is Invalid");
			}
		}
		break;
		
		case 4:{
			System.out.println("Enter Customer Id to display address");
			List<Address> address=addressDao.findByCustomerId(sc.nextInt());
			if(address.isEmpty()) {
				System.err.println("cannot display address as Customer Id is Invalid");
			}
			else {
				for(Address a:address) {
					System.out.println("Address Found");
					System.out.println(a);
				}
			}
		}
		break;
		
		case 5:{
			System.out.println("Enter customer phone no and password to display address");
			List<Address> address=addressDao.findByCustomer(sc.nextLong(), sc.next());
			if(address.isEmpty()) {
				System.err.println("cannot display Address as Customer phone no and password is Invalid");
			}
			else {
				for(Address a:address) {
					System.out.println("Address Found");
					System.out.println(a);
				}
			}
		}
		break;
		
		default:{
			System.err.println("Invalid Choice");
		}
		}
		sc.close();
		((AnnotationConfigApplicationContext)context).close();
	}
}

