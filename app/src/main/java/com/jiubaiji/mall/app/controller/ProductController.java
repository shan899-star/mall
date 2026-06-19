package com.jiubaiji.mall.app.controller;

import com.jiubaiji.mall.domain.ProductInfoVo;
import com.jiubaiji.mall.domain.ProductListFeedVo;
import com.jiubaiji.mall.domain.ProductListVo;
import com.jiubaiji.mall.module.entity.Product;
import com.jiubaiji.mall.module.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/product/detail")
    public ProductInfoVo ProductGetById(@RequestParam(value = "id") Long id) {
        Product product = productService.detail(id);
        if (product == null) {
            return null;
        }
        ProductInfoVo productInfoVo = new ProductInfoVo()
                .setId(product.getId())
                .setTitle(product.getTitle())
                .setPrice(product.getPrice())
                .setDescription(product.getDescription());

        String images = product.getImages();

        if (images != null && images.length() > 0) {
            List<String> list = Arrays.asList(images.split("\\$"));
            productInfoVo.setImages(list);
        }
        return productInfoVo;
    }


    @RequestMapping("/product/list")
    public ProductListVo productGetList() {

        List<Product> products = productService.getList();
        List<ProductListFeedVo> list = new ArrayList<>();
        for (Product product : products) {
            ProductListFeedVo productListFeedVo = new ProductListFeedVo()
                    .setId(product.getId())
                    .setImage(product.getImages().split("\\$")[0])
                    .setTitle(product.getTitle())
                    .setPrice(product.getPrice());
            list.add(productListFeedVo);
        }
        return new ProductListVo().setList(list);
    }
}
