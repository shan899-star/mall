package com.jiubaiji.mall.module.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Product {
    private Long id;
    private String images;
    private String title;
    private Float price;
    private String description;
    private Integer createTime;
    private Integer updateTime;
    private Integer isDeleted;
}