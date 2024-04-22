package  ma.zs.univ.dao.specification.core.commun;

import ma.zs.univ.dao.criteria.core.commun.CategoriePieceJointCriteria;
import ma.zs.univ.bean.core.commun.CategoriePieceJoint;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class CategoriePieceJointSpecification extends  AbstractSpecification<CategoriePieceJointCriteria, CategoriePieceJoint>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public CategoriePieceJointSpecification(CategoriePieceJointCriteria criteria) {
        super(criteria);
    }

    public CategoriePieceJointSpecification(CategoriePieceJointCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
