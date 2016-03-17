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
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/internal/InternalPortletContext.java
package org.apache.pluto.internal;
=======
package org.apache.pluto.container.driver;
>>>>>>> refs/remotes/apache/master:pluto-container-driver-api/src/main/java/org/apache/pluto/container/driver/DriverPortletContext.java

import javax.portlet.PortletContext;
import javax.servlet.ServletContext;

<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/internal/InternalPortletContext.java
import org.apache.pluto.descriptors.portlet.PortletAppDD;

public interface InternalPortletContext extends PortletContext {
=======
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;

public interface DriverPortletContext extends PortletContext {
>>>>>>> refs/remotes/apache/master:pluto-container-driver-api/src/main/java/org/apache/pluto/container/driver/DriverPortletContext.java

    /**
     * Retrieve the unique identifier for the portlet context.
     * @return unique identifier.
     */
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/internal/InternalPortletContext.java
    public String getApplicationId();
=======
    public String getApplicationName();
>>>>>>> refs/remotes/apache/master:pluto-container-driver-api/src/main/java/org/apache/pluto/container/driver/DriverPortletContext.java

    /**
     *
     * @return servlet context within which we belong
     */
    public ServletContext getServletContext();
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/internal/InternalPortletContext.java

=======
    
>>>>>>> refs/remotes/apache/master:pluto-container-driver-api/src/main/java/org/apache/pluto/container/driver/DriverPortletContext.java
    /**
     *
     * @return application config
     */
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/internal/InternalPortletContext.java
    public PortletAppDD getPortletApplicationDefinition();
=======
    public PortletApplicationDefinition getPortletApplicationDefinition();
>>>>>>> refs/remotes/apache/master:pluto-container-driver-api/src/main/java/org/apache/pluto/container/driver/DriverPortletContext.java
}


