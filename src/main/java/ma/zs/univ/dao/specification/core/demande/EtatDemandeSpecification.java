package  ma.zs.univ.dao.specification.core.demande;

import ma.zs.univ.dao.criteria.core.demande.EtatDemandeCriteria;
import ma.zs.univ.bean.core.demande.EtatDemande;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class EtatDemandeSpecification extends  AbstractSpecification<EtatDemandeCriteria, EtatDemande>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public EtatDemandeSpecification(EtatDemandeCriteria criteria) {
        super(criteria);
    }

    public EtatDemandeSpecification(EtatDemandeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
