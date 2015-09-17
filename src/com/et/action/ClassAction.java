package com.et.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtilsBean;

import com.et.base.BaseAction;
import com.et.bean.Classe;
import com.et.bean.Teacher;
import com.opensymphony.xwork2.ActionContext;

/**
 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年11月21日 下午2:09:26      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class ClassAction extends BaseAction<Classe> {
   private Long teacherId;
   private InputStream inputStream;

   public String list() {
      List<Classe> classeList = classService.getAll();
      ActionContext.getContext().put("classeList", classeList);
      return "list";
   }

   public String delete() {
      Classe deleteClasse = classService.getById(model.getId());
      classService.delete(deleteClasse);
      return "toList";
   }

   public String addUI() {
      model = new Classe();// 把班级设为空，防止到了添加页面出现回显
      List<Teacher> teacherList = teacherService.getAll();
      ActionContext.getContext().put("teacherList", teacherList);
      return "addUI";
   }

   public String editUI() throws IllegalAccessException, InvocationTargetException {
      // 拷贝
      Classe editClasse = classService.getById(model.getId());
      if (editClasse.getTeacher() != null) {
         Long oldTeacherId = editClasse.getTeacher().getId();
         teacherId = oldTeacherId;
      }
      BeanUtilsBean.getInstance().copyProperties(model, editClasse);
      List<Teacher> teacherList = teacherService.getAll();
      ActionContext.getContext().put("teacherList", teacherList);
      return "editUI";
   }

   public String add() {
      Teacher teacher = teacherService.getById(teacherId);
      model.setTeacher(teacher);
      classService.saveOrUpdate(model);
      return "toList";
   }

   public String update() {
      Classe updateClasse = classService.getById(model.getId());
      Teacher teacher = teacherService.getById(teacherId);
      updateClasse.setName(model.getName());
      updateClasse.setTeacher(teacher);
      classService.saveOrUpdate(updateClasse);
      return "toList";
   }

   /**老师是否是班主任*/
   public String teacherIsUsable() throws UnsupportedEncodingException {
      if (teacherService.getById(teacherId).getClasse() != null) {
         // 已是班主任
         inputStream = new ByteArrayInputStream("1".getBytes("utf-8"));
      } else {
         // 不是班主任
         inputStream = new ByteArrayInputStream("0".getBytes("utf-8"));
      }
      return "ajax_success";
   }

   public Long TeacherId() {
      return teacherId;
   }

   public void setTeacherId(Long teacherId) {
      this.teacherId = teacherId;
   }

   public InputStream getInputStream() {
      return inputStream;
   }

   public void setInputStream(InputStream inputStream) {
      this.inputStream = inputStream;
   }
}
