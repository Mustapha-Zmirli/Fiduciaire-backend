package ma.zs.univ.unit.dao.facade.core.demande;

import ma.zs.univ.bean.core.demande.EtatDemande;
import ma.zs.univ.dao.facade.core.demande.EtatDemandeDao;

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
public class EtatDemandeDaoTest {

@Autowired
    private EtatDemandeDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        EtatDemande entity = new EtatDemande();
        entity.setCode(code);
        underTest.save(entity);
        EtatDemande loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        EtatDemande entity = new EtatDemande();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        EtatDemande loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        EtatDemande entity = new EtatDemande();
        entity.setId(id);
        underTest.save(entity);
        EtatDemande loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        EtatDemande entity = new EtatDemande();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        EtatDemande loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<EtatDemande> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<EtatDemande> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        EtatDemande given = constructSample(1);
        EtatDemande saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private EtatDemande constructSample(int i) {
		EtatDemande given = new EtatDemande();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        return given;
    }

}
