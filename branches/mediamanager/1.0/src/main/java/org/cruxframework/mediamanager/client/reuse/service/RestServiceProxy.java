/*
 * Copyright 2011 cruxframework.org.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.cruxframework.mediamanager.client.reuse.service;

import org.cruxframework.crux.core.client.rest.Callback;
import org.cruxframework.crux.core.client.rest.RestProxy;
import org.cruxframework.mediamanager.client.reuse.controller.EditOperation;
import org.cruxframework.mediamanager.shared.reuse.dto.AbstractDTO;

/**
 * Class description: 
 * @author alexandre.costa
 */
public interface RestServiceProxy<T extends AbstractDTO> extends RestProxy
{
	void get(Integer id, Callback<T> callback);
	void update(Integer id, T dto, Callback<EditOperation> callback);
	void insert(T dto, Callback<EditOperation> callback);
	void delete(Integer id, T dto, Callback<EditOperation> callback);
}
