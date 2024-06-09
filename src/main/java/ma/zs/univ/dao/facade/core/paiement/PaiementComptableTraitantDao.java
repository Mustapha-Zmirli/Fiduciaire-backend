package ma.zs.univ.dao.facade.core.paiement;

import org.springframework.data.jpa.repository.Query;
import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.paiement.PaiementComptableTraitant;
import org.springframework.stereotype.Repository;
import ma.zs.univ.bean.core.paiement.PaiementComptableTraitant;
import java.util.List;


@Repository
public interface PaiementComptableTraitantDao extends AbstractRepository<PaiementComptableTraitant,Long>  {
    PaiementComptableTraitant findByCode(String code);
    int deleteByCode(String code);
    PaiementComptableTraitant findByDemandeCode(String code);
    List<PaiementComptableTraitant> findByDemandeId(Long id);
    int deleteByDemandeId(Long id);
    long countByDemandeCode(String code);
    List<PaiementComptableTraitant> findByComptableTraitantId(Long id);
    int deleteByComptableTraitantId(Long id);
    long countByComptableTraitantCin(String cin);
    List<PaiementComptableTraitant> findByTypePaiementId(Long id);
    int deleteByTypePaiementId(Long id);
    long countByTypePaiementCode(String code);

    @Query("SELECT NEW PaiementComptableTraitant(item.id,item.code) FROM PaiementComptableTraitant item")
    List<PaiementComptableTraitant> findAllOptimized();

}
