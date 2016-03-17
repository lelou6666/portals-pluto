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

package javax.portlet.tck.portlets;

import java.io.*;
import java.util.*;
import java.util.logging.*;
import static java.util.logging.Logger.*;
import javax.xml.namespace.QName;
import javax.portlet.*;
import javax.portlet.filter.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.portlet.tck.beans.*;
import javax.portlet.tck.constants.*;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.*;
import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.PortletSession.*;
import static javax.portlet.ResourceURL.*;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet
 * will initiate the events, but not process them. The processing is done in the companion 
 * portlet WrapperTests_EventResponseWrapper_ApiEvent_event
 *
 */
public class WrapperTests_EventResponseWrapper_ApiEvent implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         WrapperTests_EventResponseWrapper_ApiEvent.class.getName();
   private final Logger LOGGER = Logger.getLogger(LOG_CLASS);
   
   private PortletConfig portletConfig = null;

   @Override
   public void init(PortletConfig config) throws PortletException {
      this.portletConfig = config;
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet processAction entry");

      portletResp.setRenderParameters(portletReq.getParameterMap());
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      StringWriter writer = new StringWriter();

      QName eventQName = new QName(TCKNAMESPACE,
             "WrapperTests_EventResponseWrapper_ApiEvent");
      portletResp.setEvent(eventQName, "Hi!");
   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet serveResource entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet render entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      /* TestCase: V2WrapperTests_EventResponseWrapper_ApiEvent_setEventA     */
      /* Details: "Method setEvent(javax.xml.namespace.QName,                 */
      /* java.io.Serializable): Calls wrapped method"                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2WrapperTests_EventResponseWrapper_ApiEvent_setEventA", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2WrapperTests_EventResponseWrapper_ApiEvent_setEventB     */
      /* Details: "Method setEvent(String, java.io.Serializable): Calls       */
      /* wrapped method"                                                      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2WrapperTests_EventResponseWrapper_ApiEvent_setEventB", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2WrapperTests_EventResponseWrapper_ApiEvent_setPortletMode */
      /* Details: "Method setPortletMode(PortletMode): Calls wrapped          */
      /* method"                                                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2WrapperTests_EventResponseWrapper_ApiEvent_setPortletMode", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2WrapperTests_EventResponseWrapper_ApiEvent_setRenderParameterA */
      /* Details: "Method setRenderParameter(String, String): Calls wrapped   */
      /* method"                                                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2WrapperTests_EventResponseWrapper_ApiEvent_setRenderParameterA", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2WrapperTests_EventResponseWrapper_ApiEvent_setRenderParameterB */
      /* Details: "Method setRenderParameter(String, String[]): Calls         */
      /* wrapped method"                                                      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2WrapperTests_EventResponseWrapper_ApiEvent_setRenderParameterB", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2WrapperTests_EventResponseWrapper_ApiEvent_setRenderParametersA */
      /* Details: "Method setRenderParameters(EventRequest): Calls wrapped    */
      /* method"                                                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2WrapperTests_EventResponseWrapper_ApiEvent_setRenderParametersA", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2WrapperTests_EventResponseWrapper_ApiEvent_setRenderParametersB */
      /* Details: "Method setRenderParameters(EventRequest): Calls wrapped    */
      /* method"                                                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2WrapperTests_EventResponseWrapper_ApiEvent_setRenderParametersB", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2WrapperTests_EventResponseWrapper_ApiEvent_setWindowState */
      /* Details: "Method setWindowState(WindowState): Calls wrapped          */
      /* method"                                                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2WrapperTests_EventResponseWrapper_ApiEvent_setWindowState", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2WrapperTests_EventResponseWrapper_ApiEvent_getResponse   */
      /* Details: "Method getResponse(): Returns wrapped EventResponse        */
      /* object"                                                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2WrapperTests_EventResponseWrapper_ApiEvent_getResponse", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2WrapperTests_EventResponseWrapper_ApiEvent_setResponse   */
      /* Details: "Method setResponse(EventResponse): Allows wrapped          */
      /* EventResponse object to be set"                                      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2WrapperTests_EventResponseWrapper_ApiEvent_setResponse", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2WrapperTests_EventResponseWrapper_ApiEvent_getPortletMode */
      /* Details: "Method getPortletMode(): Calls wrapped method"             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2WrapperTests_EventResponseWrapper_ApiEvent_getPortletMode", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2WrapperTests_EventResponseWrapper_ApiEvent_getRenderParameterMap1 */
      /* Details: "Method getRenderParameterMap(): Calls wrapped method"      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2WrapperTests_EventResponseWrapper_ApiEvent_getRenderParameterMap1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2WrapperTests_EventResponseWrapper_ApiEvent_getWindowState */
      /* Details: "Method getWindowState(): Calls wrapped method"             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2WrapperTests_EventResponseWrapper_ApiEvent_getWindowState", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2WrapperTests_EventResponseWrapper_ApiEvent_removePublicRenderParameter */
      /* Details: "Method removePublicRenderParameter(String): Calls          */
      /* wrapped method"                                                      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2WrapperTests_EventResponseWrapper_ApiEvent_removePublicRenderParameter", aurl);
         tb.writeTo(writer);
      }

   }

}
