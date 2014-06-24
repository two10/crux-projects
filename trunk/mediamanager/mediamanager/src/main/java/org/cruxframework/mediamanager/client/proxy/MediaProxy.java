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
package org.cruxframework.mediamanager.client.proxy;

import org.cruxframework.mediamanager.client.controller.MediasController;
import org.cruxframework.mediamanager.core.client.dto.MediaDTO;
import org.cruxframework.mediamanager.core.client.enums.MediaType;


/**Class description: 
 * @author Bruno Medeiros (bruno@triggolabs.com)
 *
 */
public interface MediaProxy extends AbstractProxy<MediaDTO>
{
	void search(MediaType type, String name, String person, MediasController controller);
	void delete(MediaDTO dto, MediasController controller);
	void lend(Integer identificador, MediaDTO dto, MediasController controller);
	void getLend(Integer id, MediasController controler);
}
