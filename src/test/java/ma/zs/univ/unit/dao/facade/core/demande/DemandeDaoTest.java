package ma.zs.univ.unit.dao.facade.core.demande;

import ma.zs.univ.bean.core.demande.Demande;
import ma.zs.univ.dao.facade.core.demande.DemandeDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.univ.bean.core.commun.Societe ;
import ma.zs.univ.bean.core.demande.EtatDemande ;
import ma.zs.univ.bean.core.demande.TypeDemande ;
import ma.zs.univ.bean.core.commun.Comptable ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class DemandeDaoTest {

@Autowired
    private DemandeDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        Demande entity = new Demande();
        entity.setCode(code);
        underTest.save(entity);
        Demande loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        Demande entity = new Demande();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        Demande loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        Demande entity = new Demande();
        entity.setId(id);
        underTest.save(entity);
        Demande loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Demande entity = new Demande();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Demande loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Demande> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Demande> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Demande given = constructSample(1);
        Demande saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Demande constructSample(int i) {
		Demande given = new Demande();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        given.setDateDemande(LocalDateTime.now());
        given.setDateExigibilite(LocalDateTime.now());
        given.setSociete(new Societe(1L));
        given.setTypeDemande(new TypeDemande(1L));
        given.setEtatDemande(new EtatDemande(1L));
        given.setComptableValidateur(new Comptable(1L));
        given.setComptableTraitant(new Comptable(1L));
        given.setDateValidation(LocalDateTime.now());
        given.setDateTraitement(LocalDateTime.now());
        return given;
    }

}
