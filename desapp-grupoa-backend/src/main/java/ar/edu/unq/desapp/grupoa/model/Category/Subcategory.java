package ar.edu.unq.desapp.grupoa.model.Category;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Subcategory implements Serializable,CategoryI{
    
    private static final long serialVersionUID = 5653515588678715797L;
    
    public Integer id;
    
    public String name;
    
    public Subcategory(){}
    
    public Subcategory(String name) {
        this.name = name;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTheSame(CategoryI category) {
        return this.name == category.getName();
    }

    public String getName() {
        return this.name;
    }

}
