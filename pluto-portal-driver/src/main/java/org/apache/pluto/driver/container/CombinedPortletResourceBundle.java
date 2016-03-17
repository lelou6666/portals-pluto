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
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/internal/impl/CombinedPortletResourceBundle.java
package org.apache.pluto.internal.impl;

import org.apache.pluto.util.StringManager;

import java.util.ResourceBundle;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Vector;
=======
package org.apache.pluto.driver.container;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;

import org.apache.pluto.container.util.ArgumentUtility;
>>>>>>> refs/remotes/apache/master:pluto-portal-driver/src/main/java/org/apache/pluto/driver/container/CombinedPortletResourceBundle.java

/**
 *
 * @version 1.0
 * @since Jan 9, 2006
 */
class CombinedPortletResourceBundle extends ResourceBundle {

<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/internal/impl/CombinedPortletResourceBundle.java
    private static final StringManager EXCEPTIONS =
        StringManager.getManager(CombinedPortletResourceBundle.class.getPackage().getName());

    private final HashMap contents = new HashMap();
=======
    private HashMap<String, Object> contents = new HashMap<String, Object>();
>>>>>>> refs/remotes/apache/master:pluto-portal-driver/src/main/java/org/apache/pluto/driver/container/CombinedPortletResourceBundle.java

    public CombinedPortletResourceBundle(InlinePortletResourceBundle inlineBundle, ResourceBundle resourceBundle) {
       dump(inlineBundle);
       dump(resourceBundle);
    }

    protected Object handleGetObject(String key) {
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/internal/impl/CombinedPortletResourceBundle.java
        if(key == null) {
            throw new NullPointerException(EXCEPTIONS.getString("error.null"));
        }
        return contents.get(key);
    }

    public Enumeration getKeys() {
       return new Vector(contents.keySet()).elements();
    }

    private void dump(ResourceBundle bundle) {
        Enumeration e = bundle.getKeys();
=======
        ArgumentUtility.validateNotNull("key", key);
        return contents.get(key);
    }

    public Enumeration<String> getKeys() {
       return Collections.enumeration(contents.keySet());
    }

    private void dump(ResourceBundle bundle) {
        Enumeration<String> e = bundle.getKeys();
>>>>>>> refs/remotes/apache/master:pluto-portal-driver/src/main/java/org/apache/pluto/driver/container/CombinedPortletResourceBundle.java
        while(e.hasMoreElements()) {
            String value = e.nextElement().toString();
            contents.put(value, bundle.getObject(value));
        }
    }
}
