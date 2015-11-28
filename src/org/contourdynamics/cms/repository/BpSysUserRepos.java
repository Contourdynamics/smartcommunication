package org.contourdynamics.cms.repository;

import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.contourdynamics.cms.Entities.BpSysUser;

@Repository(forEntity = BpSysUser.class)
public abstract class BpSysUserRepos  extends AbstractEntityRepository<BpSysUser, String> {

}
