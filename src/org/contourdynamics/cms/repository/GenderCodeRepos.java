package org.contourdynamics.cms.repository;

import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.contourdynamics.cms.Entities.GenderCode;

@Repository(forEntity = GenderCode.class)
public abstract class GenderCodeRepos  extends AbstractEntityRepository<GenderCode, String> {

}
