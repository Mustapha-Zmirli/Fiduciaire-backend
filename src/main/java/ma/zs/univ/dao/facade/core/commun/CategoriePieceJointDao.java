package ma.zs.univ.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.commun.CategoriePieceJoint;
import org.springframework.stereotype.Repository;
import ma.zs.univ.bean.core.commun.CategoriePieceJoint;
import java.util.List;


@Repository
public interface CategoriePieceJointDao extends AbstractRepository<CategoriePieceJoint,Long>  {
    CategoriePieceJoint findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW CategoriePieceJoint(item.id,item.libelle) FROM CategoriePieceJoint item")
    List<CategoriePieceJoint> findAllOptimized();

}
