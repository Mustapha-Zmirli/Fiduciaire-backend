package ma.zs.univ.unit.service.impl.admin.commun;

import ma.zs.univ.bean.core.commun.CategoriePieceJoint;
import ma.zs.univ.dao.facade.core.commun.CategoriePieceJointDao;
import ma.zs.univ.service.impl.admin.commun.CategoriePieceJointAdminServiceImpl;

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
class CategoriePieceJointAdminServiceImplTest {

    @Mock
    private CategoriePieceJointDao repository;
    private AutoCloseable autoCloseable;
    private CategoriePieceJointAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new CategoriePieceJointAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllCategoriePieceJoint() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveCategoriePieceJoint() {
        // Given
        CategoriePieceJoint toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteCategoriePieceJoint() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetCategoriePieceJointById() {
        // Given
        Long idToRetrieve = 1L; // Example CategoriePieceJoint ID to retrieve
        CategoriePieceJoint expected = new CategoriePieceJoint(); // You need to replace CategoriePieceJoint with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        CategoriePieceJoint result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private CategoriePieceJoint constructSample(int i) {
		CategoriePieceJoint given = new CategoriePieceJoint();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        return given;
    }

}
