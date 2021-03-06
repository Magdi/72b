package com.OJToolkit.client;

import com.OJToolkit.client.Services.CoderService;
import com.OJToolkit.client.Services.CoderServiceAsync;
import com.OJToolkit.client.Services.ContestServices;
import com.OJToolkit.client.Services.ContestServicesAsync;
import com.OJToolkit.client.Services.HintService;
import com.OJToolkit.client.Services.HintServiceAsync;
import com.OJToolkit.client.Services.LanguageService;
import com.OJToolkit.client.Services.LanguageServiceAsync;
import com.OJToolkit.client.Services.LoginService;
import com.OJToolkit.client.Services.LoginServiceAsync;
import com.OJToolkit.client.Services.SourceCodeService;
import com.OJToolkit.client.Services.SourceCodeServiceAsync;
import com.OJToolkit.client.Services.SubmissionService;
import com.OJToolkit.client.Services.SubmissionServiceAsync;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.resources.client.ResourceException;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
@SuppressWarnings("unused")
public class OJToolkit implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad() {
		RootPanel rootPanel = RootPanel.get();
		System.out.println("start");

		SubmissionServiceAsync submissionService = GWT
				.create(SubmissionService.class);

		LanguageServiceAsync languageService = GWT
				.create(LanguageService.class);

		CoderServiceAsync coderService = GWT.create(CoderService.class);

		LoginServiceAsync loginService = GWT.create(LoginService.class);
		SourceCodeServiceAsync sourceCodeService = GWT
				.create(SourceCodeService.class);
		HintServiceAsync hintService = GWT.create(HintService.class);
		HandlerManager eventBus = new HandlerManager(null);
		ContestServicesAsync contestService = GWT.create(ContestServices.class);

		/*
		try {
	        new SpojProblemsToDBAdder();
        } catch (ResourceException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
        }
		 /*/
		AppController appViewer = new AppController(eventBus,
				submissionService, languageService, loginService, coderService,
				sourceCodeService, hintService, contestService);
		appViewer.go(rootPanel);
		// */

	}
}
