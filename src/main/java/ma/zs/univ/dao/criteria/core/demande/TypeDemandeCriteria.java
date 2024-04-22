package  ma.zs.univ.dao.criteria.core.demande;



import ma.zs.univ.zynerator.criteria.BaseCriteria;
import java.util.List;

public class TypeDemandeCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String libelle;
    private String libelleLike;
    private String honnoraireComptableTraitant;
    private String honnoraireComptableTraitantMin;
    private String honnoraireComptableTraitantMax;
    private String honnoraireComptableValidateur;
    private String honnoraireComptableValidateurMin;
    private String honnoraireComptableValidateurMax;



    public TypeDemandeCriteria(){}

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

    public String getHonnoraireComptableTraitant(){
        return this.honnoraireComptableTraitant;
    }
    public void setHonnoraireComptableTraitant(String honnoraireComptableTraitant){
        this.honnoraireComptableTraitant = honnoraireComptableTraitant;
    }   
    public String getHonnoraireComptableTraitantMin(){
        return this.honnoraireComptableTraitantMin;
    }
    public void setHonnoraireComptableTraitantMin(String honnoraireComptableTraitantMin){
        this.honnoraireComptableTraitantMin = honnoraireComptableTraitantMin;
    }
    public String getHonnoraireComptableTraitantMax(){
        return this.honnoraireComptableTraitantMax;
    }
    public void setHonnoraireComptableTraitantMax(String honnoraireComptableTraitantMax){
        this.honnoraireComptableTraitantMax = honnoraireComptableTraitantMax;
    }
      
    public String getHonnoraireComptableValidateur(){
        return this.honnoraireComptableValidateur;
    }
    public void setHonnoraireComptableValidateur(String honnoraireComptableValidateur){
        this.honnoraireComptableValidateur = honnoraireComptableValidateur;
    }   
    public String getHonnoraireComptableValidateurMin(){
        return this.honnoraireComptableValidateurMin;
    }
    public void setHonnoraireComptableValidateurMin(String honnoraireComptableValidateurMin){
        this.honnoraireComptableValidateurMin = honnoraireComptableValidateurMin;
    }
    public String getHonnoraireComptableValidateurMax(){
        return this.honnoraireComptableValidateurMax;
    }
    public void setHonnoraireComptableValidateurMax(String honnoraireComptableValidateurMax){
        this.honnoraireComptableValidateurMax = honnoraireComptableValidateurMax;
    }
      

}
