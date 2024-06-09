package ma.zs.univ.service.facade.admin.paiement;

import java.util.List;
import ma.zs.univ.bean.core.paiement.PaiementComptableValidateur;
import ma.zs.univ.dao.criteria.core.paiement.PaiementComptableValidateurCriteria;
import ma.zs.univ.zynerator.service.IService;



public interface PaiementComptableValidateurAdminService extends  IService<PaiementComptableValidateur,PaiementComptableValidateurCriteria>  {

    List<PaiementComptableValidateur> findByDemandeId(Long id);
    int deleteByDemandeId(Long id);
    long countByDemandeCode(String code);
    List<PaiementComptableValidateur> findByComptableValidateurId(Long id);
    int deleteByComptableValidateurId(Long id);
    long countByComptableValidateurCin(String cin);
    List<PaiementComptableValidateur> findByTypePaiementId(Long id);
    int deleteByTypePaiementId(Long id);
    long countByTypePaiementCode(String code);


    void payerComptableValidateur(String demandeCode, String comptableValidateurCin);
}
