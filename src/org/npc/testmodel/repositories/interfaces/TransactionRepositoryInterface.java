package org.npc.testmodel.repositories.interfaces;

import org.npc.dataaccess.repository.BaseRepositoryInterface;
import org.npc.testmodel.models.Transaction;

public interface TransactionRepositoryInterface extends BaseRepositoryInterface<Transaction>{
	Transaction byColumnId(int columnID);
}
