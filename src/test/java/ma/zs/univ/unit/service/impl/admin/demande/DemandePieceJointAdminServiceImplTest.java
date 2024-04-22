package ma.zs.univ.unit.service.impl.admin.demande;

import ma.zs.univ.bean.core.demande.DemandePieceJoint;
import ma.zs.univ.dao.facade.core.demande.DemandePieceJointDao;
import ma.zs.univ.service.impl.admin.demande.DemandePieceJointAdminServiceImpl;

import ma.zs.univ.bean.core.demande.Demande ;
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
class DemandePieceJointAdminServiceImplTest {

    @Mock
    private DemandePieceJointDao repository;
    private AutoCloseable autoCloseable;
    private DemandePieceJointAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new DemandePieceJointAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllDemandePieceJoint() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveDemandePieceJoint() {
        // Given
        DemandePieceJoint toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteDemandePieceJoint() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetDemandePieceJointById() {
        // Given
        Long idToRetrieve = 1L; // Example DemandePieceJoint ID to retrieve
        DemandePieceJoint expected = new DemandePieceJoint(); // You need to replace DemandePieceJoint with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        DemandePieceJoint result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private DemandePieceJoint constructSample(int i) {
		DemandePieceJoint given = new DemandePieceJoint();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        given.setDemande(new Demande(1L));
        given.setPath("path-"+i);
        return given;
    }

}
