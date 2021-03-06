package com.OJToolkit.client.Services;

import java.util.ArrayList;

import com.OJToolkit.client.Exceptions.NotLoggedInException;
import com.OJToolkit.client.ValueObjects.LanguageData;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @author 72B
 *         Contains all the services related to language
 */
@RemoteServiceRelativePath("language")
public interface LanguageService extends RemoteService {
	/**
	 * Gets all languages from datastore
	 * 
	 * @return all languages from datastore
	 * @throws NotLoggedInException
	 *             Thrown if the user is not logged in
	 */
	public ArrayList<LanguageData> getLanguages(String OJType) throws NotLoggedInException;

	/**
	 * Reads all languages from an array and add them to the datastore
	 */
	public void addLanguages();

}
