package jp.co.honest.controller.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.honest.domain.Book;
import jp.co.honest.service.BookService;

@Controller // コントローラクラス
@RequestMapping("/demo") // コントローラクラス全体のURL
public class DemoController {

    @Autowired
    private BookService bookService;

    // GETリクエストがきたら、このメソッドが実行される
    @GetMapping({"/", "/index"}) // メソッドのURL
    public String index(Model model) {

        // DBから一覧検索
        List<Book> bookList = bookService.getBookList();

        // テンプレートに渡す値を設定
        model.addAttribute("bookList", bookList);
        
        // テンプレート名パス（拡張子なし）
        return "demo/list";
    }

    // GETリクエストがきたら、このメソッドが実行される
    @GetMapping("/add") // GETメソッドの場合、新規登録画面の初期表示
    public String displayAdd(@ModelAttribute DemoForm form, Model model) {
        // テンプレート名パス（拡張子なし）
        return "demo/add";
    }

    // パスパラメータ:bookId
    @GetMapping({"/{bookId}/edit"}) // GETメソッドの場合、編集画面の初期表示
    public String displayEdit(@PathVariable String bookId, Model model) {
        // bookIdは、@PathVariableを付けて、パスパラメータから、受け取る

        // DBから、ブック情報取得
        Optional<Book> book = bookService.getBook(Integer.valueOf(bookId));

        // 取得出来なかった場合、エラーメッセージ
        if (!book.isPresent()) {
            // TODO
        }

        // テンプレートに渡す値を設定
        model.addAttribute("book", book.get());
        
        return "demo/edit";
    }

    @GetMapping({"/{bookId}/delete"}) // GETメソッドの場合、削除画面の初期表示
    public String displayDelete(@PathVariable String bookId, Model model) {
        // bookIdは、@PathVariableを付けて、パスパラメータから、受け取る

        // DBから、ブック情報取得
        Optional<Book> book = bookService.getBook(Integer.valueOf(bookId));

        // 取得出来なかった場合、エラーメッセージ
        if (!book.isPresent()) {
            // TODO
        }

        // テンプレートに渡す値を設定
        model.addAttribute("book", book.get());
        
        return "demo/delete";
    }

    // POSTリクエストがきたら、このメソッドが実行される
    @PostMapping("/add") // POSTメソッドの場合、新規登録処理を行う
    public String add(@ModelAttribute DemoForm form, Model model) {

        // リクエスト値が、フォームにバインドされる
        System.out.println("title:" + form.getTitle());
        System.out.println("price:" + form.getPrice());
        System.out.println("summary:" + form.getSummary());

        // DBへ保存
        Book book = Book.builder()
            .title(form.getTitle())
            .price(form.getPrice())
            .summary(form.getSummary())
            .build();
        bookService.saveBook(book);

        // DBから一覧検索
        List<Book> bookList = bookService.getBookList();

        // テンプレートに渡す値を設定
        model.addAttribute("msg", "正常に登録されました！");
        model.addAttribute("bookList", bookList);

        return "demo/list";
    }
 
    @PutMapping({"/{bookId}"}) // PUTメソッドの場合、編集処理を行う
    public String edit(@PathVariable String bookId, @ModelAttribute DemoForm form, Model model) {
        // bookIdは、@PathVariableを付けて、パスパラメータから、受け取る

        // DBへ保存
        Book book = Book.builder()
            .bookId(Integer.valueOf(bookId))
            .title(form.getTitle())
            .price(form.getPrice())
            .summary(form.getSummary())
            .build();
        bookService.saveBook(book);

        // 編集処理後、一覧画面へ遷移
        return "redirect:/demo/index";
    }

    @DeleteMapping({"/{bookId}"}) // DELETEメソッドの場合、削除処理を行う
    public String delete(@PathVariable String bookId, Model model) {
        // bookIdは、@PathVariableを付けて、パスパラメータから、受け取る

        // DBから、ブックを削除
        bookService.deleteBook(Integer.valueOf(bookId));
        
        // 削除処理後、一覧画面へ遷移
        return "redirect:/demo/index";
    }
}