package com.tekshia.springdemo.controllers;

import com.tekshia.springdemo.entities.Book;
import com.tekshia.springdemo.services.LmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

//Controller Annotation
@Controller
public class MainController {

    @Autowired
    private LmsService lmsService;
    /* --Testing
    @GetMapping("/")
    public String init(){
        return "index";
    }
    */

//    Controller Methods with Views
    @GetMapping("/")
    public String init(Model model){
        model.addAttribute("books",lmsService.findAllBooks());
        model.addAttribute("mode", "BOOK_VIEW");
        return "index";
    }

    @GetMapping("/updateBook")
    public String init(Model model, @RequestParam long id){
        model.addAttribute("book",lmsService.findBookById(id));
        model.addAttribute("mode", "BOOK_EDIT");
        return "index";
    }
    //Date Type Config to fix issues
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Book book, BindingResult bindingResult, Model model){
        lmsService.save(book);
        model.addAttribute("books",lmsService.findAllBooks());
        model.addAttribute("mode", "BOOK_VIEW");
        return "redirect:/";
    }


    @GetMapping("/newBook")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("mode", "BOOK_EDIT");
        return "index";
    }

    @GetMapping("/deleteBook")
    public String deleteBook(Model model, @RequestParam long id){
        lmsService.deleteBook(id);
        model.addAttribute("books",lmsService.findAllBooks());
        model.addAttribute("mode", "BOOK_VIEW");
        return "redirect:/";
    }
}
