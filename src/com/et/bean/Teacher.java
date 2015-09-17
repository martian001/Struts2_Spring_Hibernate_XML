package com.et.bean;

/**
 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年11月20日 下午2:35:47      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class Teacher {
   private Long id;
   private String name;
   private Classe classe;

   public Teacher() {
      super();
      // TODO Auto-generated constructor stub
   }

   public Teacher(String name, Classe classe) {
      super();
      this.name = name;
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

   public Classe getClasse() {
      return classe;
   }

   public void setClasse(Classe classe) {
      this.classe = classe;
   }

   @Override
   public String toString() {
      return "Teacher [id=" + id + ", name=" + name + "]";
   }

}
