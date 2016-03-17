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
package org.apache.pluto.driver.services.container;

<<<<<<< HEAD
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.driver.core.PortalRequestContext;
import org.apache.pluto.spi.ResourceURLProvider;
=======
import javax.servlet.http.HttpServletRequest;

import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.ResourceURLProvider;
>>>>>>> refs/remotes/apache/master

public class ResourceURLProviderImpl implements ResourceURLProvider {

    private String stringUrl = "";
    private String base = "";

    public ResourceURLProviderImpl(HttpServletRequest req,
<<<<<<< HEAD
                                   PortletWindow internalPortletWindow) {
=======
                                   PortletWindow portletWindow) {
>>>>>>> refs/remotes/apache/master
    }

    public void setAbsoluteURL(String path) {
        stringUrl = path;
    }

    public void setFullPath(String path) {
        stringUrl = base + path;
    }

    public String toString() {
        return (stringUrl == null) ? "" : stringUrl;

    }
}
