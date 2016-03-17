<<<<<<< HEAD
/*  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.apache.pluto.driver.services.container;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;

import org.apache.pluto.PortletWindow;
import org.apache.pluto.driver.core.PortalRequestContext;
import org.apache.pluto.driver.url.PortalURL;
import org.apache.pluto.driver.url.PortalURLParameter;
import org.apache.pluto.driver.url.impl.PortalURLParserImpl;
import org.apache.pluto.spi.PortletURLProvider;

/**
 * 
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 */
public class PortletURLProviderImpl implements PortletURLProvider {

    private PortalURL url;
    private String window;
    
    private static final String KEY = PortalURL.class.getName();

    public PortletURLProviderImpl(HttpServletRequest request,
                                  PortletWindow internalPortletWindow) {
    	PortalURL portalURL = (PortalURL) request.getAttribute(KEY);
        if (portalURL == null) {
        	PortalRequestContext ctx = (PortalRequestContext)
    			request.getAttribute(PortalRequestContext.REQUEST_KEY);
        	url = ctx.createPortalURL();
            request.setAttribute(KEY, portalURL);
            
        }
        else {
        	url = (PortalURL) portalURL.clone();
        }

        this.window = internalPortletWindow.getId().getStringId();
    }

    public void setPortletMode(PortletMode mode) {
        url.setPortletMode(window, mode);
    }

    public void setWindowState(WindowState state) {
        url.setWindowState(window, state);
    }
    
    public void setResourceServing(boolean resourceServing) {
        if (resourceServing) {
            url.setResourceWindow(window);
        } else {
            url.setResourceWindow(null);
        }
    }

    public boolean isResourceServing(){
    	if (url.getResourceWindow() != null)
    		return true;
    	else
    		return false;
    }
    
    public void setAction(boolean action) {
        if (action) {
            url.setActionWindow(window);
        } else {
            url.setActionWindow(null);
        }
    }

    public void setSecure() {
        //url.setSecure(true);
    }

    public void clearParameters() {
        url.clearParameters(window);
    }

    
    public void setParameters(Map parameters) {
        Iterator it = parameters.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            PortalURLParameter param = new PortalURLParameter(
            		window,
            		(String) entry.getKey(),
            		(String[]) entry.getValue());
            url.addParameter(param);
        }
    }
    
    public String[] getPrivateRenderParameters(String name){
    	String[] values = null;
    	for (Iterator it=url.getParameters().iterator();it.hasNext();){
    		PortalURLParameter param = (PortalURLParameter)it.next();
    		if (param.getName().equals(name))
    			values = param.getValues();
    	}
    	return values;
    }
    
    public String[] getPublicRenderParameters(String name){
    	Map publicRenderParaMap = url.getPublicParameters();
    	String[] values = null;
    	for (Iterator it=publicRenderParaMap.keySet().iterator();it.hasNext();){
    		String tmp = (String) it.next();
    		if (tmp.equals(name)){
    			values = (String[])publicRenderParaMap.get(tmp);
    		}
    	}
    	return values;
    }
    
    public void setPublicRenderParameters(Map parameters) {
		url.addPublicRenderParametersNew(parameters);
	}

    public String toString() {
        return url.toString();
    }

	public void savePortalURL(HttpServletRequest request) {
		PortalRequestContext ctx = (PortalRequestContext)
			request.getAttribute(PortalRequestContext.REQUEST_KEY);
		ctx.setPortalURL(url);		
	}

	

}
=======
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

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletMode;
import javax.portlet.PortletSecurityException;
import javax.portlet.ResourceURL;
import javax.portlet.WindowState;

import org.apache.pluto.container.PortletURLProvider;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.driver.url.PortalURL;
import org.apache.pluto.driver.url.PortalURLParameter;

/**
 *
 */
public class PortletURLProviderImpl implements PortletURLProvider
{
    private final PortalURL url;
    private final TYPE type;
    private final String window;
    private PortletMode portletMode;
    private WindowState windowState;
    private String cacheLevel;
    private String resourceID;
    private Map<String, String[]> renderParameters;
    private Map<String, String[]> publicRenderParameters;
    private Map<String, List<String>> properties;

    public PortletURLProviderImpl(PortalURL url, TYPE type, PortletWindow portletWindow)
    {
        this.url = url;
        this.type = type;
        this.window = portletWindow.getId().getStringId();
    }
    
    public PortalURL apply()
    {
        PortalURL url = this.url.clone();
        if (PortletURLProvider.TYPE.ACTION == type)
        {
            url.setActionWindow(window);
            url.setResourceWindow(null);
            url.clearParameters(window);
        }
        else if (PortletURLProvider.TYPE.RESOURCE == type)
        {
            url.setActionWindow(null);
            url.setResourceWindow(window);
            if (!ResourceURL.FULL.equals(cacheLevel))
            {
                for (PortalURLParameter parm : url.getParameters())
                {
                    if (window.equals(parm.getWindowId()))
                    {
                        url.getPrivateRenderParameters().put(parm.getName(), parm.getValues());
                    }                            
                }
            }
            url.clearParameters(window);
        }
        else
        {
            url.setResourceWindow(null);
            url.setActionWindow(null);
            url.clearParameters(window);
        }
        if (portletMode != null)
        {
            url.setPortletMode(window, portletMode);
        }
        if (windowState != null)
        {
            url.setWindowState(window, windowState);
        }
        if (renderParameters != null)
        {
            for (Map.Entry<String,String[]> entry : renderParameters.entrySet())
            {
                if (publicRenderParameters == null || !publicRenderParameters.containsKey(entry.getKey()))
                {
                    url.addParameter(new PortalURLParameter(window, entry.getKey(), entry.getValue()));
                }
            }
        }
        if (publicRenderParameters != null)
        {
            for (Map.Entry<String,String[]> entry : publicRenderParameters.entrySet())
            {
                url.getNewPublicParameters().put(entry.getKey(),entry.getValue() != null ? entry.getValue() : new String[]{null});
            }
        }
        url.setResourceID(resourceID);
        url.setCacheability(cacheLevel);
        return url;
    }
    
    public TYPE getType()
    {
        return type;
    }
    
    public void setPortletMode(PortletMode mode)
    {
        this.portletMode = mode;
    }
    
    public PortletMode getPortletMode()
    {
        return portletMode;
    }

    public void setWindowState(WindowState state)
    {
        this.windowState = state;
    }

    public WindowState getWindowState()
    {
        return windowState;
    }

    public void setSecure(boolean secure) throws PortletSecurityException {
        // ignore: not supported
    }
    
    public boolean isSecure()
    {
        return false;
    }
    
    public Map<String,String[]> getRenderParameters()
    {
        if (renderParameters == null)
        {
            renderParameters = new HashMap<String,String[]>();
        }
        return renderParameters;
    }
    
    public Map<String,String[]> getPublicRenderParameters()
    {
        if (publicRenderParameters == null)
        {
            publicRenderParameters = new HashMap<String,String[]>();
        }
        return publicRenderParameters;
    }
    
    public String getCacheability()
    {
        return cacheLevel;
    }

    public void setCacheability(String cacheLevel)
    {
        this.cacheLevel = cacheLevel;
    }

    public String getResourceID()
    {
        return resourceID;
    }

    public void setResourceID(String resourceID)
    {
        this.resourceID = resourceID;
    }
    
    public String toURL()
    {
        return toURL(false);
    }

    public String toURL(boolean absolute)
    {
        return apply().toURL(absolute);
    }

    public void write(Writer out, boolean escapeXML) throws IOException
    {
        String result = apply().toURL(false);
        if (escapeXML)
        {
            result = result.replaceAll("&", "&amp;");
            result = result.replaceAll("<", "&lt;");
            result = result.replaceAll(">", "&gt;");
            result = result.replaceAll("\'", "&#039;");
            result = result.replaceAll("\"", "&#034;");
        }
        out.write(result);
    }

    public Map<String, List<String>> getProperties()
    {
        if (properties == null)
        {
            properties = new HashMap<String, List<String>>();
        }
        return properties;
    }
}
>>>>>>> refs/remotes/apache/master
