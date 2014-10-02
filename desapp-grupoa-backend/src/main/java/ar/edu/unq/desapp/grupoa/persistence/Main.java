package ar.edu.unq.desapp.grupoa.persistence;

import ar.edu.unq.desapp.grupoa.model.Category.Category;

public class Main {

    public static void main(String[] args) {
        new CategoryDAO().saveOrUpdate(new Category("Income"));
    }
}
