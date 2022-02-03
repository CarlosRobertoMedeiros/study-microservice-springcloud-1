package br.com.roberto.bookservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.roberto.bookservice.model.Book;
import br.com.roberto.bookservice.model.repository.BookRepository;
import br.com.roberto.bookservice.proxy.CambioProxy;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Book endpoint") 
@RestController
@RequestMapping("book-service")
public class BookController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CambioProxy cambioProxy;
	
	@GetMapping(value = "/{id}/{currency}") 
	@Operation(summary = "Find a specific book by your id")
	public Book findBook(
			@PathVariable("id") Long id,
			@PathVariable("currency") String currency
			) {
		
		var book = bookRepository.getById(id);
		
		if (book == null) throw new RuntimeException("Book Not Found");
		
		var cambio = cambioProxy.getCambio(book.getPrice(), "USD", currency);
		
		var port = environment.getProperty("local.server.port");
		book.setEnvironment("Book port: "+ port+" Cambio port:"+cambio.getEnvironment());
		book.setPrice(cambio.getConvertedValue());
		
		return book;
	}
	
	
	/*Usando RestTemplate
	 * @GetMapping(value = "/{id}/{currency}") 
	public Book findBook(
			@PathVariable("id") Long id,
			@PathVariable("currency") String currency
			) {
		
		var book = bookRepository.getById(id);
		
		if (book == null) throw new RuntimeException("Book Not Found");
		
		Map<String, String> params = new HashMap<>();
		params.put("amount", book.getPrice().toString());
		params.put("from", "USD");
		params.put("to", currency);
		
		var response = new RestTemplate()
			.getForEntity("http://localhost:8000/cambio-service/"
					+ "{amount}/{from}/{to}",
					Cambio.class,
					params);
		
		var cambio = response.getBody();
		
		var port = environment.getProperty("local.server.port");
		book.setEnvironment(port);
		book.setPrice(cambio.getConvertedValue());
		
		return book;
	}*/

}
