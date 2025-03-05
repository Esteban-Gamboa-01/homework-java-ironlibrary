package com.ironhack.homework03.repository;

import com.ironhack.homework03.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    @Query(value = "SELECT b.title, s.name, i.return_date " +
                    "FROM book b " +
                    "LEFT JOIN issue i ON b.isbn = i.book_id " +
                    "LEFT JOIN student s ON i.student_id = s.usn " +
                    "WHERE s.usn = ?1", nativeQuery = true)
    List<Object[]> findAllWhereUsnParams(String usn);

    List<Object[]> findIssueByUsn(String usn);

}
