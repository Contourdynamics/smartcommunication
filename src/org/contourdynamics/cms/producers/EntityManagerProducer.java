package org.contourdynamics.cms.producers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.apache.deltaspike.jpa.api.entitymanager.PersistenceUnitName;


@ApplicationScoped
public class EntityManagerProducer
{
	@PersistenceContext(unitName = "contourdynamic")
    private EntityManagerFactory emfA;


    @Produces
    @Default
    public EntityManager create()
    {
        return this.emfA.createEntityManager();
    }

    public void dispose(@Disposes @Default EntityManager entityManager)
    {
        if (entityManager.isOpen())
        {
            entityManager.close();
        }
    }

}
