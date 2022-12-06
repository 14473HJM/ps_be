package ar.edu.utn.frc.tup.ps.psappbe.services.people;

import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Contact;
import ar.edu.utn.frc.tup.ps.psappbe.entities.people.ContactEntity;
import ar.edu.utn.frc.tup.ps.psappbe.repository.ContactRepository;
import ar.edu.utn.frc.tup.ps.psappbe.repository.IdentificationRepository;
import ar.edu.utn.frc.tup.ps.psappbe.services.BaseModelServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ContactServiceImpl extends BaseModelServiceImpl<Contact, ContactEntity> implements ContactService {

    private final ContactRepository contactRepository;

    private final ModelMapper modelMapper;
    @Override
    protected JpaRepository getJpaRepository() {
        return contactRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }
}
