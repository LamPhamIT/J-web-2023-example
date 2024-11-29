package com.lamphamit.springweb.controller;

import com.lamphamit.springweb.dto.request.CreateGraduationRequest;
import com.lamphamit.springweb.service.GraduationService;
import com.lamphamit.springweb.service.MajorService;
import com.lamphamit.springweb.service.UniversityService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/graduation")
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GraduationController {
    UniversityService universityService;
    MajorService majorService;
    GraduationService graduationService;
    @PostMapping
    public String createGraduation(@Valid @ModelAttribute("createGraduationRequest")
                                       CreateGraduationRequest graduationRequest,
                                   BindingResult bindingResult,
                                   Model model
    ) {
        if(bindingResult.hasErrors()) {
            return "graduation-form";
        }
        boolean check = false;
        try {
            check = graduationService.saveGraduation(graduationRequest);
        } catch (Exception e) {
            check = false;
        }
        if(check) {
            model.addAttribute("message", "Create graduation successful");
            model.addAttribute("status", "success");
            return "graduation-form";
        }
        model.addAttribute("message", "Create graduation failed");
        model.addAttribute("status", "failed");
        return "graduation-form";
    }

    @GetMapping
    public String getGraduations(Model model) {
        model.addAttribute("university", universityService.getAllUniversityCode());
        model.addAttribute("major", majorService.getAllMajorCodes());
        model.addAttribute("createGraduationRequest", new CreateGraduationRequest());
        return "graduation-form";
    }
}
