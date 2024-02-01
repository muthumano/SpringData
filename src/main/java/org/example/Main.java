package org.example;

import org.data.entity.Person;
import org.data.repo.PersonRepo;
import org.service.api.EntryController;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:application-config.xml");
       EntryController cont =  appContext.getBean(EntryController.class);
       Person p = Person.of("Science");
       PersonRepo rep = appContext.getBean(PersonRepo.class);
       rep.save(p);

       rep.findAll().forEach(p1-> System.out.println(p1.getDepartment()));
       rep.findById(p.getPersonId()).ifPresentOrElse(p2->System.out.println(p2.getDepartment()), ()-> System.out.println("No recs found"));
       assert(cont!=null);
    }
}