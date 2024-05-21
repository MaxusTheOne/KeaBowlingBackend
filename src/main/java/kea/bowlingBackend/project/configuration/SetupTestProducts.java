package kea.bowlingBackend.project.configuration;

import kea.bowlingBackend.project.model.Product;
import kea.bowlingBackend.project.repository.ProductRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SetupTestProducts implements ApplicationRunner {

    ProductRepository productRepository;

    public SetupTestProducts(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void run(ApplicationArguments args) {
        createTestProduct();
    }

    private void createTestProduct() {
        //Create test product
        Product product1 = new Product("Tuborg", 29.95, 200, "https://media.danmurphys.com.au/dmo/product/1000004677-TUBORGCAN-1.jpg?impolicy=PROD_LG");
        Product product2 = new Product("Kims Chips", 25.00, 40, "https://cdn.lomax.dk/images/t_item_large/f_auto/v1651230875/produkter/3772420/kims-sour-cream-+-onion-chips--mini-pose--25-g.jpg");
        Product product3 = new Product("Coca Cola", 15.00, 100, "https://billigfadoel.dk/wp-content/uploads/2018/11/Coca-Cola-Classic-33-cl-daase-24-stk-bestil-hos-Billigfadoel.png");
        Product product4 = new Product("Faxe Kondi", 15.00, 50, "https://billigfadoel.dk/wp-content/uploads/2018/11/Faxe-Kondi-33-cl-daase-24-stk-fadoelsudlejning.png");
        Product product5 = new Product("Ginger Ale", 15.00, 30, "https://selfdrinks.com/22945-thickbox_default/schweppes-ginger-ale-33cl-pack-de-24.jpg");

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);
    }
}
