package ar.edu.unq.desapp.grupoa.persistence;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Generic hibernate DAO
 * 
 * @param <T>
 */
public abstract class HibernateGenericDAO<T> extends HibernateDaoSupport
		implements GenericDAO<T>, Serializable {


    private static final long serialVersionUID = 6304955221724337774L;
    protected Class<T> persistentClass = this.getDomainClass();


	@SuppressWarnings("unchecked")
	public int count() {
		List<Long> list = (List<Long>) this.getHibernateTemplate().find("select count(*) from " + this.persistentClass.getName() + " o");
		Long count = list.get(0);
		return count.intValue();

	}

	public void delete(final T entity) {
		this.getHibernateTemplate().delete(entity);
	}

	public void deleteById(final Serializable id) {
		T obj = this.findById(id);
		this.getHibernateTemplate().delete(obj);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return (List<T>) this.getHibernateTemplate().find(
				"from " + this.persistentClass.getName() + " o");

	}

	public List<T> findByExample(final T exampleObject) {
		return this.getHibernateTemplate().findByExample(exampleObject);

	}

	public T findById(final Serializable id) {
		return this.getHibernateTemplate().get(this.persistentClass, id);
	}

	protected abstract Class<T> getDomainClass();

	public void save(final T entity) {
		this.getHibernateTemplate().save(entity);
		this.getHibernateTemplate().flush();
	}

	public void update(final T entity) {
		this.getHibernateTemplate().update(entity);
	}

}