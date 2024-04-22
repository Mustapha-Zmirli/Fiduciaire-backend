package ma.zs.univ.service.impl.admin.commun;


import ma.zs.univ.bean.core.commun.CategorieComptable;
import ma.zs.univ.dao.criteria.core.commun.CategorieComptableCriteria;
import ma.zs.univ.dao.facade.core.commun.CategorieComptableDao;
import ma.zs.univ.dao.specification.core.commun.CategorieComptableSpecification;
import ma.zs.univ.service.facade.admin.commun.CategorieComptableAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class CategorieComptableAdminServiceImpl extends AbstractServiceImpl<CategorieComptable, CategorieComptableCriteria, CategorieComptableDao> implements CategorieComptableAdminService {






    public CategorieComptable findByReferenceEntity(CategorieComptable t){
        return t==null? null : dao.findByCode(t.getCode());
    }


    public List<CategorieComptable> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(CategorieComptable.class, CategorieComptableSpecification.class);
    }



    public CategorieComptableAdminServiceImpl(CategorieComptableDao dao) {
        super(dao);
    }

}
