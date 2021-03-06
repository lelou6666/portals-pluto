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
import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.*;
import static javax.portlet.PortletSession.*;

/**
 * This is the event processing portlet for the test cases. This portlet processes events, 
 * but does not publish them. Events are published in the main portlet for the test cases. 
 */
public class ResponseTests_PortletResponse_ApiEvent_event implements Portlet, EventPortlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         ResponseTests_PortletResponse_ApiEvent_event.class.getName();
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
      LOGGER.entering(LOG_CLASS, "event companion processAction - ERROR!!");
   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "event companion serveResource - ERROR!!");
   }

   @Override
   public void processEvent(EventRequest portletReq, EventResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "event companion processEvent");


      portletResp.setRenderParameters(portletReq);

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      StringWriter writer = new StringWriter();

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      ClassChecker cc = new ClassChecker(portletResp.getClass());

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_addPropertyA1     */
      /* Details: "Method addProperty(javax.servlet.http.Cookie): Adds the    */
      /* specified cookie property to the response"                           */
      TestResult tr0 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYA1);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_addPropertyA2     */
      /* Details: "Method addProperty(javax.servlet.http.Cookie): Throws      */
      /* IllegalArgumentException if the specified cookie is null"            */
      TestResult tr1 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYA2);
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

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_addPropertyB1     */
      /* Details: "Method addProperty(String, org.w3c.dom.Element): Adds an   */
      /* XML DOM Element to the response for the specified key"               */
      TestResult tr2 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYB1);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_addPropertyB3     */
      /* Details: "Method addProperty(String, org.w3c.dom.Element): If the    */
      /* specified DOM Element value is null, the key is removed from the     */
      /* response"                                                            */
      TestResult tr3 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYB3);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_addPropertyB4     */
      /* Details: "Method addProperty(String, org.w3c.dom.Element): Throws    */
      /* IllegalArgumentException if the specified key is null"               */
      TestResult tr4 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYB4);
      try {
         try {
            org.w3c.dom.Element el = portletResp.createElement("p");
            portletResp.addProperty((String)null, el);
            tr4.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr4.setTcSuccess(true);
         } catch (Exception e) {
            tr4.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_addPropertyC1     */
      /* Details: "Method addProperty(String, String): A property can be      */
      /* added"                                                               */
      TestResult tr5 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYC1);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_addPropertyC2     */
      /* Details: "Method addProperty(String, String): Throws                 */
      /* IllegalArgumentException if the specified key is null"               */
      TestResult tr6 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYC2);
      try {
         try {
            portletResp.addProperty(null, "value");
            tr6.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr6.setTcSuccess(true);
         } catch (Exception e) {
            tr6.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr6.appendTcDetail(e.toString());}
      tr6.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_setProperty1      */
      /* Details: "Method setProperty(String, String): Sets a property        */
      /* value for the specified key"                                         */
      TestResult tr7 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_SETPROPERTY1);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_setProperty3      */
      /* Details: "Method setProperty(String, String): Throws                 */
      /* IllegalArgumentException if the specified key is null"               */
      TestResult tr8 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_SETPROPERTY3);
      try {
         try {
            portletResp.setProperty(null, "value");
            tr8.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr8.setTcSuccess(true);
         } catch (Exception e) {
            tr8.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr8.appendTcDetail(e.toString());}
      tr8.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_encodeURL1        */
      /* Details: "Method encodeURL(String): Returns a String representing    */
      /* the encoded URL"                                                     */
      TestResult tr9 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ENCODEURL1);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_encodeURL2        */
      /* Details: "Method encodeURL(String): Throws                           */
      /* IllegalArgumentException if the input string is not an absolute      */
      /* URL and does not start with at \"/\" character"                      */
      TestResult tr10 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ENCODEURL2);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_getNamespace1     */
      /* Details: "Method getNamespace(): Returns a String containing the     */
      /* namespace value"                                                     */
      TestResult tr11 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_GETNAMESPACE1);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_createElement1    */
      /* Details: "Method createElement(String): Returns an                   */
      /* org.w3c.dom.Element object for the specified tag name"               */
      TestResult tr12 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_CREATEELEMENT1);
      /* TODO: implement test */
      tr12.appendTcDetail("Not implemented.");
      tr12.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_createElement2    */
      /* Details: "Method createElement(String): The returned Element has     */
      /* nodeName set to the the specified tag name "                         */
      TestResult tr13 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_CREATEELEMENT2);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_createElement3    */
      /* Details: "Method createElement(String): The returned Element has     */
      /* localName set to null"                                               */
      TestResult tr14 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_CREATEELEMENT3);
      /* TODO: implement test */
      tr14.appendTcDetail("Not implemented.");
      tr14.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_createElement4    */
      /* Details: "Method createElement(String): The returned Element has     */
      /* prefix set to null"                                                  */
      TestResult tr15 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_CREATEELEMENT4);
      /* TODO: implement test */
      tr15.appendTcDetail("Not implemented.");
      tr15.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_createElement5    */
      /* Details: "Method createElement(String): The returned Element has     */
      /* namespaceURI set to null"                                            */
      TestResult tr16 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_CREATEELEMENT5);
      /* TODO: implement test */
      tr16.appendTcDetail("Not implemented.");
      tr16.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_createElement6    */
      /* Details: "Method createElement(String): Throws                       */
      /* org.w3c.dom.DOMException - INVALID_CHARACTER_ERR if the specified    */
      /* name contains an illegal character. "                                */
      TestResult tr17 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_CREATEELEMENT6);
      /* TODO: implement test */
      tr17.appendTcDetail("Not implemented.");
      tr17.writeTo(writer);

      portletReq.getPortletSession().setAttribute(
                   Constants.RESULT_ATTR_PREFIX + "ResponseTests_PortletResponse_ApiEvent",
                   writer.toString(), APPLICATION_SCOPE);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      
      LOGGER.entering(LOG_CLASS, "event companion render");

      portletResp.setContentType("text/html");
      PrintWriter writer = portletResp.getWriter();
      writer.write("<h3>Event Companion Portlet </h3>\n");
      writer.write("<p>ResponseTests_PortletResponse_ApiEvent_event</p>\n");

      String msg = (String) portletReq.getPortletSession()
            .getAttribute(RESULT_ATTR_PREFIX + "ResponseTests_PortletResponse_ApiEvent", APPLICATION_SCOPE);
      msg = (msg==null) ? "Not ready. click test case link." : msg;
      writer.write("<p>" + msg + "</p>\n");

   }

}
