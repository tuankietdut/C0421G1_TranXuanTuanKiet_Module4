package com.example.demo.controller;

import com.example.demo.model.bean.Book;
import com.example.demo.model.bean.CodeBook;
import com.example.demo.model.service.BookService;
import com.example.demo.model.service.CodeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    CodeBookService codeBookService;

    @GetMapping("/list")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("bookList", bookService.findAll());
        return modelAndView;
    }

    @GetMapping("/borrow/{id}")
    public ModelAndView showEdit(@PathVariable (name = "id") int idBook){
        Book book = this.bookService.findById(idBook);
        if (book != null){
            ModelAndView modelAndView = new ModelAndView("borrow");
            int codeBook = (int) Math.round(Math.random()*100);
            modelAndView.addObject("numberBook", codeBook);
            modelAndView.addObject("bookObject", book);
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("error");
        return modelAndView;
    }

    @PostMapping("/borrow")
    public ModelAndView saveCodeBook(@RequestParam(name = "numberBook") int numberBook,
                               @ModelAttribute (name = "bookObject")Book book) throws OutOfBookException {
        ModelAndView modelAndView = new ModelAndView("redirect:/book/list");
        if (book.getQuantity()==0){
            throw new OutOfBookException("Hết sách rồi");
        }
        this.bookService.updateBook(book.getQuantity()-1, book.getId());
        Book bookNewObject = this.bookService.findById(book.getId());
        CodeBook codeBook = new CodeBook();
        codeBook.setNumberBook(numberBook);
        codeBook.setBook(bookNewObject);
        this.codeBookService.saveCodeBook(codeBook);
        return modelAndView;
    }

    @GetMapping("/return/{id}")
    public ModelAndView showReturn(@PathVariable(name = "id") int idBook){
        Book book = this.bookService.findById(idBook);
        if (book != null){
            ModelAndView modelAndView = new ModelAndView("return");
            modelAndView.addObject("bookObject", book);
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("error");
        return modelAndView;
    }

    @PostMapping("/return")
    public ModelAndView returnBook(@ModelAttribute("bookObject") Book book, @RequestParam(name = "numberBook")int numberBook){
        this.codeBookService.removeCodeBook(numberBook);
        this.bookService.updateBook(book.getQuantity()+1, book.getId());
        return new ModelAndView("redirect:/book/list");
    }

    @ExceptionHandler(OutOfBookException.class)
    public ModelAndView outOfBook(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("msg","Vui lòng mượn sách khác");
        return new ModelAndView("redirect:/book/list");
    }
}
