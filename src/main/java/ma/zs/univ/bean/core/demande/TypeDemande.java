package ma.zs.univ.bean.core.demande;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.univ.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "type_demande")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="type_demande_seq",sequenceName="type_demande_seq",allocationSize=1, initialValue = 1)
public class TypeDemande   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String libelle;
    private BigDecimal honnoraireComptableTraitant = BigDecimal.ZERO;
    private BigDecimal honnoraireComptableValidateur = BigDecimal.ZERO;



    public TypeDemande(){
        super();
    }

    public TypeDemande(Long id){
        this.id = id;
    }

    public TypeDemande(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public TypeDemande(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="type_demande_seq")
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
    public BigDecimal getHonnoraireComptableTraitant(){
        return this.honnoraireComptableTraitant;
    }
    public void setHonnoraireComptableTraitant(BigDecimal honnoraireComptableTraitant){
        this.honnoraireComptableTraitant = honnoraireComptableTraitant;
    }
    public BigDecimal getHonnoraireComptableValidateur(){
        return this.honnoraireComptableValidateur;
    }
    public void setHonnoraireComptableValidateur(BigDecimal honnoraireComptableValidateur){
        this.honnoraireComptableValidateur = honnoraireComptableValidateur;
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
        TypeDemande typeDemande = (TypeDemande) o;
        return id != null && id.equals(typeDemande.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

