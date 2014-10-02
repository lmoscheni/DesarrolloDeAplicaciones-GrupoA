package ar.edu.unq.desapp.grupoa.persistence.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupoa.model.Category.Category;
import ar.edu.unq.desapp.grupoa.persistence.repository.CategoryRepository;

@Repository
public class CategoryDAO extends AbstractDAO<Category> implements CategoryRepository{

    @Transactional
    public void saveSubcategory(String nameCategory, String nameSubcategory){
        DetachedCriteria criteria = this.createCriteria();
        criteria.add(Restrictions.eq("name", nameCategory));
        Category result = (Category)this.getHibernateTemplate().findByCriteria(criteria);
        result.addSubcategory(nameSubcategory);
        this.update(result);
    }
}
