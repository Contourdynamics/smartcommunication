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

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.List;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.contourdynamics.cms.idm.model.Realm;
import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.PartitionManager;
import org.picketlink.idm.RelationshipManager;
import org.picketlink.idm.credential.Password;
import org.contourdynamics.cms.idm.model.Group;
import org.contourdynamics.cms.idm.model.Role;
import org.contourdynamics.cms.idm.model.User;
import org.picketlink.idm.model.IdentityType;
import org.contourdynamics.cms.idm.model.Grant;
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

import java.security.NoSuchAlgorithmException;
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

	protected static final String REALM_CD_NAME = "contourdynamics";
	protected static final String REALM_CDCustomer_NAME = "contourdynamicscustomer";
    protected static final String APPLICATION_SALES_NAME = "smartcommunication";
    
    @Inject
    private PartitionManager partitionManager;

    @PostConstruct
    public void create() throws Exception{
    	Realm cd = new Realm(REALM_CD_NAME);
    	Realm storedRealm = partitionManager.getPartition(Realm.class, cd.getName());
    	if(storedRealm == null)
    	{
    		cd.setEnforceSSL(true);
    		KeyPair keyPair = KeyPairGenerator.getInstance("RSA").generateKeyPair();
    		cd.setPrivateKey(keyPair.getPrivate().getEncoded());
    		cd.setPublickKey(keyPair.getPublic().getEncoded());
    		cd.setNumberFailedLoginAttempts(3);
    		partitionManager.add(cd);
 
        	IdentityManager cdIdentityManager = partitionManager.createIdentityManager(cd);
        	
            Role Administrator = new Role("Administrator");
            Role Customer = new Role("Customer");
            Role Consumer = new Role("Consumer");
            Role Vendor = new Role("Vendor");
            Role Contacts = new Role("Contacts");
            
            cdIdentityManager.add(Administrator);
            cdIdentityManager.add(Customer);
            cdIdentityManager.add(Consumer);
            cdIdentityManager.add(Vendor);
            cdIdentityManager.add(Contacts);
            
            User user = new User("admin");            
            cdIdentityManager.add(user);
            Password password = new Password("admin");
            cdIdentityManager.updateCredential(user, password); 
            
            RelationshipManager relationshipManager = partitionManager.createRelationshipManager();
            relationshipManager.add(new Grant(user, Administrator));
            
            
            Realm cdcustomer = new Realm(REALM_CDCustomer_NAME);
        	Realm customerRealm = partitionManager.getPartition(Realm.class, cdcustomer.getName());
        	
        	if(customerRealm == null)
        	{
        		cdcustomer.setEnforceSSL(true);
        		KeyPair keyPaircustomer = KeyPairGenerator.getInstance("RSA").generateKeyPair();
        		cdcustomer.setPrivateKey(keyPaircustomer.getPrivate().getEncoded());
        		cdcustomer.setPublickKey(keyPaircustomer.getPublic().getEncoded());
        		cdcustomer.setNumberFailedLoginAttempts(3);
        		partitionManager.add(cdcustomer);
     
            	IdentityManager cdIdentityManagercst = partitionManager.createIdentityManager(cdcustomer);
            	
            	User customer = new User("customer");            
            	cdIdentityManagercst.add(customer);
                Password demo = new Password("demo");
                cdIdentityManagercst.updateCredential(customer, demo); 
                relationshipManager.add(new Grant(customer, Customer));
                
                
                User consumer = new User("consumer");            
            	cdIdentityManagercst.add(consumer);
                cdIdentityManagercst.updateCredential(consumer, demo); 
                relationshipManager.add(new Grant(consumer, Consumer));
        	}
    	}
    }
}
