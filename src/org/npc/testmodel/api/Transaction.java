package org.npc.testmodel.api;

import java.util.UUID;
import org.npc.testmodel.enums.TransactionApiRequestStatus;
import org.apache.commons.lang3.StringUtils;

public class Transaction {
		protected UUID r_id;
		private int c_id;
		private int amount;
		private String transactiontype;
		//not sure how to add timestamp for created on
		
			public UUID getR_ID()
		{
			return this.r_id;
		}

		public Transaction setR_ID(UUID r_id)
		{
			this.r_id = r_id;
			return this;
		}
		
		public int getC_ID()
		{
			return this.c_id;
		}

		public Transaction setC_ID(int c_id)
		{
			if (this.c_id != c_id)
			{
				this.c_id = c_id;
			}
			return this;
		}
		
		public int getAmount()
		{
			return this.amount;
		}

		public Transaction setAmount(int amount)
		{
			if (this.amount != amount)
			{
				this.amount = amount;
			}
			return this;
		}
		
		public String getTransactionType()
		{
			return this.transactiontype;
		}

		public Transaction setTransactionType(String transactiontype)
		{
			if (!StringUtils.equals(this.transactiontype, transactiontype))
			{
				this.transactiontype = transactiontype;
			}
			return this;
		}
		
		private TransactionApiRequestStatus apiRequestStatus;
		public TransactionApiRequestStatus getApiRequestStatu(){
			return this.apiRequestStatus;
		}
		
		public Transaction setApiRequestStatus(TransactionApiRequestStatus apiRequestStatus){
			if(this.apiRequestStatus != apiRequestStatus){
				this.apiRequestStatus = apiRequestStatus;
			}
			
			return this;
		}
		
		private String apiRequestMessage;
		public String getApiRequestMessage(){
			return this.apiRequestMessage;
		}
		
		public Transaction setApiRequestMessage(String apiRequestMessage)
		{
			if (!StringUtils.equalsIgnoreCase(this.apiRequestMessage, apiRequestMessage))
			{
				this.apiRequestMessage = apiRequestMessage;
			}
			return this;
		}
		
		public Transaction()
		{
			this.r_id = UUID.randomUUID();
			this.c_id = -1;
			this.amount = -1;
			this.transactiontype = StringUtils.EMPTY;
		}
		
		public Transaction(org.npc.testmodel.models.Transaction modelTransaction)
		{
			this.r_id = modelTransaction.getR_ID();
			this.c_id = modelTransaction.getC_ID();
			this.amount = modelTransaction.getAmount();
			this.transactiontype = modelTransaction.getTransactionType();
			//this.apiRequestMessage = StringUtils.EMPTY;
			//this.apiRequestStatus = ProductApiRequestStatus.OK;
		}
}
