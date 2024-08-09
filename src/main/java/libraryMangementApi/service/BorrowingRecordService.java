package libraryMangementApi.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import libraryMangementApi.entity.BorrowingRecord;
import libraryMangementApi.repository.BorrowingRecordRepository;

@Service
public class BorrowingRecordService {

	@Autowired
	private BorrowingRecordRepository borrowingRecordRepository;

	public void borrowBook(BorrowingRecord borrowingRecord) {
		borrowingRecordRepository.save(borrowingRecord);
	}

	public void returnBook(Long bookId, Long patronId) {
		borrowingRecordRepository.findAll().stream().filter(
				record -> record.getBook().getId().equals(bookId) && record.getPatron().getId().equals(patronId))
				.findFirst().ifPresent(record -> {
					record.setReturnDate(LocalDate.now());
					borrowingRecordRepository.save(record);
				});
	}

}
