package ma.zs.univ.unit.service.impl.admin.paiement;

import ma.zs.univ.bean.core.paiement.PaiementComptableTraitant;
import ma.zs.univ.dao.facade.core.paiement.PaiementComptableTraitantDao;
import ma.zs.univ.service.impl.admin.paiement.PaiementComptableTraitantAdminServiceImpl;

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
class PaiementComptableTraitantAdminServiceImplTest {

    @Mock
    private PaiementComptableTraitantDao repository;
    private AutoCloseable autoCloseable;
    private PaiementComptableTraitantAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new PaiementComptableTraitantAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllPaiementComptableTraitant() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSavePaiementComptableTraitant() {
        // Given
        PaiementComptableTraitant toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeletePaiementComptableTraitant() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetPaiementComptableTraitantById() {
        // Given
        Long idToRetrieve = 1L; // Example PaiementComptableTraitant ID to retrieve
        PaiementComptableTraitant expected = new PaiementComptableTraitant(); // You need to replace PaiementComptableTraitant with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        PaiementComptableTraitant result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private PaiementComptableTraitant constructSample(int i) {
		PaiementComptableTraitant given = new PaiementComptableTraitant();
        given.setCode("code-"+i);
        given.setDemande(new Demande(1L));
        given.setMontant(BigDecimal.TEN);
        given.setComptableTraitant(new Comptable(1L));
        given.setTypePaiement(new TypePaiement(1L));
        given.setDatePaiement(LocalDateTime.now());
        return given;
    }

}
