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

/**
 * This bean encapsulates a single test result. When converted to a string or 
 * written to a writer, it generates HTML markup containing elements and IDs
 * that can be read by the TCK test driver. 
 * 
 * The TCK test driver works by accessing the page containing the test portlet,
 * clicking a link for the test if one is present, and reading the test output.
 * 
 * The test case is identified by a unique name string that contains no blanks. 
 * The test case name is used to generate ID's for the HTML result elements.
 * The following IDs are generated by this bean:
 * 
 * (TestCaseName)-success     - indicates general test case success or failure
 * (TestCaseName)-detail      - a detailed message about the test     
 * 
 */
package javax.portlet.tck.beans;

import java.io.IOException;
import java.io.Writer;

import javax.portlet.PortletURL;
import javax.portlet.tck.constants.Constants;

/**
 * Formats a link for a test case.
 * 
 * @author nick
 */
public class TestLink {
   
   String tcName;
   String urlstr;
   PortletURL purl;
   String actId;
   String title;
   
   /**
    * Creates an empty test result.
    */
   public TestLink() {
      tcName = "";
      actId = "";
      title = "";
      urlstr = null;
      purl = null;
   }

   /**
    * Creates a test link initialized according to the parameters.
    * 
    * @param tcName     test case name
    * @param url        url for the test case
    */
   public TestLink(String tcName, PortletURL purl) {
      this.tcName = tcName;
      this.actId = tcName + Constants.CLICK_ID;
      this.title = " Action Link";
      this.purl = purl;
      this.urlstr = null;
   }

   /**
    * Creates a test link initialized with a URL in string form.
    * This enables certain URL test cases such as "*URL.toString()"
    * 
    * @param tcName     test case name
    * @param urlstr     url for the test case in string form
    */
   public TestLink(String tcName, String urlstr) {
      this.tcName = tcName;
      this.actId = tcName + Constants.CLICK_ID;
      this.title = " Action Link";
      this.urlstr = urlstr;
      this.purl = null;
   }

   /**
    * Generates HTML markup representing the test link. 
    * 
    * Note that the div element containing the item that is to be acted upon
    * by the client must have an id equal to the test case name.
    * 
    * @return  HTML markup representing the test link
    */
   @Override
   public String toString() {
      
      if (urlstr == null) urlstr = purl.toString();
      StringBuilder sb = new StringBuilder();
      sb.append("<div class='portletTCKTestcase' name='");
      sb.append(tcName);
      sb.append("'>");
      sb.append("<h4>");
      sb.append(tcName);
      sb.append(" " + title + ":");
      sb.append("</h4>");
      sb.append("<a class='portletTCKLink' id='");
      sb.append(actId);
      sb.append("' href='");
      sb.append(urlstr);
      sb.append("'>");
      sb.append(tcName);
      sb.append("</a>");
      sb.append("</div>");

      return sb.toString();
   }
   
   /**
    * Generates HTML markup representing the test link and
    * writes them to the writer provided.
    * 
    * @param writer  Writer to which the string is written
    */
   public void writeTo(Writer writer)throws IOException {
      writer.write(this.toString());
   }
   
}
