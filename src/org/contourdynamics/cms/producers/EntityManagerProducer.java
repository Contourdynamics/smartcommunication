package org.contourdynamics.cms.producers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceUnit;
import org.picketlink.annotations.PicketLink;


@ApplicationScoped
public class EntityManagerProducer
{
	@PersistenceUnit(unitName = "contourdynamic")
    private EntityManagerFactory emfA;

	@Produces
    @Main
    @ConversationScoped
    public EntityManager create()
    {
        return this.emfA.createEntityManager();
    }
    
    @Produces
    @PicketLink
    @PersistenceContext(unitName = "identity", type = PersistenceContextType.EXTENDED)
	private EntityManager picketLinkEntityManager;
  
}
