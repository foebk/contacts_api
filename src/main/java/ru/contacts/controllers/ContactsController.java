package ru.contacts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.contacts.Services.CreateContactService;
import ru.contacts.Services.DeleteContactService;
import ru.contacts.Services.FindContactsService;
import ru.contacts.entities.Contacts;

import java.util.List;

@RestController
public class ContactsController  {
    private CreateContactService createContactService;
    private FindContactsService findContactsService;
    private DeleteContactService deleteContactService;

    @Autowired
    public ContactsController(CreateContactService createContactService,
                              FindContactsService findContactsService,
                              DeleteContactService deleteContactService) {
        this.createContactService = createContactService;
        this.findContactsService = findContactsService;
        this.deleteContactService = deleteContactService;
    }

    @GetMapping("/createContact")
    public String createContact(@RequestParam(name = "name") String name,
                                @RequestParam(name = "surname") String surname,
                                @RequestParam(name = "phone") String phone,
                                @RequestParam(name = "address") String address) {

        createContactService.createContact(name, surname, phone, address);

        return "Contact created";
    }

    @GetMapping("/getAllContacts")
    public List<Contacts> getAllContacts() {
        return findContactsService.findAllContacts();
    }

    @GetMapping("/getFilteredContacts")
    public List<Contacts> getFilteredContacts(@RequestParam (name = "filter") String filter) {
        return findContactsService.findFilteredContacts(filter);
    }

    @GetMapping("/deleteContact")
    public String deleteContact(@RequestParam (name = "id") Integer id) {
        deleteContactService.deleteContact(id);

        return "Contact deleted";
    }
}
