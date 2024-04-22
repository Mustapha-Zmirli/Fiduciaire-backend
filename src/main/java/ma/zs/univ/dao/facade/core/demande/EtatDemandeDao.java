package ma.zs.univ.dao.facade.core.demande;

import org.springframework.data.jpa.repository.Query;
import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.demande.EtatDemande;
import org.springframework.stereotype.Repository;
import ma.zs.univ.bean.core.demande.EtatDemande;
import java.util.List;


@Repository
public interface EtatDemandeDao extends AbstractRepository<EtatDemande,Long>  {
    EtatDemande findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW EtatDemande(item.id,item.libelle) FROM EtatDemande item")
    List<EtatDemande> findAllOptimized();

}
