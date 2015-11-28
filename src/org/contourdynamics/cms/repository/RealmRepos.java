package org.contourdynamics.cms.repository;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.contourdynamics.cms.Entities.Realm;
import org.contourdynamics.cms.producers.MainEMResolver;
@ApplicationScoped
@Repository(forEntity = Realm.class)
@EntityManagerConfig(entityManagerResolver = MainEMResolver.class)
public abstract class RealmRepos  extends AbstractEntityRepository<Realm, Integer> {

}
