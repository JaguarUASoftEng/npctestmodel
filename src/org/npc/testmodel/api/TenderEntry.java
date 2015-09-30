package org.npc.testmodel.api;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;
import org.npc.testmodel.enums.ProductApiRequestStatus;

@XmlRootElement
public class TenderEntry
{
	protected UUID id;
	private int transactionID;
	private String tenderType;
	private double amount;
	private LocalDateTime createdOn;
	private ProductApiRequestStatus apiRequestStatus;
	private String apiRequestMessage;
	
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
	
	public ProductApiRequestStatus getApiRequestStatus()
	{
		return this.apiRequestStatus;
	}
	
	public TenderEntry setApiRequestStatus(ProductApiRequestStatus apiRequestStatus)
	{
		if (this.apiRequestStatus != apiRequestStatus)
		{
			this.apiRequestStatus = apiRequestStatus;
		}
		return this;
	}
	
	public String getApiRequestMessage()
	{
		return this.apiRequestMessage;
	}
	
	public TenderEntry setApiRequestMessage(String apiRequestMessage)
	{
		if (!StringUtils.equalsIgnoreCase(this.apiRequestMessage, apiRequestMessage))
		{
			this.apiRequestMessage = apiRequestMessage;
		}
		return this;
	}

	public TenderEntry()
	{
		this.id = UUID.randomUUID();
		this.tenderType = StringUtils.EMPTY;
		this.amount = -1.0;
		this.transactionID = -1;
		this.createdOn = LocalDateTime.now();
		this.apiRequestMessage = StringUtils.EMPTY;
		this.apiRequestStatus = ProductApiRequestStatus.OK;
	}
	
	public TenderEntry(org.npc.testmodel.models.TenderEntry modelTenderEntry)
	{
		this.id = modelTenderEntry.getId();
		this.tenderType = modelTenderEntry.getLookupCode();
		this.amount = modelTenderEntry.getPrice();
		this.transactionID = modelTenderEntry.getTransactionID;
		this.createdOn = modelTenderEntry.getCreatedOn();
		this.apiRequestMessage = StringUtils.EMPTY;
		this.apiRequestStatus = ProductApiRequestStatus.OK;
	}
}
