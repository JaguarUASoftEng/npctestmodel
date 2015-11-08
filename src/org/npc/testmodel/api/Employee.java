package org.npc.testmodel.api;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;
//import org.npc.testmodel.enums.;

public class Employee {
	
	protected UUID r_id;
	public UUID getR_ID()
	{
		return this.r_id;
	}
	
	private String firstName;
	public String getFirstName()
	{
		return this.firstName;
	}
	
	public Employee setFirstName(String firstName)
	{
		this.firstName = firstName;
		return this;
	}
	
	private String lastName;
    public String getLastName()
    {
    	return this.lastName;
    }
	
    public Employee setLastName(String lastName)
    {
    	this.lastName = lastName;
    	return this;
    }
    
	private int employeeID;
	public int getEmployeeID()
	{
		return this.employeeID; 
	}
	
	public Employee setEmployeeID(int employeeID)
	{
		this.employeeID = employeeID;
		return this;
	}
	
	private String active;
	public String getActive()
	{
		return this.active;
	}
	
	public Employee setActive(String active)
	{
		this.active = active;
		return this;
	}
	
	private String classification;
	public String getClassification()
	{
		return this.classification;
	}
	
	public Employee setClassification(String classification)
	{
		this.classification = classification;
		return this;
	}

	private String manager;
	public String getManager()
	{
		return manager;
	}
	
	public Employee setManager(String manager)
	{
		this.manager = manager;
		return this;
	}
	
	private String password;
	public String getPassword()
	{
		return password;
	}
	
	public Employee setPassword(String password)
	{
		this.password = password;
		return this;
	}
	
	//need to implement EmployeeApiRequestStatus
	
	private String apiRequestMessage;
	public String getApiRequestMessage(){
		return this.apiRequestMessage;
	}
	
	public Employee setApiRequestMessage(String apiRequestMessage)
	{
		this.apiRequestMessage = apiRequestMessage;
		return this;
	}
	
	public Employee()
	{
		this.r_id = UUID.randomUUID();
		this.firstName = "";
		this.lastName = "";
		this.employeeID = 0;
		this.active = "";
		this.classification = "";
		this.manager = "";
		this.password = "";
	}
}
