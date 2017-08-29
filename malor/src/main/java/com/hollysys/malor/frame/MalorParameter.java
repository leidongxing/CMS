package com.hollysys.malor.frame;


public class MalorParameter implements IParamType {
	private long id;
	private String atomCode;
	private String code;
	private String name;
	private short cursorId;
	private short serialNo;
	private short dataType;
	private short dataWidth;
	private double dataPrec;
	private short dataScale;
	private String defVal;
	private short refType;
	private String refCode;
	private short paramType;
	private boolean nullable;
//	private Composite composite;

//	public MalorParameter() {
//		this.nullable = true;
//
//		this.composite = new Composite();
//	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getCursorId() {
		return this.cursorId;
	}

	public void setCursorId(short cursorId) {
		this.cursorId = cursorId;
	}

	public String getAtomCode() {
		return this.atomCode;
	}

	public void setAtomCode(String atomCode) {
		this.atomCode = atomCode;
	}

	public short getSerialNo() {
		return this.serialNo;
	}

	public void setSerialNo(short serialNo) {
		this.serialNo = serialNo;
	}

	public short getDataType() {
		return this.dataType;
	}

	public void setDataType(short dataType) {
		this.dataType = dataType;
	}

	public short getDataWidth() {
		return this.dataWidth;
	}

	public void setDataWidth(short dataWidth) {
		this.dataWidth = dataWidth;
	}

	public double getDataPrec() {
		return this.dataPrec;
	}

	public void setDataPrec(double dataPrec) {
		this.dataPrec = dataPrec;
	}

	public short getDataScale() {
		return this.dataScale;
	}

	public void setDataScale(short dataScale) {
		this.dataScale = dataScale;
	}

	public String getDefVal() {
		return this.defVal;
	}

	public void setDefVal(String defVal) {
		this.defVal = defVal;
	}

	public short getRefType() {
		return this.refType;
	}

	public void setRefType(short refType) {
		this.refType = refType;
	}

	public String getRefCode() {
		return this.refCode;
	}

	public void setRefCode(String refCode) {
		this.refCode = refCode;
	}

	public short getParamType() {
		return this.paramType;
	}

	public void setParamType(short paramType) {
		this.paramType = paramType;
	}

	public boolean isMust() {
		return (!(this.nullable));
	}

	public boolean isNullable() {
		return this.nullable;
	}

	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append(String.format("id:%-20d", new Object[]{Long.valueOf(this.id)}));
		sb.append(String.format("atomCode:%-20s", new Object[]{this.atomCode}));
		sb.append(String.format("code:%-20s", new Object[]{this.code}));
		sb.append(String.format("name:%-10s", new Object[]{this.name}));
		sb.append(String.format("cursorId:%-5d",
				new Object[]{Short.valueOf(this.cursorId)}));
		sb.append(String.format("serialNo:%-5d",
				new Object[]{Short.valueOf(this.serialNo)}));
		sb.append(String.format("paramType:%-5d",
				new Object[]{Short.valueOf(this.paramType)}));
		sb.append(String.format("refType:%-5d",
				new Object[]{Short.valueOf(this.refType)}));
		sb.append(String.format("refCode:%-10s", new Object[]{this.refCode}));
		sb.append(String.format("defVal:%-10s", new Object[]{this.defVal}));
		sb.append(String.format("dataType:%-5d",
				new Object[]{Short.valueOf(this.dataType)}));
		sb.append(String.format("dataPrec:%-5d",
				new Object[]{Double.valueOf(this.dataPrec)}));
		sb.append(String.format("dataWidth:%-5d",
				new Object[]{Short.valueOf(this.dataWidth)}));
		sb.append(String.format("dataScale:%-5d",
				new Object[]{Short.valueOf(this.dataScale)}));
		sb.append(String.format("nullable:%-10s",
				new Object[]{Boolean.valueOf(this.nullable)}));

		return sb.toString();
	}

	public DataType getParamDataType() {
		return DataType.forCode(getDataType());
	}

	public int getParamDataWidth() {
		return getDataWidth();
	}

	public double getParamDataPrec() {
		return getDataPrec();
	}

	public int getParamDataScale() {
		return getDataScale();
	}

	public boolean isParamNullable() {
		return isNullable();
	}

//	public Composite getComposite() {
//		return this.composite;
//	}
//
//	public void setComposite(Composite composite) {
//		this.composite = composite;
//	}
}