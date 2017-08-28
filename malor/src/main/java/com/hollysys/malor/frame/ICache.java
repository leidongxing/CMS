package com.hollysys.malor.frame;

import java.util.List;
import java.util.Map;

public interface ICache {
	  void loadCache(String paramString);
	  
	  String parseJson(String paramString);
	  
	  Map<?,?> getCaches();
	  
      Map<String, List<Map<?,?>>> getRecord(String paramString);
}
