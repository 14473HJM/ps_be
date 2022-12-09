package ar.edu.utn.frc.tup.ps.psappbe.services.people;

import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Contact;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.ContactScope;
import ar.edu.utn.frc.tup.ps.psappbe.entities.people.ContactEntity;
import ar.edu.utn.frc.tup.ps.psappbe.services.BaseModelService;

import java.util.List;
import java.util.stream.Collectors;

public interface ContactService extends BaseModelService<Contact, ContactEntity> {

    List<Contact> filterContacts(List<Contact> contacts, ContactScope contactScope);
}
