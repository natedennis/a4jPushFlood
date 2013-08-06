package org.monarchnc.navigation;

import org.apache.deltaspike.core.api.config.view.DefaultErrorView;
import org.apache.deltaspike.core.api.config.view.ViewConfig;


import org.apache.deltaspike.jsf.api.config.view.Folder;
import org.apache.deltaspike.jsf.api.config.view.View.NavigationMode;
import org.apache.deltaspike.jsf.api.config.view.View;
import org.apache.deltaspike.jsf.api.config.view.View.ViewParameterMode;

/**
*
* @author Nathan Dennis
*
*/

@Folder //optional.. loaded automatically.. just to make it easier for my small brain to understand
public interface Pages extends ViewConfig {
	
    @View
	class Index implements Pages { }
	
   	
	@View
	class Expired implements Pages { }

	@View
	class Error extends DefaultErrorView { }
	 
	@View
	class Denied implements Pages { }

	@Folder(name = "/local/")
	interface Local extends Pages
	{
	   @View(navigation = NavigationMode.REDIRECT, viewParams = ViewParameterMode.INCLUDE)
	   class Queue implements Local { }
	 
	}
	 	

}
