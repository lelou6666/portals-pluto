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
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/PlutoConfigurationException.java
package org.apache.pluto;
=======
package org.apache.pluto.container.driver;
>>>>>>> refs/remotes/apache/master:pluto-container-driver-api/src/main/java/org/apache/pluto/container/driver/PlutoConfigurationException.java

/**
 * Exception thrown when Pluto configuration fails.
 *
 * @since Jul 2, 2005
 */
public class PlutoConfigurationException extends RuntimeException {

<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/PlutoConfigurationException.java
=======
    private static final long serialVersionUID = 8159327269127050615L;

>>>>>>> refs/remotes/apache/master:pluto-container-driver-api/src/main/java/org/apache/pluto/container/driver/PlutoConfigurationException.java
    public PlutoConfigurationException(String message) {
        super(message);
    }

    public PlutoConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}
