package ma.zs.univ.unit.service.impl.admin.commun;

import ma.zs.univ.bean.core.commun.Comptable;
import ma.zs.univ.dao.facade.core.commun.ComptableDao;
import ma.zs.univ.service.impl.admin.commun.ComptableAdminServiceImpl;

import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDateTime;



import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
class ComptableAdminServiceImplTest {

    @Mock
    private ComptableDao repository;
    private AutoCloseable autoCloseable;
    private ComptableAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ComptableAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllComptable() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveComptable() {
        // Given
        Comptable toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteComptable() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetComptableById() {
        // Given
        Long idToRetrieve = 1L; // Example Comptable ID to retrieve
        Comptable expected = new Comptable(); // You need to replace Comptable with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Comptable result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Comptable constructSample(int i) {
		Comptable given = new Comptable();
        given.setCin("cin-"+i);
        given.setPrenom("prenom-"+i);
        given.setNom("nom-"+i);
        given.setEmail("email-"+i);
        given.setCategorieComptable("categorieComptable-"+i);
        return given;
    }

}
