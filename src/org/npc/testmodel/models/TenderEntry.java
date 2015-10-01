package org.npc.testmodel.models;

import java.time.LocalDateTime;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.npc.testmodel.api.TenderEntry;
import org.npc.dataaccess.model.BaseModel;

public class TenderEntry extends BaseModel<TenderEntry>
{
	private int transactionID;
	private String tenderType;
	private double amount;
	private LocalDateTime createdOn;
	
	public UUID getId()
	{
		return this.id;
	}
	
	public TenderEntry setId(UUID id)
	{
		this.id = id;
		return this;
	}
	
	public int getTransactionID()
	{
		return this.transactionID;
	}
	
	public TenderEntry setTransactionID(int transactionID)
	{
		if (this.transactionID != transactionID)
		{
			this.transactionID = transactionID;
		}
		return this;
	}
	
	public String getTenderType()
	{
		return this.tenderType;
	}
	
	public TenderEntry setTenderEntry(String tenderType)
	{
		if (!StringUtils.equals(this.tenderType, tenderType))
		{
			this.tenderType = tenderType;
		}
		return this;
	}
	
	public double getAmount()
	{
		return this.amount;
	}
	
	public TenderEntry setAmount(double amount)
	{
		if (!(this.amount == amount))
		{
			this.amount = amount;
		}
		return this;
	}

	public LocalDateTime getCreatedOn()
	{
		return this.createdOn;
	}
	
	public TenderEntry setCreatedOn(LocalDateTime date)
	{
		if (!(this.createdOn.isEqual(date)))
		{
			this.createdOn = LocalDateTime.of(date.toLocalDate(), date.toLocalTime());
		}
		return this;
	}

}
