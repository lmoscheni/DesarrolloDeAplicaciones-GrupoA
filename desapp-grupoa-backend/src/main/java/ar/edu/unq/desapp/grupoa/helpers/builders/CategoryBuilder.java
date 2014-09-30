package ar.edu.unq.desapp.grupoa.helpers.builders;

import ar.edu.unq.desapp.grupoa.model.Category.Category;

/**
 * Class category builder
 * 
 * @author Skalic Julian and Leandro Moscheni
 * @version 1.0
 * 
 */

public class CategoryBuilder {

    public static CategoryBuilder aCategory() {
        return new CategoryBuilder();
    }

    private String name;

    public Category build() {
        return new Category(name);
    }

    public CategoryBuilder withName(String name) {
        this.name = name;
        return this;
    }
}
