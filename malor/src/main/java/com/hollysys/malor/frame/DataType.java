package com.hollysys.malor.frame;
import java.util.HashMap;
import java.util.Map;

public enum DataType {
	BIT, TINYINT, SMALLINT, INTEGER, BIGINT, DECIMAL, NUMERIC, VARCHAR, DATE, BLOB, CLOB, CHAR, BOOLEAN, CURSOR, COMPOSITE, UNDEFINED;

	public final int TYPE_CODE = 0;
	public final Class TYPE_CLAZZ = null;
	private static Map<Integer, DataType> codeLookup;

	public static DataType forCode(int code) {
		return ((DataType) codeLookup.get(Integer.valueOf(code)));
	}

	public static DataType forCode(String type) {
		Integer code = Integer.valueOf(type);
		DataType dataType = (DataType) codeLookup.get(code);
		if (dataType == null) {
			dataType = UNDEFINED;
		}
		return dataType;
	}

	static {
		codeLookup = new HashMap();

		for (DataType type : values()) {
			codeLookup.put(Integer.valueOf(type.TYPE_CODE), type);
		}
	}
}