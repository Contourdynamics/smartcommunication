package org.contourdynamics.cms.producers;
import java.util.HashMap;
import java.util.Map;

import org.jbpm.kie.services.impl.KModuleDeploymentUnit;
import org.jbpm.services.api.DeploymentService;
import org.jbpm.services.api.model.DeployedUnit;
import org.jbpm.services.api.model.DeploymentUnit;
import org.jbpm.services.cdi.Kjar;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.internal.runtime.cdi.BootOnLoad;
import org.kie.internal.runtime.manager.cdi.qualifier.PerProcessInstance;
import org.kie.internal.runtime.manager.context.ProcessInstanceIdContext;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
@ApplicationScoped
@Singleton
//@BootOnLoad
@Startup
public class JbpmProducer {
	public static final String DEPLOYMENT_ID = "contourdynamics:CDAdmin:1.0.0-SNAPSHOT";
	@Inject
    @Kjar
    DeploymentService deploymentService;
	
    @PostConstruct
    public void init(){
        String[] gav = DEPLOYMENT_ID.split(":");
        DeploymentUnit deploymentUnit = new KModuleDeploymentUnit(gav[0], gav[1], gav[2]);
        if(deploymentService.isDeployed(deploymentUnit.getIdentifier()))
        {
        	deploymentService.undeploy(deploymentUnit);
        }
        deploymentService.deploy(deploymentUnit);
   
        
      //  DeployedUnit deployed = deploymentService.getDeployedUnit(deploymentUnit.getIdentifier());
      //  RuntimeManager manager = deployed.getRuntimeManager();
      //  System.out.print("This is test");
    }
	
}
