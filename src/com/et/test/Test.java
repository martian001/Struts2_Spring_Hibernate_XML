package com.et.test;

import java.util.List;

import org.hibernate.Session;

import com.et.bean.Classe;
import com.et.bean.Student;
import com.et.bean.Teacher;
import com.et.util.HibernateUtil;

/**
 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年11月19日 下午10:01:50      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class Test {

   @org.junit.Test
   public void test() {

      Session session = HibernateUtil.getSession();
      Classe classe = new Classe("1302", null, null);

      Teacher teacher = new Teacher("张老师", classe);
      classe.setTeacher(teacher);

      // Student student = new Student("martian", "123", new Date(), teacher, classe);
      //
      // session.save(student);
      HibernateUtil.close();
   }

   @org.junit.Test
   public void test2() {

      try {
         List<Student> queryByPage = HibernateUtil.getSession().createQuery("from Student").list();
         for (Student user : queryByPage) {
            System.out.println(user);
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   @org.junit.Test
   public void testDelete() {
      Student student = new Student();
      student.setId((long) 4);
      HibernateUtil.getSession().delete(student);
      // HibernateUtil.getSession().createQuery("delete Student where id=5").executeUpdate();
      HibernateUtil.close();
   }

   @org.junit.Test
   public void testDeleteClasse() {
      Long id = (long) 4;
      Session session = HibernateUtil.getSession();
      Classe classe = (Classe) session.get(Classe.class, id);
      System.out.println(classe);
      // classe.setId((long) 4);
      session.delete(classe);
      // HibernateUtil.getSession().createQuery("delete Student where id=5").executeUpdate();
      HibernateUtil.close();
   }
}
