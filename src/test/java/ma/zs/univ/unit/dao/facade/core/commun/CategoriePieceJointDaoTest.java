package ma.zs.univ.unit.dao.facade.core.commun;

import ma.zs.univ.bean.core.commun.CategoriePieceJoint;
import ma.zs.univ.dao.facade.core.commun.CategoriePieceJointDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class CategoriePieceJointDaoTest {

@Autowired
    private CategoriePieceJointDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        CategoriePieceJoint entity = new CategoriePieceJoint();
        entity.setCode(code);
        underTest.save(entity);
        CategoriePieceJoint loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        CategoriePieceJoint entity = new CategoriePieceJoint();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        CategoriePieceJoint loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        CategoriePieceJoint entity = new CategoriePieceJoint();
        entity.setId(id);
        underTest.save(entity);
        CategoriePieceJoint loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        CategoriePieceJoint entity = new CategoriePieceJoint();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        CategoriePieceJoint loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<CategoriePieceJoint> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<CategoriePieceJoint> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        CategoriePieceJoint given = constructSample(1);
        CategoriePieceJoint saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private CategoriePieceJoint constructSample(int i) {
		CategoriePieceJoint given = new CategoriePieceJoint();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        return given;
    }

}
