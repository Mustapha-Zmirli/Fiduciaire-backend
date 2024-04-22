package ma.zs.univ.unit.service.impl.admin.demande;

import ma.zs.univ.bean.core.demande.TypeDemande;
import ma.zs.univ.dao.facade.core.demande.TypeDemandeDao;
import ma.zs.univ.service.impl.admin.demande.TypeDemandeAdminServiceImpl;

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
class TypeDemandeAdminServiceImplTest {

    @Mock
    private TypeDemandeDao repository;
    private AutoCloseable autoCloseable;
    private TypeDemandeAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new TypeDemandeAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllTypeDemande() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveTypeDemande() {
        // Given
        TypeDemande toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteTypeDemande() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetTypeDemandeById() {
        // Given
        Long idToRetrieve = 1L; // Example TypeDemande ID to retrieve
        TypeDemande expected = new TypeDemande(); // You need to replace TypeDemande with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        TypeDemande result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private TypeDemande constructSample(int i) {
		TypeDemande given = new TypeDemande();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        given.setHonnoraireComptableTraitant(BigDecimal.TEN);
        given.setHonnoraireComptableValidateur(BigDecimal.TEN);
        return given;
    }

}
