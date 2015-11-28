package org.contourdynamics.cms.repository;

import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.contourdynamics.cms.Entities.StatusCode;

@Repository(forEntity = StatusCode.class)
public abstract class StatusCodeRepos  extends AbstractEntityRepository<StatusCode, String> {

}
