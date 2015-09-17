package com.et.dao.impl;

import org.hibernate.Query;

import com.et.base.BaseDaoImpl;
import com.et.bean.Student;
import com.et.dao.StudentDao;

/**
 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年11月19日 下午5:33:38      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao {

   public StudentDaoImpl() {
      System.out.println("UserDaoImpl实例化");
   }

   @Override
   public Student login(Student student) {
      Query query = getSessionFactory().getCurrentSession().createQuery("from Student s where s.name=:name and s.password=:password");
      query.setParameter("name", student.getName());
      query.setParameter("password", student.getPassword());
      return (Student) query.uniqueResult();
   }

   @Override
   public boolean nameIsExist(String name) {
      Query query = getSessionFactory().getCurrentSession().createQuery("from Student s where name=:name");
      query.setParameter("name", name);
      return query.uniqueResult() != null;
   }

   public static void main(String[] args) {
      StudentDao dao = new StudentDaoImpl();
      // TeacherDao d=new
   }
}
