package com.example.elmback.Service.impl;

import com.example.elmback.Service.FoodService;
import com.example.elmback.mapper.FoodMapper;
import com.example.elmback.model.dm.Business;
import com.example.elmback.model.dm.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodMapper foodMapper;
    @Override
    public List<Food> getFoodListByBusinessId(Integer BusinessId) {
        try {
            List<Food> foodList = foodMapper.getFoodListByBusinessId(BusinessId);
            return foodList;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("获取食物列表失败z");
        }

        return null;
    }
}
