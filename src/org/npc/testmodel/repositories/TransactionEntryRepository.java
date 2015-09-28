package org.npc.testmodel.repositories;

import java.sql.SQLException;

import org.npc.dataaccess.repository.BaseRepository;
import org.npc.dataaccess.repository.DatabaseTable;
import org.npc.dataaccess.repository.helpers.PostgreFunctionType;
import org.npc.dataaccess.repository.helpers.SQLComparisonType;
import org.npc.dataaccess.repository.helpers.where.WhereClause;
import org.npc.dataaccess.repository.helpers.where.WhereContainer;
import org.npc.testmodel.models.TransactionEntry;
import org.npc.testmodel.models.fieldnames.TransactionEntryFieldNames;
import org.npc.testmodel.repositories.interfaces.TransactionEntryRepositoryInterface;

public class TransactionEntryRepository extends BaseRepository<TransactionEntry> implements TransactionEntryRepositoryInterface {
	@Override
	public TransactionEntry byRecordID(long recordID) {
		return this.firstOrDefaultWhere(
			new WhereContainer(
				(new WhereClause()).
					postgreFunction(PostgreFunctionType.LOWER).
					table(this.primaryTable).
					fieldName(TransactionEntryFieldNames.RECORD_ID).
					comparison(SQLComparisonType.EQUALS)
			),
			(ps) -> {
				try {
					ps.setObject(1, recordID);
				} catch (SQLException e) {}

				return ps;
			}
		);
	}
	
	@Override
	public TransactionEntry createOne() {
		return new TransactionEntry();
	}
	
	public TransactionEntryRepository() {
		super(DatabaseTable.TRANSACTIONENTRY);
	}
}
