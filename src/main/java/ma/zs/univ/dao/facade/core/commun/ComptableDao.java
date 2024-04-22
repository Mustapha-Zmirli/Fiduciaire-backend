package ma.zs.univ.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.commun.Comptable;
import org.springframework.stereotype.Repository;
import ma.zs.univ.bean.core.commun.Comptable;
import java.util.List;


@Repository
public interface ComptableDao extends AbstractRepository<Comptable,Long>  {
    Comptable findByCin(String cin);
    int deleteByCin(String cin);


    @Query("SELECT NEW Comptable(item.id,item.cin) FROM Comptable item")
    List<Comptable> findAllOptimized();

}
