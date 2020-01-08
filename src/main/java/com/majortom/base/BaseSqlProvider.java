package com.majortom.base;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.majortom.annotation.Exclude;
import com.majortom.annotation.PrimaryKey;
import com.majortom.utils.Tool;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.jdbc.SQL;

import javax.persistence.Column;

public class BaseSqlProvider<T> {

    /**
     * 增
     */
    @Options
    public String add(T bean) {
        SQL sql = new SQL();
        Class clazz = bean.getClass();
        String tableName = clazz.getSimpleName();
        String realTableName = Tool.humpToLine(tableName).replaceFirst("_","");
        sql.INSERT_INTO(realTableName);
        List<Field> fields = getColumnFields(clazz);
        for (Field field : fields) {
            field.setAccessible(true);
            String column = field.getName();
            if(!column.equals("serialVersionUID")) {
                sql.VALUES(Tool.humpToLine(column), String.format("#{" + column + ",jdbcType=VARCHAR}"));
            }
        }
        return sql.toString();
    }


    /**
     * 删
     */
    public String delete(T bean) {

        SQL sql = new SQL();

        Class clazz = bean.getClass();

        String tableName = clazz.getSimpleName();

        String realTableName = Tool.humpToLine(tableName).replaceFirst("_","");
        sql.DELETE_FROM(realTableName);

        List<Field> primaryKeyField = getPrimarkKeyFields(clazz);

        temp(sql, primaryKeyField);

        return sql.toString();
    }

    public String deleteById(Long id,Class clazz) {

        SQL sql = new SQL();

        String tableName = clazz.getSimpleName();

        String realTableName = Tool.humpToLine(tableName).replaceFirst("_","");
        sql.DELETE_FROM(realTableName);

        List<Field> primaryKeyField = getPrimarkKeyFields(clazz);

        temp(sql, primaryKeyField,id);

        return sql.toString();
    }

    /**
     * 改
     */
    public String update(T bean) {
        SQL sql = new SQL();
        Class clazz = bean.getClass();
        String tableName = clazz.getSimpleName();
        String realTableName = Tool.humpToLine(tableName).replaceFirst("_","");
        sql.UPDATE(realTableName);
        List<Field> fields = getColumnFields(clazz);
        for (Field field : fields) {
            field.setAccessible(true);
            String column = field.getName();

            if (null!=field.getAnnotation(PrimaryKey.class)) {
                continue;
            }
            if(!column.equals("serialVersionUID")) {
                sql.SET(Tool.humpToLine(column) + "=" + String.format("#{" + column + ",jdbcType=VARCHAR}"));
            }        }
        List<Field> primaryKeyField = getPrimarkKeyFields(clazz);
        temp(sql, primaryKeyField);
        return sql.toString();
    }
    public String updateByColumn(Long id,Class clazz,String column,Object content) {
        if(havaColumn(column,clazz)){
            SQL sql = new SQL();
            String tableName = clazz.getSimpleName();
            String realTableName = Tool.humpToLine(tableName).replaceFirst("_", "");
            sql.UPDATE(realTableName);
            sql.SET(Tool.humpToLine(column) + "=" + String.format("#{arg3,jdbcType=VARCHAR}"));
            List<Field> primaryKeyField = getPrimarkKeyFields(clazz);
            temp(sql, primaryKeyField, id);
            return sql.toString();
        }else {
            return "";
        }
    }

    /**
     * 查
     */
    public String get(T bean) {
        SQL sql = new SQL();
        Class clazz = bean.getClass();
        String tableName = clazz.getSimpleName();
        String realTableName = Tool.humpToLine(tableName).replaceFirst("_","");
        sql.SELECT("*").FROM(realTableName);
        List<Field> primaryKeyField = getPrimarkKeyFields(clazz);
        temp(sql, primaryKeyField);
        return sql.toString();
    }
    public String getById(Long id,Class clazz) {
        SQL sql = new SQL();
        String tableName = clazz.getSimpleName();
        String realTableName = Tool.humpToLine(tableName).substring(1);
//        String realTableName = Tool.humpToLine(tableName).replaceFirst("_","");
        sql.SELECT("*").FROM(realTableName);
        List<Field> primaryKeyField = getPrimarkKeyFields(clazz);
        temp(sql, primaryKeyField,id);
        return sql.toString();
    }
    public String getByLimit (Class clazz,int start,int limit) {
        SQL sql = new SQL();
        String tableName = clazz.getSimpleName();
        String realTableName = Tool.humpToLine(tableName).replaceFirst("_","");
        sql.SELECT("*").FROM(realTableName);
        List<Field> primaryKeyField = getPrimarkKeyFields(clazz);
        sql.ORDER_BY(Tool.humpToLine(primaryKeyField.get(0).getName()));
        sql.OFFSET(start);
        sql.LIMIT(limit);
        String sqlQuery = sql.toString();
        return sqlQuery;
    }
    public String getByColumn(Class clazz,String column,Object content) {
        SQL sql = new SQL();
        String tableName = clazz.getSimpleName();
        String realTableName = Tool.humpToLine(tableName).replaceFirst("_","");
        sql.SELECT("*").FROM(realTableName);
        sql.WHERE(Tool.humpToLine(column) + "=" + String.format("#{arg2,jdbcType=VARCHAR}"));
        return sql.toString();
    }
    public String count(Class clazz) {
        SQL sql = new SQL();
        String tableName = clazz.getSimpleName();
        String realTableName = Tool.humpToLine(tableName).replaceFirst("_","");
        sql.SELECT("count(*)").FROM(realTableName);
        return sql.toString();
    }

    public String getMaxId(Class clazz) {
        SQL sql = new SQL();
        String tableName = clazz.getSimpleName();
        String realTableName = Tool.humpToLine(tableName).replaceFirst("_","");
        List<Field> primaryKeyField = getPrimarkKeyFields(clazz);
        sql.SELECT(Tool.humpToLine(primaryKeyField.get(0).getName())).FROM(realTableName);
        sql.ORDER_BY(Tool.humpToLine(primaryKeyField.get(0).getName())+" DESC");
        sql.LIMIT(0).LIMIT(1);
        return sql.toString();
    }
    public String getColumn(Class clazz,long id,String column){
        if(havaColumn(column, clazz)){
            SQL sql = new SQL();
            String tableName = clazz.getSimpleName();
            String realTableName = Tool.humpToLine(tableName).replaceFirst("_", "");

            sql.SELECT(Tool.humpToLine(column)).FROM(realTableName);
            List<Field> primaryKeyField = getPrimarkKeyFields(clazz);
            temp(sql, primaryKeyField,id);
            return sql.toString();
        }else {
            return null;
        }
    }
    /**
     * 工具方法
     * @param sql
     * @param primaryKeyField
     */
    private void temp(SQL sql, List<Field> primaryKeyField) {
        if (!primaryKeyField.isEmpty()) {
            for (Field pkField : primaryKeyField) {
                pkField.setAccessible(true);
                sql.WHERE(Tool.humpToLine(pkField.getName()) + "=" + String.format("#{" + pkField.getName() + "}"));
            }
        } else {
            sql.WHERE(" 1= 2");
            throw new RuntimeException("对象中未包含PrimaryKey属性");
        }
    }
    private void temp(SQL sql, List<Field> primaryKeyField,Long id) {
        if (!primaryKeyField.isEmpty()) {
            for (Field pkField : primaryKeyField) {
                pkField.setAccessible(true);
                sql.WHERE(Tool.humpToLine(pkField.getName()) + "=" + id);
            }
        } else {
            sql.WHERE(" 1= 2");
            throw new RuntimeException("对象中未包含PrimaryKey属性");
        }
    }
    private boolean havaColumn(String column,Class clazz) {
        List<Field> fields = getColumnFields(clazz);
        if (!fields.isEmpty()) {
            for (Field field : fields) {
                if (field.getName().equals(column)||Tool.humpToLine(field.getName()).equals(column)) {
                    return true;
                }
            }
        }
        return false;
    }
    private List<Field> getPrimarkKeyFields(Class clazz) {
        List<Field> primaryKeyField = new ArrayList<>();
        List<Field> fields = getFields(clazz);
        for (Field field : fields) {
            field.setAccessible(true);
            PrimaryKey key = field.getAnnotation(PrimaryKey.class);
            if (key != null) {
                primaryKeyField.add(field);
            }
        }
        return primaryKeyField;
    }
    private List<Field> getColumnFields(Class clazz) {
        List<Field> columnField = new ArrayList<>();
        List<Field> fields = getFields(clazz);
        for (Field field : fields) {
            field.setAccessible(true);
            Column key = field.getAnnotation(Column.class);
            if (key != null) {
                columnField.add(field);
            }
        }
        return columnField;
    }
    private List<Field> getFields(Class clazz) {
        List<Field> fieldList = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Exclude key = field.getAnnotation(Exclude.class);
            if (key == null) {
                fieldList.add(field);
            }
        }
        return fieldList;
    }
}

