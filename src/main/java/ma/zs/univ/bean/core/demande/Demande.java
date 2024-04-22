package ma.zs.univ.bean.core.demande;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.univ.bean.core.commun.Societe;
import ma.zs.univ.bean.core.demande.EtatDemande;
import ma.zs.univ.bean.core.demande.TypeDemande;
import ma.zs.univ.bean.core.commun.Comptable;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.univ.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "demande")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="demande_seq",sequenceName="demande_seq",allocationSize=1, initialValue = 1)
public class Demande   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String libelle;
    private LocalDateTime dateDemande ;
    private LocalDateTime dateExigibilite ;
    private LocalDateTime dateValidation ;
    private LocalDateTime dateTraitement ;

    private Societe societe ;
    private TypeDemande typeDemande ;
    private EtatDemande etatDemande ;
    private Comptable comptableValidateur ;
    private Comptable comptableTraitant ;


    public Demande(){
        super();
    }

    public Demande(Long id){
        this.id = id;
    }

    public Demande(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public Demande(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="demande_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public LocalDateTime getDateDemande(){
        return this.dateDemande;
    }
    public void setDateDemande(LocalDateTime dateDemande){
        this.dateDemande = dateDemande;
    }
    public LocalDateTime getDateExigibilite(){
        return this.dateExigibilite;
    }
    public void setDateExigibilite(LocalDateTime dateExigibilite){
        this.dateExigibilite = dateExigibilite;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "societe")
    public Societe getSociete(){
        return this.societe;
    }
    public void setSociete(Societe societe){
        this.societe = societe;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_demande")
    public TypeDemande getTypeDemande(){
        return this.typeDemande;
    }
    public void setTypeDemande(TypeDemande typeDemande){
        this.typeDemande = typeDemande;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etat_demande")
    public EtatDemande getEtatDemande(){
        return this.etatDemande;
    }
    public void setEtatDemande(EtatDemande etatDemande){
        this.etatDemande = etatDemande;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comptable_validateur")
    public Comptable getComptableValidateur(){
        return this.comptableValidateur;
    }
    public void setComptableValidateur(Comptable comptableValidateur){
        this.comptableValidateur = comptableValidateur;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comptable_traitant")
    public Comptable getComptableTraitant(){
        return this.comptableTraitant;
    }
    public void setComptableTraitant(Comptable comptableTraitant){
        this.comptableTraitant = comptableTraitant;
    }
    public LocalDateTime getDateValidation(){
        return this.dateValidation;
    }
    public void setDateValidation(LocalDateTime dateValidation){
        this.dateValidation = dateValidation;
    }
    public LocalDateTime getDateTraitement(){
        return this.dateTraitement;
    }
    public void setDateTraitement(LocalDateTime dateTraitement){
        this.dateTraitement = dateTraitement;
    }

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Demande demande = (Demande) o;
        return id != null && id.equals(demande.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

