package ru.contacts.Services.impl;

import org.springframework.stereotype.Service;
import ru.contacts.Repos.ContactsRepository;
import ru.contacts.Services.DeleteContactService;

@Service
public class DeleteContactServiceImpl implements DeleteContactService {

    private ContactsRepository contactsRepository;

    public DeleteContactServiceImpl(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    public void deleteContact(Integer id) {
        contactsRepository.deleteById(id);
    }
}
