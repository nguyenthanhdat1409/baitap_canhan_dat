package fit.hutech.nguyenthanhdat.repository;

import fit.hutech.nguyenthanhdat.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Integer> {
}
