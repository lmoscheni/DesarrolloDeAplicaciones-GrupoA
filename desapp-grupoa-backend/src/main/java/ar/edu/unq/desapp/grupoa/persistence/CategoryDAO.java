package ar.edu.unq.desapp.grupoa.persistence;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import ar.edu.unq.desapp.grupoa.model.Category.Category;


public class CategoryDAO extends HibernateGenericDAO<Category> implements
		GenericDAO<Category> {

    private static final long serialVersionUID = 2801879081882182333L;

    @Override
	protected Class<Category> getDomainClass() {
		return Category.class;
	}

    public Category findByName(final String name){
        Criteria criteria = this.getSession().createCriteria(Category.class);
        criteria.add(Restrictions.eq("name", name));
        return (Category) criteria.uniqueResult();
    }
    
    public void saveOrUpdate(Category category){
        Category categoryExist = this.findByName(category.getName());
        if (categoryExist == null){
            this.getSession().save(category);
        }
    }
}
