package ma.zs.univ.unit.service.impl.admin.paiement;

import ma.zs.univ.bean.core.paiement.PaiementComptableValidateur;
import ma.zs.univ.dao.facade.core.paiement.PaiementComptableValidateurDao;
import ma.zs.univ.service.impl.admin.paiement.PaiementComptableValidateurAdminServiceImpl;

import ma.zs.univ.bean.core.demande.Demande ;
import ma.zs.univ.bean.core.paiement.TypePaiement ;
import ma.zs.univ.bean.core.commun.Comptable ;
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
class PaiementComptableValidateurAdminServiceImplTest {

    @Mock
    private PaiementComptableValidateurDao repository;
    private AutoCloseable autoCloseable;
    private PaiementComptableValidateurAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new PaiementComptableValidateurAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllPaiementComptableValidateur() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSavePaiementComptableValidateur() {
        // Given
        PaiementComptableValidateur toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeletePaiementComptableValidateur() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetPaiementComptableValidateurById() {
        // Given
        Long idToRetrieve = 1L; // Example PaiementComptableValidateur ID to retrieve
        PaiementComptableValidateur expected = new PaiementComptableValidateur(); // You need to replace PaiementComptableValidateur with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        PaiementComptableValidateur result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private PaiementComptableValidateur constructSample(int i) {
		PaiementComptableValidateur given = new PaiementComptableValidateur();
        given.setCode("code-"+i);
        given.setDemande(new Demande(1L));
        given.setMontant(BigDecimal.TEN);
        given.setComptableValidateur(new Comptable(1L));
        given.setTypePaiement(new TypePaiement(1L));
        given.setDatePaiement(LocalDateTime.now());
        return given;
    }

}
