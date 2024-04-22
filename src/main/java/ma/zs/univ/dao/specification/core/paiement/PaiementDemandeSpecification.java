package  ma.zs.univ.dao.specification.core.paiement;

import ma.zs.univ.dao.criteria.core.paiement.PaiementDemandeCriteria;
import ma.zs.univ.bean.core.paiement.PaiementDemande;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class PaiementDemandeSpecification extends  AbstractSpecification<PaiementDemandeCriteria, PaiementDemande>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
        addPredicate("datePaiement", criteria.getDatePaiement(), criteria.getDatePaiementFrom(), criteria.getDatePaiementTo());
        addPredicateFk("demande","id", criteria.getDemande()==null?null:criteria.getDemande().getId());
        addPredicateFk("demande","id", criteria.getDemandes());
        addPredicateFk("demande","code", criteria.getDemande()==null?null:criteria.getDemande().getCode());
        addPredicateFk("typePaiement","id", criteria.getTypePaiement()==null?null:criteria.getTypePaiement().getId());
        addPredicateFk("typePaiement","id", criteria.getTypePaiements());
        addPredicateFk("typePaiement","code", criteria.getTypePaiement()==null?null:criteria.getTypePaiement().getCode());
    }

    public PaiementDemandeSpecification(PaiementDemandeCriteria criteria) {
        super(criteria);
    }

    public PaiementDemandeSpecification(PaiementDemandeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
