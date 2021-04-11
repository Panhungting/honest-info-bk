package jp.co.honest.service;

import java.util.List;
import java.util.Optional;

import jp.co.honest.domain.Book;

/*
 * ブックに関するサービスを提供するクラス
 */
public interface BookService {
    

    /**
     * すべてのブックを取得
     *
     * @return ブックリスト
     */
    List<Book> getBookList();

    /**
     * ブックを取得
     *
     * @param bookId ブックID
     * @return ブック情報
     */
    Optional<Book> getBook(Integer bookId);

    /**
     * ブック情報を保存
     *
     * @param book ブック情報
     */
    void saveBook(Book book);

    /**
     * ブックを削除
     *
     * @param bookId ブックID
     */
    void deleteBook(Integer bookId);
}