package libraryMangementApi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import libraryMangementApi.dto.BookDTO;
import libraryMangementApi.entity.Book;
import libraryMangementApi.mapper.BookMapper;
import libraryMangementApi.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	private BookMapper bookMapper = BookMapper.INSTANCE;

	public List<BookDTO> getAllBooks() {
		return bookRepository.findAll().stream().map(bookMapper::bookToBookDTO).collect(Collectors.toList());
	}

	public BookDTO getBookById(Long id) {
		return bookRepository.findById(id).map(bookMapper::bookToBookDTO).orElse(null);
	}

	public BookDTO addBook(BookDTO bookDTO) {
		Book book = bookMapper.bookDTOToBook(bookDTO);
		Book savedBook = bookRepository.save(book);
		return bookMapper.bookToBookDTO(savedBook);
	}

	public BookDTO updateBook(Long id, BookDTO bookDTO) {
		return bookRepository.findById(id).map(book -> {
			book.setTitle(bookDTO.getTitle());
			book.setAuthor(bookDTO.getAuthor());
			book.setPublicationYear(bookDTO.getPublicationYear());
			book.setIsbn(bookDTO.getIsbn());
			Book updatedBook = bookRepository.save(book);
			return bookMapper.bookToBookDTO(updatedBook);
		}).orElse(null);
	}

	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
}
