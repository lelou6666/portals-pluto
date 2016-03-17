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
package org.apache.pluto.testsuite;

<<<<<<< HEAD
=======
import java.util.HashMap;
import java.util.Map;

>>>>>>> refs/remotes/apache/master
import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
<<<<<<< HEAD

import java.util.HashMap;
import java.util.Map;
=======
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
>>>>>>> refs/remotes/apache/master

/**
 * @version 1.0
 * @since Mar 9, 2005
 */
public class NoOpTest implements PortletTest {

	/** The test configuration. */
    private TestConfig config;


    // Constructor -------------------------------------------------------------

    /**
     * Default no-arg constructor.
     */
    public NoOpTest() {
    	// Do nothing.
    }


    // PortletTest Impl --------------------------------------------------------

    public String getTestSuiteName() {
        return "NoOpTest";
    }

<<<<<<< HEAD
    public Map getRenderParameters(PortletRequest request) {
        return new HashMap();
=======
    public Map<String, String[]> getRenderParameters(PortletRequest request) {
        return new HashMap<String, String[]>();
>>>>>>> refs/remotes/apache/master
    }

    public TestResults doTest(PortletConfig config,
                              PortletContext context,
                              PortletRequest request,
                              PortletResponse response) {
        return new TestResults("None");
    }

    public void init(TestConfig config) {
        this.config = config;
    }

    public TestConfig getConfig() {
        return config;
    }

<<<<<<< HEAD
=======
    public void doHeaders(PortletConfig config, PortletContext context,
            RenderRequest request, RenderResponse response) {
        
    }

>>>>>>> refs/remotes/apache/master
}

