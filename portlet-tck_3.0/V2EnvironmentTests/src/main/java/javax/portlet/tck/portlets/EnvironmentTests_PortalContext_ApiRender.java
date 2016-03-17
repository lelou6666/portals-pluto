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
 * portlet EnvironmentTests_PortalContext_ApiRender_event
 *
 */
public class EnvironmentTests_PortalContext_ApiRender implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         EnvironmentTests_PortalContext_ApiRender.class.getName();
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

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      ClassChecker cc = new ClassChecker(portletReq.getPortalContext().getClass());

      /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_fieldMARKUP_HEAD_ELEMENT_SUPPORT */
      /* Details: "Has String field MARKUP_HEAD_ELEMENT_SUPPORT with value    */
      /* of \"javax.portlet.markup.head.element.support\" "                   */
      TestResult tr0 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_FIELDMARKUP_HEAD_ELEMENT_SUPPORT);
      try {
         tr0.setTcSuccess(cc.hasField("MARKUP_HEAD_ELEMENT_SUPPORT", "javax.portlet.markup.head.element.support"));
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getProperty1    */
      /* Details: "Method getProperty(String): Returns a String containing    */
      /* the value for the specified property "                               */
      TestResult tr1 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPROPERTY1);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getProperty2    */
      /* Details: "Method getProperty(String): Returns null if there is no    */
      /* property defined for the specified name"                             */
      TestResult tr2 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPROPERTY2);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getProperty3    */
      /* Details: "Method getProperty(String): Throws                         */
      /* IllegalArgumentException if the specified name is null "             */
      TestResult tr3 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPROPERTY3);
      try {
         try {
            PortalContext cntxt = portletReq.getPortalContext();
            String val = cntxt.getProperty(null);
            tr3.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr3.setTcSuccess(true);
         } catch (Exception e) {
            tr3.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr3.appendTcDetail(e.toString());}
      tr3.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getPropertyNames1 */
      /* Details: "Method getPropertyNames(): Returns an                      */
      /* java.util.Enumeration&lt;java.lang.String&gt; containing all         */
      /* portal property names"                                               */
      TestResult tr4 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPROPERTYNAMES1);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getPropertyNames2 */
      /* Details: "Method getPropertyNames(): Returns an empty Enumeration    */
      /* if there are no portal property names defined"                       */
      TestResult tr5 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPROPERTYNAMES2);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getSupportedPortletModes1 */
      /* Details: "Method getSupportedPortletModes(): Returns an              */
      /* java.util.Enumeration&lt;PortletMode&gt; containing all supported    */
      /* portlet modes"                                                       */
      TestResult tr6 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDPORTLETMODES1);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getSupportedPortletModes2 */
      /* Details: "Method getSupportedPortletModes(): The Enumeration         */
      /* returned must contain the view mode"                                 */
      TestResult tr7 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDPORTLETMODES2);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getSupportedPortletModes3 */
      /* Details: "Method getSupportedPortletModes(): The Enumeration         */
      /* returned must contain the edit mode"                                 */
      TestResult tr8 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDPORTLETMODES3);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getSupportedPortletModes4 */
      /* Details: "Method getSupportedPortletModes(): The Enumeration         */
      /* returned must contain the help mode"                                 */
      TestResult tr9 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDPORTLETMODES4);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getSupportedWindowStates1 */
      /* Details: "Method getSupportedWindowStates(): Returns an              */
      /* java.util.Enumeration&lt;WindowState&gt; containing all supported    */
      /* window states"                                                       */
      TestResult tr10 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDWINDOWSTATES1);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getSupportedWindowStates2 */
      /* Details: "Method getSupportedWindowStates(): The Enumeration         */
      /* returned must contain the maximized state"                           */
      TestResult tr11 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDWINDOWSTATES2);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getSupportedWindowStates3 */
      /* Details: "Method getSupportedWindowStates(): The Enumeration         */
      /* returned must contain the minimized state"                           */
      TestResult tr12 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDWINDOWSTATES3);
      /* TODO: implement test */
      tr12.appendTcDetail("Not implemented.");
      tr12.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getSupportedWindowStates4 */
      /* Details: "Method getSupportedWindowStates(): The Enumeration         */
      /* returned must contain the normal state"                              */
      TestResult tr13 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDWINDOWSTATES4);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getPortalInfo1  */
      /* Details: "Method getPortalInfo(): Returns a String containing        */
      /* information about the portal"                                        */
      TestResult tr14 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPORTALINFO1);
      /* TODO: implement test */
      tr14.appendTcDetail("Not implemented.");
      tr14.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getPortalInfo2  */
      /* Details: "Method getPortalInfo(): The returned string is of the      */
      /* form \"([^ ]+)/([^ ]+) *(.*)\", where $1 is the portal name, $2 is   */
      /* the version, and $3 is optional additional information"              */
      TestResult tr15 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPORTALINFO2);
      /* TODO: implement test */
      tr15.appendTcDetail("Not implemented.");
      tr15.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getPortalInfo3  */
      /* Details: "Method getPortalInfo(): The returned string contains the   */
      /* portal name"                                                         */
      TestResult tr16 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPORTALINFO3);
      /* TODO: implement test */
      tr16.appendTcDetail("Not implemented.");
      tr16.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getPortalInfo4  */
      /* Details: "Method getPortalInfo(): The returned string contains the   */
      /* portal version"                                                      */
      TestResult tr17 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPORTALINFO4);
      /* TODO: implement test */
      tr17.appendTcDetail("Not implemented.");
      tr17.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getPortalInfo5  */
      /* Details: "Method getPortalInfo(): The returned string may not be     */
      /* null"                                                                */
      TestResult tr18 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPORTALINFO5);
      /* TODO: implement test */
      tr18.appendTcDetail("Not implemented.");
      tr18.writeTo(writer);

   }

}
