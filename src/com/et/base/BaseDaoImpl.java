package com.et.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年11月19日 下午5:32:19      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public abstract class BaseDaoImpl<T> implements BaseDao<T> {
   private SessionFactory sessionFactory;
   private Class<T> clazz;

   public Session getCurrentSession() {
      return getSessionFactory().getCurrentSession();
   }

   public BaseDaoImpl() {
      // 通过反射技术得到T的真是类型
      ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();// 获取当前new对象 的泛型的 父类类型
      clazz = (Class<T>) pt.getActualTypeArguments()[0];// 获取第一个类型参数的真实类型
   }

   @Override
   public void saveOrUpdate(T t) {
      Session currentSession = getCurrentSession();
      currentSession.saveOrUpdate(t);
      currentSession.flush();
   }

   @Override
   public void delete(T t) {
      Session currentSession = getCurrentSession();
      currentSession.delete(t);
      currentSession.flush();
   }

   @Override
   public List<T> getAll() {
      Query query = getCurrentSession().createQuery("from " + clazz.getSimpleName());
      return query.list();
   }

   @Override
   public T getById(Long id) {
      if (id == null) {
         return null;
      }
      return (T) getCurrentSession().get(clazz, id);
   }

   @Override
   public List<T> getByPage(int first, int MaxResults) {
      Query query = getCurrentSession().createQuery("FROM " + clazz.getSimpleName());
      query.setFirstResult(first);
      query.setMaxResults(MaxResults);
      return query.list();
   }

   @Override
   public List<T> getByPageNum(int pageNumber, int pageResults) {
      Query query = getCurrentSession().createQuery("FROM " + clazz.getSimpleName());
      query.setFirstResult(pageNumber * pageResults - pageResults);
      query.setMaxResults(pageResults);
      return query.list();
   }

   @Override
   public void deleteById(Long id) {
      T t = getById(id);
      if (t != null) {
         getCurrentSession().delete(t);
      }
   }

   @Override
   public void deleteByIds(Long[] ids) {
      Query query = getCurrentSession().createQuery("delete " + clazz.getSimpleName() + " where id in(:ids)");
      query.setParameter("ids", ids).executeUpdate();
   }

   @Override
   public List<T> getByIds(Long[] ids) {
      Query query = getCurrentSession().createQuery("from " + clazz.getSimpleName() + " where id in(:ids)");
      return query.setParameter("ids", ids).list();
   }

   public SessionFactory getSessionFactory() {
      return sessionFactory;
   }

   public void setSessionFactory(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }
}
