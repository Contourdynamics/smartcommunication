package org.contourdynamics.cms.manager;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.contourdynamics.cms.Entities.BpMain;
import org.contourdynamics.cms.Entities.StatusCode;
import org.contourdynamics.cms.Entities.BpTypeCode;
import org.contourdynamics.cms.models.BpMainModel;
import org.contourdynamics.cms.models.CDProcessController;
import org.contourdynamics.cms.models.StatusCodeModel;
import org.contourdynamics.cms.models.BpTypeCodeModel;
import org.jbpm.services.api.DeploymentService;
import org.jbpm.services.api.ProcessService;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.internal.runtime.manager.cdi.qualifier.PerProcessInstance;
import org.kie.internal.runtime.manager.context.ProcessInstanceIdContext;
import org.kie.api.runtime.process.ProcessInstance;
@Named("CustomerListManager")
@RequestScoped
public class CDCustomerList {
	private List<BpMain> Customers;
	private BpMain selectedCustomer;
	private List<BpMain> selectedCustomers;
	private List<BpMain> filteredCustomers;
	
	@Inject 
	BpMainModel model;
	
	@Inject
	StatusCodeModel SModel;
	
	@Inject
	BpTypeCodeModel BModel;

	@Inject
	CDProcessController ProcessController;
	
	public String CDStartProcess()
	{
		try {
            String processInstanceId = ProcessController.startProcess();
        } catch (Exception e) {
        }   
		return "";
	}
	public List<String> getTypeCode()
	{
		String[] TypeCodeString;
		List<BpTypeCode> BpTypeCodes = BModel.ReadAll();
		TypeCodeString = new String[BpTypeCodes.size()];
		for(int i=0; i<BpTypeCodes.size();i++)
		{
			TypeCodeString[i] = BpTypeCodes.get(i).getDescription();
		}
		return Arrays.asList(TypeCodeString);
	}
	public List<String> getStatusCode()
	{
		String[] StatusCodeString;
		List<StatusCode> StatusCodes = SModel.ReadAll();
		StatusCodeString = new String[StatusCodes.size()];
		for(int i=0; i<StatusCodes.size();i++)
		{
			StatusCodeString[i] = StatusCodes.get(i).getDescription();
		}
		return Arrays.asList(StatusCodeString);
	}
    public List<BpMain> ReadAllCustomers() {
 		Customers = model.ReadAllCustomers();
		return Customers;
	}
	public void handleClose()
	{
	}
	public List<BpMain> getCustomers() {
        return Customers;
    }
	
	public void setCustomers(List<BpMain> cust)
	{
		Customers = cust;
	}
	public void setselectedCustomer(BpMain cust)
	{
		selectedCustomer = cust;
	}
	public BpMain getselectedCustomer()
	{
		return selectedCustomer;
	}
	public void setselectedCustomers(List<BpMain> cust)
	{
		selectedCustomers = cust;
	}
	public List<BpMain> getselectedCustomers()
	{
		return selectedCustomers;
	}
	public void setfilteredCustomers(List<BpMain> cust)
	{
		filteredCustomers = cust;
	}
	public List<BpMain> getfilteredCustomers()
	{
		return filteredCustomers;
	}
}
