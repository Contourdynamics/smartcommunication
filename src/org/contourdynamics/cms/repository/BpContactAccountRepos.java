package org.contourdynamics.cms.repository;

import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.contourdynamics.cms.Entities.BpContactAccount;

@Repository(forEntity = BpContactAccount.class)
public abstract class BpContactAccountRepos  extends AbstractEntityRepository<BpContactAccount, String> {

}
