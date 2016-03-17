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
 * portlet ResponseTests_PortletResponse_ApiResource_event
 *
 */
public class ResponseTests_PortletResponse_ApiResource implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         ResponseTests_PortletResponse_ApiResource.class.getName();
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

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_addPropertyA1  */
      /* Details: "Method addProperty(javax.servlet.http.Cookie): Adds the    */
      /* specified cookie property to the response"                           */
      TestResult tr0 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYA1);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_addPropertyA2  */
      /* Details: "Method addProperty(javax.servlet.http.Cookie): Throws      */
      /* IllegalArgumentException if the specified cookie is null"            */
      TestResult tr1 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYA2);
      try {
         try {
            portletResp.addProperty(null);
            tr1.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr1.setTcSuccess(true);
         } catch (Exception e) {
            tr1.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_addPropertyB1  */
      /* Details: "Method addProperty(String, org.w3c.dom.Element): Adds an   */
      /* XML DOM Element to the response for the specified key"               */
      TestResult tr2 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYB1);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_addPropertyB2  */
      /* Details: "Method addProperty(String, org.w3c.dom.Element): If a      */
      /* DOM Element for the specified key already exists, the new element    */
      /* is added in addition to the existing element"                        */
      TestResult tr3 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYB2);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_addPropertyB3  */
      /* Details: "Method addProperty(String, org.w3c.dom.Element): If the    */
      /* specified DOM Element value is null, the key is removed from the     */
      /* response"                                                            */
      TestResult tr4 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYB3);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_addPropertyB4  */
      /* Details: "Method addProperty(String, org.w3c.dom.Element): Throws    */
      /* IllegalArgumentException if the specified key is null"               */
      TestResult tr5 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYB4);
      try {
         try {
            org.w3c.dom.Element el = portletResp.createElement("p");
            portletResp.addProperty((String)null, el);
            tr5.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr5.setTcSuccess(true);
         } catch (Exception e) {
            tr5.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr5.appendTcDetail(e.toString());}
      tr5.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_addPropertyC1  */
      /* Details: "Method addProperty(String, String): A property can be      */
      /* added"                                                               */
      TestResult tr6 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYC1);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_addPropertyC2  */
      /* Details: "Method addProperty(String, String): Throws                 */
      /* IllegalArgumentException if the specified key is null"               */
      TestResult tr7 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYC2);
      try {
         try {
            portletResp.addProperty(null, "value");
            tr7.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr7.setTcSuccess(true);
         } catch (Exception e) {
            tr7.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr7.appendTcDetail(e.toString());}
      tr7.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_setProperty1   */
      /* Details: "Method setProperty(String, String): Sets a property        */
      /* value for the specified key"                                         */
      TestResult tr8 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_SETPROPERTY1);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_setProperty2   */
      /* Details: "Method setProperty(String, String): Resets any existing    */
      /* property values for the specified key"                               */
      TestResult tr9 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_SETPROPERTY2);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_setProperty3   */
      /* Details: "Method setProperty(String, String): Throws                 */
      /* IllegalArgumentException if the specified key is null"               */
      TestResult tr10 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_SETPROPERTY3);
      try {
         try {
            portletResp.setProperty(null, "value");
            tr10.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr10.setTcSuccess(true);
         } catch (Exception e) {
            tr10.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr10.appendTcDetail(e.toString());}
      tr10.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_encodeURL1     */
      /* Details: "Method encodeURL(String): Returns a String representing    */
      /* the encoded URL"                                                     */
      TestResult tr11 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ENCODEURL1);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_encodeURL2     */
      /* Details: "Method encodeURL(String): Throws                           */
      /* IllegalArgumentException if the input string is not an absolute      */
      /* URL and does not start with at \"/\" character"                      */
      TestResult tr12 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ENCODEURL2);
      /* TODO: implement test */
      tr12.appendTcDetail("Not implemented.");
      tr12.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_getNamespace1  */
      /* Details: "Method getNamespace(): Returns a String containing the     */
      /* namespace value"                                                     */
      TestResult tr13 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_GETNAMESPACE1);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_createElement1 */
      /* Details: "Method createElement(String): Returns an                   */
      /* org.w3c.dom.Element object for the specified tag name"               */
      TestResult tr14 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_CREATEELEMENT1);
      /* TODO: implement test */
      tr14.appendTcDetail("Not implemented.");
      tr14.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_createElement2 */
      /* Details: "Method createElement(String): The returned Element has     */
      /* nodeName set to the the specified tag name "                         */
      TestResult tr15 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_CREATEELEMENT2);
      /* TODO: implement test */
      tr15.appendTcDetail("Not implemented.");
      tr15.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_createElement3 */
      /* Details: "Method createElement(String): The returned Element has     */
      /* localName set to null"                                               */
      TestResult tr16 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_CREATEELEMENT3);
      /* TODO: implement test */
      tr16.appendTcDetail("Not implemented.");
      tr16.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_createElement4 */
      /* Details: "Method createElement(String): The returned Element has     */
      /* prefix set to null"                                                  */
      TestResult tr17 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_CREATEELEMENT4);
      /* TODO: implement test */
      tr17.appendTcDetail("Not implemented.");
      tr17.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_createElement5 */
      /* Details: "Method createElement(String): The returned Element has     */
      /* namespaceURI set to null"                                            */
      TestResult tr18 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_CREATEELEMENT5);
      /* TODO: implement test */
      tr18.appendTcDetail("Not implemented.");
      tr18.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_createElement6 */
      /* Details: "Method createElement(String): Throws                       */
      /* org.w3c.dom.DOMException - INVALID_CHARACTER_ERR if the specified    */
      /* name contains an illegal character. "                                */
      TestResult tr19 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_CREATEELEMENT6);
      /* TODO: implement test */
      tr19.appendTcDetail("Not implemented.");
      tr19.writeTo(writer);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet render entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      writer.write("<div id=\"ResponseTests_PortletResponse_ApiResource\">no resource output.</div>\n");
      ResourceURL resurl = portletResp.createResourceURL();
      resurl.setCacheability(PAGE);
      writer.write("<script>\n");
      writer.write("(function () {\n");
      writer.write("   var xhr = new XMLHttpRequest();\n");
      writer.write("   xhr.onreadystatechange=function() {\n");
      writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
      writer.write("         document.getElementById(\"ResponseTests_PortletResponse_ApiResource\").innerHTML=xhr.responseText;\n");
      writer.write("      }\n");
      writer.write("   };\n");
      writer.write("   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
      writer.write("   xhr.send();\n");
      writer.write("})();\n");
      writer.write("</script>\n");
   }

}
