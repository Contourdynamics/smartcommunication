package org.contourdynamics.cms.repository;

import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.contourdynamics.cms.Entities.BpCmpy;

@Repository(forEntity = BpCmpy.class)
public abstract class BpCmpyRepos  extends AbstractEntityRepository<BpCmpy, String> {

}
