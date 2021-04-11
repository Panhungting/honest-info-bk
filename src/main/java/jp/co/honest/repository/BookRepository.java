package jp.co.honest.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import jp.co.honest.domain.Book;

@Mapper
public interface BookRepository {

    @Select("SELECT book_id, title, price, summary, created_at FROM book WHERE book_id = #{bookId}")
    Optional<Book> selectByBookId(Integer bookId);

    @Select("SELECT book_id, title, price, summary, created_at FROM book")
    List<Book> selectAll();

    @Insert("INSERT INTO book (title, price, summary, created_at) VALUES (#{title}, #{price}, #{summary}, utc_timestamp())")
    @Options(useGeneratedKeys = true, keyProperty = "bookId")
    void insert(Book book);

    @Update("UPDATE book SET title = #{title}, price = #{price}, summary = #{summary}, created_at = utc_timestamp() WHERE book_id = #{bookId}")
    boolean update(Book book);

    @Delete("DELETE FROM book WHERE book_id = #{bookId}")
    void delete(Integer bookId);
}