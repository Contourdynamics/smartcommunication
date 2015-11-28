package org.contourdynamics.cms.repository;

import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.contourdynamics.cms.Entities.BpIndv;

@Repository(forEntity = BpIndv.class)
public abstract class BpIndvRepos  extends AbstractEntityRepository<BpIndv, String> {

}
