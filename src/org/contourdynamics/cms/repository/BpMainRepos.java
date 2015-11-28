package org.contourdynamics.cms.repository;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.contourdynamics.cms.Entities.BpMain;
import org.contourdynamics.cms.producers.MainEMResolver;

@ApplicationScoped
@Repository(forEntity = BpMain.class)
@EntityManagerConfig(entityManagerResolver = MainEMResolver.class)
public interface BpMainRepos extends EntityRepository<BpMain, Integer> {
//public abstract class BpMainRepos  extends AbstractEntityRepository<BpMain, Integer> {

}
