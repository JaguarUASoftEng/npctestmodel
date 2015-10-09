package org.npc.testmodel.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import org.npc.dataaccess.model.BaseModel;
import org.npc.testmodel.models.fieldnames.TransactionEntryFieldNames;
import org.npc.testmodel.repositories.TransactionEntryRepository;

public class TransactionEntry extends BaseModel<TransactionEntry> {
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.recordID = rs.getInt(TransactionEntryFieldNames.RECORD_ID);
		this.transactionID = rs.getInt(TransactionEntryFieldNames.TRANSACTION_ID);
		this.productID = (UUID)rs.getObject(TransactionEntryFieldNames.PRODUCT_ID);
		this.price = rs.getDouble(TransactionEntryFieldNames.PRICE);
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

	private int recordID;
	public int getRecordID() {
		return this.recordID;
	}
	public TransactionEntry setRecordID(int recordID) {
		if (this.recordID != recordID) {
			this.recordID = recordID;
			this.propertyChanged(TransactionEntryFieldNames.RECORD_ID);
		}
		
		return this;
	}

	private int transactionID;
	public int getTransactionID() {
		return this.transactionID;
	}
	public TransactionEntry setTransactionID(int transactionID) {
		if (this.transactionID != transactionID) {
			this.transactionID = transactionID;
			this.propertyChanged(TransactionEntryFieldNames.TRANSACTION_ID);
		}
		
		return this;
	}	
	
	private UUID productID;
	public UUID getProductID() {
		return this.productID;
	}
	public TransactionEntry setProductID(UUID productID){
		if(!(this.productID.equals(productID)))
		{
			this.productID = UUID.fromString(productID.toString());
			this.propertyChanged(TransactionEntryFieldNames.PRODUCT_ID);
		}
		
		return this;
	}
	
	private double price;
	public double getPrice(){
		return this.price;
	}
	public TransactionEntry setPrice(double price){
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
		
		this.productID = UUID.randomUUID();
		this.transactionID = -1;
		this.recordID = -1;
		this.price = -1;
		this.quantity = -1;
	}
	
	public TransactionEntry(UUID id) {
		super(id, new TransactionEntryRepository());
		
		this.productID = UUID.randomUUID();
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
