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
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/internal/InternalPortletConfig.java
package org.apache.pluto.internal;

import javax.portlet.PortletConfig;
import javax.servlet.ServletConfig;

import org.apache.pluto.descriptors.portlet.PortletDD;

public interface InternalPortletConfig extends PortletConfig {

    public ServletConfig getServletConfig();

    public PortletDD getPortletDefinition();
=======
package org.apache.pluto.container.driver;

import javax.portlet.PortletConfig;

import org.apache.pluto.container.om.portlet.PortletDefinition;

public interface DriverPortletConfig extends PortletConfig {

    PortletDefinition getPortletDefinition();
>>>>>>> refs/remotes/apache/master:pluto-container-driver-api/src/main/java/org/apache/pluto/container/driver/DriverPortletConfig.java
}


