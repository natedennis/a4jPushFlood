/**************************************************************
 * Copyright (c) 2012 - 2013, Monarch, All rights reserved.
 * 
 * @author Nathan Dennis
 * @date Jun 27, 2013
 */

package org.monarchnc.exception.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * The Interface FacesRequest.
 */
@Qualifier
@Target({ TYPE, METHOD, PARAMETER, FIELD })
@Retention(RUNTIME)
@Documented
/**
 * annotation interface for use in exception structure
 */
public @interface FacesRequest {

}
