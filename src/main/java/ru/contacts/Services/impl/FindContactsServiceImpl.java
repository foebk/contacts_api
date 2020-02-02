package ru.contacts.Services.impl;

import org.springframework.stereotype.Service;
import ru.contacts.Repos.ContactsRepository;
import ru.contacts.Services.FindContactsService;
import ru.contacts.entities.Contacts;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindContactsServiceImpl implements FindContactsService {
    private ContactsRepository contactsRepository;

    public FindContactsServiceImpl(ContactsRepository contactsRepository){
        this.contactsRepository = contactsRepository;
    }

    public List<Contacts> findAllContacts() {
        return contactsRepository.findAll();
    }

    public List<Contacts> findFilteredContacts(String filter) {
        List<Contacts> contacts = contactsRepository.findAll();
        List<Contacts> filteredContacts = new ArrayList<>();


        String lowerCaseFilter = "^" + filter.toLowerCase() + ".*";

        contacts.stream().filter(contact -> {
            boolean suitable = false;
            if (contact.getName() != null) {
                if (contact.getName().toLowerCase().matches(lowerCaseFilter)) {
                    return true;
                }
            }
            if (contact.getSurname() != null) {
                if (contact.getSurname().toLowerCase().matches(lowerCaseFilter) ||
                        (contact.getName() + " " + contact.getSurname()).toLowerCase().matches(lowerCaseFilter)) {
                    return true;
                }
            }
            if (contact.getPhone() != null) {
                if (contact.getPhone().toLowerCase().matches(lowerCaseFilter)) {
                    return true;
                }
            }
            if (contact.getAddress() != null) {
                return contact.getAddress().toLowerCase().matches(lowerCaseFilter);
            }
            return false;
        }).forEach(filteredContacts::add);

        return filteredContacts;
    }
}
