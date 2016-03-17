/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/util/impl/NamespaceMapperImpl.java
package org.apache.pluto.util.impl;

import org.apache.pluto.PortletWindowID;
import org.apache.pluto.util.NamespaceMapper;
=======
package org.apache.pluto.driver.container;

import org.apache.pluto.container.NamespaceMapper;
import org.apache.pluto.container.PortletWindowID;
>>>>>>> refs/remotes/apache/master:pluto-portal-driver/src/main/java/org/apache/pluto/driver/container/DefaultNamespaceMapper.java

/**
 * Default implementation of <code>NamespaceMapper</code> interface.
 */
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/util/impl/NamespaceMapperImpl.java
public class NamespaceMapperImpl implements NamespaceMapper {

    public NamespaceMapperImpl() {
    	// Do nothing.
    }


=======
public class DefaultNamespaceMapper implements NamespaceMapper {

    public DefaultNamespaceMapper() {
    	// Do nothing.
    }

>>>>>>> refs/remotes/apache/master:pluto-portal-driver/src/main/java/org/apache/pluto/driver/container/DefaultNamespaceMapper.java
    // NamespaceMapper Impl ----------------------------------------------------

    public String encode(PortletWindowID portletWindowId, String name) {
        StringBuffer buffer = new StringBuffer(50);
        buffer.append("Pluto_");
        buffer.append(portletWindowId.getStringId());
        buffer.append('_');
        buffer.append(name);
        return buffer.toString();
    }

<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/util/impl/NamespaceMapperImpl.java
    public String encode(PortletWindowID portletWindowId1,
                         PortletWindowID portletWindowId2,
                         String name) {
        StringBuffer buffer = new StringBuffer(50);
        buffer.append("Pluto_");
        buffer.append(portletWindowId1.getStringId());
        buffer.append('_');
        buffer.append(portletWindowId2.getStringId());
        buffer.append('_');
        buffer.append(name);
        return buffer.toString();
    }

=======
>>>>>>> refs/remotes/apache/master:pluto-portal-driver/src/main/java/org/apache/pluto/driver/container/DefaultNamespaceMapper.java
    public String decode(PortletWindowID portletWindowId, String name) {
        if (!name.startsWith("Pluto_")) {
            return null;
        }
        StringBuffer buffer = new StringBuffer(50);
        buffer.append("Pluto_");
        buffer.append(portletWindowId.getStringId());
        buffer.append('_');
        if (!name.startsWith(buffer.toString())) {
            return null;
        }
        return name.substring(buffer.length());
    }
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/util/impl/NamespaceMapperImpl.java

=======
>>>>>>> refs/remotes/apache/master:pluto-portal-driver/src/main/java/org/apache/pluto/driver/container/DefaultNamespaceMapper.java
}
