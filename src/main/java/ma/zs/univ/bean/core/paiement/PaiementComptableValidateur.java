package ma.zs.univ.bean.core.paiement;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.univ.bean.core.demande.Demande;
import ma.zs.univ.bean.core.paiement.TypePaiement;
import ma.zs.univ.bean.core.commun.Comptable;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.univ.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "paiement_comptable_validateur")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="paiement_comptable_validateur_seq",sequenceName="paiement_comptable_validateur_seq",allocationSize=1, initialValue = 1)
public class PaiementComptableValidateur   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    private BigDecimal montant = BigDecimal.ZERO;
    private LocalDateTime datePaiement ;

    private Demande demande ;
    private Comptable comptableValidateur ;
    private TypePaiement typePaiement ;


    public PaiementComptableValidateur(){
        super();
    }

    public PaiementComptableValidateur(Long id){
        this.id = id;
    }

    public PaiementComptableValidateur(Long id,String code){
        this.id = id;
        this.code = code ;
    }
    public PaiementComptableValidateur(String code){
        this.code = code ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="paiement_comptable_validateur_seq")
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "demande")
    public Demande getDemande(){
        return this.demande;
    }
    public void setDemande(Demande demande){
        this.demande = demande;
    }
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
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
    @JoinColumn(name = "type_paiement")
    public TypePaiement getTypePaiement(){
        return this.typePaiement;
    }
    public void setTypePaiement(TypePaiement typePaiement){
        this.typePaiement = typePaiement;
    }
    public LocalDateTime getDatePaiement(){
        return this.datePaiement;
    }
    public void setDatePaiement(LocalDateTime datePaiement){
        this.datePaiement = datePaiement;
    }

    @Transient
    public String getLabel() {
        label = code;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaiementComptableValidateur paiementComptableValidateur = (PaiementComptableValidateur) o;
        return id != null && id.equals(paiementComptableValidateur.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

