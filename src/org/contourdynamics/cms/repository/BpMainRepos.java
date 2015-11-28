package org.contourdynamics.cms.repository;

import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.contourdynamics.cms.Entities.BpMain;

@Repository(forEntity = BpMain.class)
public abstract class BpMainRepos  extends AbstractEntityRepository<BpMain, String> {

}
