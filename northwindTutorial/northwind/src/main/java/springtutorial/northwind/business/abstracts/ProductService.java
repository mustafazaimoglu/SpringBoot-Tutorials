package springtutorial.northwind.business.abstracts;

import springtutorial.northwind.core.utilities.results.DataResult;
import springtutorial.northwind.core.utilities.results.Result;
import springtutorial.northwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    Result add(Product product);
}
