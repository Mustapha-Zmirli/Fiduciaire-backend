package ma.zs.univ.bean.core.commun;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.univ.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "comptable")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="comptable_seq",sequenceName="comptable_seq",allocationSize=1, initialValue = 1)
public class Comptable   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String cin;
    @Column(length = 500)
    private String prenom;
    @Column(length = 500)
    private String nom;
    @Column(length = 500)
    private String email;
    @Column(length = 500)
    private String categorieComptable;



    public Comptable(){
        super();
    }

    public Comptable(Long id){
        this.id = id;
    }

    public Comptable(Long id,String cin){
        this.id = id;
        this.cin = cin ;
    }
    public Comptable(String cin){
        this.cin = cin ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="comptable_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getCin(){
        return this.cin;
    }
    public void setCin(String cin){
        this.cin = cin;
    }
    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getCategorieComptable(){
        return this.categorieComptable;
    }
    public void setCategorieComptable(String categorieComptable){
        this.categorieComptable = categorieComptable;
    }

    @Transient
    public String getLabel() {
        label = cin;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comptable comptable = (Comptable) o;
        return id != null && id.equals(comptable.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

