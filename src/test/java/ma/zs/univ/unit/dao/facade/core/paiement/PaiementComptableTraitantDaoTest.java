package ma.zs.univ.unit.dao.facade.core.paiement;

import ma.zs.univ.bean.core.paiement.PaiementComptableTraitant;
import ma.zs.univ.dao.facade.core.paiement.PaiementComptableTraitantDao;

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
import ma.zs.univ.bean.core.paiement.TypePaiement ;
import ma.zs.univ.bean.core.commun.Comptable ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class PaiementComptableTraitantDaoTest {

@Autowired
    private PaiementComptableTraitantDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        PaiementComptableTraitant entity = new PaiementComptableTraitant();
        entity.setCode(code);
        underTest.save(entity);
        PaiementComptableTraitant loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        PaiementComptableTraitant entity = new PaiementComptableTraitant();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        PaiementComptableTraitant loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        PaiementComptableTraitant entity = new PaiementComptableTraitant();
        entity.setId(id);
        underTest.save(entity);
        PaiementComptableTraitant loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        PaiementComptableTraitant entity = new PaiementComptableTraitant();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        PaiementComptableTraitant loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<PaiementComptableTraitant> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<PaiementComptableTraitant> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        PaiementComptableTraitant given = constructSample(1);
        PaiementComptableTraitant saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private PaiementComptableTraitant constructSample(int i) {
		PaiementComptableTraitant given = new PaiementComptableTraitant();
        given.setCode("code-"+i);
        given.setDemande(new Demande(1L));
        given.setMontant(BigDecimal.TEN);
        given.setComptableTraitant(new Comptable(1L));
        given.setTypePaiement(new TypePaiement(1L));
        given.setDatePaiement(LocalDateTime.now());
        return given;
    }

}
