package ar.edu.utn.frc.tup.ps.psappbe.services.people;

import ar.edu.utn.frc.tup.ps.psappbe.domain.address.Address;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.*;
import ar.edu.utn.frc.tup.ps.psappbe.domain.user.Role;
import ar.edu.utn.frc.tup.ps.psappbe.domain.user.User;
import ar.edu.utn.frc.tup.ps.psappbe.entities.people.StudentEntity;
import ar.edu.utn.frc.tup.ps.psappbe.repository.StudentRepository;
import ar.edu.utn.frc.tup.ps.psappbe.services.BaseModelServiceImpl;
import ar.edu.utn.frc.tup.ps.psappbe.services.common.PlatformNetworkService;
import ar.edu.utn.frc.tup.ps.psappbe.services.user.AddressService;
import ar.edu.utn.frc.tup.ps.psappbe.services.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class StudentServiceImpl extends BaseModelServiceImpl<Student, StudentEntity> implements StudentService {

    private final StudentRepository studentRepository;

    private final IdentificationService identificationService;

    private final AddressService addressService;

    private final ContactService contactService;

    private final UserService userService;

    private final PlatformNetworkService platformNetworkService;

    private final ModelMapper modelMapper;
    @Override
    protected JpaRepository<StudentEntity, Long> getJpaRepository() {
        return studentRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }

    @Override
    public Student create(Student student) {
        // Save Identifications
        createUserIdentifications(student);
        // Save Address
        if(student.getAddress() != null) {
            Address address = addressService.create(student.getAddress());
            student.setAddress(address);
        }

        User user = student.getUser();
        user.setRoles(Arrays.asList(Role.STUDENT));
        // Save User
        user = userService.create(student.getUser());
        // Setting information
        student.setUser(user);
        student.setStatus(PersonStatus.ACTIVE);
        // Save Student
        Student studentDb = super.create(student);
        // Update User
        user.setPerson(studentDb);
        studentDb.setUser(userService.update(user));
        // Save Contacts
        if(student.getUniversityContacts() != null && !student.getUniversityContacts().isEmpty()) {
            student.getUniversityContacts().forEach(contact -> {
                contact.setContactScope(ContactScope.UNIVERSITY);
                contact.setPerson(studentDb);
            });
            studentDb.setUniversityContacts(contactService.createAll(student.getUniversityContacts()));
        }
        if(student.getPersonalContacts() != null && !student.getPersonalContacts().isEmpty()) {
            student.getPersonalContacts().forEach(contact -> {
                contact.setContactScope(ContactScope.PERSONAL);
                contact.setPerson(studentDb);
            });
            studentDb.setPersonalContacts(contactService.createAll(student.getPersonalContacts()));
        }
        // Save Social Networks
        if(student.getSocialNetworks() != null && !student.getSocialNetworks().isEmpty()) {
            student.getSocialNetworks().forEach(socialNetwork -> {
                socialNetwork.setPerson(studentDb);
            });
            studentDb.setSocialNetworks(platformNetworkService.createAll(student.getSocialNetworks()));
        }
        return studentDb;
    }

    private void createUserIdentifications(Student student) {
        if(student.getPersonIdentification() != null) {
            Identification personIdentification = identificationService.create(student.getPersonIdentification());
            student.setPersonIdentification(personIdentification);
        }
        if(student.getUniversityIdentification() != null) {
            Identification universityIdentification = identificationService.create(student.getUniversityIdentification());
            student.setUniversityIdentification(universityIdentification);
        }
    }

    @Override
    public Student getById(Long id, Boolean includeDeletes) {
        Student student = super.getById(id, includeDeletes);
        if(student != null && student.getUniversityContacts() != null) {
            student.setUniversityContacts(contactService.filterContacts(student.getUniversityContacts(), ContactScope.UNIVERSITY));
        }
        if(student != null && student.getPersonalContacts() != null) {
            student.setPersonalContacts(contactService.filterContacts(student.getPersonalContacts(), ContactScope.PERSONAL));
        }
        return student;
    }

    @Override
    public List<Student> getAll(Boolean includeDeletes) {
        List<Student> students = super.getAll(includeDeletes);
        if(students != null && !students.isEmpty()) {
            students.forEach((student) -> {
                if (student != null && student.getUniversityContacts() != null) {
                    student.setUniversityContacts(contactService.filterContacts(student.getUniversityContacts(), ContactScope.UNIVERSITY));
                }
                if (student != null && student.getPersonalContacts() != null) {
                    student.setPersonalContacts(contactService.filterContacts(student.getPersonalContacts(), ContactScope.PERSONAL));
                }
            });
        }
        return students;
    }

}

