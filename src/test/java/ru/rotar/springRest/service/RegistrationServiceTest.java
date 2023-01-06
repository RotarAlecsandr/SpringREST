package ru.rotar.springRest.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.rotar.springRest.model.Person;


@ExtendWith(MockitoExtension.class)
class RegistrationServiceTest {

    @Mock
    private RegistrationService registrationService;

    @Test
    void register() {
        Person person = new Person();
        registrationService.register(person);
    }
}