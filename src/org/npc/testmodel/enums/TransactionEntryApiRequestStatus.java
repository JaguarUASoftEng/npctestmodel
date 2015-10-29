package org.npc.testmodel.enums;

import java.util.HashMap;
import java.util.Map;

public enum TransactionEntryApiRequestStatus {
	OK(0),
	INVALID_INPUT(1),
	UNKNOWN_ERROR(2),
	RECORD_ID_ALREADY_EXISTS(3);
	
	public int getValue() {
		return value;
	}

	public static TransactionEntryApiRequestStatus map(int key) {
		if (valueMap == null) {
			valueMap = new HashMap<Integer, TransactionEntryApiRequestStatus>();

			for (TransactionEntryApiRequestStatus status : TransactionEntryApiRequestStatus.values()) {
				valueMap.put(status.getValue(), status);
			}
		}
		
		return (valueMap.containsKey(key) ? valueMap.get(key) : TransactionEntryApiRequestStatus.UNKNOWN_ERROR);
	}
	
	private int value;

	private static Map<Integer, TransactionEntryApiRequestStatus> valueMap = null;

	private TransactionEntryApiRequestStatus(int value) {
		this.value = value;
	}
}
