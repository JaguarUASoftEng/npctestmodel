package org.npc.testmodel.api;

import java.util.UUID;
import org.npc.testmodel.enums.TransactionEntryApiRequestStatus;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.commons.lang3.StringUtils;


public class TransactionEntry extends BaseModel<TransactionEntry> {
	
	protected UUID id;
	public UUID getId(){
		return this.id;
	}
	public TransactionEntry setId(UUID id){
		this.id = id;
		
		return this;
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
			this.transactionID = transactionID
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
		this.productID = -1;
		this.transactionID = -1;
		this.recordID = -1;
		this.price = -1;
		this.quantity = -1;
		this.apiRequestMessage = StringUtils.EMPTY;
		this.apiRequestStatus = TransactionEntryApiRequestStatus.OK;
		
	}

	public TransactionEntry(org.npc.testmodel.models.TransactionEntry modelTransactionEntry) {
				
		this.id = modelTransactionEntry.getId();		
		this.productID = modelTransactionEntry.getProductID();
		this.transactionID = modelTransactionEntry.getTransactionID();
		this.recordID = modelTransactionEntry.getRecordID();
		this.price = modelTransactionEntry.getPrice();
		this.quantity = modelTransactionEntry.getQuantity();
		this.apiRequestMessage = StringUtils.EMPTY;
		this.apiRequestStatus = TransactionEntryApiRequestStatus.OK;
		
	}
}