/*
 * Copyright 2003,2004 The Apache Software Foundation.
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

package org.apache.pluto.core;

import org.apache.pluto.services.PortletInvokerService;
import org.apache.pluto.services.LoggerService;
import org.apache.pluto.services.Logger;
import org.apache.pluto.services.ServiceFactory;
import org.apache.pluto.services.PortletURLService;
import org.apache.pluto.services.OptionalServiceFactory;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.PlutoException;
import org.apache.pluto.PlutoConstants;
import org.apache.pluto.PlutoEnvironment;

import javax.portlet.PortletException;
import javax.portlet.UnavailableException;
import javax.servlet.ServletContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

/** <P>Invoker implementation which forwards container requests
 *  to the appropriate {@link PortletServlet} within the
 *  appropriate portlet application.</P>
 *
 *  <P>NOTE: Another example of an object that may be modified
 *  if/when we move to an IoC (Pico/Nano?) environment. It also
 *  sticks out as a sore thumb as a class that would truly benefit
 *  from such an architecture.</P>
 *
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 9, 2004 at 10:03:58 AM
 */
public class PortletInvokerServiceImpl
    implements PortletInvokerService {

    /** The surrounding Portal's ServletContext.*/
    private ServletContext context;

    private ServiceFactory factory;

    /** Our logging utility. */
    private Logger logger;

    /** The registry belonging to our container. */
    private PortletRegistry registry;

    /** The LoggerService belonging to our container. */
    private LoggerService loggerService;

    /** The PortletURLService belonging to our container. */
    private PortletURLService portletURLService;

    /** Default Constructor. */
    public PortletInvokerServiceImpl(PlutoEnvironment env,
                                     OptionalServiceFactory factory) {
        this.factory = factory;
        this.portletURLService = factory.getPortletURLService();
        this.loggerService = factory.getLoggerService();
        this.logger = loggerService.getLogger(PortletInvokerServiceImpl.class);

        context = env.getServletContext();
    }

    public void init(PortletRegistry registry) {
        this.registry = registry;
    }

    /** Process and action request. */
    public void doAction(PortletWindow window,
                         ServletRequest request,
                         ServletResponse response)
    throws PlutoException, PortletException, IOException {
        invoke(PlutoConstants.ACTION_REQUEST,window,request,response);
    }

    /** Process a render request. */
    public void doRender(PortletWindow window,
                       ServletRequest request,
                       ServletResponse response)
    throws PlutoException, PortletException, IOException {
        invoke(PlutoConstants.RENDER_REQUEST,window,request,response);
    }

    /** Process a load request. **/
    public void doLoad(PortletWindow window,
                       ServletRequest request,
                       ServletResponse response)
            throws PlutoException, PortletException, IOException {
        invoke(PlutoConstants.LOAD_REQUEST,window,request,response);
    }


    /** Complete the invocation for the specified invocation
     *  method.
     * @param method
     * @param window
     * @param req
     * @param res
     * @throws PlutoException
     * @throws PortletException
     * @throws IOException
     * @see PlutoConstants.REQUEST_METHOD
     */
    protected void invoke(String method,
                          PortletWindow window,
                          ServletRequest req,
                          ServletResponse res)
    throws PlutoException, PortletException, IOException {
        String id = window.getPortletId();
        String app = id.substring(0,id.indexOf('.'));
        // TODO make configurable.
        String url = "/pluto-portlet-invoker";

        if(logger.isDebugEnabled()) {
            logger.debug("Invoking Portlet: "+app+url);
        }

        ServletContext targetContext = context.getContext("/"+app);
        if(logger.isErrorEnabled() && targetContext==null) {
            logger.log("Unable to retrieve portlet app context: "+app
                      +" from portal context: "+context.getServletContextName());
        }
        else if(logger.isDebugEnabled() && targetContext!=null) {
            logger.debug("Retrieved portal app context: "
                         +targetContext.getServletContextName());
        }

        RequestDispatcher disp = targetContext.getRequestDispatcher(url);
        if(disp==null && logger.isErrorEnabled()) {
            logger.error("Unable to retrieve portlet invoker servlet: "+url);
        }

        req.setAttribute(
            PlutoConstants.REQUEST_METHOD,
            method
        );

        req.setAttribute(
            PlutoConstants.PORTLET_WINDOW,
            window
        );

        req.setAttribute(
            PlutoConstants.PORTLET_REGISTRY,
            registry
        );

        req.setAttribute(
            PlutoConstants.SERVICE_FACTORY,
            factory
        );

        try {
            if(logger.isDebugEnabled()) {
                logger.debug("Invoking portlet through invoker servlet."
                            +"[dispatcher="+disp+"]");
            }
            disp.include(req,res);
            if(logger.isDebugEnabled()) {
                logger.debug("Invokation complete");
                logger.debug("RenderParameters: "+
                             req.getAttribute(
                                 PlutoConstants.RENDER_PARAMETERS
                             )
                );
            }
        }
        catch(javax.servlet.UnavailableException ue) {
            ue.printStackTrace();
            throw new UnavailableException(ue.getMessage());
        }
        catch(ServletException se) {
            se.printStackTrace();
            if(se.getRootCause()!=null) {
                if(se.getRootCause() instanceof PortletException) {
                    throw (PortletException)se.getRootCause();
                }
                throw new PlutoException(se.getRootCause().getMessage());
            }
            else {
                throw new PlutoException(se.getMessage());
            }
        }
        catch(RuntimeException re) {
            re.printStackTrace();
            if(logger.isErrorEnabled()) {
                logger.error("Error invoking portlet "+
                             "(RuntimeException): ",re);
            }
            throw re;
        }
        finally {
            req.removeAttribute(PlutoConstants.REQUEST_METHOD);
            req.removeAttribute(PlutoConstants.PORTLET_WINDOW);
            req.removeAttribute(PlutoConstants.PORTLET_REGISTRY);
            req.removeAttribute(PlutoConstants.SERVICE_FACTORY);
        }
    }
}