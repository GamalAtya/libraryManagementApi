package libraryMangementApi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import libraryMangementApi.dto.PatronDTO;
import libraryMangementApi.entity.Patron;
import libraryMangementApi.mapper.PatronMapper;
import libraryMangementApi.repository.PatronRepository;

@Service
public class PatronService {

	@Autowired
	private PatronRepository patronRepository;

	private PatronMapper patronMapper = PatronMapper.INSTANCE;

	public List<PatronDTO> getAllPatrons() {
		return patronRepository.findAll().stream().map(patronMapper::patronToPatronDTO).collect(Collectors.toList());
	}

	public PatronDTO getPatronById(Long id) {
		return patronRepository.findById(id).map(patronMapper::patronToPatronDTO).orElse(null);
	}

	public PatronDTO addPatron(PatronDTO patronDTO) {
		Patron patron = patronMapper.patronDTOToPatron(patronDTO);
		Patron savedPatron = patronRepository.save(patron);
		return patronMapper.patronToPatronDTO(savedPatron);
	}

	public PatronDTO updatePatron(Long id, PatronDTO patronDTO) {
		return patronRepository.findById(id).map(patron -> {
			patron.setName(patronDTO.getName());
			patron.setContactInformation(patronDTO.getContactInformation());
			Patron updatedPatron = patronRepository.save(patron);
			return patronMapper.patronToPatronDTO(updatedPatron);
		}).orElse(null);
	}

	public void deletePatron(Long id) {
		patronRepository.deleteById(id);
	}

}
