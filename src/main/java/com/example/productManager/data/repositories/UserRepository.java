package com.example.productManager.data.repositories;

import com.example.productManager.data.models.ProductUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<ProductUser, Long> {

    @Query("SELECT u FROM ProductUser u WHERE u.username = :username")
    public ProductUser getUserByUsername(@Param("username") String username);
}
