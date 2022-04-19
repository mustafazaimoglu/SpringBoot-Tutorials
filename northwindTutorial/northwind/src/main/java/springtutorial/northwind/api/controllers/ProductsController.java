package springtutorial.northwind.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springtutorial.northwind.business.abstracts.ProductService;
import springtutorial.northwind.core.utilities.results.DataResult;
import springtutorial.northwind.core.utilities.results.Result;
import springtutorial.northwind.entities.concretes.Product;

import java.util.List;

@RestController
@RequestMapping("/api/products/")
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("getAll")
    public DataResult<List<Product>> getAll(){
        return this.productService.getAll();
    }

    @GetMapping("getAllByPage")
    public DataResult<List<Product>> getAll(@RequestParam int pageNo,@RequestParam int pageSize){
        return this.productService.getAll(pageNo,pageSize);
    }

    @GetMapping("getAllSortedDesc")
    public DataResult<List<Product>> getAllSorted(){
        return this.productService.getAllSorted();
    }

    @PostMapping("add")
    public Result add(@RequestBody Product product) {
        return this.productService.add(product);
    }

    @GetMapping("getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName){
        return this.productService.getByProductName(productName);
    }

    @GetMapping("getByProductNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategoryId(@RequestParam String productName,@RequestParam int categoryId){
        return this.productService.getByProductNameAndCategoryId(productName,categoryId);
    }

    @GetMapping("getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {
        return this.productService.getByProductNameContains(productName);
    }



}
