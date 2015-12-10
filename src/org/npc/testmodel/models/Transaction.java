package org.npc.testmodel.models;

import java.util.Map;
import java.util.UUID;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.bind.annotation.XmlRootElement;
import org.apache.commons.lang3.StringUtils;
import org.npc.testmodel.enums.ProductApiRequestStatus;

import org.npc.dataaccess.model.BaseModel;
import org.npc.testmodel.models.fieldnames.TransactionFieldNames;
import org.npc.testmodel.repositories.TransactionRepository;

@XmlRootElement
public class Transaction extends BaseModel<Transaction>
{
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException{
		this.amount = rs.getInt(TransactionFieldNames.AMOUNT);
		this.r_id = (UUID) rs.getObject(TransactionFieldNames.R_ID);
		this.c_id = rs.getInt(TransactionFieldNames.C_ID);
		this.transactiontype = rs.getString(TransactionFieldNames.TRANSACTIONTYPE);
		
	}
	
	@Override
	protected Map<String,Object> fillRecord(Map<String,Object> record){
		record.put(TransactionFieldNames.AMOUNT, this.amount);
		record.put(TransactionFieldNames.R_ID, this.r_id);
		record.put(TransactionFieldNames.C_ID,this.c_id);
		record.put(TransactionFieldNames.TRANSACTIONTYPE, this.transactiontype);
		
		return record;
	}
	
	protected UUID r_id;
	private int c_id;
	private int amount;
	private String transactiontype;
	//not sure how to add timestamp for created on
	
		public UUID getR_ID()
	{
		return this.r_id;
	}

	public Transaction setR_ID(UUID r_id)
	{
		this.r_id = r_id;
		return this;
	}
	
	public int getC_ID()
	{
		return this.c_id;
	}

	public Transaction setC_ID(int c_id)
	{
		if (this.c_id != c_id)
		{
			this.c_id = c_id;
		}
		return this;
	}
	
	public int getAmount()
	{
		return this.amount;
	}

	public Transaction setAmount(int amount)
	{
		if (this.amount != amount)
		{
			this.amount = amount;
		}
		return this;
	}
	
	public String getTransactionType()
	{
		return this.transactiontype;
	}

	public Transaction setTransactionType(String transactiontype)
	{
		if (!StringUtils.equals(this.transactiontype, transactiontype))
		{
			this.transactiontype = transactiontype;
		}
		return this;
	}
	
	/*public Transaction setApiRequestMessage(String apiRequestMessage)
	{
		if (!StringUtils.equalsIgnoreCase(this.apiRequestMessage, apiRequestMessage))
		{
			this.apiRequestMessage = apiRequestMessage;
		}
		return this;
	}*/	
	
	public Transaction(UUID id)
	{
		super(id, new TransactionRepository());
		
		this.r_id = UUID.randomUUID();
		this.c_id = -1;
		this.amount = -1;
		this.transactiontype = StringUtils.EMPTY;
	}
	
	public Transaction(org.npc.testmodel.api.Transaction modelTransaction)
	{
		super(modelTransaction.getR_ID(), new TransactionRepository());
		
		this.r_id = modelTransaction.getR_ID();
		this.c_id = modelTransaction.getC_ID();
		this.amount = modelTransaction.getAmount();
		this.transactiontype = modelTransaction.getTransactionType();
		//this.apiRequestMessage = StringUtils.EMPTY;
		//this.apiRequestStatus = ProductApiRequestStatus.OK;
	}
}