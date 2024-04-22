package ma.zs.univ.service.impl.admin.demande;


import ma.zs.univ.bean.core.demande.TypeDemande;
import ma.zs.univ.dao.criteria.core.demande.TypeDemandeCriteria;
import ma.zs.univ.dao.facade.core.demande.TypeDemandeDao;
import ma.zs.univ.dao.specification.core.demande.TypeDemandeSpecification;
import ma.zs.univ.service.facade.admin.demande.TypeDemandeAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class TypeDemandeAdminServiceImpl extends AbstractServiceImpl<TypeDemande, TypeDemandeCriteria, TypeDemandeDao> implements TypeDemandeAdminService {






    public TypeDemande findByReferenceEntity(TypeDemande t){
        return t==null? null : dao.findByCode(t.getCode());
    }


    public List<TypeDemande> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(TypeDemande.class, TypeDemandeSpecification.class);
    }



    public TypeDemandeAdminServiceImpl(TypeDemandeDao dao) {
        super(dao);
    }

}
