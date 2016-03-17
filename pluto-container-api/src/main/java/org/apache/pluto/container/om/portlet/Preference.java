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
<<<<<<< HEAD:pluto-container/src/main/java/org/apache/pluto/core/UserInfoAttribute.java
package org.apache.pluto.core;

/**
 * Encapsulates a user information attribute as described in
 * PLT.17 of the JSR-168 specification.
 *
 */
public interface UserInfoAttribute {

    String getName();

    String getValue();

    String getAuthUser();

}
=======
package org.apache.pluto.container.om.portlet;

import java.util.List;

public interface Preference {

    String getName();

    List<String> getValues();
	void addValue(String value);

	boolean isReadOnly();
	void setReadOnly(boolean readOnly);
}
>>>>>>> refs/remotes/apache/master:pluto-container-api/src/main/java/org/apache/pluto/container/om/portlet/Preference.java
