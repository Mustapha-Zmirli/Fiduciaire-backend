package ma.zs.univ.bean.core.paiement;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.univ.bean.core.demande.Demande;
import ma.zs.univ.bean.core.paiement.TypePaiement;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.univ.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "paiement_demande")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="paiement_demande_seq",sequenceName="paiement_demande_seq",allocationSize=1, initialValue = 1)
public class PaiementDemande   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    private BigDecimal montant = BigDecimal.ZERO;
    private LocalDateTime datePaiement ;

    private Demande demande ;
    private TypePaiement typePaiement ;


    public PaiementDemande(){
        super();
    }

    public PaiementDemande(Long id){
        this.id = id;
    }

    public PaiementDemande(Long id,String code){
        this.id = id;
        this.code = code ;
    }
    public PaiementDemande(String code){
        this.code = code ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="paiement_demande_seq")
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
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }
    public LocalDateTime getDatePaiement(){
        return this.datePaiement;
    }
    public void setDatePaiement(LocalDateTime datePaiement){
        this.datePaiement = datePaiement;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "demande")
    public Demande getDemande(){
        return this.demande;
    }
    public void setDemande(Demande demande){
        this.demande = demande;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_paiement")
    public TypePaiement getTypePaiement(){
        return this.typePaiement;
    }
    public void setTypePaiement(TypePaiement typePaiement){
        this.typePaiement = typePaiement;
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
        PaiementDemande paiementDemande = (PaiementDemande) o;
        return id != null && id.equals(paiementDemande.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

