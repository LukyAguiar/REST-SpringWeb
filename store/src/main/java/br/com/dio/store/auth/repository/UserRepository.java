package br.com.dio.store.auth.repository;

import br.com.dio.store.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
