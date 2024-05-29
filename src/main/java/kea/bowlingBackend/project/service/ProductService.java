package kea.bowlingBackend.project.service;

import kea.bowlingBackend.project.dto.ProductDTO;
import kea.bowlingBackend.project.model.Product;
import kea.bowlingBackend.project.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO toDTO(Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getPrice(), product.getStock(), product.getImage());
    }

    public ProductDTO getProductById(int id) {
        Product product = productRepository.findById((long) id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        return toDTO(product);
    }

    public List<ProductDTO> getAllProduct() {
        List<Product> product = productRepository.findAll();
        return product.stream().map(this::toDTO).toList();
    }

    public ProductDTO addProduct(ProductDTO request) {
        Product newProduct = new Product();
        updateProduct(newProduct, request);
        productRepository.save(newProduct);
        return toDTO(newProduct);
    }

    public ProductDTO updateProduct(Product original, ProductDTO request) {
        original.setName(request.name());
        original.setPrice(request.price());
        original.setStock(request.stock());
        original.setImage(request.image());
        return toDTO(original);
    }

    public ProductDTO updateProduct(ProductDTO original, ProductDTO request) {
        Product product = productRepository.findByName(original.name()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        updateProduct(product, request);
        productRepository.save(product);
        return toDTO(product);
    }

    public void deleteProduct(int id) {
        Product product = productRepository.findById((long) id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        productRepository.delete(product);
    }

}
