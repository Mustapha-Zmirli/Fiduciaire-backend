package ma.zs.univ.dao.facade.core.demande;

import org.springframework.data.jpa.repository.Query;
import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.demande.DemandePieceJoint;
import org.springframework.stereotype.Repository;
import ma.zs.univ.bean.core.demande.DemandePieceJoint;
import java.util.List;


@Repository
public interface DemandePieceJointDao extends AbstractRepository<DemandePieceJoint,Long>  {
    DemandePieceJoint findByCode(String code);
    int deleteByCode(String code);

    List<DemandePieceJoint> findByDemandeId(Long id);
    int deleteByDemandeId(Long id);
    long countByDemandeCode(String code);

    @Query("SELECT NEW DemandePieceJoint(item.id,item.libelle) FROM DemandePieceJoint item")
    List<DemandePieceJoint> findAllOptimized();

}
