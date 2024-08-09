package libraryMangementApi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import libraryMangementApi.dto.BookDTO;
import libraryMangementApi.entity.Book;

@Mapper
public interface BookMapper {
	BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

	BookDTO bookToBookDTO(Book book);

	Book bookDTOToBook(BookDTO bookDTO);
}