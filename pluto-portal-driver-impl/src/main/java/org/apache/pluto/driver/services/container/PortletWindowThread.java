<<<<<<< HEAD
/*
 * Copyright 2006 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
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
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Event;
import javax.portlet.PortletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.pluto.EventContainer;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.descriptors.portlet.EventDefinitionDD;
import org.apache.pluto.descriptors.portlet.PortletAppDD;
import org.apache.pluto.driver.AttributeKeys;
import org.apache.pluto.driver.core.PortalRequestContext;
import org.apache.pluto.driver.core.PortalServletRequest;
import org.apache.pluto.internal.impl.EventImpl;

public class PortletWindowThread extends Thread {
	
	private EventProviderImpl eventProvider;
	
	private PortletWindow portletWindow;
	
	private EventContainer eventContainer;
	
	private List<Event> events = new ArrayList<Event>();

	public PortletWindowThread(ThreadGroup group, String name,
			EventProviderImpl eventProvider, PortletWindow window, EventContainer eventContainer) {
		super(group, name);
		this.eventProvider = eventProvider;
		this.portletWindow = window;
		this.eventContainer = eventContainer;		
	}

	public PortletWindowThread(String name, 
			EventProviderImpl eventProvider, PortletWindow window, EventContainer eventContainer) {
		super(name);
		this.eventProvider = eventProvider;
		this.portletWindow = window;
		this.eventContainer = eventContainer;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		super.run();
		while (events.size() > 0) {
			HttpServletRequest req = new PortalServletRequest(eventProvider.getRequest(), this.portletWindow);
			HttpServletResponse res = eventProvider.getResponse();
			try {
//				synchronized (this) {
					Event event = events.remove(0);
			        Object value = event.getValue();
			        
			        XMLStreamReader xml = null;
					try {
						if (value instanceof String) {
							String in = (String) value; 
							xml = XMLInputFactory.newInstance().createXMLStreamReader(new StringReader(in));
						}			
					}  
					catch (XMLStreamException e1) {
						throw new IllegalStateException(e1);
					} catch (FactoryConfigurationError e1) {
						throw new IllegalStateException(e1);
					}
			        
			        if (xml != null) {
			        	//XMLStreamReader xml = (XMLStreamReader) event.getValue();
			        	
			        		//provider.getEventDefinition(event.getQName());
			        	try {
			        		// now test if object is jaxb
			        		EventDefinitionDD eventDefinitionDD = getEventDefintion(event.getQName()); 
			        		
			        		ClassLoader loader = Thread.currentThread().getContextClassLoader();
			        		Class<? extends Serializable> clazz = loader.loadClass(eventDefinitionDD.getJavaClass()).asSubclass(Serializable.class);

			        		JAXBContext jc = JAXBContext.newInstance(clazz);
			        		Unmarshaller unmarshaller  = jc.createUnmarshaller();

//			        		unmarshaller.setEventHandler(new javax.xml.bind.helpers.DefaultValidationEventHandler());

			        		JAXBElement result = unmarshaller.unmarshal(xml,clazz);

			        		event =  new EventImpl(event.getQName(),(Serializable) result.getValue());
			        	} catch (JAXBException e) {
			        		throw new IllegalStateException(e);
			        	} catch (ClassCastException e) {
			        		throw new IllegalStateException(e);
			        	} catch (ClassNotFoundException e) {
			        		throw new IllegalStateException(e);
			        	} catch (PortletContainerException e) {
			        		throw new IllegalStateException(e);
						}
			        }					
					eventContainer.fireEvent(req, res, portletWindow, event);	
//				}
			} catch (PortletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}

	public void addEvent(Event event) {
		this.events.add(event);	
	}

	private EventDefinitionDD getEventDefintion(QName name) throws PortletContainerException {
		PortalRequestContext context = PortalRequestContext.getContext(eventProvider.getRequest());
		ServletContext servletContext = context.getServletContext();
		PortletContainer container = (PortletContainer) servletContext.getAttribute(AttributeKeys.PORTLET_CONTAINER);
		PortletAppDD appDD = container.getPortletApplicationDescriptor(portletWindow.getContextPath());
		for (EventDefinitionDD def : appDD.getEvents()){
			if (def.getName().equals(name)){
				return def;
			}
		}
		throw new IllegalStateException();
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
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Event;
import javax.portlet.PortletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletContainerException;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.driver.PortletContextService;
import org.apache.pluto.container.om.portlet.EventDefinition;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;

public class PortletWindowThread extends Thread {
	
	/** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(PortletWindowThread.class);
    
    private PortletContainer container;
    
	private PortletWindow portletWindow;
	
	private HttpServletRequest request;
    private HttpServletResponse response;
	
	/** PortletRegistryService used to obtain PortletApplicationConfig objects */
	private PortletContextService portletContextService;
	
	private List<Event> events = new ArrayList<Event>();

	public PortletWindowThread(ThreadGroup group, String name,
	                           PortletContainer container, PortletWindow window, 
	                           HttpServletRequest request, HttpServletResponse response, 
	                           PortletContextService portletContextService)
	{
		super(group, name);
        this.request = request;
        this.response = response;
		this.portletWindow = window;
		this.container = container;
		this.portletContextService = portletContextService;
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		super.run();
		while (events.size() > 0) {
			try {
//				synchronized (this) {
					Event event = events.remove(0);
			        Object value = event.getValue();
			        
			        XMLStreamReader xml = null;
					try {
						if (value instanceof String) {
							String in = (String) value; 
							xml = XMLInputFactory.newInstance().createXMLStreamReader(new StringReader(in));
						}			
					}  
					catch (XMLStreamException e1) {
						throw new IllegalStateException(e1);
					} catch (FactoryConfigurationError e1) {
						throw new IllegalStateException(e1);
					}
			        
			        if (xml != null) {
			        	//XMLStreamReader xml = (XMLStreamReader) event.getValue();
			        	
			        		//provider.getEventDefinition(event.getQName());
			        	try {
			        		// now test if object is jaxb
			        		EventDefinition eventDefinitionDD = getEventDefintion(event.getQName()); 
			        		
			        		ClassLoader loader = portletContextService.getClassLoader(portletWindow.getPortletDefinition().getApplication().getName());
			        		Class<? extends Serializable> clazz = loader.loadClass(eventDefinitionDD.getValueType()).asSubclass(Serializable.class);

			        		JAXBContext jc = JAXBContext.newInstance(clazz);
			        		Unmarshaller unmarshaller  = jc.createUnmarshaller();

//			        		unmarshaller.setEventHandler(new javax.xml.bind.helpers.DefaultValidationEventHandler());

			        		JAXBElement result = unmarshaller.unmarshal(xml,clazz);

			        		event =  new EventImpl(event.getQName(),(Serializable) result.getValue());
			        	} catch (JAXBException e) {
			        		throw new IllegalStateException(e);
			        	} catch (ClassCastException e) {
			        		throw new IllegalStateException(e);
			        	} catch (ClassNotFoundException e) {
			        		throw new IllegalStateException(e);
			        	} catch (PortletContainerException e) {
			        		throw new IllegalStateException(e);
						}
			        }					
					container.doEvent(portletWindow, request, response, event);	
//				}
			} catch (PortletException e) {
				LOG.warn(e.getMessage(),e);
			} catch (IOException e) {
				LOG.warn(e.getMessage(),e);
			} catch (PortletContainerException e) {
				LOG.warn(e.getMessage(),e);
			}	
		}
	}

	public void addEvent(Event event) {
		this.events.add(event);	
	}

	private EventDefinition getEventDefintion(QName name) {
		PortletApplicationDefinition appDD = portletWindow.getPortletDefinition().getApplication();
		for (EventDefinition def : appDD.getEventDefinitions()){
			if (def.getQName() != null){
				if (def.getQName().equals(name))
					return def;
			}
			else{
				QName tmp = new QName(appDD.getDefaultNamespace(),def.getName());
				if (tmp.equals(name))
					return def;
			}
		}
		throw new IllegalStateException();
	}
}
>>>>>>> refs/remotes/apache/master
