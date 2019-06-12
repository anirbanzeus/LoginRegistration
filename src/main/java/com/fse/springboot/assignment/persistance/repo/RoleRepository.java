package com.fse.springboot.assignment.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fse.springboot.assignment.persistance.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

    @Override
    void delete(Role role);

}
