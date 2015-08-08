package org.npc.testmodel.repositories.interfaces;

import org.npc.dataaccess.repository.BaseRepositoryInterface;
import org.npc.testmodel.models.Product;

public interface ProductRepositoryInterface extends BaseRepositoryInterface<Product> {
	Product byLookupCode(String lookupCode);
}
