package com.pyeonhaeng.api.api.service;

import com.pyeonhaeng.api.api.entity.ItemReturnData;

import java.util.List;

public interface SearchService {

    List<ItemReturnData> searchItems(String name, String cvs, String tag, int offset, int limit, String order) throws Exception;
}
