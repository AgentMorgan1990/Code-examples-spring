package com.example.springdatajpa.services;

import com.example.springdatajpa.entities.Student;
import com.example.springdatajpa.exceptions.ResourceNotFoundException;
import com.example.springdatajpa.repositories.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Transactional
    public void changeScore(Long studentId, Integer delta) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Unable to change student's score. Student not found, id: " + studentId));
        student.setScore(student.getScore() + delta);
    }

    public List<Student> findByScoreBetween(Integer min, Integer max) {
        return studentRepository.findAllByScoreBetween(min, max);
    }
}
