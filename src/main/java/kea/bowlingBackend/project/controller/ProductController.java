package kea.bowlingBackend.project.controller;
import kea.bowlingBackend.project.dto.ProductDTO;
import kea.bowlingBackend.project.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ProductDTO getProduct(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProduct();
    }

    @PostMapping
    public ProductDTO addProduct(@RequestBody ProductDTO product) {
        return productService.addProduct(product);
    }

    @PutMapping("/{id}/reduceStock/{quantity}")
    public ResponseEntity<String> reduceStock(@PathVariable int id, @PathVariable int quantity) {
        ProductDTO original = productService.getProductById(id);
        ProductDTO updatedProduct = new ProductDTO(original.id(), original.name(), original.price(), original.stock() - quantity, original.image());
        if (updatedProduct.stock() < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Stock cannot be less than 0. Current stock: " + original.stock());
        }
        productService.updateProduct(original, updatedProduct);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable int id, @RequestBody ProductDTO updatedProduct) {
        ProductDTO original = productService.getProductById(id);
        return productService.updateProduct(original, updatedProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }

}
