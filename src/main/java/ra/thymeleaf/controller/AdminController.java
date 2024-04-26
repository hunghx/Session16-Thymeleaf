package ra.thymeleaf.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ra.thymeleaf.dto.request.CreateProduct;
import ra.thymeleaf.repository.CategoryRepository;
import ra.thymeleaf.service.IProductService;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final IProductService productService;
    private final CategoryRepository categoryRepository;
    // index
    @RequestMapping("/dash-board")
    public String dashboard(){
        return "admin/index";
    }
    // category
    @RequestMapping("/category")
    public String category(){
        return "admin/category";
    }
    // category
    @RequestMapping("/product")
    public String product(Model model){
        model.addAttribute("list",productService.findAll());
        model.addAttribute("categories",categoryRepository.findAll());
        model.addAttribute("product",new CreateProduct());

        return "admin/product";
    }
    @RequestMapping(value = "/product/add",method = RequestMethod.POST)
    public String addProduct(@ModelAttribute CreateProduct createProduct){
        productService.save(createProduct);
        return "redirect:/admin/product";
    }
}
