package org.npc.testmodel.models;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Map;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.apache.commons.lang3.StringUtils;
import org.npc.testmodel.models.fieldnames.TenderEntryFieldNames;
import org.npc.testmodel.repositories.TenderEntryRepository;
import org.npc.dataaccess.model.BaseModel;

public class TenderEntry extends BaseModel<TenderEntry>
{
	private UUID transactionID;
	private String tenderType;
	private double amount;
	private LocalDateTime createdOn;
	
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException
	{
		this.id = (UUID) rs.getObject(TenderEntryFieldNames.ID);
		this.transactionID = (UUID) rs.getObject(TenderEntryFieldNames.TRANSACTION_ID);
		this.tenderType = rs.getString(TenderEntryFieldNames.TENDER_TYPE);
		this.amount = rs.getDouble(TenderEntryFieldNames.AMOUNT);
		this.createdOn = rs.getTimestamp(TenderEntryFieldNames.CREATED_ON).toLocalDateTime();
	}
	
	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record)
	{
		record.put(TenderEntryFieldNames.ID, this.id);
		record.put(TenderEntryFieldNames.TRANSACTION_ID, this.transactionID);
		record.put(TenderEntryFieldNames.TENDER_TYPE, this.tenderType);
		record.put(TenderEntryFieldNames.AMOUNT, this.amount);
		record.put(TenderEntryFieldNames.CREATED_ON, Timestamp.valueOf(this.createdOn));
		
		return record;
	}
	
	public UUID getId()
	{
		return this.id;
	}
	
	public TenderEntry setId(UUID id)
	{
		this.id = id;
		return this;
	}
	
	public UUID getTransactionID()
	{
		return this.transactionID;
	}
	
	public TenderEntry setTransactionID(UUID transactionID)
	{
		if (!this.transactionID.toString().equals(transactionID.toString()))
		{
			this.transactionID = UUID.fromString(transactionID.toString());
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
	
	public TenderEntry()
	{
		super(new TenderEntryRepository());
		
		
	}

}
