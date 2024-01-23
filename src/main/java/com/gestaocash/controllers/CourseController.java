package com.gestaoCash.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gestaoCash.model.Course;
import com.gestaoCash.services.CourseService;
import com.gestaoCash.services.UserService;
import com.gestaoCash.utils.DataUserAuth;

@Controller
@RequestMapping("/cursos")
public class CourseController {

  @Autowired
  private CourseService courseService;

  @Autowired
  private UserService userService;

  DataUserAuth data = new DataUserAuth();

  @GetMapping
  public String listAllCourses(Model model) {
    var courses = this.courseService.findAllCourse();
    model.addAttribute("cursos", courses);

    return "";
  }

  @GetMapping("/novo")
  public String showForm(Model model) {
    var course = new Course();
    model.addAttribute("curso", course);

    return "";
  }

  @PostMapping("/salvar")
  public String saveCourse(@RequestParam("name") String name, @RequestParam("conclusion") int conclusion,
      @RequestParam("description") String description, @RequestParam("url") String url) {

    var existsCourse = this.courseService.findCourseByName(name);

    var course = new Course();
    course.setNomeCurso(name);
    course.setConclusao(conclusion);
    course.setDescricao(description);
    course.setUrl(url);

    var user = this.userService.findUserById(data.DataUser().getId());

    var courses = user.getFavoriteCourses();
    courses.add(course);

    user.setFavoriteCourses(courses);

    this.userService.saveUser(user);

    return "redirect:/usuario/area-cliente";
  }

  @GetMapping("/editar/{id}")
  public String showEditForm(@PathVariable Long id, Model model) {
    var course = this.courseService.findCourseById(id);
    model.addAttribute("curso", course);

    return "";
  }

  @PostMapping("/editar/{id}")
  public String updateCourse(@ModelAttribute("curso") Course updatedCourse, @PathVariable Long id) {
    this.courseService.updateCourseById(id, updatedCourse);

    return "redirect:/cursos";
  }

  @GetMapping("/excluir/{id}")
  public String deleteCourse(@PathVariable Long id) {
    var user = this.userService.findUserById(data.DataUser().getId());
    var courses = user.getFavoriteCourses();

    var course = this.courseService.findCourseById(id);
    courses.remove(course);

    this.courseService.deleteCourseById(id);

    this.userService.saveUser(user);

    return "redirect:/usuario/area-cliente";
  }
}
