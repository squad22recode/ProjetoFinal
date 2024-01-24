package com.gestaoCash.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestaoCash.model.Course;
import com.gestaoCash.services.CourseService;

@Controller
@RequestMapping("/painel-controle")
public class PainelController {

  @Autowired
  private CourseService courseService;

  @GetMapping
  public String showPainel(Model model) {
    var courses = this.courseService.findAllCourse();
    model.addAttribute("courses", courses);
    model.addAttribute("course", new Course());

    return "/painel/painel-controle";
  }

}