package ru.contacts.Services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.contacts.Repos.ContactsRepository;
import ru.contacts.Services.CreateContactService;
import ru.contacts.entities.Contacts;

@Service
public class CreateContactServiceImpl implements CreateContactService {
    private ContactsRepository contactsRepository;

    @Autowired
    public CreateContactServiceImpl(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    public void createContact(String name, String surname, String phone, String address) {
        Contacts contacts = new Contacts();

        contacts.setName(name);
        contacts.setSurname(surname);
        contacts.setPhone(phone);
        contacts.setAddress(address);

        contactsRepository.save(contacts);
    }
}
