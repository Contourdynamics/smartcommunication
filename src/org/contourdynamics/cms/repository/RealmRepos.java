package org.contourdynamics.cms.repository;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.contourdynamics.cms.Entities.BpCmpy;
import org.contourdynamics.cms.Entities.Realm;
import org.contourdynamics.cms.producers.MainEMResolver;
@ApplicationScoped
@Repository(forEntity = Realm.class)
@EntityManagerConfig(entityManagerResolver = MainEMResolver.class)
public interface RealmRepos extends EntityRepository<Realm, Integer> {
//public abstract class RealmRepos  extends AbstractEntityRepository<Realm, Integer> {

}
