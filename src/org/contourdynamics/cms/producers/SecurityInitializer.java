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

import java.util.List;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.PartitionManager;
import org.picketlink.idm.RelationshipManager;
import org.picketlink.idm.credential.Password;
import org.picketlink.idm.model.basic.Group;
import org.picketlink.idm.model.basic.Role;
import org.picketlink.idm.model.basic.User;
import org.picketlink.idm.query.IdentityQuery;
import org.picketlink.idm.query.IdentityQueryBuilder;
import org.picketlink.annotations.PicketLink;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import static org.picketlink.idm.model.basic.BasicModel.addToGroup;
import static org.picketlink.idm.model.basic.BasicModel.grantGroupRole;
import static org.picketlink.idm.model.basic.BasicModel.grantRole;

/**
 * This startup bean creates a number of default users, groups and roles when the application is started.
 * 
 * @author Shane Bryzak
 */
@ApplicationScoped
@Singleton
@Startup
@Transactional(qualifier = PicketLink.class)
public class SecurityInitializer {

    @Inject
    private PartitionManager partitionManager;

    @PostConstruct
    public void create() {
//Validate if already created default values.
        IdentityManager identityManager = this.partitionManager.createIdentityManager();
        
        IdentityQueryBuilder queryBuilder = identityManager.getQueryBuilder();
        IdentityQuery<User> query = queryBuilder.createIdentityQuery(User.class);
        
        query.where(queryBuilder.equal(User.FIRST_NAME, "admin"));

        List<User> users = query.getResultList();
        
        if( users.size() == 1)
        {
        	return;
        }
// create default values.
     // Create user john
        User admin = new User("admin");
        admin.setEmail("admin@contourdynamics.com");
        admin.setFirstName("admin");
        admin.setLastName("Super");
        
        identityManager.add(admin);
        identityManager.updateCredential(admin, new Password("admin"));

        // Create application role "superuser"
        Role Admin = new Role("Admin");
        identityManager.add(Admin);
        
     // Create application role "Customer"
        Role customer = new Role("Customer");
        identityManager.add(customer);
        
     // Create application role "Consumer"
        Role Consumer = new Role("Consumer");
        identityManager.add(Consumer);
        
     // Create application role "Vendor"
        Role Vendor = new Role("Vendor");
        identityManager.add(Vendor);
        
     // Create application role "Contacts"
        Role contacts = new Role("Contacts");
        identityManager.add(contacts);
        
        // there will be only 1 role for the default profile which will be admin
        // for wholesaler retailer and consumer it will create and manager the partition
        // every partition will own its own roles/groups/users
        
        RelationshipManager relationshipManager = this.partitionManager.createRelationshipManager();

        // Grant the "Admin" application role to admin
        grantRole(relationshipManager, admin, Admin);
    }
}
