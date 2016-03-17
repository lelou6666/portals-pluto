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
 * portlet RequestTests_ClientDataRequest_ApiAction_event
 *
 */
public class RequestTests_ClientDataRequest_ApiAction implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         RequestTests_ClientDataRequest_ApiAction.class.getName();
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

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      ClassChecker cc = new ClassChecker(portletReq.getClass());

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getPortletInputStream1 */
      /* Details: "Method getPortletInputStream(): Returns an InputStream     */
      /* object"                                                              */
      TestResult tr0 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM1);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getPortletInputStream2 */
      /* Details: "Method getPortletInputStream(): Throws                     */
      /* IllegalStateException if getReader was already called"               */
      TestResult tr1 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM2);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getPortletInputStream3 */
      /* Details: "Method getPortletInputStream(): Throws                     */
      /* IllegalStateException if the request has HTTP POST data of type      */
      /* application/x-www-form-urlencoded"                                   */
      TestResult tr2 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM3);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_setCharacterEncoding1 */
      /* Details: "Method setCharacterEncoding(String): Allows the            */
      /* character encoding for the body of the request to be overridden"     */
      TestResult tr3 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING1);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_setCharacterEncoding2 */
      /* Details: "Method setCharacterEncoding(String): Throws                */
      /* IllegalStateException if method is called after reading request      */
      /* parameters"                                                          */
      TestResult tr4 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING2);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_setCharacterEncoding3 */
      /* Details: "Method setCharacterEncoding(String): Throws                */
      /* IllegalStateException if method is called after using the            */
      /* getReader(): method"                                                 */
      TestResult tr5 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING3);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_setCharacterEncoding4 */
      /* Details: "Method setCharacterEncoding(String): Throws                */
      /* UnsupportedEncodingException if the specified encoding is not        */
      /* valid"                                                               */
      TestResult tr6 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING4);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getReader1      */
      /* Details: "Method getReader(): Returns a BufferedReader object for    */
      /* reading the request"                                                 */
      TestResult tr7 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER1);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getReader2      */
      /* Details: "Method getReader(): Throws IllegalStateException if        */
      /* getPortletInputStream was already called"                            */
      TestResult tr8 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER2);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getReader3      */
      /* Details: "Method getReader(): Throws IllegalStateException if the    */
      /* request has HTTP POST data of type                                   */
      /* application/x-www-form-urlencoded"                                   */
      TestResult tr9 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER3);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getReader5      */
      /* Details: "Method getReader(): Throws UnsupportedEncodingException    */
      /* if the character set encoding is not valid so that the text cannot   */
      /* be decoded"                                                          */
      TestResult tr10 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER5);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getCharacterEncoding1 */
      /* Details: "Method getCharacterEncoding(): Returns a String            */
      /* containing the name of the character encoding used in the request    */
      /* body"                                                                */
      TestResult tr11 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCHARACTERENCODING1);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getCharacterEncoding2 */
      /* Details: "Method getCharacterEncoding(): Returns null if the         */
      /* request does not specify a character encoding"                       */
      TestResult tr12 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCHARACTERENCODING2);
      /* TODO: implement test */
      tr12.appendTcDetail("Not implemented.");
      tr12.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getContentType1 */
      /* Details: "Method getContentType(): Returns a String containing the   */
      /* MIME type of the request body"                                       */
      TestResult tr13 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTTYPE1);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getContentType2 */
      /* Details: "Method getContentType(): Returns null if the MIME type     */
      /* is unknown"                                                          */
      TestResult tr14 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTTYPE2);
      /* TODO: implement test */
      tr14.appendTcDetail("Not implemented.");
      tr14.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getContentLength1 */
      /* Details: "Method getContentLength(): Returns the length in bytes     */
      /* of the request body"                                                 */
      TestResult tr15 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTLENGTH1);
      /* TODO: implement test */
      tr15.appendTcDetail("Not implemented.");
      tr15.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getContentLength2 */
      /* Details: "Method getContentLength(): Returns -1 if the length is     */
      /* unknown"                                                             */
      TestResult tr16 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTLENGTH2);
      /* TODO: implement test */
      tr16.appendTcDetail("Not implemented.");
      tr16.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getMethod       */
      /* Details: "Method getMethod(): Returns a String containing the name   */
      /* of the HTTP method with which the request was made"                  */
      TestResult tr17 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETMETHOD);
      /* TODO: implement test */
      tr17.appendTcDetail("Not implemented.");
      tr17.writeTo(writer);

      portletReq.getPortletSession().setAttribute(
                   Constants.RESULT_ATTR_PREFIX + "RequestTests_ClientDataRequest_ApiAction",
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
      String msg = (String) ps.getAttribute(RESULT_ATTR_PREFIX + "RequestTests_ClientDataRequest_ApiAction", APPLICATION_SCOPE);
      if (msg != null) {
         writer.write("<p>" + msg + "</p><br/>\n");
         ps.removeAttribute(RESULT_ATTR_PREFIX + "RequestTests_ClientDataRequest_ApiAction", APPLICATION_SCOPE);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getPortletInputStream1 */
      /* Details: "Method getPortletInputStream(): Returns an InputStream     */
      /* object"                                                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_ClientDataRequest_ApiAction_getPortletInputStream1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getPortletInputStream2 */
      /* Details: "Method getPortletInputStream(): Throws                     */
      /* IllegalStateException if getReader was already called"               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_ClientDataRequest_ApiAction_getPortletInputStream2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getPortletInputStream3 */
      /* Details: "Method getPortletInputStream(): Throws                     */
      /* IllegalStateException if the request has HTTP POST data of type      */
      /* application/x-www-form-urlencoded"                                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_ClientDataRequest_ApiAction_getPortletInputStream3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_setCharacterEncoding1 */
      /* Details: "Method setCharacterEncoding(String): Allows the            */
      /* character encoding for the body of the request to be overridden"     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_ClientDataRequest_ApiAction_setCharacterEncoding1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_setCharacterEncoding2 */
      /* Details: "Method setCharacterEncoding(String): Throws                */
      /* IllegalStateException if method is called after reading request      */
      /* parameters"                                                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_ClientDataRequest_ApiAction_setCharacterEncoding2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_setCharacterEncoding3 */
      /* Details: "Method setCharacterEncoding(String): Throws                */
      /* IllegalStateException if method is called after using the            */
      /* getReader(): method"                                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_ClientDataRequest_ApiAction_setCharacterEncoding3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_setCharacterEncoding4 */
      /* Details: "Method setCharacterEncoding(String): Throws                */
      /* UnsupportedEncodingException if the specified encoding is not        */
      /* valid"                                                               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_ClientDataRequest_ApiAction_setCharacterEncoding4", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getReader1      */
      /* Details: "Method getReader(): Returns a BufferedReader object for    */
      /* reading the request"                                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_ClientDataRequest_ApiAction_getReader1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getReader2      */
      /* Details: "Method getReader(): Throws IllegalStateException if        */
      /* getPortletInputStream was already called"                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_ClientDataRequest_ApiAction_getReader2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getReader3      */
      /* Details: "Method getReader(): Throws IllegalStateException if the    */
      /* request has HTTP POST data of type                                   */
      /* application/x-www-form-urlencoded"                                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_ClientDataRequest_ApiAction_getReader3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getReader5      */
      /* Details: "Method getReader(): Throws UnsupportedEncodingException    */
      /* if the character set encoding is not valid so that the text cannot   */
      /* be decoded"                                                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_ClientDataRequest_ApiAction_getReader5", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getCharacterEncoding1 */
      /* Details: "Method getCharacterEncoding(): Returns a String            */
      /* containing the name of the character encoding used in the request    */
      /* body"                                                                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_ClientDataRequest_ApiAction_getCharacterEncoding1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getCharacterEncoding2 */
      /* Details: "Method getCharacterEncoding(): Returns null if the         */
      /* request does not specify a character encoding"                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_ClientDataRequest_ApiAction_getCharacterEncoding2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getContentType1 */
      /* Details: "Method getContentType(): Returns a String containing the   */
      /* MIME type of the request body"                                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_ClientDataRequest_ApiAction_getContentType1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getContentType2 */
      /* Details: "Method getContentType(): Returns null if the MIME type     */
      /* is unknown"                                                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_ClientDataRequest_ApiAction_getContentType2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getContentLength1 */
      /* Details: "Method getContentLength(): Returns the length in bytes     */
      /* of the request body"                                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_ClientDataRequest_ApiAction_getContentLength1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getContentLength2 */
      /* Details: "Method getContentLength(): Returns -1 if the length is     */
      /* unknown"                                                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_ClientDataRequest_ApiAction_getContentLength2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getMethod       */
      /* Details: "Method getMethod(): Returns a String containing the name   */
      /* of the HTTP method with which the request was made"                  */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_ClientDataRequest_ApiAction_getMethod", aurl);
         tb.writeTo(writer);
      }

   }

}
