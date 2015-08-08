package org.npc.testmodel.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.npc.dataaccess.model.BaseModel;
import org.npc.testmodel.models.fieldnames.ProductFieldNames;
import org.npc.testmodel.repositories.ProductRepository;

public class Product extends BaseModel<Product> {
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.lookupCode = rs.getString(ProductFieldNames.LOOKUP_CODE);
		this.count = rs.getInt(ProductFieldNames.COUNT);
		this.createdOn = rs.getTimestamp(ProductFieldNames.CREATED_ON).toLocalDateTime();
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(ProductFieldNames.LOOKUP_CODE, this.lookupCode);
		record.put(ProductFieldNames.COUNT, this.count);
		record.put(ProductFieldNames.CREATED_ON, Timestamp.valueOf(this.createdOn));
		
		return record;
	}

	private String lookupCode;
	public String getLookupCode() {
		return this.lookupCode;
	}
	public Product setLookupCode(String lookupCode) {
		if (!StringUtils.equals(this.lookupCode, lookupCode)) {
			this.lookupCode = lookupCode;
			this.propertyChanged(ProductFieldNames.LOOKUP_CODE);
		}
		
		return this;
	}

	private int count;
	public int getCount() {
		return this.count;
	}
	public Product setCount(int count) {
		if (this.count != count) {
			this.count = count;
			this.propertyChanged(ProductFieldNames.COUNT);
		}
		
		return this;
	}

	private LocalDateTime createdOn;
	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}
	
	public org.npc.testmodel.api.Product synchronize(org.npc.testmodel.api.Product apiProduct) {
		this.setCount(apiProduct.getCount());
		this.setLookupCode(apiProduct.getLookupCode());
		
		apiProduct.setCreatedOn(this.createdOn);
		
		return apiProduct;
	}
	
	public Product() {
		super(new ProductRepository());
		
		this.count = -1;
		this.lookupCode = StringUtils.EMPTY;
		this.createdOn = LocalDateTime.now();
	}
	
	public Product(UUID id, String connectionString) {
		super(id, new ProductRepository());
		
		this.count = -1;
		this.lookupCode = StringUtils.EMPTY;
		this.createdOn = LocalDateTime.now();
	}

	public Product(org.npc.testmodel.api.Product apiProduct) {
		super(apiProduct.getId(), new ProductRepository());
		
		this.count = apiProduct.getCount();
		this.lookupCode = apiProduct.getLookupCode();

		this.createdOn = LocalDateTime.now();
	}
}
