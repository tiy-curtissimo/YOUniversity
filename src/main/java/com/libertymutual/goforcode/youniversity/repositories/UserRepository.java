package com.libertymutual.goforcode.youniversity.repositories;

import org.hibernate.validator.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libertymutual.goforcode.youniversity.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

        User findByUsername(String username);
        
}
