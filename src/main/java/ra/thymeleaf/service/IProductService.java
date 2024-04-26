package ra.thymeleaf.service;

import ra.thymeleaf.dto.request.CreateProduct;
import ra.thymeleaf.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Integer id);
    boolean save(CreateProduct request);
    boolean save(CreateProduct request,Integer idEdit);
    boolean deleteById(Integer id);
}
