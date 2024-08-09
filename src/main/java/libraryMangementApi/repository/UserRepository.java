package libraryMangementApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import libraryMangementApi.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}