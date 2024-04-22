package  ma.zs.univ.dao.specification.core.paiement;

import ma.zs.univ.dao.criteria.core.paiement.TypePaiementCriteria;
import ma.zs.univ.bean.core.paiement.TypePaiement;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class TypePaiementSpecification extends  AbstractSpecification<TypePaiementCriteria, TypePaiement>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public TypePaiementSpecification(TypePaiementCriteria criteria) {
        super(criteria);
    }

    public TypePaiementSpecification(TypePaiementCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
