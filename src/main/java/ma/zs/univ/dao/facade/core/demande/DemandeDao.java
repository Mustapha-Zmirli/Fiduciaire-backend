package ma.zs.univ.dao.facade.core.demande;

import org.springframework.data.jpa.repository.Query;
import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.demande.Demande;
import org.springframework.stereotype.Repository;
import ma.zs.univ.bean.core.demande.Demande;
import java.util.List;


@Repository
public interface DemandeDao extends AbstractRepository<Demande,Long>  {
    Demande findByCode(String code);
    int deleteByCode(String code);

    List<Demande> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);
    long countBySocieteRc(String rc);
    List<Demande> findByTypeDemandeId(Long id);
    int deleteByTypeDemandeId(Long id);
    long countByTypeDemandeCode(String code);
    List<Demande> findByEtatDemandeId(Long id);
    int deleteByEtatDemandeId(Long id);
    long countByEtatDemandeCode(String code);
    List<Demande> findByComptableValidateurId(Long id);
    int deleteByComptableValidateurId(Long id);
    long countByComptableValidateurCin(String cin);
    List<Demande> findByComptableTraitantId(Long id);
    int deleteByComptableTraitantId(Long id);
    long countByComptableTraitantCin(String cin);

    @Query("SELECT NEW Demande(item.id,item.libelle) FROM Demande item")
    List<Demande> findAllOptimized();

}
