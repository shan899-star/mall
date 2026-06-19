package com.jiubaiji.mall.module.service;

import com.jiubaiji.mall.module.entity.Product;
import com.jiubaiji.mall.module.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductMapper productMapper;

    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public Product detail(Long id) {
        Product product = productMapper.getById(id);
        return product;
    }

    public List<Product> getList() {
        List<Product> products = productMapper.getList();

        return products;
    }

    public int createProduct(String images, Float price, String title, String description) {
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

    public int updateProduct(Long id, String images, Float price, String title, String description) {
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
