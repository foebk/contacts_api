package ru.contacts.Services;

import ru.contacts.entities.Contacts;

import java.util.List;

public interface FindContactsService {
    List<Contacts> findAllContacts();

    List<Contacts> findFilteredContacts(String filter);
}
