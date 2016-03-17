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
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/PortletContainerFactory.java
package org.apache.pluto;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.core.PortletContainerImpl;
import org.apache.pluto.core.DefaultOptionalContainerServices;
import org.apache.pluto.util.ArgumentUtility;
=======
package org.apache.pluto.container.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.pluto.container.ContainerServices;
import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletContainerException;
import org.apache.pluto.container.util.ArgumentUtility;
>>>>>>> refs/remotes/apache/master:pluto-container/src/main/java/org/apache/pluto/container/impl/PortletContainerFactory.java

/**
 * Factory used to create new PortletContainer instances.  The factor constructs
 * the underlying pluto container implementation by using the the given
 * container services.
 *
 * @version 1.0
 * @since Sep 18, 2004
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/PortletContainerFactory.java
=======
 * @deprecated just use blueprint or spring to construct the PortletContainer
>>>>>>> refs/remotes/apache/master:pluto-container/src/main/java/org/apache/pluto/container/impl/PortletContainerFactory.java
 */
public class PortletContainerFactory {

    /** Logger. */
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/PortletContainerFactory.java
    private static final Log LOG = LogFactory.getLog(PortletContainerFactory.class);
=======
    private static final Logger LOG = LoggerFactory.getLogger(PortletContainerFactory.class);
>>>>>>> refs/remotes/apache/master:pluto-container/src/main/java/org/apache/pluto/container/impl/PortletContainerFactory.java


    /** Singleton instance of the <code>PortletContainerFactory</code>. */
    private static final PortletContainerFactory FACTORY =
    		new PortletContainerFactory();

    /**
     * Accessor method for the singleton instance of the
     * <code>PortletContainerFactory</code>.
     * @return singleton instance of the PortletContainerFactory
     */
    public static PortletContainerFactory getInstance() {
    	return FACTORY;
    }

    /**
     * Private constructor that prevents external instantiation.
     */
    private PortletContainerFactory() {
    	// Do nothing.
    }

    /**
     * Create a container with the given containerName, initialized from the given
     * servlet config, and using the given container services.
     * @param containerName  the name of the portlet container.
     * @param requiredServices  the required portlet container services.
     * @return newly created PortletContainer instance.
     * @throws PortletContainerException
     */
    public PortletContainer createContainer(
    		String containerName,
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/PortletContainerFactory.java
    		RequiredContainerServices requiredServices)
        throws PortletContainerException {
        return createContainer(containerName,
                               requiredServices,
                               new DefaultOptionalContainerServices());
   }

    public PortletContainer createContainer(
    		String containerName,
    		RequiredContainerServices requiredServices,
    		OptionalContainerServices optionalServices) {

        ArgumentUtility.validateNotNull("requiredServices", requiredServices);
        ArgumentUtility.validateNotEmpty("containerName", containerName);

        DefaultOptionalContainerServices optionalServicesWrapper =
        		new DefaultOptionalContainerServices(optionalServices);
        PortletContainer container = new PortletContainerImpl(
        		containerName, requiredServices, optionalServicesWrapper);
=======
    		ContainerServices requiredServices)
    throws PortletContainerException {
        ArgumentUtility.validateNotNull("requiredServices", requiredServices);
        ArgumentUtility.validateNotEmpty("containerName", containerName);

        PortletContainer container = new PortletContainerImpl(
        		containerName, requiredServices);
>>>>>>> refs/remotes/apache/master:pluto-container/src/main/java/org/apache/pluto/container/impl/PortletContainerFactory.java

        if (LOG.isInfoEnabled()) {
            LOG.info("Portlet Container [" + containerName + "] created.");
        }
        return container;
    }
}

