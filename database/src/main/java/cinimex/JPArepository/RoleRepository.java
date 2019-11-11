package cinimex.JPArepository;

import cinimex.entity.RoleEntity;
import cinimex.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.relation.Role;

public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
   public RoleEntity findByRole(RoleType roleType);
}
