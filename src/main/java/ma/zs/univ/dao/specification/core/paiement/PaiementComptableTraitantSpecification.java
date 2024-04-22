package  ma.zs.univ.dao.specification.core.paiement;

import ma.zs.univ.dao.criteria.core.paiement.PaiementComptableTraitantCriteria;
import ma.zs.univ.bean.core.paiement.PaiementComptableTraitant;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class PaiementComptableTraitantSpecification extends  AbstractSpecification<PaiementComptableTraitantCriteria, PaiementComptableTraitant>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
        addPredicate("datePaiement", criteria.getDatePaiement(), criteria.getDatePaiementFrom(), criteria.getDatePaiementTo());
        addPredicateFk("demande","id", criteria.getDemande()==null?null:criteria.getDemande().getId());
        addPredicateFk("demande","id", criteria.getDemandes());
        addPredicateFk("demande","code", criteria.getDemande()==null?null:criteria.getDemande().getCode());
        addPredicateFk("comptableTraitant","id", criteria.getComptableTraitant()==null?null:criteria.getComptableTraitant().getId());
        addPredicateFk("comptableTraitant","id", criteria.getComptableTraitants());
        addPredicateFk("comptableTraitant","cin", criteria.getComptableTraitant()==null?null:criteria.getComptableTraitant().getCin());
        addPredicateFk("typePaiement","id", criteria.getTypePaiement()==null?null:criteria.getTypePaiement().getId());
        addPredicateFk("typePaiement","id", criteria.getTypePaiements());
        addPredicateFk("typePaiement","code", criteria.getTypePaiement()==null?null:criteria.getTypePaiement().getCode());
    }

    public PaiementComptableTraitantSpecification(PaiementComptableTraitantCriteria criteria) {
        super(criteria);
    }

    public PaiementComptableTraitantSpecification(PaiementComptableTraitantCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
