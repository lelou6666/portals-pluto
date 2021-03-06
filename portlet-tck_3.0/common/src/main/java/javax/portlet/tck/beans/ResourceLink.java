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

import javax.portlet.ResourceURL;
import javax.portlet.tck.constants.Constants;

/**
 * Formats a resource link for a test case.
 * 
 * @author nick
 */
public class ResourceLink {
   
   String tcName;
   String urlstr;
   ResourceURL rurl;
   String actId;
   String linkId;
   String divId;
   String resId;
   String detId;
   String title;
   
   /**
    * Creates an empty link.
    */
   public ResourceLink() {
      tcName = "";
      actId = "";
      linkId = "";
      divId = "";
      resId = "";
      detId = "";
      title = "";
      rurl = null;
      urlstr = null;
   }

   /**
    * Creates a resource link initialized according to the parameters.
    * 
    * @param tcName     test case name
    * @param url        url for the test case
    */
   public ResourceLink(String tcName, ResourceURL rurl) {
      this.tcName = tcName;
      this.actId = tcName + Constants.CLICK_ID;
      this.linkId = tcName + Constants.RESOURCE_LINK_ID;
      this.divId = tcName + Constants.RESOURCE_DIV_ID;
      this.resId = tcName + Constants.RESULT_ID;
      this.detId = tcName + Constants.DETAIL_ID;
      this.title = " Resource Link";
      this.rurl = rurl;
      this.urlstr = null;
   }

   /**
    * Creates a resource link initialized with a URL in string form.
    * This enables certain URL test cases such as "*URL.toString()"
    * 
    * @param tcName     test case name
    * @param urlstr     url for the test case in string form
    */
   public ResourceLink(String tcName, String urlstr) {
      this.tcName = tcName;
      this.actId = tcName + Constants.CLICK_ID;
      this.linkId = tcName + Constants.RESOURCE_LINK_ID;
      this.divId = tcName + Constants.RESOURCE_DIV_ID;
      this.resId = tcName + Constants.RESULT_ID;
      this.detId = tcName + Constants.DETAIL_ID;
      this.title = " Resource Link";
      this.urlstr = urlstr;
      this.rurl = null;
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
      
      if (urlstr == null) urlstr = rurl.toString();
      StringBuilder sb = new StringBuilder();
      sb.append("<div class='portletTCKTestcase' name='");
      sb.append(tcName);
      sb.append("'>");
      sb.append("<h4>");
      sb.append(tcName);
      sb.append(" " + title + ":");
      sb.append("</h4>");
      sb.append("<a class='portletTCKLink' id='");
      sb.append(linkId);
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
   
   /**
    * Writes resource-fetching JavaScript code into the output stream.
    * 
    * This method is meant to be used by a test case whose evaluation code is 
    * located in the serveResource method accessed through the resource link
    * information contained in this class. 
    * 
    * When the link in the output is clicked, the result will be retrieved
    * and inserted into the markup.
    * 
    * @param writer     Writer to which the string is written
    * @throws IOException 
    */
   public void writeResourceFetcher(Writer writer) throws IOException {

      if (urlstr == null) urlstr = rurl.toString();
      StringBuilder sb = new StringBuilder();
      TestResult tr = new TestResult(tcName, false, "");
      sb.append("<div class='portletTCKTestcase' name='").append(tcName);
      sb.append("' id='").append(divId).append("'>\n");
      sb.append("<h4>");
      sb.append(tcName);
      sb.append(": Click for results from serveResource:");
      sb.append("</h4>\n");
      sb.append("<a class='portletTCKLink' id='");
      sb.append(actId).append("' href='javascript:;'>Waiting for results ...</a>");
      sb.append("</div>\n");

      sb.append("<script>\n");
      sb.append("(function () {\n");
      sb.append("   var getRes = function () {\n");
      sb.append("      var xhr = new XMLHttpRequest();\n");
      sb.append("      xhr.onreadystatechange=function() {\n");
      sb.append("         if (xhr.readyState==4) {\n");
      sb.append("            if (xhr.status==200) {\n");
      sb.append("               document.getElementById('" + divId + "').innerHTML=xhr.responseText;\n");
      sb.append("            } else {\n");
      sb.append("               var str=\"" + tr.toString() + "\";\n");
      sb.append("               document.getElementById('" + divId + "').innerHTML=str;\n");
      sb.append("               str=\"XMLHttpRequest status=\" + xhr.status;\n");
      sb.append("               document.getElementById('" + detId + "').innerHTML=str;\n");
      sb.append("            }\n");
      sb.append("         }\n");
      sb.append("      };\n");
      sb.append("      xhr.open('GET', '" + urlstr + "',true);\n");
      sb.append("      xhr.send();\n");
      sb.append("   };\n");
      sb.append("   document.getElementById('" + actId + "').onclick = getRes;\n");
      sb.append("})();\n");
      sb.append("</script>\n");

      writer.write(sb.toString());
   }
   
}
