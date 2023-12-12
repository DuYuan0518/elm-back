package com.example.elmback.Controller;


import com.example.elmback.Service.BusinessService;
import com.example.elmback.exception.BusinessException;
import com.example.elmback.model.dm.Business;
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
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @GetMapping("/businessLists")
    public BaseResponse<List<Business>> listBusiness() {
        List<Business> businessList = businessService.BusinessList();
        if (businessList != null) {
            return ResultUtils.success(businessList);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，获取商家列表失败");
        }
    }

    @GetMapping("/TypedBusiness/{orderTypeId}")
    public BaseResponse<List<Business>> TypedBusinessList(@PathVariable(value = "orderTypeId")Integer orderTypeId) {
        List<Business> businessList = businessService.getTypedBusinessList(orderTypeId);
        if (businessList != null) {
            return ResultUtils.success(businessList);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，获取类型商家列表失败");
        }
    }

    @GetMapping("/businesses/{businessId}")
    public BaseResponse<Business> getBusinessByBusinessId( @PathVariable(value = "businessId") Integer businessId) {
        Business BusinessByBusinessId = businessService.getBusinessByBusinessId(businessId);
        if (BusinessByBusinessId != null) {
            return ResultUtils.success(BusinessByBusinessId);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，通过商家id获取商家列表失败");
        }
    }



}
