package com.et.bean;

import java.util.HashSet;
import java.util.Set;

/**
 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年11月20日 下午2:33:36      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class Classe {
   private Long id;
   private String name;
   private Set<Student> studentSet = new HashSet<Student>();
   private Teacher teacher;

   public Classe() {
      super();
   }

   public Classe(String name, Set<Student> studentSet, Teacher teacher) {
      super();
      this.name = name;
      this.setStudentSet(studentSet);
      this.teacher = teacher;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Teacher getTeacher() {
      return teacher;
   }

   public void setTeacher(Teacher teacher) {
      this.teacher = teacher;
   }

   @Override
   public String toString() {
      return "Classe [id=" + id + ", name=" + name + "]";
   }

   public Set<Student> getStudentSet() {
      return studentSet;
   }

   public void setStudentSet(Set<Student> studentSet) {
      this.studentSet = studentSet;
   }

}
