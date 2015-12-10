package org.npc.testmodel.repositories;

import java.sql.SQLException;
import java.util.UUID;

import org.npc.dataaccess.repository.BaseRepository;
import org.npc.dataaccess.repository.DatabaseTable;
import org.npc.dataaccess.repository.helpers.PostgreFunctionType;
import org.npc.dataaccess.repository.helpers.SQLComparisonType;
import org.npc.dataaccess.repository.helpers.where.WhereClause;
import org.npc.dataaccess.repository.helpers.where.WhereContainer;
import org.npc.testmodel.models.Transaction;
import org.npc.testmodel.models.fieldnames.TransactionFieldNames;
import org.npc.testmodel.repositories.interfaces.TransactionRepositoryInterface;


public class TransactionRepository extends BaseRepository<Transaction> implements TransactionRepositoryInterface{
	@Override
	public Transaction byColumnId(int columnID){
		return this.firstOrDefaultWhere(new WhereContainer(
				(new WhereClause()).
				postgreFunction(PostgreFunctionType.LOWER).
				table(this.primaryTable).
				fieldName(TransactionFieldNames.C_ID).
				comparison(SQLComparisonType.EQUALS)
				),
				(ps) -> {
					try{
						ps.setObject(1, columnID);
					} catch (SQLException e){}
				
					return ps;
				}
				);	
		}
	
	@Override
	public Transaction createOne(){
		return new Transaction(new UUID(5, 0));
	}
	
	public TransactionRepository(){
		super(DatabaseTable.TRANSACTION);
	}
}