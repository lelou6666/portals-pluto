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
<<<<<<< HEAD:pluto-descriptor-api/src/main/java/org/apache/pluto/descriptors/services/PortletAppDescriptorService.java

package org.apache.pluto.descriptors.services;

import org.apache.pluto.descriptors.portlet.PortletAppDD;
=======
package org.apache.pluto.container;
>>>>>>> refs/remotes/apache/master:pluto-container-api/src/main/java/org/apache/pluto/container/PortletAppDescriptorService.java

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

<<<<<<< HEAD:pluto-descriptor-api/src/main/java/org/apache/pluto/descriptors/services/PortletAppDescriptorService.java
=======
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;

>>>>>>> refs/remotes/apache/master:pluto-container-api/src/main/java/org/apache/pluto/container/PortletAppDescriptorService.java
/**
 * Read/Write services for Portlet Application configuration
 * This service reads the portlet.xml and converts it to a
 * standard bean model.
 *
<<<<<<< HEAD:pluto-descriptor-api/src/main/java/org/apache/pluto/descriptors/services/PortletAppDescriptorService.java
 * @version $Id: PortletAppDescriptorService.java 157038 2005-03-11 03:44:40Z ddewolf $
=======
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
>>>>>>> refs/remotes/apache/master:pluto-container-api/src/main/java/org/apache/pluto/container/PortletAppDescriptorService.java
 * @since Mar 6, 2005
 */
public interface PortletAppDescriptorService {

    /**
     * Retrieve the PortletApp deployment descriptor
     * (portlet.xml).
     * @return Object representation of the descriptor.
     * @throws IOException if an IO error occurs.
     */
<<<<<<< HEAD:pluto-descriptor-api/src/main/java/org/apache/pluto/descriptors/services/PortletAppDescriptorService.java
    PortletAppDD read(InputStream in) throws IOException;
=======
    PortletApplicationDefinition read(String name, String contextPath, InputStream in) throws IOException;

    /**
     * Merge web.xml descriptor meta data with the PortletApplicationDefinition.
     * The Portlet container needs access to (at a minimum) the servlet-mapping url-patterns (PLT.19.3.8)
     * and the optional locale-encoding-mapping-list (PLT.12.7.1)
     * @param pa the PortletApplicationDefinition
     * @param webDescriptor the web.xml InputStream
     * @throws IOException
     */
    void mergeWebDescriptor(PortletApplicationDefinition pa, InputStream webDescriptor) throws Exception;
>>>>>>> refs/remotes/apache/master:pluto-container-api/src/main/java/org/apache/pluto/container/PortletAppDescriptorService.java

    /**
     * Write the PortletApp deployment descriptor
     * (portlet.xml).
     * @param portletDescriptor
     * @param out
     * @throws IOException if an IO error occurs.
     */
<<<<<<< HEAD:pluto-descriptor-api/src/main/java/org/apache/pluto/descriptors/services/PortletAppDescriptorService.java
    void write(PortletAppDD portletDescriptor, OutputStream out) throws IOException;
=======
    void write(PortletApplicationDefinition portletDescriptor, OutputStream out) throws IOException;
>>>>>>> refs/remotes/apache/master:pluto-container-api/src/main/java/org/apache/pluto/container/PortletAppDescriptorService.java
}
