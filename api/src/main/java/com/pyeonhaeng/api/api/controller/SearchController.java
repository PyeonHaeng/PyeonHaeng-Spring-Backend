package com.pyeonhaeng.api.api.controller;


import com.pyeonhaeng.api.api.entity.ItemReturnData;
import com.pyeonhaeng.api.api.service.SearchServiceImpl;
import com.pyeonhaeng.api.utility.PhUtility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/products")
@RestController
public class SearchController {


    private final SearchServiceImpl searchServiceImpl;
    @RequestMapping(value = "search", produces = "application/json")
    public ResponseEntity searchItem(
            @RequestParam(value = "name",required = false) String name,
            @RequestParam(value = "cvs") String cvs,
            @RequestParam(value = "event") String tag,
            @RequestParam(value = "offset",required = false,defaultValue = "0") int offset,
            @RequestParam(value = "limit",required = false,defaultValue = "10") int limit,
            @RequestParam(value = "order-by",required = false) String order) throws Exception{

        //name에서 따음표 제거
        String processedName = PhUtility.checkName(name);
        if ("".equals(processedName) || processedName==null){
            processedName ="";
        }

        //따음표 제거
        String processedCvs = PhUtility.checkName(cvs);
        //all이면 null로
        if(processedCvs.equalsIgnoreCase("all")){
            processedCvs = null;
        }

        String processedTag = PhUtility.checkName(tag);
        if(processedTag.equalsIgnoreCase("all")){
            processedTag = null;
        }

        if(offset <0){
            offset =0;
        }

        if(limit <0){
            limit =0;
        }

        if("".equals(order) || order == null){
            order = null;
        }else if(order.equalsIgnoreCase("all")){
            order = null;
        }else if(order.equalsIgnoreCase("asc")){
            order = "asc";
        } else if(order.equalsIgnoreCase("desc")){
            order = "desc";
        }


        String result = new String();
        int responseCount = 0;

        List<ItemReturnData> searchData = searchServiceImpl.searchItems(processedName,processedCvs,processedTag,offset,limit,order);
        result = PhUtility.makeResponseJson(searchData);
        responseCount = searchData.size();

        if(responseCount == 0){
            return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity(result, HttpStatus.OK);
        }

    }
}
