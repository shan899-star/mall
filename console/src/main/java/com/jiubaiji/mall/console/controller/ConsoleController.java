package com.jiubaiji.mall.console.controller;

import com.jiubaiji.mall.module.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
@RestController
public class ConsoleController {
    private final ProductService productService;
    public ConsoleController(ProductService productService) {
        this.productService = productService;
    }
    @RequestMapping("/product/create")
    public String studentCreate(@RequestParam(value = "images") String images,
                                @RequestParam(value = "price") BigDecimal price,
                                @RequestParam(value = "title") String title,
                                @RequestParam(value = "description") String description)
    {
        int result = productService.createProduct(images, price, title, description);
        if (result > 0) {
            return "成功";
        } else {
            return "失败";
        }

    }

    @RequestMapping("/product/update")
    public String studentUpdate(@RequestParam(value = "id") Long id,
                                @RequestParam(value = "images") String images,
                                @RequestParam(value = "price") BigDecimal price,
                                @RequestParam(value = "title") String title,
                                @RequestParam(value = "description") String description){
        int result = productService.updateProduct(id, images, price,title,description);
        if (result > 0) {
            return "成功";
        } else {
            return "失败";
        }
    }
    @RequestMapping("/product/delete")
    public String studentDelete(@RequestParam(value = "id") Long id) {
        int result = productService.deleteProduct(id);
        if (result > 0) {
            return "成功";
        } else {
            return "失败";
        }
    }
}

