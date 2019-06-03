package guru.springfamework.spring5webapp.bootstrap;

import guru.springfamework.spring5webapp.model.Author;
import guru.springfamework.spring5webapp.model.Book;
import guru.springfamework.spring5webapp.model.Publisher;
import guru.springfamework.spring5webapp.repositories.AuthorRepository;
import guru.springfamework.spring5webapp.repositories.BookRepository;
import guru.springfamework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher hc = new Publisher("Harper Collins", "Test Address for HC");
        publisherRepository.save(hc);
        Publisher wrox = new Publisher("Wrox", "Test Address for wrox");
        publisherRepository.save(wrox);

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", wrox);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", hc);
        rod.getBooks().add(noEJB);
        eric.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
