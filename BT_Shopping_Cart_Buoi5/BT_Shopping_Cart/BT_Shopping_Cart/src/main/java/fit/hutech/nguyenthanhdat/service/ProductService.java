package fit.hutech.nguyenthanhdat.service;

import fit.hutech.nguyenthanhdat.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    void saveProductById(int id);

    void saveProduct(Product product);
    void deleteProduct(Product product);

    Product getProductById(int id);
    void deleteProductById(int id);

    void remove(Integer id);

    void update(Integer productId, Integer quantity);

    Page<Product> findPaginated(int pageNo, int pageSize);
    Page<Product> findPaginated(int pageNo, int pageSize, String sortFiled, String sortDirection);


}
