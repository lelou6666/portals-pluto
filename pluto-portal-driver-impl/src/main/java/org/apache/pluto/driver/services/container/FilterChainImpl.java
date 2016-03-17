<<<<<<< HEAD
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
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.filter.ActionFilter;
import javax.portlet.filter.EventFilter;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.RenderFilter;
import javax.portlet.filter.ResourceFilter;

/**
 * A <code>FilterChain</code> is an object provided by the portlet container 
 * to the developer giving a view into the invocation chain of a 
 * filtered request for a portlet. Filters use the <code>FilterChain</code> 
 * to invoke the next filter in the chain, or if the calling filter is the 
 * last filter in the chain, to invoke the portlet at the end of the chain.
 *@since 29/05/2007
 *@version 2.0
 */
public class FilterChainImpl implements FilterChain {

	private List<PortletFilter> actionFilters = new ArrayList<PortletFilter>();
	private List<PortletFilter> eventFilters = new ArrayList<PortletFilter>();
	private List<PortletFilter> renderFilters = new ArrayList<PortletFilter>();
	private List<PortletFilter> resourceFilters = new ArrayList<PortletFilter>();
	private String appName = "";
	ClassLoader loader;
	String portletName;
	PortletContext portletContext;
	private int index = -1;
	
	/**
	 * The class capsulate the PortletFilter and the parameter for the
	 * init and doFilter from FilterChain.
	 */
	class PortletFilter{
		
		FilterConfigImpl filterConfig;
		ActionFilter actionFilter;
		EventFilter eventFilter;
		RenderFilter renderFilter;
		ResourceFilter resourceFilter;
		List<String> portletNames;
		String className = null;
		Class clazz = null;
		
		public PortletFilter(String className, FilterConfigImpl filterConfig,List<String> portletNames){
			this.className = className;
			this.filterConfig = filterConfig;
			this.portletNames = portletNames;
		}
		
		public void addPortletNames(List<String> portletnames){
			for (String string : portletnames) {
				this.portletNames.add(string);
			}
		}
		
		/**
		 * Tests if the filter-mapping contains with the portlet-name. 
		 * @param portletName Name of the portlet.
		 * @return true if contains, false else.
		 */
		public boolean isFilterForPortlet(String portletName){
			if (portletNames == null){
				return false;
			}
			for (int i = 0; i < portletNames.size();i++){
				String name = portletNames.get(i);
				if (name.endsWith("*")){
					if (name.length()== 1){
						//if only *
						return true;
					}
					name = name.substring(0, name.length()-1);
					if (portletName.length()>=name.length()){
						if (portletName.substring(0, name.length()).equals(name))
							return true;
					}
				}
				else if(name.equals(portletName))
					return true;
			}
			return false;
//			return this.portletNames.contains(portletName);
		}
		
		/**
		 * Returns the filter class with the given path.
		 * @return Filterclass
		 * @throws ClassNotFoundException if Class not found
		 */
		private Class getFilterClass() throws ClassNotFoundException{
			if (clazz == null){
				clazz = loader.loadClass(className);
			}
            return clazz;
		}
		private FilterConfigImpl getFilterConfig(){
			return filterConfig;
		}
	}
	
	public FilterChainImpl(String appName){
		this.appName = appName;
	}
	
	/**
	 * The filterData has do be set before call doFilter.
	 * @param loader Classloader of the appl.
	 * @param portletName
	 * @param portletContext
	 */
	public void setFilterData(ClassLoader loader, String portletName, PortletContext portletContext){
		this.loader = loader;
		this.portletName = portletName;
		this.portletContext = portletContext;  
	}
	
	/**
	 * Adds the filter to the filterChain
	 * @param className Path to the filter
	 * @param filterConfig 
	 * @param portletNames
	 * @param lifecycle
	 */
	public void addFilter(String className, FilterConfigImpl filterConfig, List<String> portletNames, List lifecycle){
		PortletFilter portletFilter = new PortletFilter(className, filterConfig, portletNames);
		for (int i = 0; i < lifecycle.size();i++){
			if (lifecycle.get(i).equals(FilterManagerImpl.ACTION_PHASE)){
				actionFilters.add(portletFilter);
			}
			else if (lifecycle.get(i).equals(FilterManagerImpl.EVENT_PHASE)){
				eventFilters.add(portletFilter);
			}
			else if (lifecycle.get(i).equals(FilterManagerImpl.RENDER_PHASE)){
				renderFilters.add(portletFilter);
			}
			else if (lifecycle.get(i).equals(FilterManagerImpl.RESOURCE_PHASE)){
				resourceFilters.add(portletFilter);
			}
		}
	}
	
	public void doFilter(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		if (actionFilters!= null){
			index++;
			if (index < actionFilters.size()){
				PortletFilter filter2 = actionFilters.get(index);
				if (filter2.isFilterForPortlet(portletName)){
					ActionFilter actionfilter;
					try {
						filter2.getFilterConfig().setPortletContext(portletContext);
						actionfilter = (ActionFilter) filter2.getFilterClass().newInstance();
						actionfilter.init(filter2.getFilterConfig());
						actionfilter.doFilter(request, response, this);
						actionfilter.destroy();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else{
					doFilter(request, response);
				}
			}
		}
	}

	public void doFilter(EventRequest request, EventResponse response) throws IOException, PortletException {
		if (eventFilters!= null){
			index++;
			if (index < eventFilters.size()){
				PortletFilter filter2 = eventFilters.get(index); 
				if (filter2.isFilterForPortlet(portletName)){
					EventFilter eventfilter;
					try {
						filter2.getFilterConfig().setPortletContext(portletContext);
						eventfilter = (EventFilter) filter2.getFilterClass().newInstance();
						eventfilter.init(filter2.getFilterConfig());
						eventfilter.doFilter(request, response, this);
						eventfilter.destroy();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else{
					doFilter(request, response);
				}
			}
		}
	}

	public void doFilter(RenderRequest request, RenderResponse response) throws IOException, PortletException {
		if (renderFilters!= null){
			index++;
			if (index < renderFilters.size()){
				PortletFilter filter2 = renderFilters.get(index);
				if (filter2.isFilterForPortlet(portletName)){
					RenderFilter renderfilter;
					try {
						filter2.getFilterConfig().setPortletContext(portletContext);
						renderfilter = (RenderFilter) filter2.getFilterClass().newInstance();
						renderfilter.init(filter2.getFilterConfig());
						renderfilter.doFilter(request, response, this);
						renderfilter.destroy();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else{
					doFilter(request, response);
				}
			}
		}
	}

	public void doFilter(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {
		if (resourceFilters!= null){
			index++;
			if (index < resourceFilters.size()){
				PortletFilter filter2 = resourceFilters.get(index);
				if (filter2.isFilterForPortlet(portletName)){
					ResourceFilter resourcefilter;
					try {
						filter2.getFilterConfig().setPortletContext(portletContext);
						resourcefilter = (ResourceFilter) filter2.getFilterClass().newInstance();
						resourcefilter.init(filter2.getFilterConfig());
						resourcefilter.doFilter(request, response, this);
						resourcefilter.destroy();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else{
					doFilter(request, response);
				}
			}
		}
	}

	/**
	 * Gets the application name.
	 * @return application name
	 */
	public String getAppName() {
		return appName;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
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
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventPortlet;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.filter.ActionFilter;
import javax.portlet.filter.EventFilter;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.RenderFilter;
import javax.portlet.filter.ResourceFilter;

import org.apache.pluto.container.om.portlet.Filter;

/**
 * A <code>FilterChain</code> is an object provided by the portlet container
 * to the developer giving a view into the invocation chain of a
 * filtered request for a portlet. Filters use the <code>FilterChain</code>
 * to invoke the next filter in the chain, or if the calling filter is the
 * last filter in the chain, to invoke the portlet at the end of the chain.
 *@since 29/05/2007
 *@version 2.0
 */
public class FilterChainImpl implements FilterChain {

    private List<Filter> filterList = new ArrayList<Filter>();
    private String lifeCycle;
    Portlet portlet;
    EventPortlet eventPortlet;
    ResourceServingPortlet resourceServingPortlet;
    ClassLoader loader;
    PortletContext portletContext;
    int filterListIndex = 0;

    public FilterChainImpl(String lifeCycle){
        this.lifeCycle = lifeCycle;
    }
    public void processFilter(EventRequest req, EventResponse res, EventPortlet eventPortlet, PortletContext portletContext) throws IOException, PortletException{
        this.eventPortlet = eventPortlet;
        this.loader = Thread.currentThread().getContextClassLoader();
        this.portletContext = portletContext;
        doFilter(req,res);
    }
    public void processFilter(ResourceRequest req, ResourceResponse res, ResourceServingPortlet resourceServingPortlet, PortletContext portletContext) throws IOException, PortletException{
        this.resourceServingPortlet = resourceServingPortlet;
        this.loader = Thread.currentThread().getContextClassLoader();
        this.portletContext = portletContext;
        doFilter(req,res);
    }

    public void processFilter(ActionRequest req, ActionResponse res, Portlet portlet, PortletContext portletContext) throws IOException, PortletException{
        this.portlet = portlet;
        this.loader = Thread.currentThread().getContextClassLoader();
        this.portletContext = portletContext;
        doFilter(req,res);
    }

    public void processFilter(RenderRequest req, RenderResponse res, Portlet portlet, PortletContext portletContext) throws IOException, PortletException{
        this.portlet = portlet;
        this.loader = Thread.currentThread().getContextClassLoader();
        this.portletContext = portletContext;
        doFilter(req, res);
    }

    public void addFilter(Filter filter){
        filterList.add(filter);
    }

    public void doFilter(ActionRequest request, ActionResponse response) throws IOException, PortletException {
        if (filterListIndex <filterList.size()){
            Filter filter = filterList.get(filterListIndex);
            filterListIndex++;
            try {
                ActionFilter actionFilter = (ActionFilter) loader.loadClass(filter.getFilterClass()).newInstance();
                FilterConfigImpl filterConfig = new FilterConfigImpl(filter.getFilterName(),filter.getInitParams(),portletContext);
                actionFilter.init(filterConfig);
                actionFilter.doFilter(request, response, this);
                actionFilter.destroy();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else{
            portlet.processAction(request, response);
        }
    }

    public void doFilter(EventRequest request, EventResponse response) throws IOException, PortletException {
        if (filterListIndex <filterList.size()){
            Filter filter = filterList.get(filterListIndex);
            filterListIndex++;
            try {
                EventFilter eventFilter = (EventFilter) loader.loadClass(filter.getFilterClass()).newInstance();
                FilterConfigImpl filterConfig = new FilterConfigImpl(filter.getFilterName(),filter.getInitParams(),portletContext);
                eventFilter.init(filterConfig);
                eventFilter.doFilter(request, response, this);
                eventFilter.destroy();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else{
            eventPortlet.processEvent(request, response);
        }
    }

    public void doFilter(RenderRequest request, RenderResponse response) throws IOException, PortletException {
        if (filterListIndex <filterList.size()){
            Filter filter = filterList.get(filterListIndex);
            filterListIndex++;
            try {
                RenderFilter renderFilter = (RenderFilter) loader.loadClass(filter.getFilterClass()).newInstance();
                FilterConfigImpl filterConfig = new FilterConfigImpl(filter.getFilterName(),filter.getInitParams(),portletContext);
                renderFilter.init(filterConfig);
                renderFilter.doFilter(request, response, this);
                renderFilter.destroy();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else{
            portlet.render(request, response);
        }
    }

    public void doFilter(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {
        if (filterListIndex <filterList.size()){
            Filter filter = filterList.get(filterListIndex);
            filterListIndex++;
            try {
                ResourceFilter resourceFilter = (ResourceFilter) loader.loadClass(filter.getFilterClass()).newInstance();
                FilterConfigImpl filterConfig = new FilterConfigImpl(filter.getFilterName(),filter.getInitParams(),portletContext);
                resourceFilter.init(filterConfig);
                resourceFilter.doFilter(request, response, this);
                resourceFilter.destroy();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else{
            resourceServingPortlet.serveResource(request, response);
        }
    }
}
>>>>>>> refs/remotes/apache/master
