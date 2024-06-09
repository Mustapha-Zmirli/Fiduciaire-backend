package ma.zs.univ.service.impl.admin.paiement;


import javassist.NotFoundException;
import ma.zs.univ.bean.core.commun.Comptable;
import ma.zs.univ.bean.core.paiement.PaiementComptableTraitant;
import ma.zs.univ.bean.core.paiement.TypePaiement;
import ma.zs.univ.dao.criteria.core.paiement.PaiementComptableTraitantCriteria;
import ma.zs.univ.dao.facade.core.commun.ComptableDao;
import ma.zs.univ.dao.facade.core.demande.DemandeDao;
import ma.zs.univ.dao.facade.core.paiement.PaiementComptableTraitantDao;
import ma.zs.univ.dao.facade.core.paiement.TypePaiementDao;
import ma.zs.univ.dao.specification.core.paiement.PaiementComptableTraitantSpecification;
import ma.zs.univ.service.facade.admin.paiement.PaiementComptableTraitantAdminService;
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

    @Override
    public void payer(String demandeCode, String comptableTraitantCin) {
        Demande demande = demandeDao.findByCode(demandeCode);
        if (demande == null) {
            try {
                throw new NotFoundException("Demande n'a pas trouvé code: " + demandeCode);
            } catch (NotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        PaiementComptableTraitant paiementExiste = paiementComptableTraitantDao.findByDemandeCode(demandeCode);
        if (paiementExiste != null) {
            throw new RuntimeException("Paiement existe déja pour demande: " + demandeCode);
        }

        Comptable comptableTraitant = comptableDao.findByCin(comptableTraitantCin);
        if (comptableTraitant == null) {
            try {
                throw new NotFoundException("ComptableTraitant n'a pas trouvé pour CIN: " + comptableTraitantCin);
            } catch (NotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        TypePaiement typePaiement = typePaiementDao.findByCode("p1");
        if (typePaiement == null) {
            throw new RuntimeException(new NotFoundException("TypePaiement n'a pas trouvé pour code: p1"));
        }

        PaiementComptableTraitant paiement = new PaiementComptableTraitant();
        paiement.setDemande(demande);
        paiement.setComptableTraitant(comptableTraitant);
        paiement.setTypePaiement(typePaiement);

        String typeDemande = demande.getTypeDemande().getLibelle();
        if ("création d'entreprise".equals(typeDemande)) {
            paiement.setMontant(BigDecimal.valueOf(400));
        } else if ("déclaration tva".equals(typeDemande)) {
            paiement.setMontant(BigDecimal.valueOf(300));
        } else if ("Consultation financiére".equals(typeDemande)) {
            paiement.setMontant(BigDecimal.valueOf(100));
        } else if ("déclaration IS".equals(typeDemande)) {
            paiement.setMontant(BigDecimal.valueOf(250));
        } else if ("déclaration IR".equals(typeDemande)) {
            paiement.setMontant(BigDecimal.valueOf(200));
        } else {
            throw new IllegalArgumentException("innconue typeDemande: " + typeDemande);
        }
        paiement.setDatePaiement(LocalDateTime.now());
        dao.save(paiement);
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
    @Autowired
    private DemandeDao demandeDao;
    @Autowired
    private ComptableDao comptableDao;
    @Autowired
    private TypePaiementDao typePaiementDao;
    @Autowired
    private PaiementComptableTraitantDao paiementComptableTraitantDao;

    public PaiementComptableTraitantAdminServiceImpl(PaiementComptableTraitantDao dao) {
        super(dao);
    }

}

