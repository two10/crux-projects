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
package org.cruxframework.mediamanager.test.procedure;

import org.cruxframework.mediamanager.test.model.Artist;
import org.cruxframework.mediamanager.test.screen.ScreenAddArtist;

/**
 * Class description: 
 * @author guilherme.alecrim
 */
// TODO guilherme.alecrim: documentar classe e métodos
public class PTAddArtist
{
	private static ScreenAddArtist screenAddArtist;

	/** 
	 * Adiciona um artista
	 * @param artist
	 * @return
	 */
	public static String addArtist(Artist artist) 
	{		
		
		populateFields(artist);
		getScreenAddArtist().getBtnAddArtist().click();
		String msg = getScreenAddArtist().getPopUp().getMenssagePopUp();
		getScreenAddArtist().getPopUp().confirmPopUp();	
		Navegation.waitInitiate();
		return msg;
	}


	/** 
	 * Dado um artista, preenche os campos da tela Add artists
	 * @param artist
	 */
	public static void populateFields(Artist artist)
	{	
			getScreenAddArtist().getName().fill(artist.getName());
			getScreenAddArtist().getCountry().select(artist.getCountry());
			getScreenAddArtist().getGenre().select(artist.getGenre());
	}

	/** 
	 * Adiciona o artista a e depois modifica os seus dados pelos dados do artista b
	 * @param artist
	 * @param newValues
	 * @return 
	 */
	public static String addAndChangerArtist(Artist artist, Artist newValues)
	{
		PTAddArtist.addArtist(artist);
		PTAddArtist.populateFields(newValues);
		getScreenAddArtist().getBtnSaveChanges().click();
		String sucessChage = getScreenAddArtist().getPopUp().getMenssagePopUp();
		getScreenAddArtist().getPopUp().confirmPopUp();
		return sucessChage;
	}

	/**
	 * 
	 */
	public static boolean isDisplayedPopUpSavedAddArtist()
	{
		return getScreenAddArtist().getPopUp().isDisplayedPopUp();
	}
	
	

	
	
	
	
	
	public static ScreenAddArtist getScreenAddArtist()
	{
		if(screenAddArtist == null)
		{
			screenAddArtist = new ScreenAddArtist();
		}
		return screenAddArtist;
	}
	
}