package org.monarchnc.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;


@Named("queuePopUpBean")
@ViewScoped
//@Clustered
public class QueuePopUpBean implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer clickSource;
	
	private ArrayList<Long> testList = new ArrayList<Long>();
	
	
	public void test(){
		testList.add(12L);
		testList.add(13L);
		testList.add(14L);
		testList.add(15L);
	}
	public void init(){
		try{
			System.out.println("mental masterbation");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void reset(){
		this.id = null;
		this.clickSource = null;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;	
	}

	public Integer getClickSource() {
		return clickSource;
	}

	public void setClickSource(Integer clickSource) {
		this.clickSource = clickSource;
	}
	
	public ArrayList<Long> getTestList(){
		return testList;
	}
	public void setTestList(ArrayList<Long> testList){
		this.testList = testList;
	}
	

	
	
}
