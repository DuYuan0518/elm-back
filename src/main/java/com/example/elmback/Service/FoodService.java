package com.example.elmback.Service;

import com.example.elmback.model.dm.Business;
import com.example.elmback.model.dm.Food;

import java.util.List;

public interface FoodService {

    public List<Food> getFoodListByBusinessId(Integer BusinessId);
}
