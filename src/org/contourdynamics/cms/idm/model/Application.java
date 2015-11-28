/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2012, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.contourdynamics.cms.idm.model;

import org.picketlink.idm.model.AbstractIdentityType;
import org.picketlink.idm.model.annotation.AttributeProperty;
import org.picketlink.idm.model.annotation.IdentityPartition;
import org.picketlink.idm.model.annotation.Unique;

/**
 * <p>{@link org.picketlink.quickstart.identitymodel.Application} represents an application for a specific {@link org.picketlink.quickstart.identitymodel.Realm}.
 * In this case we can say that it belongs to a realm.</p>
 *
 * @author Pedro Igor
 */
@IdentityPartition(supportedTypes = {Role.class, Group.class})
public class Application extends AbstractIdentityType {

    @AttributeProperty
    @Unique
    private String name;

    private Application() {
        this(null);
        // PicketLink requires a default constructor to create and populate instances using reflection
    }

    public Application(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
