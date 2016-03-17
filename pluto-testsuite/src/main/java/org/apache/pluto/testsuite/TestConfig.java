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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Configuration for <code>PortletTest</code>.
 *
 * @see TestConfigFactory
 * @see PortletTest
 *
 * @version 1.0
 * @since Sep 15, 2004
 */
public class TestConfig implements Serializable {

<<<<<<< HEAD
=======
	private static final long serialVersionUID = -6878431356359186658L;

>>>>>>> refs/remotes/apache/master
	// Private Member Variables ------------------------------------------------

	/** PortletTest class name. */
    private String testClassName;

    /** Test name. */
<<<<<<< HEAD
    private String name = null;

    private String displayURI;

    private final Map initParameters = new HashMap();
=======
    private String name;

    private String displayURI;

    private Map<String, String> initParameters = new HashMap<String, String>();
>>>>>>> refs/remotes/apache/master

    /**
     * The action parameters list holding TestConfig.Parameter objects.
     * We are not using Map to hold action parameters because parameters with
     * the same name are allowed.
     */
<<<<<<< HEAD
    private final List actionParameters = new ArrayList();
=======
    private List<Parameter> actionParameters = new ArrayList<Parameter>();
>>>>>>> refs/remotes/apache/master

    /**
     * The render parameters list holding TestConfig.Parameter objects.
     * We are not using Map to hold render parameters because parameters with
     * the same name are allowed.
     *
     * FIXME: when is this field used?
     */
<<<<<<< HEAD
    private final List renderParameters = new ArrayList();
=======
//    private List renderParameters = new ArrayList();
>>>>>>> refs/remotes/apache/master


    // Constructor -------------------------------------------------------------

    /**
     * Default constructor required by Digester.
     */
    public TestConfig() {
    	// Do nothing.
    }

    // Public Methods ----------------------------------------------------------

    public String getTestClassName() {
        return testClassName;
    }

    public void setTestClassName(String testClassName) {
        this.testClassName = testClassName;
    }

    public String getName() {
        return name;
    }

    public void setName(String testName) {
        this.name = testName;
    }

    public String getDisplayURI() {
        return displayURI;
    }

    public void setDisplayURI(String displayURI) {
        this.displayURI = displayURI;
    }

    public void addInitParameter(String parameter, String value) {
        initParameters.put(parameter, value);
    }

<<<<<<< HEAD
    public Map getInitParameters() {
=======
    public Map<String, String> getInitParameters() {
>>>>>>> refs/remotes/apache/master
        return Collections.unmodifiableMap(initParameters);
    }

    public void addActionParameter(String name, String value) {
    	actionParameters.add(new Parameter(name, value));
    }

<<<<<<< HEAD
    public List getActionParameters() {
=======
    public List<Parameter> getActionParameters() {
>>>>>>> refs/remotes/apache/master
    	return actionParameters;
    }

    /**
     * FIXME: why is this method required?
     */
<<<<<<< HEAD
    public void addRenderParameter(String name, String value) {
    	renderParameters.add(new Parameter(name, value));
    }
=======
    /*
    public void addRenderParameter(String name, String value) {
    	renderParameters.add(new Parameter(name, value));
    }
    */
>>>>>>> refs/remotes/apache/master

    /**
     * FIXME: when is this method used?
     */
<<<<<<< HEAD
    public List getRenderParameters() {
    	return renderParameters;
    }
=======
    /*
    public List getRenderParameters() {
    	return renderParameters;
    }
    */
>>>>>>> refs/remotes/apache/master

    public String toString() {
    	StringBuffer buffer = new StringBuffer();
    	buffer.append(getClass().getName());
    	buffer.append("[").append(getName()).append("]");
    	return buffer.toString();
    }

    public static class Parameter {
    	private String name = null;
    	private String value = null;
    	public Parameter(String name, String value) {
    		this.name = name;
    		this.value = value;
    	}

    	public String getName() {
    		return name;
    	}
    	public String getValue() {
    		return value;
    	}
    }

}

