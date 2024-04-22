package  ma.zs.univ.dao.criteria.core.paiement;


import ma.zs.univ.dao.criteria.core.demande.DemandeCriteria;
import ma.zs.univ.dao.criteria.core.commun.ComptableCriteria;

import ma.zs.univ.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class PaiementComptableTraitantCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String montant;
    private String montantMin;
    private String montantMax;
    private LocalDateTime datePaiement;
    private LocalDateTime datePaiementFrom;
    private LocalDateTime datePaiementTo;

    private DemandeCriteria demande ;
    private List<DemandeCriteria> demandes ;
    private ComptableCriteria comptableTraitant ;
    private List<ComptableCriteria> comptableTraitants ;
    private TypePaiementCriteria typePaiement ;
    private List<TypePaiementCriteria> typePaiements ;


    public PaiementComptableTraitantCriteria(){}

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCodeLike(){
        return this.codeLike;
    }
    public void setCodeLike(String codeLike){
        this.codeLike = codeLike;
    }

    public String getMontant(){
        return this.montant;
    }
    public void setMontant(String montant){
        this.montant = montant;
    }   
    public String getMontantMin(){
        return this.montantMin;
    }
    public void setMontantMin(String montantMin){
        this.montantMin = montantMin;
    }
    public String getMontantMax(){
        return this.montantMax;
    }
    public void setMontantMax(String montantMax){
        this.montantMax = montantMax;
    }
      
    public LocalDateTime getDatePaiement(){
        return this.datePaiement;
    }
    public void setDatePaiement(LocalDateTime datePaiement){
        this.datePaiement = datePaiement;
    }
    public LocalDateTime getDatePaiementFrom(){
        return this.datePaiementFrom;
    }
    public void setDatePaiementFrom(LocalDateTime datePaiementFrom){
        this.datePaiementFrom = datePaiementFrom;
    }
    public LocalDateTime getDatePaiementTo(){
        return this.datePaiementTo;
    }
    public void setDatePaiementTo(LocalDateTime datePaiementTo){
        this.datePaiementTo = datePaiementTo;
    }

    public DemandeCriteria getDemande(){
        return this.demande;
    }

    public void setDemande(DemandeCriteria demande){
        this.demande = demande;
    }
    public List<DemandeCriteria> getDemandes(){
        return this.demandes;
    }

    public void setDemandes(List<DemandeCriteria> demandes){
        this.demandes = demandes;
    }
    public ComptableCriteria getComptableTraitant(){
        return this.comptableTraitant;
    }

    public void setComptableTraitant(ComptableCriteria comptableTraitant){
        this.comptableTraitant = comptableTraitant;
    }
    public List<ComptableCriteria> getComptableTraitants(){
        return this.comptableTraitants;
    }

    public void setComptableTraitants(List<ComptableCriteria> comptableTraitants){
        this.comptableTraitants = comptableTraitants;
    }
    public TypePaiementCriteria getTypePaiement(){
        return this.typePaiement;
    }

    public void setTypePaiement(TypePaiementCriteria typePaiement){
        this.typePaiement = typePaiement;
    }
    public List<TypePaiementCriteria> getTypePaiements(){
        return this.typePaiements;
    }

    public void setTypePaiements(List<TypePaiementCriteria> typePaiements){
        this.typePaiements = typePaiements;
    }
}
