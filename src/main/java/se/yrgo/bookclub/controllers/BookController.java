package se.yrgo.bookclub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import se.yrgo.bookclub.domain.Book;

import java.util.*;

@Controller
public class BookController {

    private List<Book> books = List.of(
            new Book("1984", "George Orwell", "Classics"),
            new Book("Anna Karenina", "Leo Tolstoy", "Classics"),
            new Book("The Old Man And The Sea", "Ernest Hemingway", "Classics"),
            new Book("Java For Beginners", "Bosse Bredsladd", "Non-fiction"),
            new Book("History of the World", "Eva Larsson", "Non-fiction"),
            new Book("Ben Franklin", "Walter Isaacson", "Biographics"),
            new Book("Aldrig Ensam, Alltid Ensam", "Erik Fichtelius", "Biographics"));

    @RequestMapping("/home")
    public ModelAndView welcome() {
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("dateAndTime", new Date());
        return mav;
    }

    @RequestMapping("/booklist")
    public ModelAndView showBooks() {
        List<Book> bookList = books;

        ModelAndView mav = new ModelAndView("booklist");
        mav.addObject("bookList", bookList);

        return mav;
    }

    @RequestMapping("/genre")
    public ModelAndView showBooksByGenre(@RequestParam(required = false) String genre) {
        List<Book> bookListByGenre = new ArrayList<>();
        Set<String> genres = new HashSet<>();
        List<String> genreList = new ArrayList<>();

        if (genre == null) {
            for (Book book : books) {
                genres.add(book.getGenre());
            }
            genreList.addAll(genres);
        }
        else {
            for (Book book : books) {
                if (book.getGenre().toLowerCase().equals(genre)) {
                    bookListByGenre.add(book);
                }
            }

        }

        ModelAndView mav = new ModelAndView("genre");
        mav.addObject("bookListByGenre", bookListByGenre);
        mav.addObject("genre", genre);
        mav.addObject("genreList", genreList);
        return mav;
    }
}
