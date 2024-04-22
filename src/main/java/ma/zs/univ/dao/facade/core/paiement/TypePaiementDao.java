package ma.zs.univ.dao.facade.core.paiement;

import org.springframework.data.jpa.repository.Query;
import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.paiement.TypePaiement;
import org.springframework.stereotype.Repository;
import ma.zs.univ.bean.core.paiement.TypePaiement;
import java.util.List;


@Repository
public interface TypePaiementDao extends AbstractRepository<TypePaiement,Long>  {
    TypePaiement findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW TypePaiement(item.id,item.libelle) FROM TypePaiement item")
    List<TypePaiement> findAllOptimized();

}
