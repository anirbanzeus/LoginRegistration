package com.fse.springboot.assignment.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fse.springboot.assignment.persistance.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    @Override
    void delete(User user);

}
