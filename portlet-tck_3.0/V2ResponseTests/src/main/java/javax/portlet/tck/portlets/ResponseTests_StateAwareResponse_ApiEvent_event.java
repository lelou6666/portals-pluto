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
public class ResponseTests_StateAwareResponse_ApiEvent_event implements Portlet, EventPortlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         ResponseTests_StateAwareResponse_ApiEvent_event.class.getName();
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

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setWindowState1 */
      /* Details: "Method setWindowState(WindowState): Sets the WindowState   */
      /* to the specified value"                                              */
      TestResult tr0 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETWINDOWSTATE1);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setWindowState2 */
      /* Details: "Method setWindowState(WindowState): Throws                 */
      /* WindowStateException if the portlet cannot switch to the specified   */
      /* WindowState"                                                         */
      TestResult tr1 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETWINDOWSTATE2);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setWindowState3 */
      /* Details: "Method setWindowState(WindowState): Throws                 */
      /* IllegalStateException if the method is invoked after the             */
      /* sendRedirect method has been called"                                 */
      TestResult tr2 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETWINDOWSTATE3);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setPortletMode1 */
      /* Details: "Method setPortletMode(PortletMode): Sets the PortletMode   */
      /* to the specified value"                                              */
      TestResult tr3 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETPORTLETMODE1);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setPortletMode2 */
      /* Details: "Method setPortletMode(PortletMode): Throws                 */
      /* PortletModeException if the portlet cannot switch to the specified   */
      /* PortletMode"                                                         */
      TestResult tr4 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETPORTLETMODE2);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setPortletMode3 */
      /* Details: "Method setPortletMode(PortletMode): Throws                 */
      /* IllegalStateException if the method is invoked after the             */
      /* sendRedirect method has been called"                                 */
      TestResult tr5 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETPORTLETMODE3);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters1 */
      /* Details: "Method setRenderParameters(java.util.Map): Sets the        */
      /* render parameter map to the specified value"                         */
      TestResult tr6 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS1);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters2 */
      /* Details: "Method setRenderParameters(java.util.Map): Public render   */
      /* parameters can be set through the map"                               */
      TestResult tr7 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS2);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters3 */
      /* Details: "Method setRenderParameters(java.util.Map): Private         */
      /* render parameters can be set through the map"                        */
      TestResult tr8 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS3);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters4 */
      /* Details: "Method setRenderParameters(java.util.Map): Previously      */
      /* existing private render parameters not contained in the specified    */
      /* input map are removed"                                               */
      TestResult tr9 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS4);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters5 */
      /* Details: "Method setRenderParameters(java.util.Map): Previously      */
      /* existing public render parameters not contained in the specified     */
      /* input map remain unchanged"                                          */
      TestResult tr10 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS5);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters6 */
      /* Details: "Method setRenderParameters(java.util.Map): Parameters      */
      /* that are set are available in subsequent render requests"            */
      TestResult tr11 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS6);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters7 */
      /* Details: "Method setRenderParameters(java.util.Map): Throws          */
      /* IllegalArgumentException if the input map is null"                   */
      TestResult tr12 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS7);
      try {
         try {
            portletResp.setRenderParameters((Map<String, String[]>)null);
            tr12.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr12.setTcSuccess(true);
         } catch (Exception e) {
            tr12.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr12.appendTcDetail(e.toString());}
      tr12.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters8 */
      /* Details: "Method setRenderParameters(java.util.Map): Throws          */
      /* IllegalArgumentException if any key in the map is null"              */
      TestResult tr13 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS8);
      try {
         try {
            Map<String, String[]> parms = new HashMap<String, String[]>();
            parms.put("parm1", new String[]{"val1-1", "val1-2"});
            parms.put(null, new String[]{"val2-1", "val2-2"});
            portletResp.setRenderParameters(parms);
            tr13.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr13.setTcSuccess(true);
         } catch (Exception e) {
            tr13.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr13.appendTcDetail(e.toString());}
      tr13.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters10 */
      /* Details: "Method setRenderParameters(java.util.Map): Throws          */
      /* IllegalArgumentException if the values array for any key is null "   */
      TestResult tr14 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS10);
      try {
         try {
            Map<String, String[]> parms = new HashMap<String, String[]>();
            parms.put("parm1", new String[]{"val1-1", "val1-2"});
            parms.put("parm2", null);
            portletResp.setRenderParameters(parms);
            tr14.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr14.setTcSuccess(true);
         } catch (Exception e) {
            tr14.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr14.appendTcDetail(e.toString());}
      tr14.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters11 */
      /* Details: "Method setRenderParameters(java.util.Map): Throws          */
      /* IllegalArgumentException if any element in the values array is       */
      /* null "                                                               */
      TestResult tr15 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS11);
      try {
         try {
            Map<String, String[]> parms = new HashMap<String, String[]>();
            parms.put("parm1", new String[]{null, "val1-2"});
            parms.put("parm2", new String[]{"val2-1", "val2-2"});
            portletResp.setRenderParameters(parms);
            tr15.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr15.setTcSuccess(true);
         } catch (Exception e) {
            tr15.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr15.appendTcDetail(e.toString());}
      tr15.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters12 */
      /* Details: "Method setRenderParameters(java.util.Map): Throws          */
      /* IllegalStateException if the method is invoked after the             */
      /* sendRedirect method has been called"                                 */
      TestResult tr16 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS12);
      /* TODO: implement test */
      tr16.appendTcDetail("Not implemented.");
      tr16.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterA1 */
      /* Details: "Method setRenderParameter(String, String): Sets the        */
      /* parameter value for the specified name"                              */
      TestResult tr17 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA1);
      /* TODO: implement test */
      tr17.appendTcDetail("Not implemented.");
      tr17.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterA2 */
      /* Details: "Method setRenderParameter(String, String): A private       */
      /* parameter can be set"                                                */
      TestResult tr18 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA2);
      /* TODO: implement test */
      tr18.appendTcDetail("Not implemented.");
      tr18.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterA3 */
      /* Details: "Method setRenderParameter(String, String): A public        */
      /* parameter can be set"                                                */
      TestResult tr19 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA3);
      /* TODO: implement test */
      tr19.appendTcDetail("Not implemented.");
      tr19.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterA4 */
      /* Details: "Method setRenderParameter(String, String): All             */
      /* previously existing values for the specified name are removed"       */
      TestResult tr20 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA4);
      /* TODO: implement test */
      tr20.appendTcDetail("Not implemented.");
      tr20.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterA5 */
      /* Details: "Method setRenderParameter(String, String): If the value    */
      /* is null, all values for the specified name are removed"              */
      TestResult tr21 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA5);
      /* TODO: implement test */
      tr21.appendTcDetail("Not implemented.");
      tr21.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterA6 */
      /* Details: "Method setRenderParameter(String, String): Parameters      */
      /* that are set are available in subsequent render requests"            */
      TestResult tr22 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA6);
      /* TODO: implement test */
      tr22.appendTcDetail("Not implemented.");
      tr22.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterA7 */
      /* Details: "Method setRenderParameter(String, String): Throws          */
      /* IllegalArgumentException if the name is null"                        */
      TestResult tr23 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA7);
      try {
         try {
            portletResp.setRenderParameter(null, "value");
            tr23.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr23.setTcSuccess(true);
         } catch (Exception e) {
            tr23.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr23.appendTcDetail(e.toString());}
      tr23.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterA8 */
      /* Details: "Method setRenderParameter(String, String): Throws          */
      /* IllegalStateException if the method is invoked after the             */
      /* sendRedirect method has been called"                                 */
      TestResult tr24 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA8);
      /* TODO: implement test */
      tr24.appendTcDetail("Not implemented.");
      tr24.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterB1 */
      /* Details: "Method setRenderParameter(String, String[]): Sets the      */
      /* parameter values for the specified name."                            */
      TestResult tr25 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERB1);
      /* TODO: implement test */
      tr25.appendTcDetail("Not implemented.");
      tr25.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterB2 */
      /* Details: "Method setRenderParameter(String, String[]): All           */
      /* existing values are removed"                                         */
      TestResult tr26 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERB2);
      /* TODO: implement test */
      tr26.appendTcDetail("Not implemented.");
      tr26.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterB3 */
      /* Details: "Method setRenderParameter(String, String[]): Parameters    */
      /* that are set are available in subsequent render requests"            */
      TestResult tr27 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERB3);
      /* TODO: implement test */
      tr27.appendTcDetail("Not implemented.");
      tr27.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterB4 */
      /* Details: "Method setRenderParameter(String, String[]): Throws        */
      /* IllegalArgumentException if the name is null"                        */
      TestResult tr28 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERB4);
      try {
         try {
            portletResp.setRenderParameter(null, new String[]{"val1-1", "val1-2"});
            tr28.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr28.setTcSuccess(true);
         } catch (Exception e) {
            tr28.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr28.appendTcDetail(e.toString());}
      tr28.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterB5 */
      /* Details: "Method setRenderParameter(String, String[]): Throws        */
      /* IllegalArgumentException if the values array is null"                */
      TestResult tr29 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERB5);
      try {
         try {
            portletResp.setRenderParameter(null, new String[]{"val1-1", "val1-2"});
            tr29.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr29.setTcSuccess(true);
         } catch (Exception e) {
            tr29.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr29.appendTcDetail(e.toString());}
      tr29.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterB6 */
      /* Details: "Method setRenderParameter(String, String[]): Throws        */
      /* IllegalStateException if the method is invoked after the             */
      /* sendRedirect method has been called"                                 */
      TestResult tr30 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERB6);
      /* TODO: implement test */
      tr30.appendTcDetail("Not implemented.");
      tr30.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setEventA1     */
      /* Details: "Method setEvent(javax.xml.namespace.QName,                 */
      /* java.io.Serializable): Publishes an event with the specified name    */
      /* and payload"                                                         */
      TestResult tr31 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTA1);
      /* TODO: implement test */
      tr31.appendTcDetail("Not implemented.");
      tr31.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setEventA2     */
      /* Details: "Method setEvent(javax.xml.namespace.QName,                 */
      /* java.io.Serializable): Throws IllegalArgumentException if the name   */
      /* is null"                                                             */
      TestResult tr32 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTA2);
      try {
         try {
            portletResp.setEvent((javax.xml.namespace.QName)null, "value");
            tr32.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr32.setTcSuccess(true);
         } catch (Exception e) {
            tr32.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr32.appendTcDetail(e.toString());}
      tr32.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setEventA3     */
      /* Details: "Method setEvent(javax.xml.namespace.QName,                 */
      /* java.io.Serializable): Throws IllegalArgumentException if the        */
      /* value is not serializable"                                           */
      TestResult tr33 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTA3);
      /* TODO: implement test */
      tr33.appendTcDetail("Not implemented.");
      tr33.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setEventA4     */
      /* Details: "Method setEvent(javax.xml.namespace.QName,                 */
      /* java.io.Serializable): Throws IllegalArgumentException if the        */
      /* value does not have a valid JAXB binding"                            */
      TestResult tr34 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTA4);
      /* TODO: implement test */
      tr34.appendTcDetail("Not implemented.");
      tr34.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setEventA5     */
      /* Details: "Method setEvent(javax.xml.namespace.QName,                 */
      /* java.io.Serializable): Throws IllegalArgumentException if the        */
      /* value object type is not as specified in the deployment              */
      /* descriptor"                                                          */
      TestResult tr35 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTA5);
      /* TODO: implement test */
      tr35.appendTcDetail("Not implemented.");
      tr35.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setEventB1     */
      /* Details: "Method setEvent(String, java.io.Serializable): Publishes   */
      /* an event with the specified name and payload"                        */
      TestResult tr36 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTB1);
      /* TODO: implement test */
      tr36.appendTcDetail("Not implemented.");
      tr36.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setEventB2     */
      /* Details: "Method setEvent(String, java.io.Serializable): Throws      */
      /* IllegalArgumentException if the name is null"                        */
      TestResult tr37 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTB2);
      try {
         try {
            portletResp.setEvent((javax.xml.namespace.QName)null, "value");
            tr37.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr37.setTcSuccess(true);
         } catch (Exception e) {
            tr37.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr37.appendTcDetail(e.toString());}
      tr37.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setEventB3     */
      /* Details: "Method setEvent(String, java.io.Serializable): Throws      */
      /* IllegalArgumentException if the value is not serializable"           */
      TestResult tr38 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTB3);
      /* TODO: implement test */
      tr38.appendTcDetail("Not implemented.");
      tr38.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setEventB4     */
      /* Details: "Method setEvent(String, java.io.Serializable): Throws      */
      /* IllegalArgumentException if the value does not have a valid JAXB     */
      /* binding"                                                             */
      TestResult tr39 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTB4);
      /* TODO: implement test */
      tr39.appendTcDetail("Not implemented.");
      tr39.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setEventB5     */
      /* Details: "Method setEvent(String, java.io.Serializable): Throws      */
      /* IllegalArgumentException if the value object type is not as          */
      /* specified in the deployment descriptor"                              */
      TestResult tr40 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTB5);
      /* TODO: implement test */
      tr40.appendTcDetail("Not implemented.");
      tr40.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_getRenderParameterMap1 */
      /* Details: "Method getRenderParameterMap(): Returns a map of the       */
      /* render parameters currently set on the response"                     */
      TestResult tr41 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETRENDERPARAMETERMAP1);
      /* TODO: implement test */
      tr41.appendTcDetail("Not implemented.");
      tr41.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_getRenderParameterMap2 */
      /* Details: "Method getRenderParameterMap(): The returned map           */
      /* contains public render parameters"                                   */
      TestResult tr42 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETRENDERPARAMETERMAP2);
      /* TODO: implement test */
      tr42.appendTcDetail("Not implemented.");
      tr42.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_getRenderParameterMap3 */
      /* Details: "Method getRenderParameterMap(): The returned map           */
      /* contains private render parameters"                                  */
      TestResult tr43 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETRENDERPARAMETERMAP3);
      /* TODO: implement test */
      tr43.appendTcDetail("Not implemented.");
      tr43.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_getRenderParameterMap4 */
      /* Details: "Method getRenderParameterMap(): An empty map is returned   */
      /* if no parameters have been set "                                     */
      TestResult tr44 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETRENDERPARAMETERMAP4);
      /* TODO: implement test */
      tr44.appendTcDetail("Not implemented.");
      tr44.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_getPortletMode1 */
      /* Details: "Method getPortletMode(): Returns the current PortletMode   */
      /* for the portlet"                                                     */
      TestResult tr45 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETPORTLETMODE1);
      /* TODO: implement test */
      tr45.appendTcDetail("Not implemented.");
      tr45.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_getPortletMode2 */
      /* Details: "Method getPortletMode(): Returns null if no PortletMode    */
      /* has been set"                                                        */
      TestResult tr46 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETPORTLETMODE2);
      /* TODO: implement test */
      tr46.appendTcDetail("Not implemented.");
      tr46.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_getWindowState1 */
      /* Details: "Method getWindowState(): Returns the current WindowState   */
      /* for the portlet"                                                     */
      TestResult tr47 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETWINDOWSTATE1);
      /* TODO: implement test */
      tr47.appendTcDetail("Not implemented.");
      tr47.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_getWindowState2 */
      /* Details: "Method getWindowState(): Returns null if no WindowState    */
      /* has been set"                                                        */
      TestResult tr48 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETWINDOWSTATE2);
      /* TODO: implement test */
      tr48.appendTcDetail("Not implemented.");
      tr48.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_removePublicRenderParameter1 */
      /* Details: "Method removePublicRenderParameter(String): Removes the    */
      /* specified public render parameter"                                   */
      TestResult tr49 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_REMOVEPUBLICRENDERPARAMETER1);
      /* TODO: implement test */
      tr49.appendTcDetail("Not implemented.");
      tr49.writeTo(writer);

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_removePublicRenderParameter2 */
      /* Details: "Method removePublicRenderParameter(String): Throws         */
      /* IllegalArgumentException if the name is null"                        */
      TestResult tr50 = tcd.getTestResultFailed(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_REMOVEPUBLICRENDERPARAMETER2);
      try {
         try {
            portletResp.removePublicRenderParameter(null);
            tr50.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr50.setTcSuccess(true);
         } catch (Exception e) {
            tr50.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr50.appendTcDetail(e.toString());}
      tr50.writeTo(writer);

      portletReq.getPortletSession().setAttribute(
                   Constants.RESULT_ATTR_PREFIX + "ResponseTests_StateAwareResponse_ApiEvent",
                   writer.toString(), APPLICATION_SCOPE);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      
      LOGGER.entering(LOG_CLASS, "event companion render");

      portletResp.setContentType("text/html");
      PrintWriter writer = portletResp.getWriter();
      writer.write("<h3>Event Companion Portlet </h3>\n");
      writer.write("<p>ResponseTests_StateAwareResponse_ApiEvent_event</p>\n");

      String msg = (String) portletReq.getPortletSession()
            .getAttribute(RESULT_ATTR_PREFIX + "ResponseTests_StateAwareResponse_ApiEvent", APPLICATION_SCOPE);
      msg = (msg==null) ? "Not ready. click test case link." : msg;
      writer.write("<p>" + msg + "</p>\n");

   }

}
