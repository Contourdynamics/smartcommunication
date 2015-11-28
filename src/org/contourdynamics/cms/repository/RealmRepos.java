package org.contourdynamics.cms.repository;

import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.contourdynamics.cms.Entities.Realm;

@Repository(forEntity = Realm.class)
public abstract class RealmRepos  extends AbstractEntityRepository<Realm, String> {

}
