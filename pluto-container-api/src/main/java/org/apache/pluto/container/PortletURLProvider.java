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
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/spi/PortletURLProvider.java
package org.apache.pluto.spi;

import java.util.Map;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;
import javax.portlet.PortletSecurityException;

/**
 * Defines the interface used by the portlet container to create Portal URLs.
=======
package org.apache.pluto.container;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletMode;
import javax.portlet.PortletSecurityException;
import javax.portlet.WindowState;

/**
 * Defines the interface used by the portlet container to create Portlet URLs.
>>>>>>> refs/remotes/apache/master:pluto-container-api/src/main/java/org/apache/pluto/container/PortletURLProvider.java
 * This provider must be implemented by the Portal and provided via the
 * container services upon initialization of the container.
 *
 * @version 1.0
 */
public interface PortletURLProvider {

<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/spi/PortletURLProvider.java
=======
    enum TYPE { ACTION, RENDER, RESOURCE };
    
    TYPE getType();
>>>>>>> refs/remotes/apache/master:pluto-container-api/src/main/java/org/apache/pluto/container/PortletURLProvider.java

    /**
     * Sets the new portlet mode at the URL. If no mode is set at the URL the
     * currently active mode is used.
     * @param mode the new portlet mode
     */
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/spi/PortletURLProvider.java
    public void setPortletMode(PortletMode mode);
=======
    void setPortletMode(PortletMode mode);
    
    PortletMode getPortletMode();
>>>>>>> refs/remotes/apache/master:pluto-container-api/src/main/java/org/apache/pluto/container/PortletURLProvider.java

    /**
     * Sets the new window state at the URL. If no state is set at the URL the
     * currently active state is used.
     * @param state the new window state
     */
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/spi/PortletURLProvider.java
    public void setWindowState(WindowState state);

    /**
     * Specifies whether or not this request should be considered an action
     * request. If the value specified is false, a render request will be
     * assumed.
     */
    public void setAction(boolean action);

    /**
     * By calling this method the URL is defined as a secure URL.
     */
    public void setSecure() throws PortletSecurityException;

    /**
     * Determine whether or not this url provider
     * supports secure urls.
     * 
     * @return
     * @throws PortletSecurityException
     */
    public boolean isSecureSupported();

    /**
     * Removes all pre-existing parameters in this URL
     */
    public void clearParameters();

    /**
     * Sets the given parameters as parameters into the URL, Removes all
     * previously set parameters.
     * @param parameters a map containing the name [java.lang.String] and value
     *                   [java.lang.String[]] of the parameters.
     */
    public void setParameters(Map parameters);

    /**
     * Returns the URL in string format. This method should only be called
     * once.
     * @return the URL
     */
    public String toString();
=======
    void setWindowState(WindowState state);
    
    WindowState getWindowState();

    void setSecure(boolean secure) throws PortletSecurityException;
    boolean isSecure();

    Map<String, String[]> getRenderParameters();
    Map<String, String[]> getPublicRenderParameters();
    
    String getCacheability();
    void setCacheability(String cacheLevel);
    
    String getResourceID();
    void setResourceID(String resourceID);
    
    String toURL();
    
    void write(Writer out, boolean escapeXML) throws IOException;

    /**
     * Gets the mutable map of vendor-specific properties as set on the BaseURL
     * @return parameters a map containing the name and value(s) of the properties (may return null)
     */
    public Map<String, List<String>> getProperties();
>>>>>>> refs/remotes/apache/master:pluto-container-api/src/main/java/org/apache/pluto/container/PortletURLProvider.java
}
