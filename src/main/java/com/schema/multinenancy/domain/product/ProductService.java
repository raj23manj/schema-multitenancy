package com.schema.multinenancy.domain.product;

import com.schema.multinenancy.domain.warehouse.WarehouseRepository;
import com.schema.multinenancy.dto.product.ProductDto;
import com.schema.multinenancy.entities.Product;
import com.schema.multinenancy.entities.Warehouse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
class ProductService {

    private ProductRepository productRepository;
    private WarehouseRepository warehouseRepository;


    public ProductService(ProductRepository productRepository,
                          WarehouseRepository warehouseRepository) {
        this.productRepository = productRepository;
        this.warehouseRepository = warehouseRepository;
    }

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductMapper::mapToDto)
                .collect(toList());
    }

    public ProductDto createProduct(ProductDto productDto) {
        Warehouse warehouse = warehouseRepository.getReferenceById(1L);
        Product product = Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .description(productDto.getDescription())
                .warehouse(warehouse)
                .build();
        Product createdProduct = productRepository.save(product);
        return ProductMapper.mapToDto(createdProduct);
    }

}