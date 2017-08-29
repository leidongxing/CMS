package com.hollysys.malor.frame;

public interface IParamType {
	DataType getParamDataType();
	int getParamDataWidth();
	double getParamDataPrec();
	int getParamDataScale();
	boolean isParamNullable();
}