package dao;

import java.util.List;

public interface Dao <Classe, Id>{

	public List<Classe> findAll();
	public Classe findById(Id id);
	public Classe save(Classe objet);
    public Classe update(Classe objet);
    public void remove(Id id);
    
    
	
	
}
