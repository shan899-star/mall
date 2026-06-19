package com.jiubaiji.mall.domain;

import lombok.Data;
import lombok.experimental.Accessors;


import java.util.List;

@Data
@Accessors(chain = true)
public class ProductInfoVo {
    private Long id;
    private List<String> images;
    private String title;
    private Float price;
    private String description;
}