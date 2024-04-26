package ra.thymeleaf.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.thymeleaf.dto.request.CreateProduct;
import ra.thymeleaf.model.Product;
import ra.thymeleaf.repository.CategoryRepository;
import ra.thymeleaf.repository.ProductRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService{
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final UploadService uploadService;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("ID ko tim thay"));
    }

    @Override
    public boolean save(CreateProduct request) {
        // them moi
        // kiêểm tra có file hay ko
        String url = null;
        if (request.getFile().getSize() > 0){
            // upload
            url = uploadService.uploadFileToServer(request.getFile());
        }
        Product product =  Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .createdDate(new Date())
                .status(true)
                .description(request.getDescription())
                .imageUrl(url)
                .category(categoryRepository.findById(request.getCategoryId()).orElse(null))
                .build();
        productRepository.save(product);
        return true;
    }

    @Override
    public boolean save(CreateProduct request, Integer idEdit) {
        // cpa nhat
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        boolean check = productRepository.existsById(id);
        if (check) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
