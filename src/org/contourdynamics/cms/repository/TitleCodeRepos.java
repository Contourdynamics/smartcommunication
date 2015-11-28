package org.contourdynamics.cms.repository;

import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.contourdynamics.cms.Entities.TitleCode;

@Repository(forEntity = TitleCode.class)
public abstract class TitleCodeRepos  extends AbstractEntityRepository<TitleCode, String> {

}
