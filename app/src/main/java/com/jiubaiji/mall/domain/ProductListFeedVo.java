package com.jiubaiji.mall.domain;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class ProductListFeedVo {
    private Long id;
    private String image;
    private String title;
    private Float price;
}