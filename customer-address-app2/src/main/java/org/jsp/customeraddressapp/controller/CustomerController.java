package org.jsp.customeraddressapp.controller;

import java.util.Scanner;

import org.jsp.customeraddressapp.CustomerConfig;
import org.jsp.customeraddressapp.dao.CustomerDao;
import org.jsp.customeraddressapp.dto.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomerController {

		public static void main(String[] args) {
			ApplicationContext context=new AnnotationConfigApplicationContext(CustomerConfig.class);
			CustomerDao customerDao=context.getBean("customerDao",CustomerDao.class);
			System.out.println("1.Save Customer");
			System.out.println("2.Update Customer");
			System.out.println("3.Find Customer By Id");
			System.out.println("4.Verify Customer By Phone and Password");
			System.out.println("5.Verify Customer By Email and Password");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Your Choice");
			switch(sc.nextInt()) {
			case 1:{
				System.out.println("Enter Customer name,phone,email,age,gender and password");
				Customer c=new Customer();
				c.setName(sc.next());
				c.setPhone(sc.nextLong());
				c.setEmail(sc.next());
				c.setAge(sc.nextInt());
				c.setGender(sc.next());
				c.setPassword(sc.next());
			    c=customerDao.saveCustomer(c);
			    System.out.println("Customer saved with id: "+c.getId());
						}
		    break;

			case 2:{
				System.out.println("Enter Customer name,phone,email,age,gender and password");
				Customer c=new Customer();
				c.setId(sc.nextInt());
				c.setName(sc.next());
				c.setPhone(sc.nextLong());
				c.setEmail(sc.next());
				c.setAge(sc.nextInt());
				c.setGender(sc.next());
				c.setPassword(sc.next());
				c=customerDao.updateCustomer(c);
				System.out.println("Customer Data Updated Successfully with id: "+c.getId());
			}
			break;
			
			case 3:{
				System.out.println("Enter Customer Id to display details");
				int id=sc.nextInt();
				Customer c=new Customer();
				if(c!=null) {
					System.out.println(c);
				}
				else {
					System.err.println("Invalid Customer Id");
				}
			}
			break;
			
			case 4:{
				System.out.println("Enter customer phone no and password to verify");
				long phone=sc.nextLong();
				String password=sc.next();
				Customer c=customerDao.verify(phone, password);
				if(c!=null) {
					System.out.println(c);
				}
				else {
					System.err.println("Invalid Customer Phone no or password");
				}
			}
			break;
			
			case 5:{
				System.out.println("Enter Customer email and password to verify");
				String email=sc.next();
				String password=sc.next();
				Customer c=customerDao.verify(email, password);
				if(c!=null) {
					System.out.println(c);
				}
				else {
					System.err.println("Invalid Customer email or password");
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
	

