package ar.edu.unq.desapp.grupoa.TestArquitectura;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import ar.edu.unq.desapp.grupoa.persistence.DAO;

@ContextConfiguration(locations = {"classpath:META-INF/spring-services-context.xml","classpath:META-INF/spring-persistence-context.xml"})
public class PersistabilityTest extends AbstractTransactionalJUnit4SpringContextTests{ 

    @Autowired
    private DAO dao;
    
    public void setDao(DAO dao) {
        this.dao = dao;
    }
    
    @Test
    public void testEntities() throws Exception {
        Set<Class<?>> entities = this.filter(getClasses());
        for(Class<?> entityClass : entities){
            checkIsPersistent( entityClass.newInstance());
        }
    }
    
    private void checkIsPersistent(Object object) throws Exception{
        List<Object> all = dao.findAll(object.getClass());
        int numberOfObjects = all.size();
        dao.save(object);
        all = dao.findAll(object.getClass());
        assertTrue((numberOfObjects + 1) == all.size());
        dao.delete(object);
        all = dao.findAll(object.getClass());
        assertTrue(numberOfObjects == all.size());
    }
    
    public Set<Class<?>> getClasses() throws InstantiationException, IllegalAccessException{

        List<ClassLoader> classLoadersList = new LinkedList<ClassLoader>();
        classLoadersList.add(ClasspathHelper.contextClassLoader());
        classLoadersList.add(ClasspathHelper.staticClassLoader());

        Reflections reflections = new Reflections(new ConfigurationBuilder()
            .setScanners(new SubTypesScanner(false), new ResourcesScanner())
            .setUrls(ClasspathHelper.forClassLoader(classLoadersList.toArray(new ClassLoader[0])))
            .filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix("ar.edu.unq.desapp.grupoa.model"))));
        Set<Class<?>> funcList = reflections.getSubTypesOf(Object.class);
        return funcList;
    }
    
    public Set<Class<?>> filter(Set<Class<?>> clases){
        Set<Class<?>> newSet = new HashSet<Class<?>>();
        for(Class<?> c : clases){
            if(this.match(c.getCanonicalName())){
                newSet.add(c);
            }
        }
        return newSet;
    }
    
    public boolean match(String nameClass){
        return (nameClass.equals("ar.edu.unq.desapp.grupoa.model.Accounts.Account") ||
                nameClass.equals("ar.edu.unq.desapp.grupoa.model.Bills.BillType")  ||
                nameClass.equals("ar.edu.unq.desapp.grupoa.model.Category.Category") ||
                nameClass.equals("ar.edu.unq.desapp.grupoa.model.Operation.Operation") ||
                nameClass.equals("ar.edu.unq.desapp.grupoa.model.System.Voucher") ||
                nameClass.equals("ar.edu.unq.desapp.grupoa.model.System.Consolidation"));
    }

}

