/**************************************************************
 * Copyright (c) 2012 - 2013, Monarch, All rights reserved.
 * 
 * @author Nathan Dennis
 * @date Jun 27, 2013
 */

package org.monarchnc.exception;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

import org.apache.deltaspike.core.api.exception.control.event.ExceptionToCatchEvent;
import org.monarchnc.exception.handlers.DeltaSpikeExceptionHandler;

// TODO: Auto-generated Javadoc
/**
 * This class is registered in src/main/webapp/WEB-INF/faces-config.xml file.
 * 
 * It creates te {@link DeltaSpikeExceptionHandler} class that is responsible to fire the {@link ExceptionToCatchEvent}
 * 
 * @author <a href="mailto:benevides@redhat.com">Rafael Benevides</a>
 * 
 */
public class DeltaSpikeJSFExceptionHandlerFactory extends ExceptionHandlerFactory {

    /** The parent. */
    private final javax.faces.context.ExceptionHandlerFactory parent;

    /**
     * Instantiates a new delta spike jsf exception handler factory.
     *
     * @param parent the parent
     */
    public DeltaSpikeJSFExceptionHandlerFactory(final ExceptionHandlerFactory parent) {
        this.parent = parent;
    }

    /* (non-Javadoc)
     * @see javax.faces.context.ExceptionHandlerFactory#getExceptionHandler()
     */
    @Override
    public ExceptionHandler getExceptionHandler() {
        return new DeltaSpikeExceptionHandler(parent.getExceptionHandler());
    }

}