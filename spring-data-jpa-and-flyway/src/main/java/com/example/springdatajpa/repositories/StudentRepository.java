package com.example.springdatajpa.repositories;

import com.example.springdatajpa.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // @Query("select s from Student s where s.score between ?1 and ?2")
    List<Student> findAllByScoreBetween(Integer min, Integer max);

    // @Query("select s from Student s where s.name = :name")
    Optional<Student> findByName(String name);

    @Query("select s from Student s where s.score < 20")
    List<Student> findLowRatingStudents();

    @Query("select s.score from Student s where s.name = ?1")
    Integer hqlGetScoreByName(String name);

    @Query(value = "select score from students where name = :name", nativeQuery = true)
    Integer nativeSqlGetScoreByName(String name);

    // Если бы у студентов был List<Book>, то не ленивая загрузка книг:
    // @Query("select s from Student s join fetch s.books where s.id = :id")
    // Optional<Student> findByIdWithBooks(String name);
}
