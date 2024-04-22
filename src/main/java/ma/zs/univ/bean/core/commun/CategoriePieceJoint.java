package ma.zs.univ.bean.core.commun;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.univ.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "categorie_piece_joint")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="categorie_piece_joint_seq",sequenceName="categorie_piece_joint_seq",allocationSize=1, initialValue = 1)
public class CategoriePieceJoint   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String libelle;



    public CategoriePieceJoint(){
        super();
    }

    public CategoriePieceJoint(Long id){
        this.id = id;
    }

    public CategoriePieceJoint(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public CategoriePieceJoint(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="categorie_piece_joint_seq")
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
        CategoriePieceJoint categoriePieceJoint = (CategoriePieceJoint) o;
        return id != null && id.equals(categoriePieceJoint.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

