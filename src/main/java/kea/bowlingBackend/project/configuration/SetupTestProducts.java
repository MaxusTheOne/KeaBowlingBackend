package kea.bowlingBackend.project.configuration;

import kea.bowlingBackend.project.model.Product;
import kea.bowlingBackend.project.repository.ProductRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

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

        // Create products in list.
        List<Product> productList = Arrays.asList(
        // Beers
        new Product("Carlsberg Pilsner", 29.95, 200, "https://www.kioskenrodbyhavn.dk/5008-thickbox_default/coca-cola-l.jpg"),
        new Product("Carlsberg Fadøl", 49.95, 120, "https://images3.alphacoders.com/277/277225.jpg"),
        new Product("Tuborg", 29.95, 200, "https://media.danmurphys.com.au/dmo/product/1000004677-TUBORGCAN-1.jpg?impolicy=PROD_LG"),
        new Product("Tuborg Fadøl", 49.95, 120, "https://diskogruppen.dk/wp-content/uploads/2023/03/Tuborg-plastglas-1.png"),
        new Product("Royal Classic", 29.95, 200, "https://www.otto-duborg.dk/42-large_default/Royal-Classic-.jpg"),
        new Product("Royal Export", 29.95, 200, "https://driveinbottleshop.dk/wp-content/uploads/2021/01/9764G-155722380732.png"),
        new Product("Royal Pilsner", 29.95, 200, "https://potio.dk/wp-content/uploads/2020/09/royal-pilsner-dase-can-1024x1024.png"),
        new Product("Heineken", 19.95, 100, "https://panten.dk/wp-content/uploads/2023/01/Heineken-dase.jpg"),
        // Sodas
        new Product("Coca Cola", 15.00, 100, "https://billigfadoel.dk/wp-content/uploads/2018/11/Coca-Cola-Classic-33-cl-daase-24-stk-bestil-hos-Billigfadoel.png"),
        new Product("Faxe Kondi", 15.00, 50, "https://billigfadoel.dk/wp-content/uploads/2018/11/Faxe-Kondi-33-cl-daase-24-stk-fadoelsudlejning.png"),
        new Product("Ginger Ale", 15.00, 30, "https://selfdrinks.com/22945-thickbox_default/schweppes-ginger-ale-33cl-pack-de-24.jpg"),
        new Product("Pepsi", 15.00, 100, "https://content.etilize.com/Original/1029886380.jpg"),
        new Product("Fanta", 15.00, 100, "https://www.coca-cola.com/content/dam/onexp/gb/en/brands/fanta/Product-Information-fanta-orange.jpg"),
        new Product("Sprite", 15.00, 100, "https://bison.blob.core.windows.net/img/prods/large/1010041933.jpg"),
        new Product("7up", 15.00, 100, "https://kadonawholesale.ie/wp-content/uploads/2021/07/7up-can.png"),
        new Product("Red Bull", 15.00, 100, "https://www.laudinella.ch/delivery-shop/wp-content/uploads/2014/12/RedBull.png"),
        new Product("Monster", 15.00, 100, "https://selvastoreuk.com/wp-content/uploads/2020/08/5060166690687.jpg"),
        new Product("Rockstar", 15.00, 100, "https://assets.iceland.co.uk/i/iceland/rockstar_original_energy_drink_500ml_54092_T596.jpg?$pdpzoom$"),
        // Snacks
        new Product("Kims Chips", 25.00, 40, "https://cdn.lomax.dk/images/t_item_large/f_auto/v1651230875/produkter/3772420/kims-sour-cream-+-onion-chips--mini-pose--25-g.jpg"),
        new Product("Kims Snacks", 25.00, 40, "https://kims.dk/wp-content/uploads/2020/10/Snack-Orginial-160g.png"),
        new Product("Kims Nødder", 25.00, 40, "https://archivana.com/pics/5a/e0/5ae09826462a50ea1c19166f74d64329158ddff1.jpg"),
        new Product("Pommes Frites", 35.00, 999, "https://www.toepfer-feinkost.de/files/toepfer/fotogalerien/produkte-layout/iStock_000013075985Small.jpg"),
        new Product("Hot Dog", 25.00, 999, "https://allhailtheblackmarket.com/wp-content/uploads/2015/08/1plain.png"),
        new Product("Burger", 60.00, 999, "https://upload.wikimedia.org/wikipedia/commons/4/4d/Cheeseburger.jpg")
        );


        // Save products to database.
        productRepository.saveAll(productList);
    }
}
