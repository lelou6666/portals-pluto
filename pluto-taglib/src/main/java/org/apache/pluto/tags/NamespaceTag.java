/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
<<<<<<< HEAD
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
=======
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
>>>>>>> refs/remotes/apache/master
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.tags;

<<<<<<< HEAD
import javax.portlet.RenderResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
=======
import java.io.IOException;

import javax.portlet.PortletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
>>>>>>> refs/remotes/apache/master

/**
 * This tag produces a unique value for the current portlet.
 * <p/>
 * <p/>
<<<<<<< HEAD
 * Supporting class for the <CODE>namespace</CODE> tag. writes a unique value
 * for the current portlet <BR>This tag has no attributes
 */
public class NamespaceTag extends TagSupport {
=======
 * A tag handler for the <CODE>namespace</CODE> tag. writes a unique value
 * for the current portlet <BR>This tag has no attributes
 * 
 * @version 2.0
 */
public class NamespaceTag extends TagSupport {
	
	private static final long serialVersionUID = 286L;
>>>>>>> refs/remotes/apache/master

    /* (non-Javadoc)
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     */
    public int doStartTag() throws JspException {
<<<<<<< HEAD
        RenderResponse renderResponse = (RenderResponse) pageContext.getRequest()
            .getAttribute("javax.portlet.response");
        String namespace = renderResponse.getNamespace();
        JspWriter writer = pageContext.getOut();
=======
    	
    	PortletResponse portletResponse = (PortletResponse) pageContext.getRequest()
            .getAttribute(Constants.PORTLET_RESPONSE);
    	
        String namespace = portletResponse.getNamespace();
        
        JspWriter writer = pageContext.getOut();
        
>>>>>>> refs/remotes/apache/master
        try {
            writer.print(namespace);
        } catch (IOException ioe) {
            throw new JspException(
                "Unable to write namespace", ioe
            );
        }
<<<<<<< HEAD
=======
        
>>>>>>> refs/remotes/apache/master
        return SKIP_BODY;
    }
}
