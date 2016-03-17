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
 * portlet SigTestsURL_PortletURL_SIGRenderRenurl_event
 *
 */
public class SigTestsURL_PortletURL_SIGRenderRenurl implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         SigTestsURL_PortletURL_SIGRenderRenurl.class.getName();
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

      PortletURL url = portletResp.createRenderURL();
      ClassChecker cc = new ClassChecker(url.getClass());

      /* TestCase: V2SigTestsURL_PortletURL_SIGRenderRenurl_hasGetPortletMode */
      /* Details: "Render URL has a getPortletMode()  method "                */
      TestResult tr0 = tcd.getTestResultFailed(V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_HASGETPORTLETMODE);
      try {
         String name = "getPortletMode";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr0.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: V2SigTestsURL_PortletURL_SIGRenderRenurl_hasGetPortletModeReturns */
      /* Details: "Render URL method getPortletMode() returns PortletMode "   */
      TestResult tr1 = tcd.getTestResultFailed(V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_HASGETPORTLETMODERETURNS);
      try {
         String name = "getPortletMode";
         Class<?> retType = PortletMode.class;
         Class<?>[] parms = null;
         tr1.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

      /* TestCase: V2SigTestsURL_PortletURL_SIGRenderRenurl_hasGetWindowState */
      /* Details: "Render URL has a getWindowState()  method "                */
      TestResult tr2 = tcd.getTestResultFailed(V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_HASGETWINDOWSTATE);
      try {
         String name = "getWindowState";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr2.appendTcDetail(e.toString());}
      tr2.writeTo(writer);

      /* TestCase: V2SigTestsURL_PortletURL_SIGRenderRenurl_hasGetWindowStateReturns */
      /* Details: "Render URL method getWindowState() returns WindowState "   */
      TestResult tr3 = tcd.getTestResultFailed(V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_HASGETWINDOWSTATERETURNS);
      try {
         String name = "getWindowState";
         Class<?> retType = WindowState.class;
         Class<?>[] parms = null;
         tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr3.appendTcDetail(e.toString());}
      tr3.writeTo(writer);

      /* TestCase: V2SigTestsURL_PortletURL_SIGRenderRenurl_hasRemovePublicRenderParameter */
      /* Details: "Render URL has a removePublicRenderParameter(String)       */
      /* method "                                                             */
      TestResult tr4 = tcd.getTestResultFailed(V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_HASREMOVEPUBLICRENDERPARAMETER);
      try {
         String name = "removePublicRenderParameter";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      /* TestCase: V2SigTestsURL_PortletURL_SIGRenderRenurl_hasRemovePublicRenderParameterReturns */
      /* Details: "Render URL method removePublicRenderParameter(String)      */
      /* returns void "                                                       */
      TestResult tr5 = tcd.getTestResultFailed(V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_HASREMOVEPUBLICRENDERPARAMETERRETURNS);
      try {
         String name = "removePublicRenderParameter";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class};
         tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr5.appendTcDetail(e.toString());}
      tr5.writeTo(writer);

      /* TestCase: V2SigTestsURL_PortletURL_SIGRenderRenurl_hasSetPortletMode */
      /* Details: "Render URL has a setPortletMode(PortletMode) throws        */
      /* PortletModeException method "                                        */
      TestResult tr6 = tcd.getTestResultFailed(V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_HASSETPORTLETMODE);
      try {
         String name = "setPortletMode";
         Class<?>[] exceptions = {PortletModeException.class};
         Class<?>[] parms = {PortletMode.class};
         tr6.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr6.appendTcDetail(e.toString());}
      tr6.writeTo(writer);

      /* TestCase: V2SigTestsURL_PortletURL_SIGRenderRenurl_hasSetPortletModeReturns */
      /* Details: "Render URL method setPortletMode(PortletMode) returns      */
      /* void "                                                               */
      TestResult tr7 = tcd.getTestResultFailed(V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_HASSETPORTLETMODERETURNS);
      try {
         String name = "setPortletMode";
         Class<?> retType = void.class;
         Class<?>[] parms = {PortletMode.class};
         tr7.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr7.appendTcDetail(e.toString());}
      tr7.writeTo(writer);

      /* TestCase: V2SigTestsURL_PortletURL_SIGRenderRenurl_hasSetWindowState */
      /* Details: "Render URL has a setWindowState(WindowState) throws        */
      /* WindowStateException method "                                        */
      TestResult tr8 = tcd.getTestResultFailed(V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_HASSETWINDOWSTATE);
      try {
         String name = "setWindowState";
         Class<?>[] exceptions = {WindowStateException.class};
         Class<?>[] parms = {WindowState.class};
         tr8.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr8.appendTcDetail(e.toString());}
      tr8.writeTo(writer);

      /* TestCase: V2SigTestsURL_PortletURL_SIGRenderRenurl_hasSetWindowStateReturns */
      /* Details: "Render URL method setWindowState(WindowState) returns      */
      /* void "                                                               */
      TestResult tr9 = tcd.getTestResultFailed(V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_HASSETWINDOWSTATERETURNS);
      try {
         String name = "setWindowState";
         Class<?> retType = void.class;
         Class<?>[] parms = {WindowState.class};
         tr9.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr9.appendTcDetail(e.toString());}
      tr9.writeTo(writer);

      /* TestCase: V2SigTestsURL_PortletURL_SIGRenderRenurl_implementsBaseURL */
      /* Details: "Render URL implements BaseURL "                            */
      TestResult tr10 = tcd.getTestResultFailed(V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_IMPLEMENTSBASEURL);
      try {
         tr10.setTcSuccess(cc.implementsInterface(BaseURL.class));
      } catch(Exception e) {tr10.appendTcDetail(e.toString());}
      tr10.writeTo(writer);

   }

}
