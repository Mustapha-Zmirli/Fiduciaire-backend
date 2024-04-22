package ma.zs.univ.unit.dao.facade.core.commun;

import ma.zs.univ.bean.core.commun.CategorieComptable;
import ma.zs.univ.dao.facade.core.commun.CategorieComptableDao;

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
public class CategorieComptableDaoTest {

@Autowired
    private CategorieComptableDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        CategorieComptable entity = new CategorieComptable();
        entity.setCode(code);
        underTest.save(entity);
        CategorieComptable loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        CategorieComptable entity = new CategorieComptable();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        CategorieComptable loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        CategorieComptable entity = new CategorieComptable();
        entity.setId(id);
        underTest.save(entity);
        CategorieComptable loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        CategorieComptable entity = new CategorieComptable();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        CategorieComptable loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<CategorieComptable> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<CategorieComptable> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        CategorieComptable given = constructSample(1);
        CategorieComptable saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private CategorieComptable constructSample(int i) {
		CategorieComptable given = new CategorieComptable();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        return given;
    }

}
