package org.contourdynamics.cms.repository;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.contourdynamics.cms.Entities.BpCmpy;
import org.contourdynamics.cms.Entities.GenderCode;
import org.contourdynamics.cms.producers.MainEMResolver;
@ApplicationScoped
@Repository(forEntity = GenderCode.class)
@EntityManagerConfig(entityManagerResolver = MainEMResolver.class)
public interface GenderCodeRepos extends EntityRepository<GenderCode, Integer> {
//public abstract class GenderCodeRepos  extends AbstractEntityRepository<GenderCode, Integer> {

}
