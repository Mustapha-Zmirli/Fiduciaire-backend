package ma.zs.univ.service.impl.admin.paiement;


import javassist.NotFoundException;
import ma.zs.univ.bean.core.paiement.PaiementComptableTraitant;
import ma.zs.univ.bean.core.paiement.PaiementComptableValidateur;
import ma.zs.univ.bean.core.paiement.TypePaiement;
import ma.zs.univ.dao.criteria.core.paiement.PaiementComptableValidateurCriteria;
import ma.zs.univ.dao.facade.core.commun.ComptableDao;
import ma.zs.univ.dao.facade.core.demande.DemandeDao;
import ma.zs.univ.dao.facade.core.paiement.PaiementComptableValidateurDao;
import ma.zs.univ.dao.facade.core.paiement.TypePaiementDao;
import ma.zs.univ.dao.specification.core.paiement.PaiementComptableValidateurSpecification;
import ma.zs.univ.service.facade.admin.paiement.PaiementComptableValidateurAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.univ.service.facade.admin.demande.DemandeAdminService ;
import ma.zs.univ.bean.core.demande.Demande ;
import ma.zs.univ.service.facade.admin.paiement.TypePaiementAdminService ;
import ma.zs.univ.service.facade.admin.commun.ComptableAdminService ;
import ma.zs.univ.bean.core.commun.Comptable ;

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

    @Override
    public void payerComptableValidateur(String demandeCode, String comptableValidateurCin) {
        Demande demande = demandeDao.findByCode(demandeCode);
        if (demande == null) {
            throw new RuntimeException(new NotFoundException("Demande n'a pas trouvé code: " + demandeCode));
        }
        PaiementComptableValidateur paiementExiste = paiementComptableValidateurDao.findByDemandeCode(demandeCode);
        if (paiementExiste != null) {
            throw new RuntimeException("Paiement existe déja pour demande: " + demandeCode);
        }
        Comptable comptableValidateur = comptableDao.findByCin(comptableValidateurCin);
        if (comptableValidateur == null) {
            throw new RuntimeException(new NotFoundException("ComptableTraitant n'a pas trouvé pour CIN: " + comptableValidateurCin));
        }

        TypePaiement typePaiement = typePaiementDao.findByCode("p1");
        if (typePaiement == null) {
            throw new RuntimeException(new NotFoundException("TypePaiement n'a pas trouvé pour code: p1"));
        }

        PaiementComptableValidateur paiement = new PaiementComptableValidateur();
        paiement.setDemande(demande);
        paiement.setComptableValidateur(comptableValidateur);
        paiement.setTypePaiement(typePaiement);

        String typeDemande = demande.getTypeDemande().getLibelle();
        if ("création d'entreprise".equals(typeDemande)) {
            paiement.setMontant(BigDecimal.valueOf(250));
        } else if ("déclaration tva".equals(typeDemande)) {
            paiement.setMontant(BigDecimal.valueOf(200));
        } else if ("Consultation financiére".equals(typeDemande)) {
            paiement.setMontant(BigDecimal.valueOf(50));
        } else if ("déclaration IS".equals(typeDemande)) {
            paiement.setMontant(BigDecimal.valueOf(150));
        } else if ("déclaration IR".equals(typeDemande)) {
            paiement.setMontant(BigDecimal.valueOf(100));
        } else {
            throw new IllegalArgumentException("inconnue typeDemande: " + typeDemande);
        }

        paiement.setDatePaiement(LocalDateTime.now());
        dao.save(paiement);
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
    @Autowired
    private DemandeDao demandeDao;
    @Autowired
    private ComptableDao comptableDao;
    @Autowired
    private TypePaiementDao typePaiementDao;
    @Autowired
    private PaiementComptableValidateurDao paiementComptableValidateurDao;

    public PaiementComptableValidateurAdminServiceImpl(PaiementComptableValidateurDao dao) {
        super(dao);
    }

}
