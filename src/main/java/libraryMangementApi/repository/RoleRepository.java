package libraryMangementApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import libraryMangementApi.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}