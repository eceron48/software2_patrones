package ingsw.pdd.visitor.domain;


 import java.util.*;
 import javax.xml.bind.annotation.*;
 import ingsw.pdd.visitor.impl.*;

 @XmlRootElement(name = "Project")
 @XmlAccessorType(XmlAccessType.FIELD)
import java.util.List;

import ingsw.pdd.visitor.impl.IVisitable;
import ingsw.pdd.visitor.impl.IVisitor;

public class Project implements IVisitable{

	
	@XmlAttribute(name = "name")
	 private String name;
	@XmlElement(name = "Activities")
	 private List<Activitie> activities;
	
	 public Project() {
	 }
	
	 public Project(String name) {
	 this.name = name;
	 }
	
	 public String getName() {
	 return name;
	 }
	
	 public void setName(String name) {
	 this.name = name;
	 }
	
	 public List<Activitie> getActivities() {
		 if(this.activities==null){
	 this.activities = new ArrayList<>();
	 }
	 return activities;
	 }
	
	 public void setActivities(List<Activitie> activities) {
	 this.activities = activities;
	 }
	
	 public void addActivitie(Activitie activitie){
	 if(this.activities ==null){
	 this.activities = new ArrayList<>();
	 }
	 this.activities.add(activitie);
	 }
	
	 @Override
	 public void accept(IVisitor visitor) {
	 visitor.project(this);
	 }
	
}
