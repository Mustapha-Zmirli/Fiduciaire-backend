package ma.zs.univ.unit.dao.facade.core.demande;

import ma.zs.univ.bean.core.demande.DemandePieceJoint;
import ma.zs.univ.dao.facade.core.demande.DemandePieceJointDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.univ.bean.core.demande.Demande ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class DemandePieceJointDaoTest {

@Autowired
    private DemandePieceJointDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        DemandePieceJoint entity = new DemandePieceJoint();
        entity.setCode(code);
        underTest.save(entity);
        DemandePieceJoint loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        DemandePieceJoint entity = new DemandePieceJoint();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        DemandePieceJoint loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        DemandePieceJoint entity = new DemandePieceJoint();
        entity.setId(id);
        underTest.save(entity);
        DemandePieceJoint loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        DemandePieceJoint entity = new DemandePieceJoint();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        DemandePieceJoint loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<DemandePieceJoint> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<DemandePieceJoint> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        DemandePieceJoint given = constructSample(1);
        DemandePieceJoint saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
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
