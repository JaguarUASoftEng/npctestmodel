package org.npc.testmodel.api;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TenderEntryListing
{
	private List<TenderEntry> entries;
	
	public List<TenderEntry> getEntries()
	{
		return this.entries;
	}
	
	public TenderEntryListing setEntries(List<TenderEntry> entries)
	{
		this.entries = entries;
		return this;
	}
	
	public TenderEntryListing addEntry(TenderEntry entry)
	{
		this.entries.add(entry);
		return this;
	}
	
	public TenderEntryListing()
	{
		this.entries = new LinkedList<TenderEntry>();
	}
}
