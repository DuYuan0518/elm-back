package com.example.elmback.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.elmback.model.dm.Food;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface FoodMapper extends BaseMapper<Food> {

    @Select("select * from food where businessId = #{BusinessId} order by foodId")
    public List<Food> getFoodListByBusinessId(Integer BusinessId);

    @Select("select * from food where foodId=#{foodId}")
    public Food getFoodById(Integer foodId) throws SQLException;

    @Select("SELECT * FROM food WHERE foodId = #{foodId} AND businessId = #{businessId}")
    Food getFoodByIdAndBusinessId(@Param("foodId") Integer foodId, @Param("businessId") Integer businessId);
}
