package org.jsp.customeraddressapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.jsp.customeraddressapp.dto.Address;
import org.jsp.customeraddressapp.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDao {

	@Autowired
	private EntityManager entityManager;
	
	public Address saveAddress(Address address,int customer_id) {
		EntityTransaction transaction=entityManager.getTransaction();
		Customer c=entityManager.find(Customer.class, customer_id);
		if(c!=null) {
			c.getAddress().add(address);
			address.setCustomer(c);
			entityManager.persist(address);
			transaction.begin();
			transaction.commit();
			return address;
		}
		return null;
	}
	
	public Address updateAddress(Address address) {
		EntityTransaction transaction=entityManager.getTransaction();
		Address dbaddress=entityManager.find(Address.class, address.getId());
		if(dbaddress!=null) {
			dbaddress.setBuilding_name(address.getBuilding_name());
			dbaddress.setCity(address.getCity());
			dbaddress.setCountry(address.getCountry());
			dbaddress.setHousenumber(address.getHousenumber());
			dbaddress.setLandmark(address.getLandmark());
			dbaddress.setPincode(address.getPincode());
			dbaddress.setState(address.getState());
			transaction.begin();
			transaction.commit();
			return address;
		}
		return null;
	}
	
	public Address findById(int id) {
		return entityManager.find(Address.class, id);
	}
	
	public List<Address> findByCustomerId(int id){
		return entityManager.createQuery("select c.address from Customer c where c.id=?1 ")
				.setParameter(1, id).getResultList();
	}
	
	public List<Address> findByCustomer(long phone,String password){
		return entityManager.createQuery("select c.address from Customer c where c.phone=?1 and c.password=?2")
				.setParameter(1, phone).setParameter(2, password).getResultList();
	}
}

