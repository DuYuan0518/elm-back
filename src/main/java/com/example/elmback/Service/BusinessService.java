package com.example.elmback.Service;

import com.example.elmback.model.dm.Business;

import java.util.List;

public interface BusinessService {

    public  List<Business> BusinessList();

    public  List<Business> getTypedBusinessList(Integer orderTypeId);

    public  Business getBusinessByBusinessId(Integer orderTypeId);
}
