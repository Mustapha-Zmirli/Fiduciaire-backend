package ma.zs.univ.service.impl.admin.paiement;


import ma.zs.univ.bean.core.paiement.PaiementComptableValidateur;
import ma.zs.univ.dao.criteria.core.paiement.PaiementComptableValidateurCriteria;
import ma.zs.univ.dao.facade.core.paiement.PaiementComptableValidateurDao;
import ma.zs.univ.dao.specification.core.paiement.PaiementComptableValidateurSpecification;
import ma.zs.univ.service.facade.admin.paiement.PaiementComptableValidateurAdminService;
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
public class PaiementComptableValidateurAdminServiceImpl extends AbstractServiceImpl<PaiementComptableValidateur, PaiementComptableValidateurCriteria, PaiementComptableValidateurDao> implements PaiementComptableValidateurAdminService {






    public PaiementComptableValidateur findByReferenceEntity(PaiementComptableValidateur t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(PaiementComptableValidateur t){
        if( t != null) {
            t.setDemande(demandeService.findOrSave(t.getDemande()));
            t.setComptableValidateur(comptableService.findOrSave(t.getComptableValidateur()));
            t.setTypePaiement(typePaiementService.findOrSave(t.getTypePaiement()));
        }
    }

    public List<PaiementComptableValidateur> findByDemandeId(Long id){
        return dao.findByDemandeId(id);
    }
    public int deleteByDemandeId(Long id){
        return dao.deleteByDemandeId(id);
    }
    public long countByDemandeCode(String code){
        return dao.countByDemandeCode(code);
    }
    public List<PaiementComptableValidateur> findByComptableValidateurId(Long id){
        return dao.findByComptableValidateurId(id);
    }
    public int deleteByComptableValidateurId(Long id){
        return dao.deleteByComptableValidateurId(id);
    }
    public long countByComptableValidateurCin(String cin){
        return dao.countByComptableValidateurCin(cin);
    }
    public List<PaiementComptableValidateur> findByTypePaiementId(Long id){
        return dao.findByTypePaiementId(id);
    }
    public int deleteByTypePaiementId(Long id){
        return dao.deleteByTypePaiementId(id);
    }
    public long countByTypePaiementCode(String code){
        return dao.countByTypePaiementCode(code);
    }

    public List<PaiementComptableValidateur> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(PaiementComptableValidateur.class, PaiementComptableValidateurSpecification.class);
    }


    @Autowired
    private DemandeAdminService demandeService ;
    @Autowired
    private TypePaiementAdminService typePaiementService ;
    @Autowired
    private ComptableAdminService comptableService ;

    public PaiementComptableValidateurAdminServiceImpl(PaiementComptableValidateurDao dao) {
        super(dao);
    }

}
