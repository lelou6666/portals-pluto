/*
 * Copyright 2003,2004 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/* 

 */

package org.apache.pluto.factory.impl;

import javax.portlet.*;

import org.apache.pluto.factory.*;
import org.apache.pluto.om.window.PortletWindow;
import org.apache.pluto.core.impl.PortletSessionImpl;

public class PortletSessionFactoryImpl implements PortletSessionFactory {

    public void init(javax.servlet.ServletConfig config, java.util.Map properties) throws Exception
    {
    }

    // org.apache.pluto.factory.PortletSessionFactory ---------------------------------------------
    public PortletSession getPortletSession(PortletWindow portletWindow,
                                            javax.servlet.http.HttpSession httpSession)
    {
        return new PortletSessionImpl(portletWindow, httpSession);
    }
    // --------------------------------------------------------------------------------------------

    // additional methods -------------------------------------------------------------------------
    public void destroy() throws Exception
    {
    }
    // --------------------------------------------------------------------------------------------
}