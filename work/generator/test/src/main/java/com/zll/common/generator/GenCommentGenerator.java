package com.zll.common.generator;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.InnerEnum;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.internal.util.StringUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

/**
 * 自定义注解
 * @author CZH
 */
public class GenCommentGenerator implements CommentGenerator {

	private Properties systemPro;
	private String currentDateStr;

	@Override
	public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> set) {

	}

	@Override
	public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> set) {

	}

	@Override
	public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> set) {

	}

	@Override
	public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> set) {

	}

	@Override
	public void addClassAnnotation(InnerClass innerClass, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> set) {
		StringBuilder sb = new StringBuilder();
		innerClass.addJavaDocLine("/**");
		sb.append(" * 描述:");
		sb.append(introspectedTable.getFullyQualifiedTable()+"表的实体类");
		innerClass.addJavaDocLine(sb.toString().replace("\n", " "));
		sb.setLength(0);
		sb.append(" * @version");
		innerClass.addJavaDocLine(sb.toString().replace("\n", " "));
		sb.setLength(0);
		sb.append(" * @author:  ");
		sb.append(systemPro.getProperty("user.name"));
		innerClass.addJavaDocLine(sb.toString().replace("\n", " "));
		sb.setLength(0);
		sb.append(" * @Date: ");
		sb.append(currentDateStr);
		innerClass.addJavaDocLine(sb.toString().replace("\n", " "));
		innerClass.addJavaDocLine(" */");
	}

	public GenCommentGenerator() {
		super();
		systemPro = System.getProperties();
		currentDateStr = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date());
	}

	/**
	 * 给字段添加数据库备注
	 * @param field
	 * @param introspectedTable
	 * @param introspectedColumn
	 */
	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
		if (StringUtility.stringHasValue(introspectedColumn.getRemarks())) {
			StringBuilder sb = new StringBuilder();
			field.addJavaDocLine("/**");
			sb.append(" * ");
			sb.append(introspectedColumn.getRemarks());
			field.addJavaDocLine(sb.toString().replace("\n", " "));
			field.addJavaDocLine(" */");
		}
	}

	/**
	 * getter方法注释
	 * @param method
	 * @param introspectedTable
	 * @param introspectedColumn
	 */
	@Override
	public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
		if (StringUtility.stringHasValue(introspectedColumn.getRemarks())) {
			StringBuilder sb = new StringBuilder();
			method.addJavaDocLine("/**");
			sb.append(" * ");
			sb.append(introspectedColumn.getRemarks());
			method.addJavaDocLine(sb.toString().replace("\n", " "));
			sb.setLength(0);
			sb.append(" * @return ");
			sb.append(introspectedColumn.getActualColumnName());
			sb.append(" ");
			sb.append(introspectedColumn.getRemarks());
			method.addJavaDocLine(sb.toString().replace("\n", " "));
			method.addJavaDocLine(" */");
		}

	}

	/**
	 * setter方法注释
	 * @param method
	 * @param introspectedTable
	 * @param introspectedColumn
	 */
	@Override
	public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
		if (StringUtility.stringHasValue(introspectedColumn.getRemarks())) {
			StringBuilder sb = new StringBuilder();
			method.addJavaDocLine("/**");
			sb.append(" * ");
			sb.append(introspectedColumn.getRemarks());
			method.addJavaDocLine(sb.toString().replace("\n", " "));
			Parameter parm = method.getParameters().get(0);
			sb.setLength(0);
			sb.append(" * @param ");
			sb.append(parm.getName());
			sb.append(" ");
			sb.append(introspectedColumn.getRemarks());
			method.addJavaDocLine(sb.toString().replace("\n", " "));
			method.addJavaDocLine(" */");
		}
	}

	/**
	 * xml中的注释
	 * @param xmlElement
	 */
	@Override
	public void addComment(XmlElement xmlElement) {
	}

	@Override
	public void addJavaFileComment(CompilationUnit compilationUnit) {
		return;
	}

	@Override
	public void addRootComment(XmlElement rootElement) {
		return;
	}

	@Override
	public void addConfigurationProperties(Properties properties) {
	}

	@Override
	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
		StringBuilder sb = new StringBuilder();
		innerClass.addJavaDocLine("/**");
		sb.append(" * ");
		sb.append(introspectedTable.getFullyQualifiedTable());
		sb.append(" ");
		sb.append(currentDateStr);
		innerClass.addJavaDocLine(sb.toString().replace("\n", " "));
		innerClass.addJavaDocLine(" */");
	}

	@Override
	public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
	}

	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
	}

	@Override
	public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

	}

	@Override
	public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
	}

	@Override
	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {

	}
}
