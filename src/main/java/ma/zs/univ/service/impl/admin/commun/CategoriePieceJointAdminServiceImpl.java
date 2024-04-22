package ma.zs.univ.service.impl.admin.commun;


import ma.zs.univ.bean.core.commun.CategoriePieceJoint;
import ma.zs.univ.dao.criteria.core.commun.CategoriePieceJointCriteria;
import ma.zs.univ.dao.facade.core.commun.CategoriePieceJointDao;
import ma.zs.univ.dao.specification.core.commun.CategoriePieceJointSpecification;
import ma.zs.univ.service.facade.admin.commun.CategoriePieceJointAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class CategoriePieceJointAdminServiceImpl extends AbstractServiceImpl<CategoriePieceJoint, CategoriePieceJointCriteria, CategoriePieceJointDao> implements CategoriePieceJointAdminService {






    public CategoriePieceJoint findByReferenceEntity(CategoriePieceJoint t){
        return t==null? null : dao.findByCode(t.getCode());
    }


    public List<CategoriePieceJoint> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(CategoriePieceJoint.class, CategoriePieceJointSpecification.class);
    }



    public CategoriePieceJointAdminServiceImpl(CategoriePieceJointDao dao) {
        super(dao);
    }

}
