package libraryMangementApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import libraryMangementApi.entity.Patron;

public interface PatronRepository extends JpaRepository<Patron, Long> {
}