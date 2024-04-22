package ma.zs.univ.unit.dao.facade.core.commun;

import ma.zs.univ.bean.core.commun.Comptable;
import ma.zs.univ.dao.facade.core.commun.ComptableDao;

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
public class ComptableDaoTest {

@Autowired
    private ComptableDao underTest;

    @Test
    void shouldFindByCin(){
        String cin = "cin-1";
        Comptable entity = new Comptable();
        entity.setCin(cin);
        underTest.save(entity);
        Comptable loaded = underTest.findByCin(cin);
        assertThat(loaded.getCin()).isEqualTo(cin);
    }

    @Test
    void shouldDeleteByCin() {
        String cin = "cin-1";
        Comptable entity = new Comptable();
        entity.setCin(cin);
        underTest.save(entity);

        int result = underTest.deleteByCin(cin);

        Comptable loaded = underTest.findByCin(cin);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        Comptable entity = new Comptable();
        entity.setId(id);
        underTest.save(entity);
        Comptable loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Comptable entity = new Comptable();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Comptable loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Comptable> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Comptable> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Comptable given = constructSample(1);
        Comptable saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Comptable constructSample(int i) {
		Comptable given = new Comptable();
        given.setCin("cin-"+i);
        given.setPrenom("prenom-"+i);
        given.setNom("nom-"+i);
        given.setEmail("email-"+i);
        given.setCategorieComptable("categorieComptable-"+i);
        return given;
    }

}
