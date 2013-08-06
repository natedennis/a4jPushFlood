package org.monarchnc.view;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.richfaces.cdi.push.Push;


@Named
@RequestScoped
public class TestProducerBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String PUSH_CDI_TOPIC = "pushGlobalQueue";
	
	@Inject
	private Conversation conversation;
	
    @Inject
    @Push(topic = PUSH_CDI_TOPIC)
    Event<String> pushEventGlobal;
	
  	public static final String PUSH_CDI_TOPIC_LOCAL = "pushLocalQueue";

  	String message;
  	
  	@Inject
  	QueueBean queueBean;
  	
  	public String postMessage(){
		
  		queueBean.getQueue().add(message);
		pushEventGlobal.fire(message);
		
		return null;	
	}
	
	public void reset(){
		queueBean.setQueue(new ArrayList<String>());
		pushEventGlobal.fire("");
	}

	
public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

}
