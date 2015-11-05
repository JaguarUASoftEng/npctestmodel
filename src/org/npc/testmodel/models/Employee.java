package org.npc.testmodel.models;

import java.util.UUID;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.commons.lang3.StringUtils;
import org.npc.testmodel.enums.ProductApiRequestStatus;

@XmlRootElement
public class Employee
{
	protected UUID r_id;
	private String fname;
	private String lname;
	private int e_id;
	private String active;
	private String classification;
	private String manager;
	private String password;
	//not sure how to add timestamp for created on
	
	public UUID getR_ID()
	{
		return this.r_id;
	}

	public Employee setR_ID(UUID r_id)
	{
		this.r_id = r_id;
		return this;
	}
	
		public String getFName()
	{
		return this.fname;
	}

	public Employee setFName(String fname)
	{
		if (!StringUtils.equals(this.fname, fname))
		{
			this.fname = fname;
		}
		return this;
	}
	
		public String getLName()
	{
		return this.lname;
	}

	public Employee setLName(String lname)
	{
		if (!StringUtils.equals(this.lname, lname))
		{
			this.lname = lname;
		}
		return this;
	}
	
		public int getE_ID()
	{
		return this.e_id;
	}

	public Employee setE_ID(int e_id)
	{
		if (this.e_id != e_id)
		{
			this.e_id = e_id;
		}
		return this;
	}
	
	public String getActive()
	{
		return this.active;
	}

	public Employee setActive(String active)
	{
		if (!StringUtils.equals(this.active, active))
		{
			this.active = active;
		}
		return this;
	}
	
	public String getClassification()
	{
		return this.classification;
	}

	public Employee setClassification(String classification)
	{
		if (!StringUtils.equals(this.classification, classification))
		{
			this.classification = classification;
		}
		return this;
	}
	
	public String getManager()
	{
		return this.manager;
	}

	public Employee setManager(String manager)
	{
		if (!StringUtils.equals(this.manager, manager))
		{
			this.manager = manager;
		}
		return this;
	}
	
	public String getPassword()
	{
		return this.password;
	}

	public Employee setPassword(String passsword)
	{
		if (!StringUtils.equals(this.password, passsword))
		{
			this.password = password;
		}
		return this;
	}
	
	/*public Employee setApiRequestMessage(String apiRequestMessage)
	{
		if (!StringUtils.equalsIgnoreCase(this.apiRequestMessage, apiRequestMessage))
		{
			this.apiRequestMessage = apiRequestMessage;
		}
		return this;
	}*/
	
	public Employee()
	{
		this.r_id = UUID.randomUUID();
		this.fname = "";
		this.lname = "";
		this.e_id = -1;
		this.active = "";
		this.classification = "";
		this.manager = "";
		this.password = "";
	}
	
	public Employee(org.npc.testmodel.models.Employee modelEmployee)
	{
		this.r_id = modelEmployee.getR_ID();
		this.fname = modelEmployee.getFName();
		this.lname = modelEmployee.getLName();
		this.e_id = modelEmployee.getE_ID();
		this.active = modelEmployee.getActive();
		this.classification = modelEmployee.getClassification();
		this.manager = modelEmployee.getManager();
		this.password = modelEmployee.getPassword();
		/*this.apiRequestMessage = StringUtils.EMPTY;
		this.apiRequestStatus = ProductApiRequestStatus.OK;
		*/
	}
	
}	