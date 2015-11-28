package org.contourdynamics.cms.repository;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.contourdynamics.cms.Entities.BpCmpy;
import org.contourdynamics.cms.Entities.StatusCode;
import org.contourdynamics.cms.producers.MainEMResolver;
@ApplicationScoped
@Repository(forEntity = StatusCode.class)
@EntityManagerConfig(entityManagerResolver = MainEMResolver.class)
public interface StatusCodeRepos extends EntityRepository<StatusCode, Integer> {
//public abstract class StatusCodeRepos  extends AbstractEntityRepository<StatusCode, Integer> {

}
