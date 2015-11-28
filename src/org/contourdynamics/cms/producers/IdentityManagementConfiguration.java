/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.contourdynamics.cms.producers;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.contourdynamics.cms.idm.entity.ApplicationAccessTypeEntity;
import org.contourdynamics.cms.idm.entity.ApplicationRealmTypeEntity;
import org.contourdynamics.cms.idm.entity.ApplicationTypeEntity;
import org.contourdynamics.cms.idm.entity.GrantTypeEntity;
import org.contourdynamics.cms.idm.entity.GroupMembershipTypeEntity;
import org.contourdynamics.cms.idm.entity.GroupTypeEntity;
import org.contourdynamics.cms.idm.entity.PartitionTypeEntity;
import org.contourdynamics.cms.idm.entity.RealmTypeEntity;
import org.contourdynamics.cms.idm.entity.RoleTypeEntity;
import org.contourdynamics.cms.idm.entity.PasswordCredentialTypeEntity;
import org.contourdynamics.cms.idm.entity.UserTypeEntity;
import org.contourdynamics.cms.idm.entity.RelationshipIdentityTypeEntity;
import org.contourdynamics.cms.idm.entity.RelationshipTypeEntity;
import org.contourdynamics.cms.idm.model.Application;
import org.contourdynamics.cms.idm.model.ApplicationAccess;
import org.contourdynamics.cms.idm.model.ApplicationRealm;
import org.contourdynamics.cms.idm.model.Grant;
import org.contourdynamics.cms.idm.model.Group;
import org.contourdynamics.cms.idm.model.GroupMembership;
import org.contourdynamics.cms.idm.model.Realm;
import org.contourdynamics.cms.idm.model.Role;
import org.contourdynamics.cms.idm.model.User;
import org.picketlink.annotations.PicketLink;
import org.picketlink.idm.PartitionManager;
import org.picketlink.idm.config.IdentityConfiguration;
import org.picketlink.idm.config.IdentityConfigurationBuilder;
import org.picketlink.idm.internal.DefaultPartitionManager;
import org.picketlink.idm.jpa.internal.JPAIdentityStore;
import org.picketlink.idm.spi.ContextInitializer;
import org.picketlink.idm.spi.IdentityContext;
import org.picketlink.idm.spi.IdentityStore;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.picketlink.internal.EntityManagerContextInitializer;
import org.picketlink.idm.config.IdentityConfiguration;
import org.picketlink.idm.config.IdentityConfigurationBuilder;
import org.picketlink.idm.model.Relationship;
/**
 * This bean produces the configuration for PicketLink IDM
 * 
 * 
 * @author Shane Bryzak
 *
 */
@ApplicationScoped
public class IdentityManagementConfiguration {

	private IdentityConfiguration identityConfig = null;
	
//	@Inject
 //   private PartitionManager partitionManager;
	
	@Produces
	@PicketLink
	@PersistenceContext
	private EntityManager picketLinkEntityManager;
	
	@Produces
	public IdentityConfiguration createConfig() {
		if (identityConfig == null) {
		initJPAConfig();
		}
		return identityConfig;
	}
	private void initJPAConfig() {
		IdentityConfigurationBuilder builder = new IdentityConfigurationBuilder();
		builder
		.named("default")
		.stores()
		.jpa()
		.supportType(
                User.class,
                Role.class,
                Group.class,
                Realm.class,
                Application.class,
                ApplicationRealm.class)
            .supportGlobalRelationship(
                Grant.class,
                GroupMembership.class,
                ApplicationAccess.class)
            .supportCredentials(true)
            .mappedEntity(
                ApplicationAccessTypeEntity.class,
                ApplicationTypeEntity.class,
                ApplicationRealmTypeEntity.class,
                PartitionTypeEntity.class,
                GrantTypeEntity.class,
                GroupMembershipTypeEntity.class,
                GroupTypeEntity.class,
                RealmTypeEntity.class,
                RoleTypeEntity.class,
                UserTypeEntity.class,
                PasswordCredentialTypeEntity.class,
                RelationshipTypeEntity.class,
                RelationshipIdentityTypeEntity.class)
                .addContextInitializer(new ContextInitializer() {
                            @Override
                            public void initContextForStore(IdentityContext context, IdentityStore<?> store) {
                                if (store instanceof JPAIdentityStore) {
                                    if (!context.isParameterSet(JPAIdentityStore.INVOCATION_CTX_ENTITY_MANAGER)) {
                                        context.setParameter(JPAIdentityStore.INVOCATION_CTX_ENTITY_MANAGER, picketLinkEntityManager);
                                    }
                                }
                            }
                        });
		identityConfig = builder.build();
	//	partitionManager = new DefaultPartitionManager(builder.buildAll());
	}
}