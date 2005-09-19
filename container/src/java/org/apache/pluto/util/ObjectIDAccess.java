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

package org.apache.pluto.util;

import org.apache.pluto.factory.ObjectIDFactory;
import org.apache.pluto.om.common.ObjectID;
import org.apache.pluto.services.factory.FactoryManager;

public class ObjectIDAccess
{

    public static ObjectID createObjectID(String id)
    {
        return getObjectIDFactory().createObjectID(id);
    }

    private static ObjectIDFactory getObjectIDFactory()
    {
        return (ObjectIDFactory)FactoryManager.getFactory(org.apache.pluto.factory.ObjectIDFactory.class);
    }
}