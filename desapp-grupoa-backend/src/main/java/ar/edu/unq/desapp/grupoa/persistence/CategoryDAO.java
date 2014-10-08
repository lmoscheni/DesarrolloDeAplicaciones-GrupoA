package ar.edu.unq.desapp.grupoa.persistence;

import ar.edu.unq.desapp.grupoa.model.Category.Category;


public class CategoryDAO extends HibernateGenericDAO<Category> implements
		GenericDAO<Category> {

    private static final long serialVersionUID = 2801879081882182333L;

    @Override
	protected Class<Category> getDomainClass() {
		return Category.class;
	}

}
