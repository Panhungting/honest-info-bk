package jp.co.honest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.honest.domain.Book;
import jp.co.honest.repository.BookRepository;
import jp.co.honest.service.BookService;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Book> getBookList() {
        return bookRepository.selectAll();    
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Book> getBook(Integer bookId) {
        return bookRepository.selectByBookId(bookId); 
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveBook(Book pBook) {

        if (pBook.getBookId() != null) {
            bookRepository.update(pBook);
        } else {
            bookRepository.insert(pBook);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteBook(Integer bookId) {
        bookRepository.delete(bookId); 
    }
}