package org.npc.testmodel.repositories;

import java.sql.SQLException;

import org.npc.dataaccess.repository.BaseRepository;
import org.npc.dataaccess.repository.DatabaseTable;
import org.npc.dataaccess.repository.helpers.PostgreFunctionType;
import org.npc.dataaccess.repository.helpers.SQLComparisonType;
import org.npc.dataaccess.repository.helpers.where.WhereClause;
import org.npc.dataaccess.repository.helpers.where.WhereContainer;
import org.npc.testmodel.models.Product;
import org.npc.testmodel.models.fieldnames.ProductFieldNames;
import org.npc.testmodel.repositories.interfaces.ProductRepositoryInterface;

public class ProductRepository extends BaseRepository<Product> implements ProductRepositoryInterface {
	public Product byLookupCode(String lookupCode) {
		return this.firstOrDefaultWhere(
			new WhereContainer(
				(new WhereClause()).
					postgreFunction(PostgreFunctionType.LOWER).
					table(this.primaryTable).
					fieldName(ProductFieldNames.LOOKUP_CODE).
					comparison(SQLComparisonType.EQUALS)
			),
			(ps) -> {
				try {
					ps.setObject(1, lookupCode.toLowerCase());
				} catch (SQLException e) {}

				return ps;
			}
		);
	}
	
	@Override
	public Product createOne() {
		return new Product();
	}
	
	public ProductRepository() {
		super(DatabaseTable.PRODUCT);
	}
}
