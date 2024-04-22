package  ma.zs.univ.dao.specification.core.demande;

import ma.zs.univ.dao.criteria.core.demande.DemandePieceJointCriteria;
import ma.zs.univ.bean.core.demande.DemandePieceJoint;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class DemandePieceJointSpecification extends  AbstractSpecification<DemandePieceJointCriteria, DemandePieceJoint>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("path", criteria.getPath(),criteria.getPathLike());
        addPredicateFk("demande","id", criteria.getDemande()==null?null:criteria.getDemande().getId());
        addPredicateFk("demande","id", criteria.getDemandes());
        addPredicateFk("demande","code", criteria.getDemande()==null?null:criteria.getDemande().getCode());
    }

    public DemandePieceJointSpecification(DemandePieceJointCriteria criteria) {
        super(criteria);
    }

    public DemandePieceJointSpecification(DemandePieceJointCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
