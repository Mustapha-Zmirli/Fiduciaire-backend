package ma.zs.univ.service.impl.admin.demande;


import ma.zs.univ.bean.core.demande.Demande;
import ma.zs.univ.bean.core.demande.EtatDemande;
import ma.zs.univ.dao.criteria.core.demande.DemandeCriteria;
import ma.zs.univ.dao.facade.core.demande.DemandeDao;
import ma.zs.univ.dao.facade.core.demande.EtatDemandeDao;
import ma.zs.univ.dao.specification.core.demande.DemandeSpecification;
import ma.zs.univ.service.facade.admin.demande.DemandeAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.univ.service.facade.admin.commun.SocieteAdminService ;
import ma.zs.univ.service.facade.admin.demande.EtatDemandeAdminService ;
import ma.zs.univ.service.facade.admin.demande.TypeDemandeAdminService ;
import ma.zs.univ.service.facade.admin.commun.ComptableAdminService ;

@Service
public class DemandeAdminServiceImpl extends AbstractServiceImpl<Demande, DemandeCriteria, DemandeDao> implements DemandeAdminService {



    @Override
    public int refuserDemande(String code) {
        Demande demande = dao.findByCode(code);
        if (demande!=null){
            demande.getEtatDemande().setLibelle("RefuserParComptableTraitant");
            dao.save(demande);
            return 0;
        }
        else{
            return -1;
        }
    }

    @Override
    public int finaliserDemande(String code) {
        Demande demande = dao.findByCode(code);
        if (demande!=null){
            demande.getEtatDemande().setLibelle("traité");
            dao.save(demande);
            return 0;
        }
        else{
            return -1;
        }
    }

    @Override
   public int validerDemande(String code){
       Demande demande = dao.findByCode(code);
       if (demande == null){
           return -1;
       }else {
           EtatDemande etatDemande = etatDemandeDao.findByCode("validé");
           demande.setEtatDemande(etatDemande);
           dao.save(demande);
           return 1;
       }

   }
    @Override
    public List<Demande> getDemandeEnAttente(){
        List<Demande> demandes = dao.findAll();
        List<Demande> demandesEnAttente =new ArrayList<>();
        for(Demande demande :demandes){
            if (demande.getEtatDemande().getLabel().equals("comptable traitant en attend")){
                demandesEnAttente.add(demande);
            }
        }
        return demandesEnAttente;
    }
    @Override
    public int accepterDemande(String code){
        Demande demande1=dao.findByCode(code);
        if (demande1!=null){
            EtatDemande etatDemande= demande1.getEtatDemande();
            etatDemande.setLibelle("comptable traitant accepté");
            dao.save(demande1);
            return 1;
        }
        return -1;
    }
    @Override
    public List<Demande> getListDemandesAcceptees(){
        List<Demande> demandes = dao.findAll();
        List<Demande> demandesAcceptees =new ArrayList<>();
        for(Demande demande :demandes){
            if (demande.getEtatDemande().getLabel().equals("comptable traitant accepté")){
                demandesAcceptees.add(demande);
            }
        }
        return demandesAcceptees;
    }

    @Override
    public List<Demande> getDemandeTraite(){
        List<Demande> demandes = dao.findAll();
        List<Demande> demandesTraite =new ArrayList<>();
         for(Demande demande :demandes){
             if (demande.getEtatDemande().getLabel().equals("traité")){
                 demandesTraite.add(demande);
             }
         }
         return demandesTraite;
    }

    public Demande findByReferenceEntity(Demande t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(Demande t){
        if( t != null) {
            t.setSociete(societeService.findOrSave(t.getSociete()));
            t.setTypeDemande(typeDemandeService.findOrSave(t.getTypeDemande()));
            t.setEtatDemande(etatDemandeService.findOrSave(t.getEtatDemande()));
            t.setComptableValidateur(comptableService.findOrSave(t.getComptableValidateur()));
            t.setComptableTraitant(comptableService.findOrSave(t.getComptableTraitant()));
        }
    }

    public List<Demande> findBySocieteId(Long id){
        return dao.findBySocieteId(id);
    }
    public int deleteBySocieteId(Long id){
        return dao.deleteBySocieteId(id);
    }
    public long countBySocieteRc(String rc){
        return dao.countBySocieteRc(rc);
    }
    public List<Demande> findByTypeDemandeId(Long id){
        return dao.findByTypeDemandeId(id);
    }
    public int deleteByTypeDemandeId(Long id){
        return dao.deleteByTypeDemandeId(id);
    }
    public long countByTypeDemandeCode(String code){
        return dao.countByTypeDemandeCode(code);
    }
    public List<Demande> findByEtatDemandeId(Long id){
        return dao.findByEtatDemandeId(id);
    }
    public int deleteByEtatDemandeId(Long id){
        return dao.deleteByEtatDemandeId(id);
    }
    public long countByEtatDemandeCode(String code){
        return dao.countByEtatDemandeCode(code);
    }
    public List<Demande> findByComptableValidateurId(Long id){
        return dao.findByComptableValidateurId(id);
    }
    public int deleteByComptableValidateurId(Long id){
        return dao.deleteByComptableValidateurId(id);
    }
    public long countByComptableValidateurCin(String cin){
        return dao.countByComptableValidateurCin(cin);
    }
    public List<Demande> findByComptableTraitantId(Long id){
        return dao.findByComptableTraitantId(id);
    }
    public int deleteByComptableTraitantId(Long id){
        return dao.deleteByComptableTraitantId(id);
    }
    public long countByComptableTraitantCin(String cin){
        return dao.countByComptableTraitantCin(cin);
    }

    public List<Demande> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Demande.class, DemandeSpecification.class);
    }


    @Autowired
    private SocieteAdminService societeService ;
    @Autowired
    private EtatDemandeAdminService etatDemandeService ;
    @Autowired
    private TypeDemandeAdminService typeDemandeService ;
    @Autowired
    private ComptableAdminService comptableService ;
    @Autowired
    private EtatDemandeDao etatDemandeDao;

    public DemandeAdminServiceImpl(DemandeDao dao) {
        super(dao);
    }

}
