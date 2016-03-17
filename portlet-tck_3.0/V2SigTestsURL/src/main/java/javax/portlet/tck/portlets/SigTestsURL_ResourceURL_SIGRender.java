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
 * portlet SigTestsURL_ResourceURL_SIGRender_event
 *
 */
public class SigTestsURL_ResourceURL_SIGRender implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         SigTestsURL_ResourceURL_SIGRender.class.getName();
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

      ResourceURL url = portletResp.createResourceURL();      ClassChecker cc = new ClassChecker(url.getClass());

      /* TestCase: V2SigTestsURL_ResourceURL_SIGRender_fieldFULL              */
      /* Details: "ResourceURL has String field FULL "                        */
      TestResult tr0 = tcd.getTestResultFailed(V2SIGTESTSURL_RESOURCEURL_SIGRENDER_FIELDFULL);
      try {
         tr0.setTcSuccess(cc.hasField("FULL"));
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: V2SigTestsURL_ResourceURL_SIGRender_fieldPAGE              */
      /* Details: "ResourceURL has String field PAGE "                        */
      TestResult tr1 = tcd.getTestResultFailed(V2SIGTESTSURL_RESOURCEURL_SIGRENDER_FIELDPAGE);
      try {
         tr1.setTcSuccess(cc.hasField("PAGE"));
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

      /* TestCase: V2SigTestsURL_ResourceURL_SIGRender_fieldPORTLET           */
      /* Details: "ResourceURL has String field PORTLET "                     */
      TestResult tr2 = tcd.getTestResultFailed(V2SIGTESTSURL_RESOURCEURL_SIGRENDER_FIELDPORTLET);
      try {
         tr2.setTcSuccess(cc.hasField("PORTLET"));
      } catch(Exception e) {tr2.appendTcDetail(e.toString());}
      tr2.writeTo(writer);

      /* TestCase: V2SigTestsURL_ResourceURL_SIGRender_fieldSHARED            */
      /* Details: "ResourceURL has String field SHARED "                      */
      TestResult tr3 = tcd.getTestResultFailed(V2SIGTESTSURL_RESOURCEURL_SIGRENDER_FIELDSHARED);
      try {
         tr3.setTcSuccess(cc.hasField("SHARED"));
      } catch(Exception e) {tr3.appendTcDetail(e.toString());}
      tr3.writeTo(writer);

      /* TestCase: V2SigTestsURL_ResourceURL_SIGRender_hasGetCacheability     */
      /* Details: "ResourceURL has a getCacheability()  method "              */
      TestResult tr4 = tcd.getTestResultFailed(V2SIGTESTSURL_RESOURCEURL_SIGRENDER_HASGETCACHEABILITY);
      try {
         String name = "getCacheability";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      /* TestCase: V2SigTestsURL_ResourceURL_SIGRender_hasGetCacheabilityReturns */
      /* Details: "ResourceURL method getCacheability() returns String "      */
      TestResult tr5 = tcd.getTestResultFailed(V2SIGTESTSURL_RESOURCEURL_SIGRENDER_HASGETCACHEABILITYRETURNS);
      try {
         String name = "getCacheability";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr5.appendTcDetail(e.toString());}
      tr5.writeTo(writer);

      /* TestCase: V2SigTestsURL_ResourceURL_SIGRender_hasSetCacheability     */
      /* Details: "ResourceURL has a setCacheability(String)  method "        */
      TestResult tr6 = tcd.getTestResultFailed(V2SIGTESTSURL_RESOURCEURL_SIGRENDER_HASSETCACHEABILITY);
      try {
         String name = "setCacheability";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr6.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr6.appendTcDetail(e.toString());}
      tr6.writeTo(writer);

      /* TestCase: V2SigTestsURL_ResourceURL_SIGRender_hasSetCacheabilityReturns */
      /* Details: "ResourceURL method setCacheability(String) returns void    */
      /* "                                                                    */
      TestResult tr7 = tcd.getTestResultFailed(V2SIGTESTSURL_RESOURCEURL_SIGRENDER_HASSETCACHEABILITYRETURNS);
      try {
         String name = "setCacheability";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class};
         tr7.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr7.appendTcDetail(e.toString());}
      tr7.writeTo(writer);

      /* TestCase: V2SigTestsURL_ResourceURL_SIGRender_hasSetResourceID       */
      /* Details: "ResourceURL has a setResourceID(String)  method "          */
      TestResult tr8 = tcd.getTestResultFailed(V2SIGTESTSURL_RESOURCEURL_SIGRENDER_HASSETRESOURCEID);
      try {
         String name = "setResourceID";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr8.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr8.appendTcDetail(e.toString());}
      tr8.writeTo(writer);

      /* TestCase: V2SigTestsURL_ResourceURL_SIGRender_hasSetResourceIDReturns */
      /* Details: "ResourceURL method setResourceID(String) returns void "    */
      TestResult tr9 = tcd.getTestResultFailed(V2SIGTESTSURL_RESOURCEURL_SIGRENDER_HASSETRESOURCEIDRETURNS);
      try {
         String name = "setResourceID";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class};
         tr9.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr9.appendTcDetail(e.toString());}
      tr9.writeTo(writer);

      /* TestCase: V2SigTestsURL_ResourceURL_SIGRender_implementsBaseURL      */
      /* Details: "ResourceURL implements BaseURL "                           */
      TestResult tr10 = tcd.getTestResultFailed(V2SIGTESTSURL_RESOURCEURL_SIGRENDER_IMPLEMENTSBASEURL);
      try {
         tr10.setTcSuccess(cc.implementsInterface(BaseURL.class));
      } catch(Exception e) {tr10.appendTcDetail(e.toString());}
      tr10.writeTo(writer);

   }

}
