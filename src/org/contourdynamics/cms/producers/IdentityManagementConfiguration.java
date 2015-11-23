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

import org.picketlink.annotations.PicketLink;
import org.picketlink.idm.config.IdentityConfiguration;
import org.picketlink.idm.config.IdentityConfigurationBuilder;
import org.picketlink.idm.jpa.internal.JPAIdentityStore;
import org.picketlink.idm.spi.ContextInitializer;
import org.picketlink.idm.spi.IdentityContext;
import org.picketlink.idm.spi.IdentityStore;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.picketlink.internal.EntityManagerContextInitializer;
import org.picketlink.idm.config.IdentityConfiguration;
import org.picketlink.idm.config.IdentityConfigurationBuilder;
import org.picketlink.idm.jpa.model.sample.simple.AccountTypeEntity;
import org.picketlink.idm.jpa.model.sample.simple.AttributeTypeEntity;
import org.picketlink.idm.jpa.model.sample.simple.GroupTypeEntity;
import org.picketlink.idm.jpa.model.sample.simple.IdentityTypeEntity;
import org.picketlink.idm.jpa.model.sample.simple.PartitionTypeEntity;
import org.picketlink.idm.jpa.model.sample.simple.PasswordCredentialTypeEntity;
import org.picketlink.idm.jpa.model.sample.simple.RelationshipIdentityTypeEntity;
import org.picketlink.idm.jpa.model.sample.simple.RelationshipTypeEntity;
import org.picketlink.idm.jpa.model.sample.simple.RoleTypeEntity;
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
		.mappedEntity(
				AccountTypeEntity.class,
				AttributeTypeEntity.class,
				GroupTypeEntity.class,
				IdentityTypeEntity.class,
				PartitionTypeEntity.class,
				PasswordCredentialTypeEntity.class,
				RelationshipIdentityTypeEntity.class,
				RelationshipTypeEntity.class,
				RoleTypeEntity.class
		)
		.supportGlobalRelationship(Relationship.class)
		.supportAllFeatures();
		identityConfig = builder.build();
	}
}