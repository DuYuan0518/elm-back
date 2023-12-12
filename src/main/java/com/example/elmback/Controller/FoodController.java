package com.example.elmback.Controller;

import com.example.elmback.Service.FoodService;
import com.example.elmback.exception.BusinessException;
import com.example.elmback.model.dm.Business;
import com.example.elmback.model.dm.Food;
import com.example.elmback.utils.BaseResponse;
import com.example.elmback.utils.ErrorCode;
import com.example.elmback.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/lists/{businessId}")
    public BaseResponse<List<Food>> getFoodListsByBusinessId(@PathVariable(value = "businessId") Integer businessId) {
        List<Food> FoodList = foodService.getFoodListByBusinessId(businessId);
        if (FoodList != null) {
            return ResultUtils.success(FoodList);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，获取食物列表失败");
        }
    }
}
