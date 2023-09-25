package com.schema.multinenancy.domain.product;

import com.schema.multinenancy.dto.product.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class ProductDomainImpl implements ProductDomain {

    private ProductService productService;

    public ProductDomainImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        return productService.createProduct(productDto);
    }

}