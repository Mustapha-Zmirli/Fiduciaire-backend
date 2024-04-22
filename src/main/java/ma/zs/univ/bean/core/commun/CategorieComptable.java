package ma.zs.univ.bean.core.commun;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.univ.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "categorie_comptable")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="categorie_comptable_seq",sequenceName="categorie_comptable_seq",allocationSize=1, initialValue = 1)
public class CategorieComptable   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String libelle;



    public CategorieComptable(){
        super();
    }

    public CategorieComptable(Long id){
        this.id = id;
    }

    public CategorieComptable(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public CategorieComptable(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="categorie_comptable_seq")
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
        CategorieComptable categorieComptable = (CategorieComptable) o;
        return id != null && id.equals(categorieComptable.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

