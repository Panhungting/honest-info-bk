package jp.co.honest.controller.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.honest.domain.Book;
import jp.co.honest.service.BookService;

@RestController // RESTコントローラクラス
@RequestMapping("/api/v1/book") // コントローラクラス全体のURL
public class BookController {

    @Autowired
    private BookService bookService;

    // GETリクエストがきたら、このメソッドが実行される
    @GetMapping({"/", "/index"}) // メソッドのURL
    public List<Book> index() {

        // DBから一覧検索
        return bookService.getBookList();
        // return null;
    }
}