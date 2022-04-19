package springtutorial.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import springtutorial.northwind.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
