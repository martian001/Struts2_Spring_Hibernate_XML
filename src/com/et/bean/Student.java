package com.et.bean;

import java.util.Date;

/**
 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年11月19日 下午5:48:15      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class Student {
   private Long id;
   private String name;
   private String password;
   private Date birthDate;
   private Classe classe;

   public Student() {
      super();
      // TODO Auto-generated constructor stub
   }

   public Student(String name, String password, Date birthDate, Classe classe) {
      super();
      this.name = name;
      this.password = password;
      this.birthDate = birthDate;
      this.classe = classe;
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

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public Date getBirthDate() {
      return birthDate;
   }

   public void setBirthDate(Date birthDate) {
      this.birthDate = birthDate;
   }

   public Classe getClasse() {
      return classe;
   }

   public void setClasse(Classe classe) {
      this.classe = classe;
   }

   @Override
   public String toString() {
      return "Student [id=" + id + ", name=" + name + ", password=" + password + ", birthDate=" + birthDate + ", classe=" + classe + "]";
   }

}
