package org.npc.testmodel.api;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;
import org.npc.testmodel.enums.ProductApiRequestStatus;

@XmlRootElement
public class Product {
	protected UUID id;
	public UUID getId() {
		return this.id;
	}
	public Product setId(UUID id) {
		this.id = id;
		
		return this;
	}
	
	private String Description;
	public String getDescription(){
		return this.Description;
	}
	public Product setDescription(String Description){
		if(!StringUtils.equals(this.Description,Description)){
			this.Description = Description;
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
	
	private ProductApiRequestStatus apiRequestStatus;
	public ProductApiRequestStatus getApiRequestStatus() {
		return this.apiRequestStatus;
	}
	public Product setApiRequestStatus(ProductApiRequestStatus apiRequestStatus) {
		if (this.apiRequestStatus != apiRequestStatus) {
			this.apiRequestStatus = apiRequestStatus;
		}
		
		return this;
	}
	
	private String apiRequestMessage;
	public String getApiRequestMessage() {
		return this.apiRequestMessage;
	}
	public Product setApiRequestMessage(String apiRequestMessage) {
		if (!StringUtils.equalsIgnoreCase(this.apiRequestMessage, apiRequestMessage)) {
			this.apiRequestMessage = apiRequestMessage;
		}
		
		return this;
	}
	
	public Product() {
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
		this.apiRequestMessage = StringUtils.EMPTY;
		this.apiRequestStatus = ProductApiRequestStatus.OK;
	}
	
	public Product(org.npc.testmodel.models.Product modelProduct) {
		this.id = modelProduct.getId();
		this.Description = modelProduct.getDescription();
		this.lookupCode = modelProduct.getLookupCode();
		this.Price = modelProduct.getPrice();
		this.ItemType = modelProduct.getItemType();
		this.Cost = modelProduct.getCost();
		this.Quantity = modelProduct.getQuantity();
		this.ReorderPoint = modelProduct.getReorderPoint();
		this.RestockLevel = modelProduct.getRestockLevel();
		this.ParentItem = modelProduct.getParentItem();
		this.ExtendedDescription = modelProduct.getExtendedDescription();
		this.Active = modelProduct.getActive();
		this.MSRP = modelProduct.getMSRP();
		this.createdOn = modelProduct.getCreatedOn();

		this.apiRequestMessage = StringUtils.EMPTY;
		this.apiRequestStatus = ProductApiRequestStatus.OK;
	}
}
