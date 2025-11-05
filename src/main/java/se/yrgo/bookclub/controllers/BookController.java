package se.yrgo.bookclub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import se.yrgo.bookclub.domain.Book;

import java.util.*;

/**
 * This class handles requests and provides endpoints for an online book-club.
 */
@Controller
public class BookController {

    // Hard codes a book list so that we can present some book recommendations
    private List<Book> books = List.of(
            new Book("1984", "George Orwell", "Classics"),
            new Book("Anna Karenina", "Leo Tolstoy", "Classics"),
            new Book("The Old Man And The Sea", "Ernest Hemingway", "Classics"),
            new Book("Java For Beginners", "Bosse Bredsladd", "Non-fiction"),
            new Book("History of the World", "Eva Larsson", "Non-fiction"),
            new Book("Ben Franklin", "Walter Isaacson", "Biographics"),
            new Book("Aldrig Ensam, Alltid Ensam", "Erik Fichtelius", "Biographics"));

    /**
     * This is the endpoint for the home-page
     * @return ModelAndView that passes along the current date and time
     */
    @RequestMapping("/home")
    public ModelAndView welcome() {
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("dateAndTime", new Date());
        return mav;
    }

    /**
     * This is the endpoint for book-recommendations
     * @return ModelAndView with the hard-coded book list
     */
    @RequestMapping("/booklist")
    public ModelAndView showBooks() {
        List<Book> bookList = books;

        ModelAndView mav = new ModelAndView("booklist");
        mav.addObject("bookList", bookList);

        return mav;
    }

    /**
     * This is the endpoint for showing genres/books by genre
     * @param genre is optional and if entered shows a list of books by that genre, otherwise just a list of genres
     * @return ModelAndview with a book list, genre and genre list
     */
    @RequestMapping("/genre")
    public ModelAndView showBooksByGenre(@RequestParam(required = false) String genre) {
        List<Book> bookListByGenre = new ArrayList<>();
        Set<String> genres = new HashSet<>();
        List<String> genreList = new ArrayList<>();

        // If no genre-parameter is entered, a list of available genres is presented
        if (genre == null) {
            for (Book book : books) {
                genres.add(book.getGenre());
            }
            genreList.addAll(genres);
        }
        // Otherwise a list of books that matches the genre
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
