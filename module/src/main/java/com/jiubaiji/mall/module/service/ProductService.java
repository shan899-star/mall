package com.jiubaiji.mall.module.service;

import com.jiubaiji.mall.domain.ProductInfoVo;
import com.jiubaiji.mall.domain.ProductListFeedVo;
import com.jiubaiji.mall.domain.ProductListVo;
import com.jiubaiji.mall.module.entity.Product;
import com.jiubaiji.mall.module.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    private final ProductMapper productMapper;

    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public ProductInfoVo getById(Long id) {
        Product product = productMapper.getById(id);
        ProductInfoVo productInfoVo =new ProductInfoVo()
                .setId(product.getId())
                .setTitle(product.getTitle())
                .setPrice(product.getPrice())
                .setDescription(product.getDescription());
        List<String> images = Arrays.asList(product.getImages().split("\\$"));
        productInfoVo.setImages(images);
        return productInfoVo;
    }

    public ProductListVo getList() {
        List<Product> products = productMapper.getList();
        List<ProductListFeedVo> list = new ArrayList<>();
        for (Product product : products) {
            ProductListFeedVo vo = new ProductListFeedVo()
                    .setId(product.getId())
                    .setImage(product.getImages().split("\\$")[0])
                    .setTitle(product.getTitle())
                    .setPrice(product.getPrice());
            list.add(vo);

        }
        return new ProductListVo().setList(list);
    }

    public int createProduct(String images, BigDecimal price, String title, String description) {
        int timestamp = (int) (System.currentTimeMillis() / 1000);
        Product product = new Product();
        product.setImages(images);
        product.setPrice(price);
        product.setTitle(title);
        product.setDescription(description);
        product.setUpdateTime(timestamp);
        product.setCreateTime(timestamp);
        product.setIsDeleted(0);
        return productMapper.insert(product);
    }

    public int updateProduct(Long id, String images, BigDecimal price, String title, String description) {
        int timestamp = (int) (System.currentTimeMillis() / 1000);
        Product product = new Product();
        product.setId(id);
        product.setImages(images);
        product.setPrice(price);
        product.setTitle(title);
        product.setDescription(description);
        product.setUpdateTime(timestamp);
        product.setCreateTime(timestamp);
        return productMapper.update(product);
    }

    public int deleteProduct(Long id) {
        int timestamp = (int) (System.currentTimeMillis() / 1000);
        return productMapper.delete(id, timestamp);
    }
}
