package ma.zs.univ.service.impl.admin.commun;


import ma.zs.univ.bean.core.commun.Societe;
import ma.zs.univ.dao.criteria.core.commun.SocieteCriteria;
import ma.zs.univ.dao.facade.core.commun.SocieteDao;
import ma.zs.univ.dao.specification.core.commun.SocieteSpecification;
import ma.zs.univ.service.facade.admin.commun.SocieteAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class SocieteAdminServiceImpl extends AbstractServiceImpl<Societe, SocieteCriteria, SocieteDao> implements SocieteAdminService {






    public Societe findByReferenceEntity(Societe t){
        return t==null? null : dao.findByRc(t.getRc());
    }


    public List<Societe> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Societe.class, SocieteSpecification.class);
    }



    public SocieteAdminServiceImpl(SocieteDao dao) {
        super(dao);
    }

}
