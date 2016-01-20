package org.contourdynamics.cms.producers;
import org.jbpm.services.api.DeploymentService;
import org.jbpm.services.cdi.Kjar;
import org.jbpm.services.task.audit.JPATaskLifeCycleEventListener;
import org.kie.api.task.TaskLifeCycleEventListener;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

@ApplicationScoped
public class JBPMApplicationScopedProducer {
	 @PersistenceUnit(unitName = "org.jbpm.domain")
	    private EntityManagerFactory emf;

	    @Produces
	    public EntityManagerFactory produceEntityManagerFactory() {
	        if (this.emf == null) {
	            this.emf = Persistence
	                    .createEntityManagerFactory("org.jbpm.domain");
	        }
	        return this.emf;
	    }

	    @Inject
	    @Kjar
	    private Instance<DeploymentService> deploymentService;

	    @Produces
	    public DeploymentService produceDeploymentService() {
	         return deploymentService.select(new AnnotationLiteral<Kjar>() {}).get();
	    }

	    @Produces
	    public TaskLifeCycleEventListener produceAuditListener() {
	    	return new JPATaskLifeCycleEventListener(true);
	    }
}
