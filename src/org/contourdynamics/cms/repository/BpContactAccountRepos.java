package org.contourdynamics.cms.repository;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.contourdynamics.cms.Entities.BpContactAccount;
import org.contourdynamics.cms.producers.MainEMResolver;

@ApplicationScoped
@Repository(forEntity = BpContactAccount.class)
@EntityManagerConfig(entityManagerResolver = MainEMResolver.class)
public abstract class BpContactAccountRepos  extends AbstractEntityRepository<BpContactAccount, Integer> {

}
