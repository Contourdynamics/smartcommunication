package org.contourdynamics.cms.repository;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.contourdynamics.cms.Entities.BpCmpy;
import org.contourdynamics.cms.Entities.BpSysUser;
import org.contourdynamics.cms.producers.MainEMResolver;

@ApplicationScoped
@Repository(forEntity = BpSysUser.class)
@EntityManagerConfig(entityManagerResolver = MainEMResolver.class)
public interface BpSysUserRepos extends EntityRepository<BpSysUser, Integer> {
//public abstract class BpSysUserRepos  extends AbstractEntityRepository<BpSysUser, Integer> {

}
