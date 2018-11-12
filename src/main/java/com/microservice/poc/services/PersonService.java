package com.microservice.poc.services;

import com.microservice.poc.dao.AbstractDao;
import com.microservice.poc.dao.PersonDao;
import com.microservice.poc.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;

@Service
public class PersonService extends AbstractService<Person> {

    @Autowired
    public PersonService(@Qualifier("personDao") AbstractDao<Person> dao) {
        super(dao);
    }

    @Override
    public Person create(Person person) {
        return super.create(person);
    }

    @Override
    public void delete(Long id) {
        PersonDao personDao = (PersonDao) dao;
        //personDao.delete(id);
    }

    @Override
    public void update(Person person) {
        super.update(person);
    }

    private List<Person> persons;

    @PostConstruct
    void init() {
        this.persons = new ArrayList<>();

        Person john = new Person(1L, "John", "Smith", 42);
        persons.add(john);

        Person jane = new Person(2L, "Jane", "Jonhnson", 19);
        persons.add(jane);

        Person kate = new Person(3L, "Kate", "Jones", 33);
        persons.add(kate);
    }

    public List<Person> getAllPersons() {
        return this.persons;
    }

    public Person getPersonById(int id) {
        return this.persons
                .stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Person createPerson(Person person) {
        OptionalLong maxId = this.persons.stream().mapToLong(Person::getId).max();
        if (maxId.isPresent()) {
            person.setId(maxId.getAsLong() + 1L);
        }

        return person;
    }

    public void deletePerson(int id) {
        for (Person person : this.persons) {
            if(person.getId() == id) {
                this.persons.remove(person);
                return;
            }
        }
    }
}
