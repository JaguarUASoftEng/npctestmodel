package org.npc.testmodel.repositories.interfaces;

import org.npc.dataaccess.repository.BaseRepositoryInterface;
import org.npc.testmodel.models.TransactionEntry;

public interface TransactionEntryRepositoryInterface extends BaseRepositoryInterface<TransactionEntry> {
	TransactionEntry byRecordID(long recordID);
}
