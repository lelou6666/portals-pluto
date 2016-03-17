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
<<<<<<< HEAD
/* 

 */

/*
 * Created on Feb 21, 2003
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code Template
 */
package org.apache.pluto.tags;

import javax.portlet.PortletURL;
import javax.portlet.RenderResponse;

/**
 * Supporting class for the <CODE>actionURL</CODE> tag. Creates a url that
 * points to the current Portlet and triggers an action request with the
 * supplied parameters.
 */
public class ActionURLTag extends BasicURLTag {

    protected PortletURL createPortletURL() {
        RenderResponse renderResponse = (RenderResponse) pageContext.getRequest()
            .getAttribute("javax.portlet.response");
        return renderResponse.createActionURL();
    }

}

=======
package org.apache.pluto.tags;

/**
 * Backwards compatibility Pluto 1.0.1 ActionURLTag providing support for old
 * Pluto 1.0.1 portlet.tld usages.
 * <p>
 * Although a portlet.tld should not be provided by Portlet Applications
 * themselves but "injected" by the target portlet container, fact is many
 * have them embedded in the application anyway. This class ensures those
 * applications still can use their old portlet.tld.
 * </p>
 * @version $Id$
 * @deprecated
 */
public class ActionURLTag extends ActionURLTag168
{
    private static final long serialVersionUID = 286L;
}
>>>>>>> refs/remotes/apache/master
