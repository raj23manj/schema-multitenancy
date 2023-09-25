package com.schema.multinenancy.api;

import com.schema.multinenancy.domain.product.ProductDomain;
import com.schema.multinenancy.dto.product.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {

    private ProductDomain productDomain;

    public ProductController(ProductDomain productDomain) {
        this.productDomain = productDomain;
    }

    @GetMapping("/all")
    public List<ProductDto> getAllProductsOfClient(){
        return productDomain.getAllProducts();
    }

    @PostMapping
    public ProductDto create(@RequestBody ProductDto productDto) {
        return productDomain.createProduct(productDto);
    }
}