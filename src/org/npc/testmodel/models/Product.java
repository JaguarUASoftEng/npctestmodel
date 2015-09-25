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
	
	private UUID Identification;
	public UUID getIdentification(){
		return this.Identification;
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

	private int MSRP;
	public int getmsrp(){
		return MSRP;
	}
	public Product setMSRP(int MSRP){
		if(!(this.MSRP == MSRP))
		{
			this.MSRP = MSRP;
			this.propertyChanged(ProductFieldNames.MSRP);
		}
		return this;
	}

	private Timestamp CreatedOn;
	public Timestamp getCreateOn(){
		return CreatedOn;
	}
	
	public int ProductKey;
	public int getProductKey(){
		return ProductKey;
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
	
	public Product(UUID id) {
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
