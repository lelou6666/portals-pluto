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
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.*;
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
 * portlet SigTestsEnv_PortletRequestDispatcher_SIGRender_event
 *
 */
public class SigTestsEnv_PortletRequestDispatcher_SIGRender implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         SigTestsEnv_PortletRequestDispatcher_SIGRender.class.getName();
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

      JSR286SignatureTestCaseDetails tcd = new JSR286SignatureTestCaseDetails();

      // Create result objects for the tests

      PortletRequestDispatcher rd = portletConfig.getPortletContext()
                              .getRequestDispatcher("/WEB-INF/portlet.xml");
      ClassChecker cc = new ClassChecker(rd.getClass());

      /* TestCase: V2SigTestsEnv_PortletRequestDispatcher_SIGRender_hasForward */
      /* Details: "PortletRequestDispatcher has a forward(PortletRequest,     */
      /* PortletResponse) throws PortletException, java.io.IOException        */
      /* method "                                                             */
      TestResult tr0 = tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETREQUESTDISPATCHER_SIGRENDER_HASFORWARD);
      try {
         String name = "forward";
         Class<?>[] exceptions = {PortletException.class, java.io.IOException.class};
         Class<?>[] parms = {PortletRequest.class, PortletResponse.class};
         tr0.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: V2SigTestsEnv_PortletRequestDispatcher_SIGRender_hasForwardReturns */
      /* Details: "PortletRequestDispatcher method forward(PortletRequest,    */
      /* PortletResponse) returns void "                                      */
      TestResult tr1 = tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETREQUESTDISPATCHER_SIGRENDER_HASFORWARDRETURNS);
      try {
         String name = "forward";
         Class<?> retType = void.class;
         Class<?>[] parms = {PortletRequest.class, PortletResponse.class};
         tr1.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

      /* TestCase: V2SigTestsEnv_PortletRequestDispatcher_SIGRender_hasInclude */
      /* Details: "PortletRequestDispatcher has a include(RenderRequest,      */
      /* RenderResponse) throws PortletException, java.io.IOException         */
      /* method "                                                             */
      TestResult tr2 = tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETREQUESTDISPATCHER_SIGRENDER_HASINCLUDE);
      try {
         String name = "include";
         Class<?>[] exceptions = {PortletException.class, java.io.IOException.class};
         Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
         tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr2.appendTcDetail(e.toString());}
      tr2.writeTo(writer);

      /* TestCase: V2SigTestsEnv_PortletRequestDispatcher_SIGRender_hasIncludeA */
      /* Details: "PortletRequestDispatcher has a include(PortletRequest,     */
      /* PortletResponse) throws PortletException, java.io.IOException        */
      /* method "                                                             */
      TestResult tr3 = tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETREQUESTDISPATCHER_SIGRENDER_HASINCLUDEA);
      try {
         String name = "include";
         Class<?>[] exceptions = {PortletException.class, java.io.IOException.class};
         Class<?>[] parms = {PortletRequest.class, PortletResponse.class};
         tr3.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr3.appendTcDetail(e.toString());}
      tr3.writeTo(writer);

      /* TestCase: V2SigTestsEnv_PortletRequestDispatcher_SIGRender_hasIncludeReturns */
      /* Details: "PortletRequestDispatcher method include(RenderRequest,     */
      /* RenderResponse) returns void "                                       */
      TestResult tr4 = tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETREQUESTDISPATCHER_SIGRENDER_HASINCLUDERETURNS);
      try {
         String name = "include";
         Class<?> retType = void.class;
         Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
         tr4.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      /* TestCase: V2SigTestsEnv_PortletRequestDispatcher_SIGRender_hasIncludeReturnsA */
      /* Details: "PortletRequestDispatcher method include(PortletRequest,    */
      /* PortletResponse) returns void "                                      */
      TestResult tr5 = tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETREQUESTDISPATCHER_SIGRENDER_HASINCLUDERETURNSA);
      try {
         String name = "include";
         Class<?> retType = void.class;
         Class<?>[] parms = {PortletRequest.class, PortletResponse.class};
         tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr5.appendTcDetail(e.toString());}
      tr5.writeTo(writer);

   }

}
