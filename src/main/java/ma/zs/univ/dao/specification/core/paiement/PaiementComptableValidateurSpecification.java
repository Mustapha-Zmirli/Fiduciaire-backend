package  ma.zs.univ.dao.specification.core.paiement;

import ma.zs.univ.dao.criteria.core.paiement.PaiementComptableValidateurCriteria;
import ma.zs.univ.bean.core.paiement.PaiementComptableValidateur;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class PaiementComptableValidateurSpecification extends  AbstractSpecification<PaiementComptableValidateurCriteria, PaiementComptableValidateur>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
        addPredicate("datePaiement", criteria.getDatePaiement(), criteria.getDatePaiementFrom(), criteria.getDatePaiementTo());
        addPredicateFk("demande","id", criteria.getDemande()==null?null:criteria.getDemande().getId());
        addPredicateFk("demande","id", criteria.getDemandes());
        addPredicateFk("demande","code", criteria.getDemande()==null?null:criteria.getDemande().getCode());
        addPredicateFk("comptableValidateur","id", criteria.getComptableValidateur()==null?null:criteria.getComptableValidateur().getId());
        addPredicateFk("comptableValidateur","id", criteria.getComptableValidateurs());
        addPredicateFk("comptableValidateur","cin", criteria.getComptableValidateur()==null?null:criteria.getComptableValidateur().getCin());
        addPredicateFk("typePaiement","id", criteria.getTypePaiement()==null?null:criteria.getTypePaiement().getId());
        addPredicateFk("typePaiement","id", criteria.getTypePaiements());
        addPredicateFk("typePaiement","code", criteria.getTypePaiement()==null?null:criteria.getTypePaiement().getCode());
    }

    public PaiementComptableValidateurSpecification(PaiementComptableValidateurCriteria criteria) {
        super(criteria);
    }

    public PaiementComptableValidateurSpecification(PaiementComptableValidateurCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
