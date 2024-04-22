package  ma.zs.univ.dao.criteria.core.commun;



import ma.zs.univ.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ComptableCriteria extends  BaseCriteria  {

    private String cin;
    private String cinLike;
    private String prenom;
    private String prenomLike;
    private String nom;
    private String nomLike;
    private String email;
    private String emailLike;
    private String categorieComptable;
    private String categorieComptableLike;



    public ComptableCriteria(){}

    public String getCin(){
        return this.cin;
    }
    public void setCin(String cin){
        this.cin = cin;
    }
    public String getCinLike(){
        return this.cinLike;
    }
    public void setCinLike(String cinLike){
        this.cinLike = cinLike;
    }

    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public String getPrenomLike(){
        return this.prenomLike;
    }
    public void setPrenomLike(String prenomLike){
        this.prenomLike = prenomLike;
    }

    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getNomLike(){
        return this.nomLike;
    }
    public void setNomLike(String nomLike){
        this.nomLike = nomLike;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmailLike(){
        return this.emailLike;
    }
    public void setEmailLike(String emailLike){
        this.emailLike = emailLike;
    }

    public String getCategorieComptable(){
        return this.categorieComptable;
    }
    public void setCategorieComptable(String categorieComptable){
        this.categorieComptable = categorieComptable;
    }
    public String getCategorieComptableLike(){
        return this.categorieComptableLike;
    }
    public void setCategorieComptableLike(String categorieComptableLike){
        this.categorieComptableLike = categorieComptableLike;
    }


}
