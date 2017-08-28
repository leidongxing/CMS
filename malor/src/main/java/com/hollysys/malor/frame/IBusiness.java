package com.hollysys.malor.frame;
public  interface IBusiness
{
  GenericResult doBusiness(GenericRequest paramGenericRequest, BusinessConfig paramBusinessConfig);
  
  GenericResult doBusiness(GenericRequest paramGenericRequest);
  
  BusinessConfig getBusinessConfig();
  
  void setBusinessConfig(BusinessConfig paramBusinessConfig);
  
  void setDataExchange(DataExchangeAssembly paramDataExchangeAssembly);
  
  void setBusinessCode(String paramString);
}