package com.example.elmback.Service.impl;

import com.example.elmback.Service.BusinessService;
import com.example.elmback.mapper.BusinessMapper;
import com.example.elmback.model.dm.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessMapper businessMapper;

    public List<Business> BusinessList(){
        try {
            List<Business> BusinessList = businessMapper.BusinessList();
            return BusinessList;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("首页获取商家列表失败z");
        }

        return null;
    };

    public  List<Business> getTypedBusinessList(Integer orderTypeId){
        try {
            List<Business> BusinessList = businessMapper.getTypedBusinessList(orderTypeId);
            return BusinessList;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("首页获取类型商家列表失败");
        }
        return null;
    };

    public  Business getBusinessByBusinessId(Integer businessId){
        try {
            Business BusinessByBusinessId = businessMapper.getBusinessByBusinessId(businessId);
            return BusinessByBusinessId;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("通过id获取类型商家列表失败");
        }
        return null;
    };
}
