package ma.zs.univ.dao.facade.core.paiement;

import org.springframework.data.jpa.repository.Query;
import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.paiement.PaiementDemande;
import org.springframework.stereotype.Repository;
import ma.zs.univ.bean.core.paiement.PaiementDemande;
import java.util.List;


@Repository
public interface PaiementDemandeDao extends AbstractRepository<PaiementDemande,Long>  {
    PaiementDemande findByCode(String code);
    int deleteByCode(String code);

    List<PaiementDemande> findByDemandeId(Long id);
    int deleteByDemandeId(Long id);
    long countByDemandeCode(String code);
    List<PaiementDemande> findByTypePaiementId(Long id);
    int deleteByTypePaiementId(Long id);
    long countByTypePaiementCode(String code);

    @Query("SELECT NEW PaiementDemande(item.id,item.code) FROM PaiementDemande item")
    List<PaiementDemande> findAllOptimized();

}
