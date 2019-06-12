package com.fse.springboot.assignment.persistance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fse.springboot.assignment.persistance.model.DeviceMetadata;

public interface DeviceMetadataRepository extends JpaRepository<DeviceMetadata, Long> {

    List<DeviceMetadata> findByUserId(Long userId);
}
