package org.contourdynamics.cms.repository;

import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.contourdynamics.cms.Entities.BpRoles;

@Repository(forEntity = BpRoles.class)
public abstract class BpRolesRepos  extends AbstractEntityRepository<BpRoles, String> {

}
