package org.example.spring6webapp.bootstrap;

import org.example.spring6webapp.domain.Author;
import org.example.spring6webapp.domain.Book;
import org.example.spring6webapp.domain.Publisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.example.spring6webapp.repositories.AuthorRepository;
import org.example.spring6webapp.repositories.BookRepository;
import org.example.spring6webapp.repositories.PublisherRepository;


@Component
public class BootstrapData implements CommandLineRunner {


    private  final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author vali = new Author();
        vali.setFirstname("Valentina");
        vali.setLastname("toska");

        Book aaa =new Book();
        aaa.setTitle("AnaMari");
        aaa.setIsbn("12345");
        Author valiSaved =authorRepository.save(vali);
        Book aaaSaved =bookRepository.save(aaa);


        Author sona = new Author();
        sona.setFirstname("son");
        sona.setLastname("toska");

        Book bbb =new Book();
        bbb.setTitle("Davide");
        bbb.setIsbn("14545");

        Author sonaSaved =authorRepository.save(sona);
        Book bbbSaved =bookRepository.save(bbb);

        valiSaved.getBooks().add(aaaSaved);
        sonaSaved.getBooks().add(bbbSaved);

        authorRepository.save(valiSaved);
        authorRepository.save(sonaSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author count" + authorRepository.count());
        System.out.println("book count " + bookRepository.count());

        Publisher publisher = new Publisher();
        publisher.setPublisherName("My publidher");
        publisher.setAddress("Siri Kodra");
        publisherRepository.save(publisher);
        System.out.println("Publisher count" + publisherRepository.count());

    }

}
