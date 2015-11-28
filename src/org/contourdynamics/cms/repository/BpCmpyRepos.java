package org.contourdynamics.cms.repository;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.contourdynamics.cms.Entities.BpCmpy;
import org.contourdynamics.cms.Entities.BpMain;
import org.contourdynamics.cms.producers.MainEMResolver;

@ApplicationScoped
@Repository(forEntity = BpCmpy.class)
@EntityManagerConfig(entityManagerResolver = MainEMResolver.class)
public interface BpCmpyRepos extends EntityRepository<BpCmpy, Integer> {
//public abstract class BpCmpyRepos  extends AbstractEntityRepository<BpCmpy, Integer> {

}
