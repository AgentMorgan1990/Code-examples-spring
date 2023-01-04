package com.example.thymeleaf.controllers;

import com.example.thymeleaf.data.Student;
import com.example.thymeleaf.repositories.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * @RequestParam - вытаскивает параметры из запроса (/add?a=5&b=10)
 * по умолчанию @RequestParam(required = true), если параметра не будет, словим эксепшен
 * @RequestParam(name = "a") - вытаскиваем параметр по имени, если не соответствует пути и методе
 *
 *
 * @PathVariable - вытаскиваем переменную из пути (/product/{id}/info)
 *
 * @ResponseBody - можем возвращать - json (java script object notation), строку, приметив,
 * если не будет этой аннотации и возвращаем строки - словим эксепшн
 * Без этой аннотации можем возвращать html страницы
 *
 * @RequestParam(defaultValue = "") - можно указать значение по умолчанию, если придёт null/
 *
 * Нежелательно принимать примитивы, лучше взять ссылочные типы данных, чтобы не перепутать null и 0
 *
 * В класс Model - можем складывать любые значения, которые нужны в отображении html страницы
 *
 *
 * @RestController - автоматом проставляет всем @ResponseBody, отправляем только объекты, не предназначен для отдачи страниц
 *
 * @Controller - можем отправлять вьюшки
 * */

//todo копнуть поглубже что можем получать и возвращать в ресте, кроме json-ов и html


@Controller
@RestController
public class MainController {
    private StudentRepository studentRepository;

    public MainController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // http://localhost:8189/app

    // GET [http://localhost:8189/app]/add?a=5&b=10
    @GetMapping("/add")
    @ResponseBody
    public int add(@RequestParam(defaultValue = "") int a, @RequestParam int b) {
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