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
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/spi/ResourceURLProvider.java
package org.apache.pluto.spi;
=======
package org.apache.pluto.container;
>>>>>>> refs/remotes/apache/master:pluto-container-api/src/main/java/org/apache/pluto/container/ResourceURLProvider.java

/**
 *
 * @version 1.0
 */
public interface ResourceURLProvider {

    /**
     * Sets the absolute URL to be returned by the provider. E.g.
     * http://host/wps/portal/hello.gif
     * @param path the new absolute url
     */
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/spi/ResourceURLProvider.java
    public void setAbsoluteURL(String path);
=======
    void setAbsoluteURL(String path);
>>>>>>> refs/remotes/apache/master:pluto-container-api/src/main/java/org/apache/pluto/container/ResourceURLProvider.java

    /**
     * Sets a full path URI including the context root. E.g.
     * /wps/portal/hello.gif
     * @param path the new absolute url
     */
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/spi/ResourceURLProvider.java
    public void setFullPath(String path);
=======
    void setFullPath(String path);
>>>>>>> refs/remotes/apache/master:pluto-container-api/src/main/java/org/apache/pluto/container/ResourceURLProvider.java

    /**
     * Returns a url to a resource as absolute URL starting with protocol so
     * that it can be accessed by a browser.
     * @return the URL as string
     */
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/spi/ResourceURLProvider.java
    public String toString();
=======
    String toString();
>>>>>>> refs/remotes/apache/master:pluto-container-api/src/main/java/org/apache/pluto/container/ResourceURLProvider.java

}
