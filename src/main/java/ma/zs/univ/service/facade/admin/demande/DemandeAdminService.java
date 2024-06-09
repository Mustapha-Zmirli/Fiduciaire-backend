package ma.zs.univ.service.facade.admin.demande;

import java.util.List;
import ma.zs.univ.bean.core.demande.Demande;
import ma.zs.univ.dao.criteria.core.demande.DemandeCriteria;
import ma.zs.univ.zynerator.service.IService;



public interface DemandeAdminService extends  IService<Demande,DemandeCriteria>  {

    int finaliserDemande(String code);

    int refuserDemande(String code);


    List<Demande> getDemandeEnAttente();
    List<Demande> getDemandeRefusee();


    int accepterDemande(String code);

    int validerDemande(String code);

    List<Demande> getListDemandesAcceptees();

    List<Demande> getDemandeTraite();

    List<Demande> getDemandeValide();

    List<Demande> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);
    long countBySocieteRc(String rc);
    List<Demande> findByTypeDemandeId(Long id);
    int deleteByTypeDemandeId(Long id);
    long countByTypeDemandeCode(String code);
    List<Demande> findByEtatDemandeId(Long id);
    int deleteByEtatDemandeId(Long id);
    long countByEtatDemandeCode(String code);
    List<Demande> findByComptableValidateurId(Long id);
    int deleteByComptableValidateurId(Long id);
    long countByComptableValidateurCin(String cin);
    List<Demande> findByComptableTraitantId(Long id);
    int deleteByComptableTraitantId(Long id);
    long countByComptableTraitantCin(String cin);




}
