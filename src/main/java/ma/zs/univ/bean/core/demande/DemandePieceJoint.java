package ma.zs.univ.bean.core.demande;

import java.util.Objects;





import ma.zs.univ.bean.core.demande.Demande;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.univ.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "demande_piece_joint")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="demande_piece_joint_seq",sequenceName="demande_piece_joint_seq",allocationSize=1, initialValue = 1)
public class DemandePieceJoint   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String path;

    private Demande demande ;


    public DemandePieceJoint(){
        super();
    }

    public DemandePieceJoint(Long id){
        this.id = id;
    }

    public DemandePieceJoint(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public DemandePieceJoint(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="demande_piece_joint_seq")
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "demande")
    public Demande getDemande(){
        return this.demande;
    }
    public void setDemande(Demande demande){
        this.demande = demande;
    }
    public String getPath(){
        return this.path;
    }
    public void setPath(String path){
        this.path = path;
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
        DemandePieceJoint demandePieceJoint = (DemandePieceJoint) o;
        return id != null && id.equals(demandePieceJoint.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

