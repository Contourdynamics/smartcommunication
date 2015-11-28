package org.contourdynamics.cms.manager;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.picketlink.annotations.PicketLink;
import org.contourdynamics.cms.Entities.BpMain;
import org.contourdynamics.cms.models.BpMainModel;
@Named("CustomerListManager")
@RequestScoped
@PicketLink
public class CDCustomerList {
	private List<BpMain> Customers;
	private BpMain selectedCustomer;
	private BpMain[] selectedCustomers;
	
	@Inject 
	BpMainModel model;
	
    public List<BpMain> ReadAllCustomers() {
		Customers = model.ReadAll();
		return Customers;
	}
	
	public List<BpMain> getCustomers() {
        return Customers;
    }
	
	public void setCustomers(List<BpMain> cust)
	{
		Customers = cust;
	}
}
