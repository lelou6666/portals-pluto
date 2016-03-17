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
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.*;
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
 * portlet AddlEnvironmentTests_SPEC2_17_ActionPreferences_event
 *
 */
public class AddlEnvironmentTests_SPEC2_17_ActionPreferences implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         AddlEnvironmentTests_SPEC2_17_ActionPreferences.class.getName();
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

      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_setValues4 */
      /* Details: "The setValues method allows the value array to be set to   */
      /* null"                                                                */
      TestResult tr0 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_ACTIONPREFERENCES_SETVALUES4);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_reset1   */
      /* Details: "The reset method sets the value of the specified           */
      /* preference to its default value. The actual default value itself     */
      /* is implementation-specific and cannot be tested."                    */
      TestResult tr1 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_ACTIONPREFERENCES_RESET1);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_store1   */
      /* Details: "The store method persists preference changes previously    */
      /* made during the processAction method"                                */
      TestResult tr2 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_ACTIONPREFERENCES_STORE1);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_store4   */
      /* Details: "If preference changes are made during the processAction    */
      /* method, but the method completes without store being called, the     */
      /* preference changes are discarded"                                    */
      TestResult tr3 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_ACTIONPREFERENCES_STORE4);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_deployment3 */
      /* Details: "A preference attribute definition may indicate if the      */
      /* attribute is read only"                                              */
      TestResult tr4 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_ACTIONPREFERENCES_DEPLOYMENT3);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_deployment4 */
      /* Details: "If a preference attribute definition does not contain      */
      /* the read-only setting, it will be modifiable in the processAction    */
      /* method"                                                              */
      TestResult tr5 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_ACTIONPREFERENCES_DEPLOYMENT4);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_deployment7 */
      /* Details: "If a preference attribute definition contains the          */
      /* read-only setting, it will not be modifiable in the processAction    */
      /* method"                                                              */
      TestResult tr6 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_ACTIONPREFERENCES_DEPLOYMENT7);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_deployment10 */
      /* Details: "A preference attribute not defined in the deployment       */
      /* descriptor may be added programmatically in the processAction        */
      /* method"                                                              */
      TestResult tr7 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_ACTIONPREFERENCES_DEPLOYMENT10);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      portletReq.getPortletSession().setAttribute(
                   Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_17_ActionPreferences",
                   writer.toString(), APPLICATION_SCOPE);
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

      PortletSession ps = portletReq.getPortletSession();
      String msg = (String) ps.getAttribute(RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_17_ActionPreferences", APPLICATION_SCOPE);
      if (msg != null) {
         writer.write("<p>" + msg + "</p><br/>\n");
         ps.removeAttribute(RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_17_ActionPreferences", APPLICATION_SCOPE);
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_setValues4 */
      /* Details: "The setValues method allows the value array to be set to   */
      /* null"                                                                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_setValues4", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_reset1   */
      /* Details: "The reset method sets the value of the specified           */
      /* preference to its default value. The actual default value itself     */
      /* is implementation-specific and cannot be tested."                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_reset1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_store1   */
      /* Details: "The store method persists preference changes previously    */
      /* made during the processAction method"                                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_store1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_store4   */
      /* Details: "If preference changes are made during the processAction    */
      /* method, but the method completes without store being called, the     */
      /* preference changes are discarded"                                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_store4", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_deployment3 */
      /* Details: "A preference attribute definition may indicate if the      */
      /* attribute is read only"                                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_deployment3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_deployment4 */
      /* Details: "If a preference attribute definition does not contain      */
      /* the read-only setting, it will be modifiable in the processAction    */
      /* method"                                                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_deployment4", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_deployment7 */
      /* Details: "If a preference attribute definition contains the          */
      /* read-only setting, it will not be modifiable in the processAction    */
      /* method"                                                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_deployment7", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_deployment10 */
      /* Details: "A preference attribute not defined in the deployment       */
      /* descriptor may be added programmatically in the processAction        */
      /* method"                                                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_deployment10", aurl);
         tb.writeTo(writer);
      }

   }

}
