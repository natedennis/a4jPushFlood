/**************************************************************
 * Copyright (c) 2012 - 2013, Monarch, All rights reserved.
 * 
 * @author Nathan Dennis
 * @date Jun 27, 2013
 */
package org.monarchnc.exception.annotation;

import javax.enterprise.util.AnnotationLiteral;

// TODO: Auto-generated Javadoc
/**
 * The Class FacesRequestLiteral.
 */
public class FacesRequestLiteral extends AnnotationLiteral<FacesRequest> implements FacesRequest {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5782459184825622680L;

    /** The Constant INSTANCE. */
    public static final FacesRequest INSTANCE = new FacesRequestLiteral();

    /**
     * Instantiates a new faces request literal.
     */
    private FacesRequestLiteral() {
    }

}
