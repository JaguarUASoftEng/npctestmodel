package org.npc.testmodel.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.npc.dataaccess.model.BaseModel;
import org.npc.testmodel.models.fieldnames.TransactionEntryFieldNames;
import org.npc.testmodel.repositories.TransactionEntryRepository;

public class TransactionEntry extends BaseModel<TransactionEntry> {
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.recordID = rs.getLong(TransactionEntryFieldNames.RECORD_ID);
		this.transactionID = rs.getLong(TransactionEntryFieldNames.TRANSACTION_ID);
		this.productID = rs.getLong(TransactionEntryFieldNames.PRODUCT_ID);
		this.price = rs.getFloat(TransactionEntryFieldNames.PRICE);
		this.quantity = rs.getInt(TransactionEntryFieldNames.QUANTITY);
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(TransactionEntryFieldNames.PRODUCT_ID, this.productID);
		record.put(TransactionEntryFieldNames.TRANSACTION_ID, this.transactionID);
		record.put(TransactionEntryFieldNames.RECORD_ID, this.recordID);
		record.put(TransactionEntryFieldNames.PRICE, this.price);
		record.put(TransactionEntryFieldNames.QUANTITY, this.quantity);
		
		return record;
	}

	private long recordID;
	public long getRecordID() {
		return this.recordID;
	}
	public TransactionEntry setRecordID(long recordID) {
		if (this.recordID != recordID) {
			this.recordID = recordID;
			this.propertyChanged(TransactionEntryFieldNames.RECORD_ID);
		}
		
		return this;
	}

	private long transactionID;
	public long getTransactionID() {
		return this.transactionID;
	}
	public TransactionEntry setTransactionID(long transactionID) {
		if (this.transactionID != transactionID) {
			this.transactionID = transactionID;
			this.propertyChanged(TransactionEntryFieldNames.TRANSACTION_ID);
		}
		
		return this;
	}	
	
	private long productID;
	public long getProductID() {
		return this.productID;
	}
	public TransactionEntry setProductID(long productID){
		if(this.productID != productID){
			this.productID = productID;
			this.propertyChanged(TransactionEntryFieldNames.PRODUCT_ID);
		}
		
		return this;
	}
	
	private float price;
	public float getPrice(){
		return this.price;
	}
	public TransactionEntry setPrice(float price){
		if(this.price != price){
			this.price = price;
			this.propertyChanged(TransactionEntryFieldNames.PRICE);
		}
		
		return this;
	}
	
	private int quantity;
	public int getQuantity(){
		return this.quantity;
	}
	public TransactionEntry setQuantity(int quantity){
		if(this.quantity != quantity){
			this.quantity = quantity;
			this.propertyChanged(TransactionEntryFieldNames.QUANTITY);
		}
		
		return this;
	}
	
	public org.npc.testmodel.api.TransactionEntry synchronize(org.npc.testmodel.api.TransactionEntry apiTransactionEntry) {
		this.setProductID(apiTransactionEntry.getProductID());
		this.setTransactionID(apiTransactionEntry.getTransactionID());
		this.setRecordID(apiTransactionEntry.getRecordID());
		this.setPrice(apiTransactionEntry.getPrice());
		this.setQuantity(apiTransactionEntry.getQuantity());
		
		return apiTransactionEntry;
	}
	
	public TransactionEntry() {
		super(new TransactionEntryRepository());
		
		this.productID = -1;
		this.transactionID = -1;
		this.recordID = -1;
		this.price = -1;
		this.quantity = -1;
	}
	
	public TransactionEntry(UUID id) {
		super(id, new TransactionEntryRepository());
		
		this.productID = -1;
		this.transactionID = -1;
		this.recordID = -1;
		this.price = -1;
		this.quantity = -1;
	}

	public TransactionEntry(org.npc.testmodel.api.TransactionEntry apiTransactionEntry) {
		super(apiTransactionEntry.getId(), new TransactionEntryRepository());
		
		this.productID = apiTransactionEntry.getProductID();
		this.transactionID = apiTransactionEntry.getTransactionID();
		this.recordID = apiTransactionEntry.getRecordID();
		this.price = apiTransactionEntry.getPrice();
		this.quantity = apiTransactionEntry.getQuantity();
	}
}
