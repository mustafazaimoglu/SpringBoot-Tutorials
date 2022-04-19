package springtutorial.northwind.business.abstracts;

import springtutorial.northwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
}
