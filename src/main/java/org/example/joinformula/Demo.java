package org.example.joinformula;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Demo implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final PersonRepository personRepository;
    private final HistoryRepository historyRepository;

    public Demo(PersonRepository personRepository, HistoryRepository historyRepository) {
        this.personRepository = personRepository;
        this.historyRepository = historyRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        List<Person> p1 = personRepository.get();
        logger.info("get() works: {}", p1);

        List<Person> p2 = personRepository.getNative();
        logger.info("getNative() doesn't work: {}", p2);
    }

}