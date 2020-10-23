package com.giga.service;

import com.giga.entity.Book;
import com.giga.entity.Code;
import com.giga.entity.Status;
import com.giga.exception.NotAvailableException;
import com.giga.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BookService implements IBookService {

    @Autowired
    IBookRepository bookRepository;

    @Autowired
    ICodeService codeService;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
        Status available = new Status(1);
        for (int i = 0; i < book.getQuantity(); i++) {
            int n = 10000 + new Random().nextInt(90000);
            Code code = new Code(n, bookRepository.findById(book.getId()).orElse(null), available);
            book.generateCode(code);
            codeService.save(code);
        }
        bookRepository.save(book);
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void borrow(Book book, Integer usedCode) {
        List<Code> codeList = codeService.findAllCodeByBookId(book.getId());
        for (Code code : codeList) {
            if (code.getCode().equals(usedCode)) {
                code.setStatus(new Status(2, "in used"));
                break;
            }
        }
        book.borrow();
        bookRepository.save(book);
    }

    @Override
    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Code getNextAvailableCode(Book book) throws NotAvailableException {
        List<Code> codeList = codeService.findAvailableCodeByBookId(book.getId());
        if (codeList.size() == 0) {
            throw new NotAvailableException();
        }
        return codeList.get(0);
    }


}
