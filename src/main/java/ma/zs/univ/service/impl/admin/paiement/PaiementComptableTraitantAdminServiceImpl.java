package ma.zs.univ.service.impl.admin.paiement;


import ma.zs.univ.bean.core.paiement.PaiementComptableTraitant;
import ma.zs.univ.dao.criteria.core.paiement.PaiementComptableTraitantCriteria;
import ma.zs.univ.dao.facade.core.paiement.PaiementComptableTraitantDao;
import ma.zs.univ.dao.specification.core.paiement.PaiementComptableTraitantSpecification;
import ma.zs.univ.service.facade.admin.paiement.PaiementComptableTraitantAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.univ.service.facade.admin.demande.DemandeAdminService ;
import ma.zs.univ.bean.core.demande.Demande ;
import ma.zs.univ.service.facade.admin.paiement.TypePaiementAdminService ;
import ma.zs.univ.bean.core.paiement.TypePaiement ;
import ma.zs.univ.service.facade.admin.commun.ComptableAdminService ;
import ma.zs.univ.bean.core.commun.Comptable ;

import java.util.List;
@Service
public class PaiementComptableTraitantAdminServiceImpl extends AbstractServiceImpl<PaiementComptableTraitant, PaiementComptableTraitantCriteria, PaiementComptableTraitantDao> implements PaiementComptableTraitantAdminService {






    public PaiementComptableTraitant findByReferenceEntity(PaiementComptableTraitant t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(PaiementComptableTraitant t){
        if( t != null) {
            t.setDemande(demandeService.findOrSave(t.getDemande()));
            t.setComptableTraitant(comptableService.findOrSave(t.getComptableTraitant()));
            t.setTypePaiement(typePaiementService.findOrSave(t.getTypePaiement()));
        }
    }

    public List<PaiementComptableTraitant> findByDemandeId(Long id){
        return dao.findByDemandeId(id);
    }
    public int deleteByDemandeId(Long id){
        return dao.deleteByDemandeId(id);
    }
    public long countByDemandeCode(String code){
        return dao.countByDemandeCode(code);
    }
    public List<PaiementComptableTraitant> findByComptableTraitantId(Long id){
        return dao.findByComptableTraitantId(id);
    }
    public int deleteByComptableTraitantId(Long id){
        return dao.deleteByComptableTraitantId(id);
    }
    public long countByComptableTraitantCin(String cin){
        return dao.countByComptableTraitantCin(cin);
    }
    public List<PaiementComptableTraitant> findByTypePaiementId(Long id){
        return dao.findByTypePaiementId(id);
    }
    public int deleteByTypePaiementId(Long id){
        return dao.deleteByTypePaiementId(id);
    }
    public long countByTypePaiementCode(String code){
        return dao.countByTypePaiementCode(code);
    }

    public List<PaiementComptableTraitant> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(PaiementComptableTraitant.class, PaiementComptableTraitantSpecification.class);
    }


    @Autowired
    private DemandeAdminService demandeService ;
    @Autowired
    private TypePaiementAdminService typePaiementService ;
    @Autowired
    private ComptableAdminService comptableService ;

    public PaiementComptableTraitantAdminServiceImpl(PaiementComptableTraitantDao dao) {
        super(dao);
    }

}
