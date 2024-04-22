package ma.zs.univ.unit.service.impl.admin.commun;

import ma.zs.univ.bean.core.commun.Societe;
import ma.zs.univ.dao.facade.core.commun.SocieteDao;
import ma.zs.univ.service.impl.admin.commun.SocieteAdminServiceImpl;

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
class SocieteAdminServiceImplTest {

    @Mock
    private SocieteDao repository;
    private AutoCloseable autoCloseable;
    private SocieteAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new SocieteAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllSociete() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveSociete() {
        // Given
        Societe toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteSociete() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetSocieteById() {
        // Given
        Long idToRetrieve = 1L; // Example Societe ID to retrieve
        Societe expected = new Societe(); // You need to replace Societe with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Societe result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Societe constructSample(int i) {
		Societe given = new Societe();
        given.setIce("ice-"+i);
        given.setRc("rc-"+i);
        return given;
    }

}
