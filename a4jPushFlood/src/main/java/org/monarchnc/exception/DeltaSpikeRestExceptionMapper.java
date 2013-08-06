/**************************************************************
 * Copyright (c) 2012 - 2013, Monarch, All rights reserved.
 * 
 * @author Nathan Dennis
 * @date Jun 27, 2013
 */
package org.monarchnc.exception;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.deltaspike.core.api.exception.control.event.ExceptionToCatchEvent;
import org.monarchnc.exception.annotation.RestRequestLiteral;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * This exception mapper is registered with JAX-RS by the provider annotation. It
 * </p>
 * <p>
 * You can inject other CDI beans into it.
 * </p>
 * 
* 
 */
@Provider
public class DeltaSpikeRestExceptionMapper implements ExceptionMapper<Exception> {

    // Inject CDI Event
    /** The catch event. */
    @Inject
    private Event<ExceptionToCatchEvent> catchEvent;

    /** The response. */
    @Inject
    private Instance<Response> response;

    /*
     * (non-Javadoc)
     * 
     * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
     */
    @Override
    public Response toResponse(Exception exception) {
        catchEvent.fire(new ExceptionToCatchEvent(exception, RestRequestLiteral.INSTANCE));
        Response resp = response.get();
        return resp;
    }

}
