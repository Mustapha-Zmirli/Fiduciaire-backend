package ma.zs.univ.service.impl.admin.paiement;


import ma.zs.univ.bean.core.paiement.PaiementDemande;
import ma.zs.univ.dao.criteria.core.paiement.PaiementDemandeCriteria;
import ma.zs.univ.dao.facade.core.paiement.PaiementDemandeDao;
import ma.zs.univ.dao.specification.core.paiement.PaiementDemandeSpecification;
import ma.zs.univ.service.facade.admin.paiement.PaiementDemandeAdminService;
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

import java.util.List;
@Service
public class PaiementDemandeAdminServiceImpl extends AbstractServiceImpl<PaiementDemande, PaiementDemandeCriteria, PaiementDemandeDao> implements PaiementDemandeAdminService {






    public PaiementDemande findByReferenceEntity(PaiementDemande t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(PaiementDemande t){
        if( t != null) {
            t.setDemande(demandeService.findOrSave(t.getDemande()));
            t.setTypePaiement(typePaiementService.findOrSave(t.getTypePaiement()));
        }
    }

    public List<PaiementDemande> findByDemandeId(Long id){
        return dao.findByDemandeId(id);
    }
    public int deleteByDemandeId(Long id){
        return dao.deleteByDemandeId(id);
    }
    public long countByDemandeCode(String code){
        return dao.countByDemandeCode(code);
    }
    public List<PaiementDemande> findByTypePaiementId(Long id){
        return dao.findByTypePaiementId(id);
    }
    public int deleteByTypePaiementId(Long id){
        return dao.deleteByTypePaiementId(id);
    }
    public long countByTypePaiementCode(String code){
        return dao.countByTypePaiementCode(code);
    }

    public List<PaiementDemande> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(PaiementDemande.class, PaiementDemandeSpecification.class);
    }


    @Autowired
    private DemandeAdminService demandeService ;
    @Autowired
    private TypePaiementAdminService typePaiementService ;

    public PaiementDemandeAdminServiceImpl(PaiementDemandeDao dao) {
        super(dao);
    }

}
