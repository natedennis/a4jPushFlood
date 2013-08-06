/**************************************************************
 * Copyright (c) 2012 - 2013, Monarch, All rights reserved.
 * 
 * @author Nathan Dennis
 * @date Jul 1, 2013
 */
package org.monarchnc.navigation;

import javax.enterprise.inject.Model;

import org.apache.deltaspike.core.api.config.view.DefaultErrorView;
import org.apache.deltaspike.core.api.config.view.ViewConfig;

// TODO: Auto-generated Javadoc
/**
 * The Class PageController.
 */
@Model
public class PageController
{
    
    /**
     * Action without error.
     *
     * @return the class<? extends view config>
     */
    public Class<? extends ViewConfig> actionWithoutError()
    {
        return Pages.Index.class;
    }

    /**
     * Action with error.
     *
     * @return the class<? extends view config>
     */
    public Class<? extends ViewConfig> actionWithError()
    {
        //navigates to the view which is configured as default error-view
        return DefaultErrorView.class;
    }
    
  
}