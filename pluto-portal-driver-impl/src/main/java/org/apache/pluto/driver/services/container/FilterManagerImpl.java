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
import javax.portlet.filter.FilterChain;

import org.apache.pluto.descriptors.portlet.FilterDD;
import org.apache.pluto.descriptors.portlet.FilterMappingDD;
import org.apache.pluto.descriptors.portlet.PortletAppDD;
import org.apache.pluto.spi.FilterManager;

/**
 * Manage the initialization and doFilter {@link FilterChainImpl} for the filter which are
 * declareted in the deployment descriptor.
 * @since 05/29/2007
 * @version 2.0
 */
public class FilterManagerImpl implements FilterManager{
	protected static final String ACTION_PHASE = "ACTION_PHASE";
	protected static final String EVENT_PHASE = "EVENT_PHASE";
	protected static final String RENDER_PHASE = "RENDER_PHASE";
	protected static final String RESOURCE_PHASE = "RESOURCE_PHASE";
	static List<FilterChainImpl> filterApps = new ArrayList<FilterChainImpl>();
	private static FilterManagerImpl filterManager = new FilterManagerImpl();
	ClassLoader loader = null;
	
	
	public static FilterManager getFilterManager(){
		return filterManager;
	}
	
	/**
	 * The processFilter initialize the rest you need and invoke doFilter from FilterChain.
	 * @param req request for doFilter in the filterChain
	 * @param res response for doFilter in the filterChain
	 * @param loader Classloader for the filter 
	 * @param portletName current portletName
	 * @param portletContext current portletcontext
	 * @param lifecycle must be ACTION_PHASE, EVENT_PHASE, RENDER_PHASE or RESOURCE_PHASE
	 */
	public void processFilter(PortletRequest req, PortletResponse res, ClassLoader loader, String portletName, PortletContext portletContext, String lifecycle){
		//search for the filter in the portlet app
		String appName = req.getContextPath();
		//iterate over the applications.
		for (FilterChainImpl filterChain2 : filterApps) {
			if (filterChain2.getAppName().equals(appName)){
				//initialize the rest of the needed data
				filterChain2.setFilterData(loader, portletName, portletContext);
				try {
					filterChain2.setIndex(-1);
					if (lifecycle.equals(ACTION_PHASE)){
							filterChain2.doFilter((ActionRequest)req, (ActionResponse)res);	
					}
					else if (lifecycle.equals(EVENT_PHASE)){
							filterChain2.doFilter((EventRequest)req, (EventResponse)res);	
					}
					else if (lifecycle.equals(RENDER_PHASE)){
						filterChain2.doFilter((RenderRequest)req, (RenderResponse)res);	
					}
					else if (lifecycle.equals(RESOURCE_PHASE)){
						filterChain2.doFilter((ResourceRequest)req, (ResourceResponse)res);	
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (PortletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			}
		}
	}

	/**
	 * Adds the Applications for the filter.
	 * @param portletAppDD	PortletAppDD for iterate over all filter in the map.
	 * @param ContextPath needed for the FilterConfig
	 * @return
	 */
	public static boolean addFilterApp(PortletAppDD portletAppDD, String ContextPath){
		
		for(FilterChainImpl filterChain: filterApps){
			if (filterChain.getAppName().equals(ContextPath))
				return false;
		}
		FilterChainImpl filterChain = new FilterChainImpl(ContextPath);
		filterApps.add(filterChain);
		List<FilterMappingDD> filterMappingDD =  portletAppDD.getFilterMapping();
		List<FilterDD> filterDD = portletAppDD.getFilter();
		if (filterDD!=null){
			for (FilterDD filterDD2 : filterDD) {
//				if (filterDD2.getLifecycle().equals(ACTION_PHASE)){
					if (filterMappingDD!=null)
					for (FilterMappingDD filterMappingDD2 : filterMappingDD) {
						if (filterMappingDD2.getFilterName().equals(filterDD2.getFilterName())){
							//insert FilterChain activation
							FilterConfigImpl filterConfig = new FilterConfigImpl(filterDD2.getFilterName(),
																				filterDD2.getInitParam());
							filterChain.addFilter(filterDD2.getFilterClass(), filterConfig, filterMappingDD2.getPortletName(), filterDD2.getLifecycle());
						}
					}
//				}
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param ContextPath
	 */
	public static void removeFilterApp(String ContextPath){
		// TODO must be updated, when SupportedModesServiceImpl is done
	}
	
	/**
	 * 
	 *
	 */
	public static void removeAllFilterApps(){
		// TODO must be updated, when SupportedModesServiceImpl is done
		filterApps = null;
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

import org.apache.pluto.container.FilterManager;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.om.portlet.Filter;
import org.apache.pluto.container.om.portlet.FilterMapping;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.PortletDefinition;


/**
 * Manage the initialization and doFilter {@link FilterChainImpl} for the filter which are
 * declareted in the deployment descriptor.
 * @since 05/29/2007
 * @version 2.0
 */
public class FilterManagerImpl implements FilterManager{
    private FilterChainImpl filterchain;
    private PortletApplicationDefinition portletApp;
    private String portletName;
    private String lifeCycle;

    public FilterManagerImpl(PortletWindow portletWindow, String lifeCycle) {
        final PortletDefinition pd = portletWindow.getPortletDefinition();
        this.portletApp = pd.getApplication();
        this.portletName =  pd.getPortletName();
        this.lifeCycle = lifeCycle;
        filterchain = new FilterChainImpl(lifeCycle);
        initFilterChain();
    }

    private void initFilterChain(){
        List<? extends FilterMapping> filterMappingList = portletApp.getFilterMappings();
        if (filterMappingList!= null){
            for (FilterMapping filterMapping : filterMappingList) {
                if (isFilter(filterMapping, portletName)){
                    //the filter is specified for the portlet, check the filter for the lifecycle
                    List<? extends Filter> filterList = portletApp.getFilters();
                    for (Filter filter : filterList) {
                        //search for the filter in the filter
                        if (filter.getFilterName().equals(filterMapping.getFilterName())){
                            //check the lifecycle
                            if (isLifeCycle(filter, lifeCycle)){
                                //the filter match to the portlet and has the specified lifecycle -> add to chain
                                filterchain.addFilter(filter);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * @see org.apache.pluto.container.FilterManager#processFilter(javax.portlet.EventRequest, javax.portlet.EventResponse, javax.portlet.EventPortlet, javax.portlet.PortletContext)
     */
    public void processFilter(EventRequest req, EventResponse res, EventPortlet eventPortlet,PortletContext portletContext)throws PortletException, IOException{
        filterchain.processFilter(req, res, eventPortlet, portletContext);
    }

    /**
     * @see org.apache.pluto.container.FilterManager#processFilter(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse, javax.portlet.ResourceServingPortlet, javax.portlet.PortletContext)
     */
    public void processFilter(ResourceRequest req, ResourceResponse res, ResourceServingPortlet resourceServingPortlet,PortletContext portletContext)throws PortletException, IOException{
        filterchain.processFilter(req, res, resourceServingPortlet, portletContext);
    }

    /**
     * @see org.apache.pluto.container.FilterManager#processFilter(javax.portlet.RenderRequest, javax.portlet.RenderResponse, javax.portlet.Portlet, javax.portlet.PortletContext)
     */
    public void processFilter(RenderRequest req, RenderResponse res, Portlet portlet,PortletContext portletContext) throws PortletException, IOException{
        filterchain.processFilter(req, res, portlet, portletContext);
    }

    /**
     * @see org.apache.pluto.container.FilterManager#processFilter(javax.portlet.ActionRequest, javax.portlet.ActionResponse, javax.portlet.Portlet, javax.portlet.PortletContext)
     */
    public void processFilter(ActionRequest req, ActionResponse res, Portlet portlet,PortletContext portletContext) throws PortletException, IOException{
        filterchain.processFilter(req, res, portlet, portletContext);
    }

    private boolean isLifeCycle(Filter filter, String lifeCycle){
        List <String> lifeCyclesList = filter.getLifecycles();
        for (String string : lifeCyclesList) {
            if (string.equals(lifeCycle))
                return true;
        }
        return false;
    }

    private boolean isFilter(FilterMapping filterMapping,String portletName){
        List <String> portletNamesList = filterMapping.getPortletNames();
        for (String portletNameFromFilterList : portletNamesList) {
            if (portletNameFromFilterList.endsWith("*")){
                if (portletNameFromFilterList.length()==1){
                    //if name contains only *
                    return true;
                }
                portletNameFromFilterList = portletNameFromFilterList.substring(0, portletNameFromFilterList.length()-1);
                if (portletName.length()>= portletNameFromFilterList.length()){
                    if (portletName.substring(0, portletNameFromFilterList.length()).equals(portletNameFromFilterList)){
                        return true;
                    }
                }
            }
            else if (portletNameFromFilterList.equals(portletName))
                return true;
        }
        return false;
    }


}
>>>>>>> refs/remotes/apache/master
