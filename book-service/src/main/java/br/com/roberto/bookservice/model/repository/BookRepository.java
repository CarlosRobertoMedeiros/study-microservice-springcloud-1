package br.com.roberto.bookservice.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.roberto.bookservice.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	
}
