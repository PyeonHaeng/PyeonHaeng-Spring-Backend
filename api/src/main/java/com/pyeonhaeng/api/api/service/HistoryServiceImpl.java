package com.pyeonhaeng.api.api.service;

import com.pyeonhaeng.api.api.entity.ItemReturnData;
import com.pyeonhaeng.api.api.repository.ItemRepositoryImpl;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Builder
@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private final ItemRepositoryImpl itemRepository;

    @Override
    public List<ItemReturnData> lookHistory(String name, String cvs) throws Exception{

        List<ItemReturnData> selectedItems = itemRepository.searchItemsbyConditions(name,null,cvs,null, PageRequest.of(0,24),true);

        return selectedItems;

    }

}
