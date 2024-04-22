package ma.zs.univ.service.facade.admin.demande;

import java.util.List;
import ma.zs.univ.bean.core.demande.DemandePieceJoint;
import ma.zs.univ.dao.criteria.core.demande.DemandePieceJointCriteria;
import ma.zs.univ.zynerator.service.IService;



public interface DemandePieceJointAdminService extends  IService<DemandePieceJoint,DemandePieceJointCriteria>  {

    List<DemandePieceJoint> findByDemandeId(Long id);
    int deleteByDemandeId(Long id);
    long countByDemandeCode(String code);




}
