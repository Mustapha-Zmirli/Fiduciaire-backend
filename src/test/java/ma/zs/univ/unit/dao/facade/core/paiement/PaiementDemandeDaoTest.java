package ma.zs.univ.unit.dao.facade.core.paiement;

import ma.zs.univ.bean.core.paiement.PaiementDemande;
import ma.zs.univ.dao.facade.core.paiement.PaiementDemandeDao;

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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class PaiementDemandeDaoTest {

@Autowired
    private PaiementDemandeDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        PaiementDemande entity = new PaiementDemande();
        entity.setCode(code);
        underTest.save(entity);
        PaiementDemande loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        PaiementDemande entity = new PaiementDemande();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        PaiementDemande loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        PaiementDemande entity = new PaiementDemande();
        entity.setId(id);
        underTest.save(entity);
        PaiementDemande loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        PaiementDemande entity = new PaiementDemande();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        PaiementDemande loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<PaiementDemande> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<PaiementDemande> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        PaiementDemande given = constructSample(1);
        PaiementDemande saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private PaiementDemande constructSample(int i) {
		PaiementDemande given = new PaiementDemande();
        given.setCode("code-"+i);
        given.setMontant(BigDecimal.TEN);
        given.setDatePaiement(LocalDateTime.now());
        given.setDemande(new Demande(1L));
        given.setTypePaiement(new TypePaiement(1L));
        return given;
    }

}
