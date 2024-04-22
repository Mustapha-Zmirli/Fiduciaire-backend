package  ma.zs.univ.dao.specification.core.demande;

import ma.zs.univ.dao.criteria.core.demande.TypeDemandeCriteria;
import ma.zs.univ.bean.core.demande.TypeDemande;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class TypeDemandeSpecification extends  AbstractSpecification<TypeDemandeCriteria, TypeDemande>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicateBigDecimal("honnoraireComptableTraitant", criteria.getHonnoraireComptableTraitant(), criteria.getHonnoraireComptableTraitantMin(), criteria.getHonnoraireComptableTraitantMax());
        addPredicateBigDecimal("honnoraireComptableValidateur", criteria.getHonnoraireComptableValidateur(), criteria.getHonnoraireComptableValidateurMin(), criteria.getHonnoraireComptableValidateurMax());
    }

    public TypeDemandeSpecification(TypeDemandeCriteria criteria) {
        super(criteria);
    }

    public TypeDemandeSpecification(TypeDemandeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
