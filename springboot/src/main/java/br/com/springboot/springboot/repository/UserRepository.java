package br.com.springboot.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.springboot.springboot.model.user;

public interface UserRepository extends JpaRepository<user,Long> {
    
    @Query("SELECT u from user u where u.id > :id")
    public List<user> findAllMoreThan(@Param("id") long id);

    public List<user> findByIdGreaterThan(long id);

    public List<user> findByNameIgnoreCase(String name);
}
