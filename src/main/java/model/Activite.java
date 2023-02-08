package model;

public class Activite {
    private Integer id;
    private String nom;
    private String type;
    private String lieu;
    private String date;
    private String heure;
    
	public Activite() {
		super();
	}

	public Activite(String nom, String type, String lieu, String date, String heure) {
		super();
		this.nom = nom;
		this.type = type;
		this.lieu = lieu;
		this.date = date;
		this.heure = heure;
	}

	public Activite(Integer id, String nom, String type, String lieu, String date, String heure) {
		super();
		this.id = id;
		this.nom = nom;
		this.type = type;
		this.lieu = lieu;
		this.date = date;
		this.heure = heure;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}

	@Override
	public String toString() {
		return "Activite [id=" + id + ", nom=" + nom + ", type=" + type + ", lieu=" + lieu + ", date=" + date
				+ ", heure=" + heure + "]";
	}
    
    
   
    
}
    
   