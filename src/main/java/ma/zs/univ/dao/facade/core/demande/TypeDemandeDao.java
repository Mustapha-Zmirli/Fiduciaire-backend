package ma.zs.univ.dao.facade.core.demande;

import org.springframework.data.jpa.repository.Query;
import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.demande.TypeDemande;
import org.springframework.stereotype.Repository;
import ma.zs.univ.bean.core.demande.TypeDemande;
import java.util.List;


@Repository
public interface TypeDemandeDao extends AbstractRepository<TypeDemande,Long>  {
    TypeDemande findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW TypeDemande(item.id,item.libelle) FROM TypeDemande item")
    List<TypeDemande> findAllOptimized();

}
