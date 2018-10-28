package com.watchers.business.finder.service;

import com.watchers.business.finder.model.FinderVo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public interface FinderService {
	public JSONArray getFinderList();
	public JSONObject procFinderModify(FinderVo finderInfo);
}
