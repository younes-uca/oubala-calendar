package emsi.sir.oubala.zynerator.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import emsi.sir.oubala.zynerator.security.bean.Permission;

public interface PermissionDao extends JpaRepository<Permission, Long> {
    public Permission findByName(String name);
}
