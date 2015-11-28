package org.contourdynamics.cms.repository;

import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.contourdynamics.cms.Entities.ContactAccountCode;

@Repository(forEntity = ContactAccountCode.class)
public abstract class ContactAccountCodeRepos  extends AbstractEntityRepository<ContactAccountCode, String> {

}
