package ma.zs.univ.service.impl.admin.demande;


import ma.zs.univ.bean.core.demande.EtatDemande;
import ma.zs.univ.dao.criteria.core.demande.EtatDemandeCriteria;
import ma.zs.univ.dao.facade.core.demande.EtatDemandeDao;
import ma.zs.univ.dao.specification.core.demande.EtatDemandeSpecification;
import ma.zs.univ.service.facade.admin.demande.EtatDemandeAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class EtatDemandeAdminServiceImpl extends AbstractServiceImpl<EtatDemande, EtatDemandeCriteria, EtatDemandeDao> implements EtatDemandeAdminService {






    public EtatDemande findByReferenceEntity(EtatDemande t){
        return t==null? null : dao.findByCode(t.getCode());
    }


    public List<EtatDemande> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(EtatDemande.class, EtatDemandeSpecification.class);
    }



    public EtatDemandeAdminServiceImpl(EtatDemandeDao dao) {
        super(dao);
    }

}
