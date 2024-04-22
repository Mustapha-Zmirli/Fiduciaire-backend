package ma.zs.univ.service.impl.admin.demande;


import ma.zs.univ.bean.core.demande.DemandePieceJoint;
import ma.zs.univ.dao.criteria.core.demande.DemandePieceJointCriteria;
import ma.zs.univ.dao.facade.core.demande.DemandePieceJointDao;
import ma.zs.univ.dao.specification.core.demande.DemandePieceJointSpecification;
import ma.zs.univ.service.facade.admin.demande.DemandePieceJointAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.univ.service.facade.admin.demande.DemandeAdminService ;
import ma.zs.univ.bean.core.demande.Demande ;

import java.util.List;
@Service
public class DemandePieceJointAdminServiceImpl extends AbstractServiceImpl<DemandePieceJoint, DemandePieceJointCriteria, DemandePieceJointDao> implements DemandePieceJointAdminService {






    public DemandePieceJoint findByReferenceEntity(DemandePieceJoint t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(DemandePieceJoint t){
        if( t != null) {
            t.setDemande(demandeService.findOrSave(t.getDemande()));
        }
    }

    public List<DemandePieceJoint> findByDemandeId(Long id){
        return dao.findByDemandeId(id);
    }
    public int deleteByDemandeId(Long id){
        return dao.deleteByDemandeId(id);
    }
    public long countByDemandeCode(String code){
        return dao.countByDemandeCode(code);
    }

    public List<DemandePieceJoint> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(DemandePieceJoint.class, DemandePieceJointSpecification.class);
    }


    @Autowired
    private DemandeAdminService demandeService ;

    public DemandePieceJointAdminServiceImpl(DemandePieceJointDao dao) {
        super(dao);
    }

}
