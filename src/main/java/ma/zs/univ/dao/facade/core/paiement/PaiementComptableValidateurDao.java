package ma.zs.univ.dao.facade.core.paiement;

import org.springframework.data.jpa.repository.Query;
import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.paiement.PaiementComptableValidateur;
import org.springframework.stereotype.Repository;
import ma.zs.univ.bean.core.paiement.PaiementComptableValidateur;
import java.util.List;


@Repository
public interface PaiementComptableValidateurDao extends AbstractRepository<PaiementComptableValidateur,Long>  {
    PaiementComptableValidateur findByCode(String code);
    int deleteByCode(String code);

    List<PaiementComptableValidateur> findByDemandeId(Long id);
    int deleteByDemandeId(Long id);
    long countByDemandeCode(String code);
    List<PaiementComptableValidateur> findByComptableValidateurId(Long id);
    int deleteByComptableValidateurId(Long id);
    long countByComptableValidateurCin(String cin);
    List<PaiementComptableValidateur> findByTypePaiementId(Long id);
    int deleteByTypePaiementId(Long id);
    long countByTypePaiementCode(String code);

    @Query("SELECT NEW PaiementComptableValidateur(item.id,item.code) FROM PaiementComptableValidateur item")
    List<PaiementComptableValidateur> findAllOptimized();

}
