package com.pyeonhaeng.api.api.service;

import com.pyeonhaeng.api.api.entity.ItemReturnData;

import java.util.List;

public interface HistoryService {

    List<ItemReturnData> lookHistory(String name, String cvs) throws Exception;
}
