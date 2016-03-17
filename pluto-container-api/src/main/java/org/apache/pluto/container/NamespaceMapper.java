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
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/util/NamespaceMapper.java
package org.apache.pluto.util;

import org.apache.pluto.PortletWindowID;
=======
package org.apache.pluto.container;

>>>>>>> refs/remotes/apache/master:pluto-container-api/src/main/java/org/apache/pluto/container/NamespaceMapper.java

/**
 **/
public interface NamespaceMapper {

<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/util/NamespaceMapper.java

    public String encode(PortletWindowID namespace, String name);

    public String encode(PortletWindowID ns1, PortletWindowID ns2, String name);

    public String decode(PortletWindowID ns, String name);

=======
    String encode(PortletWindowID namespace, String name);
    String decode(PortletWindowID ns, String name);
>>>>>>> refs/remotes/apache/master:pluto-container-api/src/main/java/org/apache/pluto/container/NamespaceMapper.java
}
