package ma.zs.univ.bean.core.demande;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.univ.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "etat_demande")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="etat_demande_seq",sequenceName="etat_demande_seq",allocationSize=1, initialValue = 1)
public class EtatDemande   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String libelle;



    public EtatDemande(){
        super();
    }

    public EtatDemande(Long id){
        this.id = id;
    }

    public EtatDemande(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public EtatDemande(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="etat_demande_seq")
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

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EtatDemande etatDemande = (EtatDemande) o;
        return id != null && id.equals(etatDemande.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

