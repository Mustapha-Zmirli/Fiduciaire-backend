package ma.zs.univ.unit.dao.facade.core.paiement;

import ma.zs.univ.bean.core.paiement.TypePaiement;
import ma.zs.univ.dao.facade.core.paiement.TypePaiementDao;

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
public class TypePaiementDaoTest {

@Autowired
    private TypePaiementDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        TypePaiement entity = new TypePaiement();
        entity.setCode(code);
        underTest.save(entity);
        TypePaiement loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        TypePaiement entity = new TypePaiement();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        TypePaiement loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        TypePaiement entity = new TypePaiement();
        entity.setId(id);
        underTest.save(entity);
        TypePaiement loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        TypePaiement entity = new TypePaiement();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        TypePaiement loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<TypePaiement> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<TypePaiement> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        TypePaiement given = constructSample(1);
        TypePaiement saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private TypePaiement constructSample(int i) {
		TypePaiement given = new TypePaiement();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        return given;
    }

}
