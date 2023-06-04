package fit.hutech.nguyenthanhdat.repository;

import fit.hutech.nguyenthanhdat.model.Role;

import java.util.Optional;

public interface RoleRepository {
    Optional<Role> findByName(String name);
}
