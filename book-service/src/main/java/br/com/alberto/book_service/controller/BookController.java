package br.com.alberto.book_service.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.alberto.book_service.model.Book;
import br.com.alberto.book_service.proxy.CambioProxy;
import br.com.alberto.book_service.repository.BookRepository;

@RestController
@RequestMapping("book-service")
public class BookController {

  @Autowired
  private BookRepository bookRepository;
  
  @Autowired
  private CambioProxy cambioProxy;

  @GetMapping(value="/{id}/{currency}")
  public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {
    var book = bookRepository.findById(id).get();
    if (book == null) {
      throw new RuntimeException("Book not found");
    }
    var cambio = cambioProxy.getCambio(book.getPrice(), "USD", currency);
    book.setPrice(cambio.getConvertedValue());
    return book;
  }


  /*
   * @GetMapping(value="/{id}/{currency}")
   * public Book findBook(@PathVariable("id") Long id, @PathVariable("currency")
   * String currency) {
   * var book = bookRepository.findById(id).get();
   * if (book == null) {
   * throw new RuntimeException("Book not found");
   * }
   * HashMap<String, String> params = new HashMap<>();
   * params.put("amount", book.getPrice().toString());
   * params.put("from", "USD");
   * params.put("to", currency);
   * var cambio = new RestTemplate().getForEntity(
   * "http://localhost:8000/cambio-service/{amount}/{from}/{to}",
   * Cambio.class, params);
   * book.setPrice(cambio.getBody().getConvertedValue());
   * return book;
   * }
   */
}
