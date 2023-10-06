package ru.study.seminar4.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class BookServiceTest {

    BookRepository fakeRepo;
    BookService testedObj;

    @BeforeEach
    void initBookService() {
        fakeRepo = mock(BookRepository.class);
        testedObj = new BookService(fakeRepo);
    }


    @Test
    void findBookById() {
        Book testBook = new Book("abc");
        when(fakeRepo.findById("abc")).thenReturn(testBook);
        assertEquals(testBook, testedObj.findBookById("abc"));
        verify(fakeRepo, times(1)).findById("abc");
    }

    @Test
    void findAllBooks() {
        // Воспользуюсь InMemoryBookRepository как готовыми тестовыми данными
        BookRepository inMemoryBook = new InMemoryBookRepository();
        List<Book> realBooks = inMemoryBook.findAll();
        when(fakeRepo.findAll()).thenReturn(realBooks);
        assertThat(testedObj.findAllBooks()).isEqualTo(realBooks);
        verify(fakeRepo, times(1)).findAll();
    }
}