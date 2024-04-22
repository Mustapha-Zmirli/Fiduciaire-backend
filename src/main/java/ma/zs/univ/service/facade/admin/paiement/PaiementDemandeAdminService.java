package ma.zs.univ.service.facade.admin.paiement;

import java.util.List;
import ma.zs.univ.bean.core.paiement.PaiementDemande;
import ma.zs.univ.dao.criteria.core.paiement.PaiementDemandeCriteria;
import ma.zs.univ.zynerator.service.IService;



public interface PaiementDemandeAdminService extends  IService<PaiementDemande,PaiementDemandeCriteria>  {

    List<PaiementDemande> findByDemandeId(Long id);
    int deleteByDemandeId(Long id);
    long countByDemandeCode(String code);
    List<PaiementDemande> findByTypePaiementId(Long id);
    int deleteByTypePaiementId(Long id);
    long countByTypePaiementCode(String code);




}
