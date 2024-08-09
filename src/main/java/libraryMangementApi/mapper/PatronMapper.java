package libraryMangementApi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import libraryMangementApi.dto.PatronDTO;
import libraryMangementApi.entity.Patron;

@Mapper
public interface PatronMapper {
	PatronMapper INSTANCE = Mappers.getMapper(PatronMapper.class);

	PatronDTO patronToPatronDTO(Patron patron);

	Patron patronDTOToPatron(PatronDTO patronDTO);
}