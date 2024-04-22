package  ma.zs.univ.dao.specification.core.commun;

import ma.zs.univ.dao.criteria.core.commun.CategorieComptableCriteria;
import ma.zs.univ.bean.core.commun.CategorieComptable;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class CategorieComptableSpecification extends  AbstractSpecification<CategorieComptableCriteria, CategorieComptable>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public CategorieComptableSpecification(CategorieComptableCriteria criteria) {
        super(criteria);
    }

    public CategorieComptableSpecification(CategorieComptableCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
