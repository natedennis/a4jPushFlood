/**************************************************************
 * Copyright (c) 2012 - 2013, Monarch, All rights reserved.
 * 
 * @author Nathan Dennis
 * @date Jun 27, 2013
 */

package org.monarchnc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.deltaspike.core.api.projectstage.ProjectStage;
import org.apache.deltaspike.core.util.ProjectStageProducer;

/**
 * This class uses CDI to alias Java EE resources, such as the
 * {@link FacesContext}, to CDI beans
 * 
 * <p>
 * Example injection on a managed bean field:
 * </p>
 * 
 * <pre>
 * &#064;Inject
 * private FacesContext facesContext;
 * </pre>
 * 
 * .
 */
@RequestScoped
public class Resources {

	

	/**
	 * Produce log.
	 * 
	 * @param injectionPoint
	 *            the injection point
	 * @return the logger
	 */
	@Produces
	public Logger produceLog(InjectionPoint injectionPoint) {
		return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}

	/**
	 * Produce faces context.
	 * 
	 * @return the faces context
	 */
	@Produces
	@RequestScoped
	public FacesContext produceFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	/**
	 * Return the current {@link ProjectStage}
	 * 
	 * @return
	 */
	@Produces
	@Named
	@Any
	public ProjectStage currentProjectStage() {
		return ProjectStageProducer.getInstance().getProjectStage();
	}


	/**
	 * This utility method will convert any {@link Iterator} to a {@link List}
	 * 
	 * @param the
	 *            {@link Iterator}
	 * @return the {@link List}
	 */
	private <T> List<T> convertToList(Iterator<T> i) {
		List<T> list = new ArrayList<T>();
		while (i.hasNext()) {
			list.add(i.next());
		}
		return list;
	}
}
