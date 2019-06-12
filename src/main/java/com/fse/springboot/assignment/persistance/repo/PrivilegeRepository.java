package com.fse.springboot.assignment.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fse.springboot.assignment.persistance.model.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    Privilege findByName(String name);

    @Override
    void delete(Privilege privilege);

}
