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
 * portlet SigTestsURL_BaseURL_SIGRenderResurl_event
 *
 */
public class SigTestsURL_BaseURL_SIGRenderResurl implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         SigTestsURL_BaseURL_SIGRenderResurl.class.getName();
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

      ResourceURL url = portletResp.createResourceURL();
      ClassChecker cc = new ClassChecker(url.getClass());

      /* TestCase: V2SigTestsURL_BaseURL_SIGRenderResurl_hasAddProperty       */
      /* Details: "Resource URL has a addProperty(String, String)  method "   */
      TestResult tr0 = tcd.getTestResultFailed(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASADDPROPERTY);
      try {
         String name = "addProperty";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class, String.class};
         tr0.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: V2SigTestsURL_BaseURL_SIGRenderResurl_hasAddPropertyReturns */
      /* Details: "Resource URL method addProperty(String, String) returns    */
      /* void "                                                               */
      TestResult tr1 = tcd.getTestResultFailed(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASADDPROPERTYRETURNS);
      try {
         String name = "addProperty";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class, String.class};
         tr1.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

      /* TestCase: V2SigTestsURL_BaseURL_SIGRenderResurl_hasGetParameterMap   */
      /* Details: "Resource URL has a getParameterMap()  method "             */
      TestResult tr2 = tcd.getTestResultFailed(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASGETPARAMETERMAP);
      try {
         String name = "getParameterMap";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr2.appendTcDetail(e.toString());}
      tr2.writeTo(writer);

      /* TestCase: V2SigTestsURL_BaseURL_SIGRenderResurl_hasGetParameterMapReturns */
      /* Details: "Resource URL method getParameterMap() returns              */
      /* java.util.Map "                                                      */
      TestResult tr3 = tcd.getTestResultFailed(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASGETPARAMETERMAPRETURNS);
      try {
         String name = "getParameterMap";
         Class<?> retType = java.util.Map.class;
         Class<?>[] parms = null;
         tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr3.appendTcDetail(e.toString());}
      tr3.writeTo(writer);

      /* TestCase: V2SigTestsURL_BaseURL_SIGRenderResurl_hasSetParameter      */
      /* Details: "Resource URL has a setParameter(String, String)  method    */
      /* "                                                                    */
      TestResult tr4 = tcd.getTestResultFailed(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASSETPARAMETER);
      try {
         String name = "setParameter";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class, String.class};
         tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      /* TestCase: V2SigTestsURL_BaseURL_SIGRenderResurl_hasSetParameterA     */
      /* Details: "Resource URL has a setParameter(String, String[])          */
      /* method "                                                             */
      TestResult tr5 = tcd.getTestResultFailed(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASSETPARAMETERA);
      try {
         String name = "setParameter";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class, String[].class};
         tr5.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr5.appendTcDetail(e.toString());}
      tr5.writeTo(writer);

      /* TestCase: V2SigTestsURL_BaseURL_SIGRenderResurl_hasSetParameterReturns */
      /* Details: "Resource URL method setParameter(String, String) returns   */
      /* void "                                                               */
      TestResult tr6 = tcd.getTestResultFailed(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASSETPARAMETERRETURNS);
      try {
         String name = "setParameter";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class, String.class};
         tr6.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr6.appendTcDetail(e.toString());}
      tr6.writeTo(writer);

      /* TestCase: V2SigTestsURL_BaseURL_SIGRenderResurl_hasSetParameterReturnsA */
      /* Details: "Resource URL method setParameter(String, String[])         */
      /* returns void "                                                       */
      TestResult tr7 = tcd.getTestResultFailed(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASSETPARAMETERRETURNSA);
      try {
         String name = "setParameter";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class, String[].class};
         tr7.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr7.appendTcDetail(e.toString());}
      tr7.writeTo(writer);

      /* TestCase: V2SigTestsURL_BaseURL_SIGRenderResurl_hasSetParameters     */
      /* Details: "Resource URL has a setParameters(java.util.Map)  method    */
      /* "                                                                    */
      TestResult tr8 = tcd.getTestResultFailed(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASSETPARAMETERS);
      try {
         String name = "setParameters";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {java.util.Map.class};
         tr8.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr8.appendTcDetail(e.toString());}
      tr8.writeTo(writer);

      /* TestCase: V2SigTestsURL_BaseURL_SIGRenderResurl_hasSetParametersReturns */
      /* Details: "Resource URL method setParameters(java.util.Map) returns   */
      /* void "                                                               */
      TestResult tr9 = tcd.getTestResultFailed(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASSETPARAMETERSRETURNS);
      try {
         String name = "setParameters";
         Class<?> retType = void.class;
         Class<?>[] parms = {java.util.Map.class};
         tr9.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr9.appendTcDetail(e.toString());}
      tr9.writeTo(writer);

      /* TestCase: V2SigTestsURL_BaseURL_SIGRenderResurl_hasSetProperty       */
      /* Details: "Resource URL has a setProperty(String, String)  method "   */
      TestResult tr10 = tcd.getTestResultFailed(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASSETPROPERTY);
      try {
         String name = "setProperty";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class, String.class};
         tr10.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr10.appendTcDetail(e.toString());}
      tr10.writeTo(writer);

      /* TestCase: V2SigTestsURL_BaseURL_SIGRenderResurl_hasSetPropertyReturns */
      /* Details: "Resource URL method setProperty(String, String) returns    */
      /* void "                                                               */
      TestResult tr11 = tcd.getTestResultFailed(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASSETPROPERTYRETURNS);
      try {
         String name = "setProperty";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class, String.class};
         tr11.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr11.appendTcDetail(e.toString());}
      tr11.writeTo(writer);

      /* TestCase: V2SigTestsURL_BaseURL_SIGRenderResurl_hasSetSecure         */
      /* Details: "Resource URL has a setSecure(boolean) throws               */
      /* PortletSecurityException method "                                    */
      TestResult tr12 = tcd.getTestResultFailed(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASSETSECURE);
      try {
         String name = "setSecure";
         Class<?>[] exceptions = {PortletSecurityException.class};
         Class<?>[] parms = {boolean.class};
         tr12.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr12.appendTcDetail(e.toString());}
      tr12.writeTo(writer);

      /* TestCase: V2SigTestsURL_BaseURL_SIGRenderResurl_hasSetSecureReturns  */
      /* Details: "Resource URL method setSecure(boolean) returns void "      */
      TestResult tr13 = tcd.getTestResultFailed(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASSETSECURERETURNS);
      try {
         String name = "setSecure";
         Class<?> retType = void.class;
         Class<?>[] parms = {boolean.class};
         tr13.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr13.appendTcDetail(e.toString());}
      tr13.writeTo(writer);

      /* TestCase: V2SigTestsURL_BaseURL_SIGRenderResurl_hasToString          */
      /* Details: "Resource URL has a toString()  method "                    */
      TestResult tr14 = tcd.getTestResultFailed(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASTOSTRING);
      try {
         String name = "toString";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr14.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr14.appendTcDetail(e.toString());}
      tr14.writeTo(writer);

      /* TestCase: V2SigTestsURL_BaseURL_SIGRenderResurl_hasToStringReturns   */
      /* Details: "Resource URL method toString() returns String "            */
      TestResult tr15 = tcd.getTestResultFailed(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASTOSTRINGRETURNS);
      try {
         String name = "toString";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr15.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr15.appendTcDetail(e.toString());}
      tr15.writeTo(writer);

      /* TestCase: V2SigTestsURL_BaseURL_SIGRenderResurl_hasWrite             */
      /* Details: "Resource URL has a write(java.io.Writer) throws            */
      /* java.io.IOException method "                                         */
      TestResult tr16 = tcd.getTestResultFailed(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASWRITE);
      try {
         String name = "write";
         Class<?>[] exceptions = {java.io.IOException.class};
         Class<?>[] parms = {java.io.Writer.class};
         tr16.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr16.appendTcDetail(e.toString());}
      tr16.writeTo(writer);

      /* TestCase: V2SigTestsURL_BaseURL_SIGRenderResurl_hasWriteA            */
      /* Details: "Resource URL has a write(java.io.Writer, boolean) throws   */
      /* java.io.IOException method "                                         */
      TestResult tr17 = tcd.getTestResultFailed(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASWRITEA);
      try {
         String name = "write";
         Class<?>[] exceptions = {java.io.IOException.class};
         Class<?>[] parms = {java.io.Writer.class, boolean.class};
         tr17.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr17.appendTcDetail(e.toString());}
      tr17.writeTo(writer);

      /* TestCase: V2SigTestsURL_BaseURL_SIGRenderResurl_hasWriteReturns      */
      /* Details: "Resource URL method write(java.io.Writer) returns void "   */
      TestResult tr18 = tcd.getTestResultFailed(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASWRITERETURNS);
      try {
         String name = "write";
         Class<?> retType = void.class;
         Class<?>[] parms = {java.io.Writer.class};
         tr18.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr18.appendTcDetail(e.toString());}
      tr18.writeTo(writer);

      /* TestCase: V2SigTestsURL_BaseURL_SIGRenderResurl_hasWriteReturnsA     */
      /* Details: "Resource URL method write(java.io.Writer, boolean)         */
      /* returns void "                                                       */
      TestResult tr19 = tcd.getTestResultFailed(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASWRITERETURNSA);
      try {
         String name = "write";
         Class<?> retType = void.class;
         Class<?>[] parms = {java.io.Writer.class, boolean.class};
         tr19.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr19.appendTcDetail(e.toString());}
      tr19.writeTo(writer);

   }

}
