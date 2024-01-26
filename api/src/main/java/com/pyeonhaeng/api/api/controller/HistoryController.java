package com.pyeonhaeng.api.api.controller;


import com.pyeonhaeng.api.api.entity.ItemReturnData;
import com.pyeonhaeng.api.api.service.HistoryServiceImpl;
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
public class HistoryController {


    private final HistoryServiceImpl historyServiceImpl;

    @RequestMapping(value = "history", produces = "application/json")
    public ResponseEntity searchItem (
            @RequestParam(value = "name",required = false) String name,
            @RequestParam(value = "cvs") String cvs) throws Exception{



        String processedName = PhUtility.checkName(name);
        //따음표 제거
        String processedCvs = PhUtility.checkName(cvs);
        //all이면 null로
        if(processedCvs.equalsIgnoreCase("all")){

            processedCvs = null;
        }

        String result = new String();
        int responseCount = 0;

        List<ItemReturnData> searchData = historyServiceImpl.lookHistory(processedName,processedCvs);
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
