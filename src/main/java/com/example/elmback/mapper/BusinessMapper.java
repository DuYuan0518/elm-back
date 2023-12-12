package com.example.elmback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.elmback.model.dm.Business;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface BusinessMapper extends BaseMapper<Business> {

    @Select("select * from business order by businessId")
    public List<Business> BusinessList();

    @Select("select * from business where orderTypeId=#{orderTypeId} order by businessId")
    public  List<Business> getTypedBusinessList(Integer orderTypeId);


    @Select("select * from business where businessId = #{businessId} ")
    public  Business getBusinessByBusinessId(Integer businessId);

    @Select("select * from business where businessId=#{businessId}")
    public Business getBusinessById(Integer businessId) throws SQLException;
}
