package guru.springfamework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import guru.springfamework.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
