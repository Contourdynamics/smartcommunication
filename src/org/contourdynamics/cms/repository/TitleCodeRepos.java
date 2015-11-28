package org.contourdynamics.cms.repository;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.contourdynamics.cms.Entities.BpCmpy;
import org.contourdynamics.cms.Entities.TitleCode;
import org.contourdynamics.cms.producers.MainEMResolver;

@ApplicationScoped
@Repository(forEntity = TitleCode.class)
@EntityManagerConfig(entityManagerResolver = MainEMResolver.class)
public interface TitleCodeRepos extends EntityRepository<TitleCode, Integer> {
//public abstract class TitleCodeRepos  extends AbstractEntityRepository<TitleCode, Integer> {

}
