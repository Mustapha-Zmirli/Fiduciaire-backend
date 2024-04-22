package  ma.zs.univ.dao.specification.core.commun;

import ma.zs.univ.dao.criteria.core.commun.ComptableCriteria;
import ma.zs.univ.bean.core.commun.Comptable;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class ComptableSpecification extends  AbstractSpecification<ComptableCriteria, Comptable>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("cin", criteria.getCin(),criteria.getCinLike());
        addPredicate("prenom", criteria.getPrenom(),criteria.getPrenomLike());
        addPredicate("nom", criteria.getNom(),criteria.getNomLike());
        addPredicate("email", criteria.getEmail(),criteria.getEmailLike());
        addPredicate("categorieComptable", criteria.getCategorieComptable(),criteria.getCategorieComptableLike());
    }

    public ComptableSpecification(ComptableCriteria criteria) {
        super(criteria);
    }

    public ComptableSpecification(ComptableCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
