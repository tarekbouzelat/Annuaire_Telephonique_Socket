package ConnBDD;

public class AnnuairePersonne {
	
    private String nom;
    private String numero;

    public AnnuairePersonne(String nom, String numero) {
    
    
        this.nom = nom;
        this.numero=numero;
    }





    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

  

    @Override
    public String toString() {
        return "Personne{" +
                ", nom = '" + nom + '\'' +
                ", numero = '" + numero + '\'' +
                '}';
    }
    

}

