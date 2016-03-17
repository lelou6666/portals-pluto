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
<<<<<<< HEAD:pluto-descriptor-api/src/main/java/org/apache/pluto/descriptors/servlet/LoadOnStartupDD.java
package org.apache.pluto.descriptors.servlet;

/**
 * <B>TODO</B>: Document
 * @version $Id: LoadOnStartupDD.java 156636 2005-03-09 12:16:31Z cziegeler $
 * @since Mar 8, 2005
 */
public class LoadOnStartupDD {

    private int priority;

    public LoadOnStartupDD() {

    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

}

=======
package org.apache.pluto.driver.container;

import javax.servlet.ServletContext;

public interface ApplicationIdResolver {

    public static final int DECISIVE = 1;

    public static final int MANUAL = 2;

    public static final int DEFAULT = 3;

    /**
     * Resolve the applicationId for the given
     * context.
     *
     * @param context
     * @return
     */
    String resolveApplicationId(ServletContext context);

    /**
     * Retrive the degree of authority with which
     * the resolver speaks.
     * 
     * @return
     */
    int getAuthority();

}
>>>>>>> refs/remotes/apache/master:pluto-portal-driver/src/main/java/org/apache/pluto/driver/container/ApplicationIdResolver.java
