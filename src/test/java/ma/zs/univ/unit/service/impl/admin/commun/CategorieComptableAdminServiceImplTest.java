package ma.zs.univ.unit.service.impl.admin.commun;

import ma.zs.univ.bean.core.commun.CategorieComptable;
import ma.zs.univ.dao.facade.core.commun.CategorieComptableDao;
import ma.zs.univ.service.impl.admin.commun.CategorieComptableAdminServiceImpl;

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
class CategorieComptableAdminServiceImplTest {

    @Mock
    private CategorieComptableDao repository;
    private AutoCloseable autoCloseable;
    private CategorieComptableAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new CategorieComptableAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllCategorieComptable() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveCategorieComptable() {
        // Given
        CategorieComptable toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteCategorieComptable() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetCategorieComptableById() {
        // Given
        Long idToRetrieve = 1L; // Example CategorieComptable ID to retrieve
        CategorieComptable expected = new CategorieComptable(); // You need to replace CategorieComptable with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        CategorieComptable result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private CategorieComptable constructSample(int i) {
		CategorieComptable given = new CategorieComptable();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        return given;
    }

}
