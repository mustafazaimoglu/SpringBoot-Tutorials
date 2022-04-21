package springtutorial.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import springtutorial.northwind.business.abstracts.ProductService;
import springtutorial.northwind.core.utilities.results.DataResult;
import springtutorial.northwind.core.utilities.results.Result;
import springtutorial.northwind.core.utilities.results.SuccessDataResult;
import springtutorial.northwind.core.utilities.results.SuccessResult;
import springtutorial.northwind.dataAccess.abstracts.ProductDao;
import springtutorial.northwind.entities.concretes.Product;
import springtutorial.northwind.entities.dtos.ProductWithCategoryDto;

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
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);

        return new SuccessDataResult<List<Product>>("Data Alındı", this.productDao.findAll(pageable).getContent());
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC,"productName");
        return new SuccessDataResult<List<Product>>("Data Sıralandı",this.productDao.findAll(sort));
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Ürün Eklendi!");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>("Data Listelendi",this.productDao.getByProductName(productName));
    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<Product>("Data Listelendi",this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId));
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>("Data Listelendi",this.productDao.getByProductNameOrCategory_CategoryId(productName,categoryId));
    }

    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>("Data Listelendi",this.productDao.getByCategory_CategoryIdIn(categories));

    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>("Data Listelendi",this.productDao.getByProductNameContains(productName));
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>("Data Listelendi",this.productDao.getByProductNameStartsWith(productName));
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>("Data Listelendi",this.productDao.getByNameAndCategory(productName,categoryId));
    }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return new SuccessDataResult<List<ProductWithCategoryDto>>("Data Arrived",this.productDao.getProductWithCategoryDetails());
    }
}
