/**************************************************************
 * Copyright (c) 2012 - 2013, Monarch, All rights reserved.
 * 
 * @author Nathan Dennis
 * @date Jun 27, 2013
 */
package org.monarchnc.exception.handlers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.apache.deltaspike.core.api.exception.control.ExceptionHandler;
import org.apache.deltaspike.core.api.exception.control.Handles;
import org.apache.deltaspike.core.api.exception.control.event.ExceptionEvent;
import org.monarchnc.exception.annotation.RestRequest;

// TODO: Auto-generated Javadoc
/**
 * This handler handles exceptions and builds an error message using {@link Status} and {@link Response} entities.
 */
@ExceptionHandler
public class RestExceptionHandler {

    /** The log. */
    @Inject
    private Logger log;

    /**
     * Handle generic exception.
     *
     * @param evt the evt
     * @param builder the builder
     */
  /*
    public void handleGenericException(@Handles @RestRequest ExceptionEvent<Throwable> evt, ResponseBuilder builder) {
        // Handle generic exceptions
        Map<String, String> responseObj = new HashMap<String, String>();
        responseObj.put("error", evt.getException().getMessage());
        builder.status(Response.Status.BAD_REQUEST).entity(responseObj);
        // Mark as handled
        evt.handled();
    }
*/
    /**
     * Handle validation exception.
     *
     * @param evt the evt
     * @param builder the builder
     */
    /*public void handleValidationException(@Handles @RestRequest ExceptionEvent<ValidationException> evt, ResponseBuilder builder) {
        // Handle the unique constrain violation
        Map<String, String> responseObj = new HashMap<String, String>();
        responseObj.put("email", "Email taken");
        builder.status(Response.Status.CONFLICT).entity(responseObj);
        // Mark as handled
        evt.handled();
    }
*/
    /**
     * Handle web application exception.
     *
     * @param evt the evt
     * @param builder the builder
     */
  /*  public void handleWebApplicationException(@Handles @RestRequest ExceptionEvent<WebApplicationException> evt,
            ResponseBuilder builder) {
        // Handle Web Application exceptions
        builder.status(evt.getException().getResponse().getStatus());
        // Mark as handled
        evt.handled();
    }
*/
    /**
     * Handle constraint violation exception.
     *
     * @param evt the evt
     * @param builder the builder
     */
  /*  public void handleConstraintViolationException(@Handles @RestRequest ExceptionEvent<ConstraintViolationException> evt,
            ResponseBuilder builder) {
        // Handle bean validation issues
        builder.status(Status.BAD_REQUEST).entity(createViolationEntity(evt.getException().getConstraintViolations()));
        // Mark as handled
        evt.handled();
    }
*/
    /**
     * Creates the violation entity.
     *
     * @param violations the violations
     * @return the map
     */
    private Map<String, String> createViolationEntity(Set<ConstraintViolation<?>> violations) {
        log.fine("Validation completed. violations found: " + violations.size());

        Map<String, String> responseObj = new HashMap<String, String>();

        for (ConstraintViolation<?> violation : violations) {
            responseObj.put(violation.getPropertyPath().toString(), violation.getMessage());
        }

        return responseObj;
    }

}
