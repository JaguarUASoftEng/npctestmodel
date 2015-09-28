package org.npc.testmodel.api;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TransactionEntryListing {
	private List<TransactionEntry> transactionEntries;
	public List<TransactionEntry> getTransactionEntries() {
		return this.transactionEntries;
	}
	public ProductListing setTransactionEntries(List<TransactionEntry> transactionEntries) {
		this.transactionEntries = transactionEntries;
		return this;
	}
	public TransactionEntryListing addTransactionEntry(TransactionEntry transactionEntries) {
		this.transactionEntries.add(transactionEntries);
		return this;
	}
	
	public TransactionEntryListing() {
		this.transactionEntries = new LinkedList<TransactionEntry>();
	}
}
