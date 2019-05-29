package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

	 @Autowired
	    private BookRepository repository;
	    
	    @Test
	    public void findByTitleShouldReturnBook() {
	        List<Book> books = repository.findByAuthor("G.G.Martin");
	        
	        assertThat(books).hasSize(1);
	        assertThat(books.get(0).getAuthor()).isEqualTo("G.G.Martin");
	    }
	    
	    @Test
	    public void createNewBook() {
	    	Book book = new Book("IT", "Stephene King", 1992, "2113", 70, new Category("Horror"));
	    	repository.save(book);
	    	assertThat(book.getId()).isNotNull();
	    }  
}
