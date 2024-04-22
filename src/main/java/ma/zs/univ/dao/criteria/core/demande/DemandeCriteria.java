package  ma.zs.univ.dao.criteria.core.demande;


import ma.zs.univ.dao.criteria.core.commun.SocieteCriteria;
import ma.zs.univ.dao.criteria.core.commun.ComptableCriteria;

import ma.zs.univ.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class DemandeCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String libelle;
    private String libelleLike;
    private LocalDateTime dateDemande;
    private LocalDateTime dateDemandeFrom;
    private LocalDateTime dateDemandeTo;
    private LocalDateTime dateExigibilite;
    private LocalDateTime dateExigibiliteFrom;
    private LocalDateTime dateExigibiliteTo;
    private LocalDateTime dateValidation;
    private LocalDateTime dateValidationFrom;
    private LocalDateTime dateValidationTo;
    private LocalDateTime dateTraitement;
    private LocalDateTime dateTraitementFrom;
    private LocalDateTime dateTraitementTo;

    private SocieteCriteria societe ;
    private List<SocieteCriteria> societes ;
    private TypeDemandeCriteria typeDemande ;
    private List<TypeDemandeCriteria> typeDemandes ;
    private EtatDemandeCriteria etatDemande ;
    private List<EtatDemandeCriteria> etatDemandes ;
    private ComptableCriteria comptableValidateur ;
    private List<ComptableCriteria> comptableValidateurs ;
    private ComptableCriteria comptableTraitant ;
    private List<ComptableCriteria> comptableTraitants ;


    public DemandeCriteria(){}

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

    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getLibelleLike(){
        return this.libelleLike;
    }
    public void setLibelleLike(String libelleLike){
        this.libelleLike = libelleLike;
    }

    public LocalDateTime getDateDemande(){
        return this.dateDemande;
    }
    public void setDateDemande(LocalDateTime dateDemande){
        this.dateDemande = dateDemande;
    }
    public LocalDateTime getDateDemandeFrom(){
        return this.dateDemandeFrom;
    }
    public void setDateDemandeFrom(LocalDateTime dateDemandeFrom){
        this.dateDemandeFrom = dateDemandeFrom;
    }
    public LocalDateTime getDateDemandeTo(){
        return this.dateDemandeTo;
    }
    public void setDateDemandeTo(LocalDateTime dateDemandeTo){
        this.dateDemandeTo = dateDemandeTo;
    }
    public LocalDateTime getDateExigibilite(){
        return this.dateExigibilite;
    }
    public void setDateExigibilite(LocalDateTime dateExigibilite){
        this.dateExigibilite = dateExigibilite;
    }
    public LocalDateTime getDateExigibiliteFrom(){
        return this.dateExigibiliteFrom;
    }
    public void setDateExigibiliteFrom(LocalDateTime dateExigibiliteFrom){
        this.dateExigibiliteFrom = dateExigibiliteFrom;
    }
    public LocalDateTime getDateExigibiliteTo(){
        return this.dateExigibiliteTo;
    }
    public void setDateExigibiliteTo(LocalDateTime dateExigibiliteTo){
        this.dateExigibiliteTo = dateExigibiliteTo;
    }
    public LocalDateTime getDateValidation(){
        return this.dateValidation;
    }
    public void setDateValidation(LocalDateTime dateValidation){
        this.dateValidation = dateValidation;
    }
    public LocalDateTime getDateValidationFrom(){
        return this.dateValidationFrom;
    }
    public void setDateValidationFrom(LocalDateTime dateValidationFrom){
        this.dateValidationFrom = dateValidationFrom;
    }
    public LocalDateTime getDateValidationTo(){
        return this.dateValidationTo;
    }
    public void setDateValidationTo(LocalDateTime dateValidationTo){
        this.dateValidationTo = dateValidationTo;
    }
    public LocalDateTime getDateTraitement(){
        return this.dateTraitement;
    }
    public void setDateTraitement(LocalDateTime dateTraitement){
        this.dateTraitement = dateTraitement;
    }
    public LocalDateTime getDateTraitementFrom(){
        return this.dateTraitementFrom;
    }
    public void setDateTraitementFrom(LocalDateTime dateTraitementFrom){
        this.dateTraitementFrom = dateTraitementFrom;
    }
    public LocalDateTime getDateTraitementTo(){
        return this.dateTraitementTo;
    }
    public void setDateTraitementTo(LocalDateTime dateTraitementTo){
        this.dateTraitementTo = dateTraitementTo;
    }

    public SocieteCriteria getSociete(){
        return this.societe;
    }

    public void setSociete(SocieteCriteria societe){
        this.societe = societe;
    }
    public List<SocieteCriteria> getSocietes(){
        return this.societes;
    }

    public void setSocietes(List<SocieteCriteria> societes){
        this.societes = societes;
    }
    public TypeDemandeCriteria getTypeDemande(){
        return this.typeDemande;
    }

    public void setTypeDemande(TypeDemandeCriteria typeDemande){
        this.typeDemande = typeDemande;
    }
    public List<TypeDemandeCriteria> getTypeDemandes(){
        return this.typeDemandes;
    }

    public void setTypeDemandes(List<TypeDemandeCriteria> typeDemandes){
        this.typeDemandes = typeDemandes;
    }
    public EtatDemandeCriteria getEtatDemande(){
        return this.etatDemande;
    }

    public void setEtatDemande(EtatDemandeCriteria etatDemande){
        this.etatDemande = etatDemande;
    }
    public List<EtatDemandeCriteria> getEtatDemandes(){
        return this.etatDemandes;
    }

    public void setEtatDemandes(List<EtatDemandeCriteria> etatDemandes){
        this.etatDemandes = etatDemandes;
    }
    public ComptableCriteria getComptableValidateur(){
        return this.comptableValidateur;
    }

    public void setComptableValidateur(ComptableCriteria comptableValidateur){
        this.comptableValidateur = comptableValidateur;
    }
    public List<ComptableCriteria> getComptableValidateurs(){
        return this.comptableValidateurs;
    }

    public void setComptableValidateurs(List<ComptableCriteria> comptableValidateurs){
        this.comptableValidateurs = comptableValidateurs;
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
}
