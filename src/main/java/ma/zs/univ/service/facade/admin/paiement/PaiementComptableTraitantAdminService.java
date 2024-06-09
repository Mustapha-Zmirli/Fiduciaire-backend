package ma.zs.univ.service.facade.admin.paiement;

import java.math.BigDecimal;
import java.util.List;
import ma.zs.univ.bean.core.paiement.PaiementComptableTraitant;
import ma.zs.univ.dao.criteria.core.paiement.PaiementComptableTraitantCriteria;
import ma.zs.univ.zynerator.service.IService;



public interface PaiementComptableTraitantAdminService extends  IService<PaiementComptableTraitant,PaiementComptableTraitantCriteria>  {

    List<PaiementComptableTraitant> findByDemandeId(Long id);
    int deleteByDemandeId(Long id);
    long countByDemandeCode(String code);
    List<PaiementComptableTraitant> findByComptableTraitantId(Long id);
    int deleteByComptableTraitantId(Long id);
    long countByComptableTraitantCin(String cin);
    List<PaiementComptableTraitant> findByTypePaiementId(Long id);
    int deleteByTypePaiementId(Long id);
    long countByTypePaiementCode(String code);


    void payer(String demandeCode, String comptableTraitantCin);
}
