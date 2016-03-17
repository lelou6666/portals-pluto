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
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/internal/impl/ResourceBundleFactory.java
package org.apache.pluto.internal.impl;
=======
package org.apache.pluto.driver.container;
>>>>>>> refs/remotes/apache/master:pluto-portal-driver/src/main/java/org/apache/pluto/driver/container/ResourceBundleFactory.java

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/internal/impl/ResourceBundleFactory.java
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.core.ContainerInvocation;
import org.apache.pluto.descriptors.portlet.PortletDD;
import org.apache.pluto.descriptors.portlet.PortletInfoDD;
import org.apache.pluto.spi.optional.PortletInfoService;
import org.apache.pluto.util.StringManager;
=======
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.apache.pluto.container.om.portlet.PortletInfo;
import org.apache.pluto.container.util.StringManager;
>>>>>>> refs/remotes/apache/master:pluto-portal-driver/src/main/java/org/apache/pluto/driver/container/ResourceBundleFactory.java

/**
 * Factory object used to create Portlet Resource Bundles.
 *
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/internal/impl/ResourceBundleFactory.java
 */
class ResourceBundleFactory {

    private static final Log LOG =
        LogFactory.getLog(ResourceBundleFactory.class);
=======
 *
 */
class ResourceBundleFactory {

    private static final Logger LOG =
        LoggerFactory.getLogger(ResourceBundleFactory.class);
>>>>>>> refs/remotes/apache/master:pluto-portal-driver/src/main/java/org/apache/pluto/driver/container/ResourceBundleFactory.java

    private static final StringManager EXCEPTIONS =
        StringManager.getManager(ResourceBundleFactory.class.getPackage().getName());

    /**
     * The default (no local) resources bundle for
     * this bundle.
     */
    private InlinePortletResourceBundle defaultBundle;

    /**
     * All of the previously loaded bundles.
     */
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/internal/impl/ResourceBundleFactory.java
    private final Map bundles = new HashMap();
=======
    private Map<Locale, ResourceBundle> bundles = new HashMap<Locale, ResourceBundle>();
>>>>>>> refs/remotes/apache/master:pluto-portal-driver/src/main/java/org/apache/pluto/driver/container/ResourceBundleFactory.java

    /**
     * The name of the bundle.
     */
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/internal/impl/ResourceBundleFactory.java
    private final String bundleName;

    public ResourceBundleFactory(PortletDD dd) {
=======
    private String bundleName;

    public ResourceBundleFactory(PortletDefinition dd, PortletInfo windowInfo) {
>>>>>>> refs/remotes/apache/master:pluto-portal-driver/src/main/java/org/apache/pluto/driver/container/ResourceBundleFactory.java
        bundleName = dd.getResourceBundle();
        if(LOG.isDebugEnabled()) {
            LOG.debug("Resource Bundle Created: "+bundleName);
        }

<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/internal/impl/ResourceBundleFactory.java
        PortletInfoDD info = dd.getPortletInfo();

        PortletInfoService infoService = getPortletInfoService();
        PortletWindow window = getWindow();

        if(info != null) {
            String title = infoService == null ? info.getTitle() : infoService.getTitle(window);
            String shortTitle = infoService == null ? info.getShortTitle() : infoService.getShortTitle(window);
            String keywords = infoService == null ? info.getKeywords() : infoService.getKeywords(window);

            defaultBundle = new InlinePortletResourceBundle(
                title, shortTitle, keywords
=======
        PortletInfo info = dd.getPortletInfo();


        if(info != null) {
            String title = windowInfo == null ? info.getTitle() : windowInfo.getTitle();
            String shortTitle = windowInfo == null ? info.getShortTitle() : windowInfo.getShortTitle();
            String keywords = windowInfo == null ? info.getKeywords() : windowInfo.getKeywords();

            defaultBundle = new InlinePortletResourceBundle(
                    title, shortTitle, keywords
>>>>>>> refs/remotes/apache/master:pluto-portal-driver/src/main/java/org/apache/pluto/driver/container/ResourceBundleFactory.java
            );
        }
        else {
            defaultBundle = new InlinePortletResourceBundle(new Object[][] { {"a", "b"} });
        }
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/internal/impl/ResourceBundleFactory.java
   }
=======
    }
>>>>>>> refs/remotes/apache/master:pluto-portal-driver/src/main/java/org/apache/pluto/driver/container/ResourceBundleFactory.java

    public ResourceBundle getResourceBundle(Locale locale) {
        if(LOG.isDebugEnabled()) {
            LOG.debug("Resource Bundle: "+bundleName+" : "+locale+" requested. ");
        }

        // If allready loaded for this local, return immediately!
        if (bundles.containsKey(locale)) {
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/internal/impl/ResourceBundleFactory.java
            return (ResourceBundle) bundles.get(locale);
=======
            return bundles.get(locale);
>>>>>>> refs/remotes/apache/master:pluto-portal-driver/src/main/java/org/apache/pluto/driver/container/ResourceBundleFactory.java
        }

        try {
            ResourceBundle bundle = null;
            if(bundleName != null) {
                ClassLoader loader =
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/internal/impl/ResourceBundleFactory.java
                        Thread.currentThread().getContextClassLoader();
=======
                    Thread.currentThread().getContextClassLoader();
>>>>>>> refs/remotes/apache/master:pluto-portal-driver/src/main/java/org/apache/pluto/driver/container/ResourceBundleFactory.java
                bundle = ResourceBundle.getBundle(bundleName, locale, loader);
                bundles.put(locale, new CombinedPortletResourceBundle(defaultBundle, bundle));
            }
            else {
                bundles.put(locale, defaultBundle);
            }
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/internal/impl/ResourceBundleFactory.java
       } catch (MissingResourceException mre) {
            if(bundleName != null && LOG.isWarnEnabled()) {
                LOG.info(EXCEPTIONS.getString("warning.resourcebundle.notfound",bundleName, mre.getMessage()));
=======
        } catch (MissingResourceException mre) {
            if(bundleName != null && LOG.isWarnEnabled()) {
                LOG.warn(EXCEPTIONS.getString("warning.resourcebundle.notfound",bundleName, mre.getMessage()));
>>>>>>> refs/remotes/apache/master:pluto-portal-driver/src/main/java/org/apache/pluto/driver/container/ResourceBundleFactory.java
            }
            if(LOG.isDebugEnabled()) {
                LOG.debug("Using default bundle for locale ("+locale+").");
            }
            bundles.put(locale, defaultBundle);
        }
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/internal/impl/ResourceBundleFactory.java
       return (ResourceBundle)bundles.get(locale);
    }


    private PortletInfoService getPortletInfoService() {
        ContainerInvocation invocation = ContainerInvocation.getInvocation();
        if(invocation != null) {
            return invocation.getPortletContainer().getOptionalContainerServices().getPortletInfoService();
        }
        return null;
    }

    private PortletWindow getWindow() {
        ContainerInvocation invocation = ContainerInvocation.getInvocation();
        if(invocation != null) {
            return invocation.getPortletWindow();
        }
        return null;
=======
        return bundles.get(locale);
>>>>>>> refs/remotes/apache/master:pluto-portal-driver/src/main/java/org/apache/pluto/driver/container/ResourceBundleFactory.java
    }
}
