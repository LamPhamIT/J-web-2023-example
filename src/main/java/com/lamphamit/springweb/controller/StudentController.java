package com.lamphamit.springweb.controller;

import com.lamphamit.springweb.service.StudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentController {
    StudentService studentService;

    @GetMapping("/search")
    public String search(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        if(keyword != null && !keyword.isEmpty()) {
            model.addAttribute("keyword", keyword);
            model.addAttribute("students", studentService.searchStudents(keyword));
        }
        return "searchStudent";
    }
}
