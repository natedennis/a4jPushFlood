package org.monarchnc.view;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;


@Named("queueBean")
@ApplicationScoped
public class QueueBean {


	private List<String> queue = new ArrayList<String>();
	

	public QueueBean() {
	}


	public List<String> getQueue() {
		return queue;
	}


	public void setQueue(List<String> queue) {
		this.queue = queue;
	}

	
	
	
}
