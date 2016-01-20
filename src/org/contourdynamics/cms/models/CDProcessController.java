package org.contourdynamics.cms.models;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.jbpm.services.api.ProcessService; 
import org.contourdynamics.cms.producers.JbpmProducer;

@Model
public class CDProcessController {
	
	@Inject 
	ProcessService PS;
	
	public String startProcess() {
		long ret = 0;
		long ret2 = 0;
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("recipient", "admin");
        params.put("reward", 1);
        try {
            ret2 = PS.startProcess(JbpmProducer.DEPLOYMENT_ID,"CDAdmin.login", params);
        } catch (Exception e) {

        }
        long ret1 = ret;
        ret1 = ret2;
        return "";
    }
}
