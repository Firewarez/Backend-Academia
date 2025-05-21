package loja.com.example.LojaApi.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity user = new UserEntity();
    
}