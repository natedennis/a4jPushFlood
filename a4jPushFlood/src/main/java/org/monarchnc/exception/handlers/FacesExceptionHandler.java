/**************************************************************
 * Copyright (c) 2012 - 2013, Monarch, All rights reserved.
 * 
 * @author Nathan Dennis
 * @date Jun 27, 2013
 */
package org.monarchnc.exception.handlers;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.deltaspike.core.api.exception.control.ExceptionHandler;
import org.apache.deltaspike.core.api.exception.control.Handles;
import org.apache.deltaspike.core.api.exception.control.event.ExceptionEvent;
import org.monarchnc.exception.annotation.FacesRequest;

/**
 * This exception handler uses {@link FacesMessage} to display the exception message on JSF.
 */
@ExceptionHandler
public class FacesExceptionHandler {

    /**
     * Show faces message.
     *
     * @param evt the evt
     * @param facesContext the faces context
     */
    void showFacesMessage(@Handles @FacesRequest ExceptionEvent<Throwable> evt, FacesContext facesContext) {
        String errorMessage = getRootErrorMessage(evt.getException());
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, evt.getException()
                .getMessage()));
        evt.handledAndContinue();
    }

    /**
     * Gets the root error message.
     *
     * @param throwable the throwable
     * @return the root error message
     */
    private String getRootErrorMessage(Throwable throwable) {
        // Default to general error message that registration failed.
        String errorMessage = "Operation failed. See server log for more information";
        if (throwable == null) {
            // This shouldn't happen, but return the default messages
            return errorMessage;
        }

        // Start with the exception and recurse to find the root cause
        Throwable t = throwable;
        while (t != null) {
            // Get the message from the Throwable class instance
            errorMessage = t.getLocalizedMessage();
            t = t.getCause();
        }
        // This is the root cause message
        return errorMessage;
    }

}
