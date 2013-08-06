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
 * The Class RestRequestLiteral.
 */
public class RestRequestLiteral extends AnnotationLiteral<RestRequest> implements RestRequest {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6229036106752634991L;

    /** The Constant INSTANCE. */
    public static final RestRequest INSTANCE = new RestRequestLiteral();

    /**
     * Instantiates a new rest request literal.
     */
    private RestRequestLiteral() {
    }

}
