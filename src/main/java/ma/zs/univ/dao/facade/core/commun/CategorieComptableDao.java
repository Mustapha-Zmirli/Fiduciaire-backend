package ma.zs.univ.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.commun.CategorieComptable;
import org.springframework.stereotype.Repository;
import ma.zs.univ.bean.core.commun.CategorieComptable;
import java.util.List;


@Repository
public interface CategorieComptableDao extends AbstractRepository<CategorieComptable,Long>  {
    CategorieComptable findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW CategorieComptable(item.id,item.libelle) FROM CategorieComptable item")
    List<CategorieComptable> findAllOptimized();

}
