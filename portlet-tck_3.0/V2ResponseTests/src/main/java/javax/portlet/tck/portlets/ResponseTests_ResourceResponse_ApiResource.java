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
 * portlet ResponseTests_ResourceResponse_ApiResource_event
 *
 */
public class ResponseTests_ResourceResponse_ApiResource implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         ResponseTests_ResourceResponse_ApiResource.class.getName();
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

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      ClassChecker cc = new ClassChecker(portletResp.getClass());

      /* TestCase: V2ResponseTests_ResourceResponse_ApiResource_fieldHTTP_STATUS_CODE  */
      /* Details: "Has String field HTTP_STATUS_CODE with value of            */
      /* \"portlet.http-status-code\""                                        */
      TestResult tr0 = tcd.getTestResultFailed(V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_FIELDHTTP_STATUS_CODE );
      try {
         tr0.setTcSuccess(cc.hasField("HTTP_STATUS_CODE", "portlet.http-status-code"));
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: V2ResponseTests_ResourceResponse_ApiResource_setLocale1    */
      /* Details: "Method setLocale(Locale): Sets the locale of the           */
      /* response"                                                            */
      TestResult tr1 = tcd.getTestResultFailed(V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_SETLOCALE1);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2ResponseTests_ResourceResponse_ApiResource_setLocale4    */
      /* Details: "Method setLocale(Locale): Throws                           */
      /* IllegalArgumentException if the Locale parameter is null"            */
      TestResult tr2 = tcd.getTestResultFailed(V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_SETLOCALE4);
      try {
         try {
            portletResp.setLocale(null);
            tr2.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr2.setTcSuccess(true);
         } catch (Exception e) {
            tr2.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr2.appendTcDetail(e.toString());}
      tr2.writeTo(writer);

      /* TestCase: V2ResponseTests_ResourceResponse_ApiResource_setCharacterEncoding1 */
      /* Details: "Method setCharacterEncoding(String): Sets the character    */
      /* encoding of the response"                                            */
      TestResult tr3 = tcd.getTestResultFailed(V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_SETCHARACTERENCODING1);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2ResponseTests_ResourceResponse_ApiResource_setCharacterEncoding4 */
      /* Details: "Method setCharacterEncoding(String): Throws                */
      /* IllegalArgumentException if the Locale parameter is null"            */
      TestResult tr4 = tcd.getTestResultFailed(V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_SETCHARACTERENCODING4);
      try {
         try {
            portletResp.setCharacterEncoding(null);
            tr4.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr4.setTcSuccess(true);
         } catch (Exception e) {
            tr4.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      /* TestCase: V2ResponseTests_ResourceResponse_ApiResource_setContentLength1 */
      /* Details: "Method setContentLength(int): Sets the length of the       */
      /* content body"                                                        */
      TestResult tr5 = tcd.getTestResultFailed(V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_SETCONTENTLENGTH1);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2ResponseTests_ResourceResponse_ApiResource_createRenderURL2 */
      /* Details: "Method createRenderURL(): Throws IllegalStateException     */
      /* if the cacheability level for the resource URL triggering the        */
      /* serveResource call is not PAGE"                                      */
      TestResult tr6 = tcd.getTestResultFailed(V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_CREATERENDERURL2);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2ResponseTests_ResourceResponse_ApiResource_createActionURL2 */
      /* Details: "Method createActionURL(): Throws IllegalStateException     */
      /* if the cacheability level for the resource URL triggering the        */
      /* serveResource call is not PAGE"                                      */
      TestResult tr7 = tcd.getTestResultFailed(V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_CREATEACTIONURL2);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2ResponseTests_ResourceResponse_ApiResource_createResourceURL2 */
      /* Details: "Method createResourceURL(): Throws IllegalStateException   */
      /* if the cacheability level for the resource URL triggering the        */
      /* serveResource call is not PAGE"                                      */
      TestResult tr8 = tcd.getTestResultFailed(V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_CREATERESOURCEURL2);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet render entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      writer.write("<div id=\"ResponseTests_ResourceResponse_ApiResource\">no resource output.</div>\n");
      ResourceURL resurl = portletResp.createResourceURL();
      resurl.setCacheability(PAGE);
      writer.write("<script>\n");
      writer.write("(function () {\n");
      writer.write("   var xhr = new XMLHttpRequest();\n");
      writer.write("   xhr.onreadystatechange=function() {\n");
      writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
      writer.write("         document.getElementById(\"ResponseTests_ResourceResponse_ApiResource\").innerHTML=xhr.responseText;\n");
      writer.write("      }\n");
      writer.write("   };\n");
      writer.write("   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
      writer.write("   xhr.send();\n");
      writer.write("})();\n");
      writer.write("</script>\n");
   }

}
