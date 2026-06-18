package com.jiubaiji.mall.app.controller;
import com.jiubaiji.mall.domain.ProductInfoVo;
import com.jiubaiji.mall.domain.ProductListVo;
import com.jiubaiji.mall.module.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    private final ProductService productService;

    public AppController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/product/detail")
    public ProductInfoVo ProductGetById(@RequestParam(value = "id") Long id) {
        return productService.getById(id);
    }

    @RequestMapping("/product/list")
    public ProductListVo productGetList() {
        return productService.getList();
    }

}
