package ar.edu.unq.desapp.grupoa;

public class Subcategory extends Category{
    
    public Category superCategory;

    public Subcategory(String anName,Category anSupetegory) {
        super(anName);
        superCategory = anSupetegory;
    }

}
