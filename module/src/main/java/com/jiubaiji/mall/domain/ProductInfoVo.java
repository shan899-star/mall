package com.jiubaiji.mall.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.List;

@Data
@Accessors(chain = true)
public class ProductInfoVo {
    private Long id;
    private List<String> images;
    private String title;
    private BigDecimal price;
    private String description;
}