/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/internal/InternalRenderResponse.java
package org.apache.pluto.internal;

import javax.portlet.RenderResponse;

/**
 * The internal render response interface extends the internal portlet response
 * interface and provides some render-specific methods.
 * @since 2006-02-17
 */
public interface InternalRenderResponse extends InternalPortletResponse, RenderResponse {

    void setIncluded(boolean included);

    boolean isIncluded();
=======
package org.apache.pluto.driver.container;

import javax.ccpp.Profile;
import javax.servlet.http.HttpServletRequest;

import org.apache.pluto.container.CCPPProfileService;

/**
 *
 */
public class DummyCCPPProfileServiceImpl implements CCPPProfileService {

	/* (non-Javadoc)
	 * @see org.apache.pluto.spi.CCPPProfileService#getCCPPProfile()
	 */
	public Profile getCCPPProfile(HttpServletRequest httpServletRequest) {
		return new DummyProfile();
		// FIXME: Here we have to return a "real" javax.ccpp.Profile
	}
>>>>>>> refs/remotes/apache/master:pluto-portal-driver/src/main/java/org/apache/pluto/driver/container/DummyCCPPProfileServiceImpl.java

}
