package com.pyeonhaeng.api.api.repository;

import com.pyeonhaeng.api.api.entity.ItemReturnData;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemRepository {
    public abstract List<ItemReturnData> searchItemsbyConditions(String name, String tag, String cvs, String order, Pageable pageable, Boolean history);
}
