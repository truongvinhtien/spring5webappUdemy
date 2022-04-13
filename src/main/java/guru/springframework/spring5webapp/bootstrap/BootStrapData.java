package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.crypto.interfaces.PBEKey;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepo;
    private final BookRepository bookRepo;
    private final PublisherRepository publisherRepo;

    public BootStrapData(AuthorRepository authorRepo, BookRepository bookRepo, PublisherRepository publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher = new Publisher();
        publisher.setName("Dong Ho");
        publisher.setCity("Rach Gia");
        publisher.setState("Kien Giang");

        publisherRepo.save(publisher);

        Author eric = new Author("Eric", "Evan");
        Book porn = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(porn);
        porn.getAuthors().add(eric);
        porn.setPublisher(publisher);
        publisher.getBooks().add(porn);

        authorRepo.save(eric);
        bookRepo.save(porn);
        publisherRepo.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development with EJB", "323123");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);
        authorRepo.save(rod);
        bookRepo.save(noEJB);
        publisherRepo.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepo.count());
        System.out.println("Publisher books: " + publisher.getBooks().size());
    }
}
