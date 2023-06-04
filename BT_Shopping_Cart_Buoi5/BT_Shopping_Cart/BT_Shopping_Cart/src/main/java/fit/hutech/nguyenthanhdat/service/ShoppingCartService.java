package fit.hutech.nguyenthanhdat.service;

import fit.hutech.nguyenthanhdat.model.CartItem;
import fit.hutech.nguyenthanhdat.model.Product;
import org.springframework.data.domain.Page;

import java.util.Collection;

public interface ShoppingCartService {
    void add(CartItem newItem);
    void remove(int id);
    CartItem update(int productID, int quantity);
    void clear();
    double getAmount();
    int getCount();
    Collection<CartItem> getAllItems();
    Page<Product> findPaginated(int pageNo, int pageSize);

}
