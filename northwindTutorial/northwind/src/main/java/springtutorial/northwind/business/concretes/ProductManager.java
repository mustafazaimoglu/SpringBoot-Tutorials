package springtutorial.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springtutorial.northwind.business.abstracts.ProductService;
import springtutorial.northwind.core.utilities.results.DataResult;
import springtutorial.northwind.core.utilities.results.Result;
import springtutorial.northwind.core.utilities.results.SuccessDataResult;
import springtutorial.northwind.core.utilities.results.SuccessResult;
import springtutorial.northwind.dataAccess.abstracts.ProductDao;
import springtutorial.northwind.entities.concretes.Product;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>("Data Listelendi",this.productDao.findAll());
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Ürün Eklendi!");
    }
}
