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
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/internal/impl/InlinePortletResourceBundle.java
package org.apache.pluto.internal.impl;

import org.apache.pluto.Constants;

import java.util.ListResourceBundle;
import java.util.ArrayList;
=======
package org.apache.pluto.driver.container;

import java.util.ArrayList;
import java.util.ListResourceBundle;
>>>>>>> refs/remotes/apache/master:pluto-portal-driver/src/main/java/org/apache/pluto/driver/container/InlinePortletResourceBundle.java

/**
 * InlinePortletResourceBundle implementation which provides the
 * inline title, short-title, and keywords as properties from the
 * bundle.
 *
 * @version 1.0
 * @since Jan 9, 2006
 */
class InlinePortletResourceBundle extends ListResourceBundle {

<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/internal/impl/InlinePortletResourceBundle.java
    private final Object[][] contents;
=======
   private final static String TITLE_KEY = "javax.portlet.title";
   private final static String SHORT_TITLE_KEY = "javax.portlet.short-title";
   private final static String KEYWORDS_KEY = "javax.portlet.keywords";

    private Object[][] contents;
>>>>>>> refs/remotes/apache/master:pluto-portal-driver/src/main/java/org/apache/pluto/driver/container/InlinePortletResourceBundle.java

    public InlinePortletResourceBundle(Object[][] contents) {
        this.contents = contents;
    }

    public InlinePortletResourceBundle(String title, String shortTitle, String keywords) {
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/internal/impl/InlinePortletResourceBundle.java
        ArrayList temp = new ArrayList();
        if(title != null)
            temp.add(new Object[] {Constants.TITLE_KEY, title});

        if(shortTitle != null)
            temp.add(new Object[] {Constants.SHORT_TITLE_KEY, shortTitle});

        if(keywords != null)
            temp.add(new Object[] {Constants.KEYWORDS_KEY, keywords});

        contents = (Object[][])temp.toArray(new Object[temp.size()][]);
=======
        ArrayList<Object[]> temp = new ArrayList<Object[]>();
        if(title != null)
            temp.add(new Object[] {TITLE_KEY, title});

        if(shortTitle != null)
            temp.add(new Object[] {SHORT_TITLE_KEY, shortTitle});

        if(keywords != null)
            temp.add(new Object[] {KEYWORDS_KEY, keywords});

        contents = temp.toArray(new Object[temp.size()][]);
>>>>>>> refs/remotes/apache/master:pluto-portal-driver/src/main/java/org/apache/pluto/driver/container/InlinePortletResourceBundle.java
    }

    protected Object[][] getContents() {
        return contents;
    }
}
