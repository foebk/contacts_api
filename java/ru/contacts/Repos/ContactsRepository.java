package ru.contacts.Repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.contacts.entities.Contacts;

import java.util.List;

@Repository
public interface ContactsRepository extends CrudRepository<Contacts, Integer> {
    List<Contacts> findAll();
}
