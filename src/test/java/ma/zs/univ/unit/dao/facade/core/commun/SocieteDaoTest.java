package ma.zs.univ.unit.dao.facade.core.commun;

import ma.zs.univ.bean.core.commun.Societe;
import ma.zs.univ.dao.facade.core.commun.SocieteDao;

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
public class SocieteDaoTest {

@Autowired
    private SocieteDao underTest;

    @Test
    void shouldFindByRc(){
        String rc = "rc-1";
        Societe entity = new Societe();
        entity.setRc(rc);
        underTest.save(entity);
        Societe loaded = underTest.findByRc(rc);
        assertThat(loaded.getRc()).isEqualTo(rc);
    }

    @Test
    void shouldDeleteByRc() {
        String rc = "rc-1";
        Societe entity = new Societe();
        entity.setRc(rc);
        underTest.save(entity);

        int result = underTest.deleteByRc(rc);

        Societe loaded = underTest.findByRc(rc);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        Societe entity = new Societe();
        entity.setId(id);
        underTest.save(entity);
        Societe loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Societe entity = new Societe();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Societe loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Societe> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Societe> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Societe given = constructSample(1);
        Societe saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Societe constructSample(int i) {
		Societe given = new Societe();
        given.setIce("ice-"+i);
        given.setRc("rc-"+i);
        return given;
    }

}
