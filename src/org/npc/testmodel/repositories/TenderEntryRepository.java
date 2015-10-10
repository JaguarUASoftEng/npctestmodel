package org.npc.testmodel.repositories;

import org.npc.dataaccess.repository.BaseRepository;
import org.npc.dataaccess.repository.DatabaseTable;
import org.npc.testmodel.models.TenderEntry;

public class TenderEntryRepository extends BaseRepository<TenderEntry>
{
	@Override
	public TenderEntry createOne() {
		return new TenderEntry();
	}
	
	public TenderEntryRepository() {
		super(DatabaseTable.TENDERENTRY);
	}
}
