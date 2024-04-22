package ma.zs.univ.unit.dao.facade.core.demande;

import ma.zs.univ.bean.core.demande.TypeDemande;
import ma.zs.univ.dao.facade.core.demande.TypeDemandeDao;

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
public class TypeDemandeDaoTest {

@Autowired
    private TypeDemandeDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        TypeDemande entity = new TypeDemande();
        entity.setCode(code);
        underTest.save(entity);
        TypeDemande loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        TypeDemande entity = new TypeDemande();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        TypeDemande loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        TypeDemande entity = new TypeDemande();
        entity.setId(id);
        underTest.save(entity);
        TypeDemande loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        TypeDemande entity = new TypeDemande();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        TypeDemande loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<TypeDemande> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<TypeDemande> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        TypeDemande given = constructSample(1);
        TypeDemande saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private TypeDemande constructSample(int i) {
		TypeDemande given = new TypeDemande();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        given.setHonnoraireComptableTraitant(BigDecimal.TEN);
        given.setHonnoraireComptableValidateur(BigDecimal.TEN);
        return given;
    }

}
