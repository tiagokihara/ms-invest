package br.com.tiagokihara.invuser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tiagokihara.invuser.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
