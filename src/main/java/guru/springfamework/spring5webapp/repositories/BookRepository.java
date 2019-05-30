package guru.springfamework.spring5webapp.repositories;

import guru.springfamework.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
