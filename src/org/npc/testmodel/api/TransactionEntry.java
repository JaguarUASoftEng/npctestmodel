package org.npc.testmodel.api;

import java.util.UUID;
import org.npc.testmodel.enums.TransactionEntryApiRequestStatus;
import org.apache.commons.lang3.StringUtils;


public class TransactionEntry{
	
	protected UUID id;
	public UUID getId(){
		return this.id;
	}
	
	public TransactionEntry setId(UUID id){
		this.id = id;
		
		return this;
	}

	private int recordID;
	public int getRecordID() {
		return this.recordID;
	}
	public TransactionEntry setRecordID(int recordID) {
		if (this.recordID != recordID) {
			this.recordID = recordID;
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
		}
		
		return this;
	}	
	
	private UUID productID;
	public UUID getProductID() {
		return this.productID;
	}
	public TransactionEntry setProductID(UUID productID){
		if(!this.productID.equals(productID)){
			this.productID = UUID.fromString(productID.toString());
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
		}
		
		return this;
	}
	
	private TransactionEntryApiRequestStatus apiRequestStatus;
	public TransactionEntryApiRequestStatus getApiRequestStatus() {
		return this.apiRequestStatus;
	}
	public TransactionEntry setApiRequestStatus(TransactionEntryApiRequestStatus apiRequestStatus) {
		if (this.apiRequestStatus != apiRequestStatus) {
			this.apiRequestStatus = apiRequestStatus;
		}
		
		return this;
	}
	
	private String apiRequestMessage;
	public String getApiRequestMessage() {
		return this.apiRequestMessage;
	}
	public TransactionEntry setApiRequestMessage(String apiRequestMessage) {
		if (!StringUtils.equalsIgnoreCase(this.apiRequestMessage, apiRequestMessage)) {
			this.apiRequestMessage = apiRequestMessage;
		}
		
		return this;
	}	
	
	public TransactionEntry() {
		
		this.id = UUID.randomUUID();
		this.productID = UUID.randomUUID();
		this.transactionID = -1;
		this.recordID = -1;
		this.price = -1;
		this.quantity = -1;
		this.apiRequestMessage = StringUtils.EMPTY;
		this.apiRequestStatus = TransactionEntryApiRequestStatus.OK;
		
	}

	public TransactionEntry(org.npc.testmodel.models.TransactionEntry modelTransactionEntry) {
				
		this.id = modelTransactionEntry.getId();		
		this.productID = UUID.fromString(modelTransactionEntry.getProductID().toString());
		this.transactionID = modelTransactionEntry.getTransactionID();
		this.recordID = modelTransactionEntry.getRecordID();
		this.price = modelTransactionEntry.getPrice();
		this.quantity = modelTransactionEntry.getQuantity();
		this.apiRequestMessage = StringUtils.EMPTY;
		this.apiRequestStatus = TransactionEntryApiRequestStatus.OK;
		
	}
}