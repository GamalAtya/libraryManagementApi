package libraryMangementApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import libraryMangementApi.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}