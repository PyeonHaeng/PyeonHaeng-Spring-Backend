package com.pyeonhaeng.api.utility;

import com.pyeonhaeng.api.api.entity.ItemReturnData;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;

import java.util.List;
import java.util.Objects;

@Slf4j
public final class PhUtility {
    private PhUtility(){}


    public static String checkName(String name){
        if ("".equals(name) || name==null){
            return null;
        }
        name = name.replaceAll("[\'\"']", "");
        return name;
    }


    public static String makeResponseJson(List<ItemReturnData> entity){
        int count =entity.size();
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("count",count);
        if(count == 0){

            jsonObject.put("message","Can't find any products.");

        }
        else{
            jsonObject.put("products",entity);
        }



        return jsonObject.toString();
    }
}
