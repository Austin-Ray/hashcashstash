package com.edge.demo.repository;

import com.edge.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by spann303 on 3/5/2018
 * Connects the User.java to the hibernate db through the Spring JPA.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
