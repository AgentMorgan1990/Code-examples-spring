package com.example.thymeleaf.controllers;

import com.example.thymeleaf.data.Student;
import com.example.thymeleaf.repositories.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @RequestParam - вытаскивает параметры из запроса (/add?a=5&b=10)
 * по умолчанию @RequestParam(required = true), если параметра не будет, словим эксепшен
 * @RequestParam(name = "a") - вытаскиваем параметр по имени, если не соответствует пути и методе
 *
 *
 * @PathVariable - вытаскиваем переменную из пути (/product/{id}/info)
 *
 * @ResponseBody - можем возвращать тело - json (строка), если не будет этой аннотации и возвращаем строки - словим эксепшнб
 * Без этой аннотации можем возвращать html страницы
 *
 *
 * В класс Model - можем складывать любые значения, которые нужны в отображении html страницы
 * */

//todo копнуть поглубже что можем получать и возвращать в ресте, кроме json-ов и html


@Controller
public class MainController {
    private StudentRepository studentRepository;

    public MainController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // http://localhost:8189/app

    // GET [http://localhost:8189/app]/add?a=5&b=10
    @GetMapping("/add")
    @ResponseBody
    public int add(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }

    // GET [http://localhost:8189/app]/product/110/info
    @GetMapping("/product/{id}/info")
    @ResponseBody
    public String showProductInfo(@PathVariable Long id) {
        return "Product #" + id;
    }

    @GetMapping("/students")
    public String showStudentsPage(Model model) {
        model.addAttribute("students", studentRepository.getAllStudents());
        return "students_page";
    }

    @GetMapping("/students/{id}")
    public String showStudentPage(Model model, @PathVariable Long id) {
        Student student = studentRepository.findById(id);
        model.addAttribute("student", student);
        return "student_info_page";
    }
}