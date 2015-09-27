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
		this.id = (UUID)rs.getObject(ProductFieldNames.ID);
		this.Description = rs.getString(ProductFieldNames.DESCRIPTION);
		this.lookupCode = rs.getString(ProductFieldNames.LOOKUP_CODE);
		this.Price = rs.getDouble(ProductFieldNames.PRICE);
		this.ItemType = rs.getInt(ProductFieldNames.ITEM_TYPE);
		this.Cost = rs.getDouble(ProductFieldNames.COST);
		this.Quantity = rs.getInt(ProductFieldNames.QUANTITY);
		this.ReorderPoint = rs.getInt(ProductFieldNames.REORDER_POINT);
		this.RestockLevel = rs.getInt(ProductFieldNames.RESTOCK_LEVEL);
		this.ParentItem = rs.getInt(ProductFieldNames.PARENT_ITEM);
		this.ExtendedDescription = rs.getString(ProductFieldNames.EXTENDED_DESCRIPTION);
		this.Active = rs.getInt(ProductFieldNames.ACTIVE);
		this.MSRP = rs.getDouble(ProductFieldNames.MSRP);
		this.createdOn = rs.getTimestamp(ProductFieldNames.CREATED_ON).toLocalDateTime();
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(ProductFieldNames.ID, this.id);
		record.put(ProductFieldNames.DESCRIPTION, this.Description);
		record.put(ProductFieldNames.LOOKUP_CODE, this.lookupCode);
		record.put(ProductFieldNames.PRICE, this.Price);
		record.put(ProductFieldNames.ITEM_TYPE, this.ItemType);
		record.put(ProductFieldNames.COST, this.Cost);
		record.put(ProductFieldNames.QUANTITY, this.Quantity);
		record.put(ProductFieldNames.REORDER_POINT, this.ReorderPoint);
		record.put(ProductFieldNames.RESTOCK_LEVEL, this.RestockLevel);
		record.put(ProductFieldNames.PARENT_ITEM, this.ParentItem);
		record.put(ProductFieldNames.EXTENDED_DESCRIPTION, this.ExtendedDescription);
		record.put(ProductFieldNames.ACTIVE, this.Active);
		record.put(ProductFieldNames.MSRP, this.MSRP);
		record.put(ProductFieldNames.CREATED_ON, Timestamp.valueOf(this.createdOn));
		
		return record;
	}
	
	private String Description;
	public String getDescription(){
		return this.Description;
	}
	public Product setDescription(String Description){
		if(!StringUtils.equals(this.Description,Description)){
			this.Description = Description;
			this.propertyChanged(ProductFieldNames.DESCRIPTION);
		}
		return this;
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
	
	private double Price;
	public double getPrice(){
		return this.Price;
	}
	public Product setPrice(double Price){
		if(!(this.Price == Price))
		{
			this.Price = Price;
			this.propertyChanged(ProductFieldNames.PRICE);
		}
		return this;
	}
	
	private int ItemType;
	public int getItemType(){
		return this.ItemType;
	}
	public Product setItemType(int ItemType){
		if(!(this.ItemType == ItemType)){
			this.ItemType = ItemType;
			this.propertyChanged(ProductFieldNames.ITEM_TYPE);
		}
		return this;
	}
	
	private double Cost;
	public double getCost(){
		return this.Cost;
	}
	public Product setCost(double Cost){
		if(!(this.Cost == Cost))
		{
			this.Cost = Cost;
			this.propertyChanged(ProductFieldNames.COST);
		}
		return this;
	}
	
	private int Quantity;
	public int getQuantity(){
		return this.Quantity;
	}
	public Product setQuantity(int Quantity){
		if(!(this.Quantity == Quantity))
		{
			this.Quantity = Quantity;
			this.propertyChanged(ProductFieldNames.QUANTITY);
		}
		return this;
	}
	
	private int ReorderPoint;
	public int getReorderPoint(){
		return this.ReorderPoint;
	}
	public Product setReorderPoint(int ReorderPoint)
	{
		if(!(this.ReorderPoint == ReorderPoint))
		{
			this.ReorderPoint = ReorderPoint;
			this.propertyChanged(ProductFieldNames.REORDER_POINT);
		}
		return this;
	}
	
	private int RestockLevel;
	public int getRestockLevel(){
		return this.RestockLevel;
	}
	public Product setRestockLevel(int RestockLevel){
		if(!(this.RestockLevel == RestockLevel))
		{
			this.RestockLevel = RestockLevel;
			this.propertyChanged(ProductFieldNames.RESTOCK_LEVEL);
		}
		return this;
	}
	
	private int ParentItem;
	public int getParentItem(){
		return this.ParentItem;
	}
	//Not sure if this should be changed
	//must come back and confirm
	public Product setParentItem(int ParentItem){
		if(!(this.ParentItem == ParentItem))
		{
			this.ParentItem = ParentItem;
			this.propertyChanged(ProductFieldNames.PARENT_ITEM);
		}
		return this;
	}
	
	private String ExtendedDescription;
	public String getExtendedDescription(){
		return ExtendedDescription;
	}
	public Product setExtendedDescription(String ExtendedDescription){
		if(!(this.ExtendedDescription.equals(ExtendedDescription)))
		{
			this.ExtendedDescription = ExtendedDescription;
			this.propertyChanged(ProductFieldNames.EXTENDED_DESCRIPTION);
		}
		return this;
	}
	
	private int Active;
	public int getActive(){
		return Active;
	}
	public Product setActive(int Active){
		if(!(this.Active == Active))
		{
			this.Active = Active;
			this.propertyChanged(ProductFieldNames.ACTIVE);
		}
		return this;
	}

	private double MSRP;
	public double getMSRP(){
		return MSRP;
	}
	public Product setMSRP(double MSRP){
		if(!(this.MSRP == MSRP))
		{
			this.MSRP = MSRP;
			this.propertyChanged(ProductFieldNames.MSRP);
		}
		return this;
	}

	private LocalDateTime createdOn;
	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}
	
	public Product setCreatedOn(LocalDateTime date)
	{
		if(!(this.createdOn.isEqual(date)))
		{
			this.createdOn = LocalDateTime.of(date.toLocalDate(), date.toLocalTime());
		}
		return this;
	}
	
	//Do we need a setter for this as well?
	//Would that even make sense?
	public int ProductKey;
	public int getProductKey(){
		return ProductKey;
	}
	
	public org.npc.testmodel.api.Product synchronize(org.npc.testmodel.api.Product apiProduct) {
		this.setId(apiProduct.getId());
		this.setDescription(apiProduct.getDescription());
		this.setLookupCode(apiProduct.getLookupCode());
		this.setPrice(apiProduct.getPrice());
		this.setItemType(apiProduct.getItemType());
		this.setCost(apiProduct.getCost());
		this.setQuantity(apiProduct.getQuantity());
		this.setReorderPoint(apiProduct.getReorderPoint());
		this.setRestockLevel(apiProduct.getRestockLevel());
		this.setParentItem(apiProduct.getParentItem());
		this.setExtendedDescription(apiProduct.getExtendedDescription());
		this.setActive(apiProduct.getActive());
		this.setMSRP(apiProduct.getMSRP());
		
		apiProduct.setCreatedOn(this.createdOn);
		
		return apiProduct;
	}
	
	public Product() {
		super(new ProductRepository());
		
		this.id = UUID.randomUUID();
		this.Description = "";
		this.lookupCode = StringUtils.EMPTY;
		this.Price = -1.0;
		this.ItemType = -1;
		this.Cost = -1.0;
		this.Quantity = -1;
		this.ReorderPoint = -1;
		this.RestockLevel = -1;
		this.ParentItem = -1;
		this.ExtendedDescription = "";
		this.Active = -1;
		this.MSRP = -1.0;
		this.createdOn = LocalDateTime.now();
	}
	
	public Product(UUID id) {
		super(id, new ProductRepository());
		
		this.Description = "";
		this.lookupCode = StringUtils.EMPTY;
		this.Price = -1.0;
		this.ItemType = -1;
		this.Cost = -1.0;
		this.Quantity = -1;
		this.ReorderPoint = -1;
		this.RestockLevel = -1;
		this.ParentItem = -1;
		this.ExtendedDescription = "";
		this.Active = -1;
		this.MSRP = -1.0;
		this.createdOn = LocalDateTime.now();
	}

	public Product(org.npc.testmodel.api.Product apiProduct) {
		super(apiProduct.getId(), new ProductRepository());
		
		this.Description = apiProduct.getDescription();
		this.lookupCode = apiProduct.getLookupCode();
		this.Price = apiProduct.getPrice();
		this.ItemType = apiProduct.getItemType();
		this.Cost = apiProduct.getCost();
		this.Quantity = apiProduct.getQuantity();
		this.ReorderPoint = apiProduct.getReorderPoint();
		this.RestockLevel = apiProduct.getRestockLevel();
		this.ParentItem = apiProduct.getParentItem();
		this.ExtendedDescription = apiProduct.getExtendedDescription();
		this.Active = apiProduct.getActive();
		this.MSRP = apiProduct.getMSRP();

		this.createdOn = LocalDateTime.now();
	}
}
