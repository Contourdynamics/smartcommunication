package org.contourdynamics.cms.repository;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.contourdynamics.cms.Entities.BpTypeCode;
import org.contourdynamics.cms.producers.MainEMResolver;

@ApplicationScoped
@Repository(forEntity = BpTypeCode.class)
@EntityManagerConfig(entityManagerResolver = MainEMResolver.class)
public interface BpTypeCodeRepos extends EntityRepository<BpTypeCode, Integer> {
//public abstract class BpRolesRepos  extends AbstractEntityRepository<BpRoles, Integer> {

}
