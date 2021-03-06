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
 * portlet AddlResponseTests_SPEC2_12_Render_event
 *
 */
public class AddlResponseTests_SPEC2_12_Render implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         AddlResponseTests_SPEC2_12_Render.class.getName();
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

      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2AddlResponseTests_SPEC2_12_Render_cookie8                */
      /* Details: "Cookies set during the Render phase should be available    */
      /* to the portlet during the Resource phase"                            */
      TestResult tr0 = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE8);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2AddlResponseTests_SPEC2_12_Render_cookie9                */
      /* Details: "Cookies set during the Render phase should be available    */
      /* to the portlet during a subsequent Action phase"                     */
      TestResult tr1 = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE9);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2AddlResponseTests_SPEC2_12_Render_cookie10               */
      /* Details: "Cookies set during the Render phase should be available    */
      /* to the portlet during a subsequent Render phase"                     */
      TestResult tr2 = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE10);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2AddlResponseTests_SPEC2_12_Render_cookie11               */
      /* Details: "Cookies set during the Render phase should be available    */
      /* to the portlet during a subsequent request triggered by a URL"       */
      TestResult tr3 = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE11);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2AddlResponseTests_SPEC2_12_Render_cookie12               */
      /* Details: "Cookies set during the Render phase after the response     */
      /* has been committed are ignored"                                      */
      TestResult tr4 = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE12);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2AddlResponseTests_SPEC2_12_Render_contentType5           */
      /* Details: "If the setContentType method is not called before the      */
      /* getWriter or getPortletOutputStream method is used, the portlet      */
      /* container uses the content type returned by                          */
      /* getResponseContentType"                                              */
      TestResult tr5 = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_RENDER_CONTENTTYPE5);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2AddlResponseTests_SPEC2_12_Render_characterEncoding2     */
      /* Details: "The character encoding can be set via the setLocale        */
      /* method and a locale-encoding-mapping-list mapping in the web.xml     */
      /* deployment descriptor"                                               */
      TestResult tr6 = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_RENDER_CHARACTERENCODING2);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2AddlResponseTests_SPEC2_12_Render_characterEncoding3     */
      /* Details: "The character encoding can be set via the setContentType   */
      /* method if the given content type string provides a value for the     */
      /* charset attribute"                                                   */
      TestResult tr7 = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_RENDER_CHARACTERENCODING3);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2AddlResponseTests_SPEC2_12_Render_characterEncoding4     */
      /* Details: "If the portlet does not set the character encoding, the    */
      /* portlet container uses UTF-8 as the default character encoding"      */
      TestResult tr8 = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_RENDER_CHARACTERENCODING4);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

   }

}
