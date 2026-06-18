package com.jiubaiji.mall.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class ProductListVo {
    private List<ProductListFeedVo> list;
}