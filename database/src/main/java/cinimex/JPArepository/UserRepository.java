package cinimex.JPArepository;

import cinimex.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UsersEntity,Long> {
}
