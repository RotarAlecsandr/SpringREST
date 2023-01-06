package ru.rotar.springRest.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PersonDetailsServiceTest {

    @Mock
    private PersonDetailsService personDetailsService;

    @Test
    void loadUserByUsername() {
        personDetailsService.loadUserByUsername("Hello world");
    }
}