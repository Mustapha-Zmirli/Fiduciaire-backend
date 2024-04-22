package ma.zs.univ.service.impl.admin.commun;


import ma.zs.univ.bean.core.commun.Comptable;
import ma.zs.univ.dao.criteria.core.commun.ComptableCriteria;
import ma.zs.univ.dao.facade.core.commun.ComptableDao;
import ma.zs.univ.dao.specification.core.commun.ComptableSpecification;
import ma.zs.univ.service.facade.admin.commun.ComptableAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class ComptableAdminServiceImpl extends AbstractServiceImpl<Comptable, ComptableCriteria, ComptableDao> implements ComptableAdminService {






    public Comptable findByReferenceEntity(Comptable t){
        return t==null? null : dao.findByCin(t.getCin());
    }


    public List<Comptable> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Comptable.class, ComptableSpecification.class);
    }



    public ComptableAdminServiceImpl(ComptableDao dao) {
        super(dao);
    }

}
