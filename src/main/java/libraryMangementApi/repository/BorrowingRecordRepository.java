package libraryMangementApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import libraryMangementApi.entity.BorrowingRecord;

public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Long> {
}