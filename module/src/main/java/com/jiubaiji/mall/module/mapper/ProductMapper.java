package com.jiubaiji.mall.module.mapper;

import com.jiubaiji.mall.module.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ProductMapper {

    Product getById(@Param("id") Long id);

    @Select("select  * from product where is_deleted =0;")
    List<Product> getList();

    int insert(@Param("product") Product product);

    int update(@Param("product") Product product);

    @Update("update product set is_deleted =1,update_time =#{time} where id =#{id}")
    int delete(@Param("id") Long id, @Param("time") Integer time);
}
