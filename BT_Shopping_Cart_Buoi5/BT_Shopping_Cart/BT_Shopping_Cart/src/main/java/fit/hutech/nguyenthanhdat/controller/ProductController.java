package fit.hutech.nguyenthanhdat.controller;

import fit.hutech.nguyenthanhdat.model.Product;
import fit.hutech.nguyenthanhdat.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("view")
    public String viewProducts(Model model){
        model.addAttribute("listProducts", productService.getAllProducts());
        return "view_productlist";
    }
    @GetMapping("addnew")
    public String showNewProductForm(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        return "new_product";
    }
    @PostMapping("save")
    public String saveProduct(@ModelAttribute("product") Product product){
        productService.saveProduct(product);
        return "redirect:/product/view";
    }
    @PostMapping("delete")
    public String deleteProduct(@ModelAttribute("product") Product product){
        productService.deleteProduct(product);
        return "redirect:/product/view";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir, Model model) {
        int pageSize = 5;

        Page < Product > page = productService.findPaginated(pageNo, pageSize);
        List < Product > listEmployees = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listEmployees", listEmployees);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("listEmployees", listEmployees);
        return "index";
    }
    @GetMapping("/")
    public  String viewHomePage(Model model){
        return  findPaginated(1,"firstName", "asc",model);
    }

}
