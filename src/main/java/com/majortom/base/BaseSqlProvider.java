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
        String realTableName = Tool.humpToLine(tableName).replace("_","");
        sql.INSERT_INTO(realTableName);
        List<Field> fields = getColumnFields(clazz);
//        Options annotation = this.getClass().getMethods()[0].getAnnotation(Options.class);
//        InvocationHandler handler = Proxy.getInvocationHandler(annotation);
//        Field hField = null;
//        try {
//            hField = handler.getClass().getDeclaredField("memberValues");
//            hField.setAccessible(true);
//            Map memberValues = (Map) hField.get(handler);
//            memberValues.put("keyProperty","\""+fields.get(1).getName()+"\"");
//            memberValues.put("useGeneratedKeys",true);
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        System.out.println(annotation);
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

        String realTableName = Tool.humpToLine(tableName).replace("_","");
        sql.DELETE_FROM(realTableName);

        List<Field> primaryKeyField = getPrimarkKeyFields(clazz);

        temp(sql, primaryKeyField);

        return sql.toString();
    }

    public String deleteById(Long id,Class clazz) {

        SQL sql = new SQL();

        String tableName = clazz.getSimpleName();

        String realTableName = Tool.humpToLine(tableName).replace("_","");
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
        String realTableName = Tool.humpToLine(tableName).replace("_","");
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
        SQL sql = new SQL();
        String tableName = clazz.getSimpleName();
        String realTableName = Tool.humpToLine(tableName).replace("_","");
        sql.UPDATE(realTableName);
        sql.SET(Tool.humpToLine(column) + "=" + String.format("#{arg3,jdbcType=VARCHAR}"));
        List<Field> primaryKeyField = getPrimarkKeyFields(clazz);
        temp(sql, primaryKeyField,id);
        return sql.toString();
    }

    /**
     * 查
     */
    public String get(T bean) {
        SQL sql = new SQL();
        Class clazz = bean.getClass();
        String tableName = clazz.getSimpleName();
        String realTableName = Tool.humpToLine(tableName).replace("_","");
        sql.SELECT("*").FROM(realTableName);
        List<Field> primaryKeyField = getPrimarkKeyFields(clazz);
        temp(sql, primaryKeyField);
        return sql.toString();
    }
    public String getById(Long id,Class clazz) {
        SQL sql = new SQL();
        String tableName = clazz.getSimpleName();
        String realTableName = Tool.humpToLine(tableName).substring(1);
//        String realTableName = Tool.humpToLine(tableName).replace("_","");
        sql.SELECT("*").FROM(realTableName);
        List<Field> primaryKeyField = getPrimarkKeyFields(clazz);
        temp(sql, primaryKeyField,id);
//        System.out.println(sql);
        return sql.toString();
    }
    public String getByLimit (Class clazz,int start,int limit) {
        SQL sql = new SQL();
        String tableName = clazz.getSimpleName();
        String realTableName = Tool.humpToLine(tableName).replace("_","");
        sql.SELECT("*").FROM(realTableName);
        List<Field> primaryKeyField = getPrimarkKeyFields(clazz);
        sql.ORDER_BY(Tool.humpToLine(primaryKeyField.get(0).getName()));
        sql.LIMIT(start);
        String sqlQuery = sql.toString()+","+limit;
        return sqlQuery;
    }
    public String getByColumn(Class clazz,String column,Object content) {
        SQL sql = new SQL();
        String tableName = clazz.getSimpleName();
        String realTableName = Tool.humpToLine(tableName).replace("_","");
        sql.SELECT("*").FROM(realTableName);
        sql.WHERE(Tool.humpToLine(column) + "=" + String.format("#{arg2,jdbcType=VARCHAR}"));
        return sql.toString();
    }
    public String count(Class clazz) {
        SQL sql = new SQL();
        String tableName = clazz.getSimpleName();
        String realTableName = Tool.humpToLine(tableName).replace("_","");
        sql.SELECT("count(*)").FROM(realTableName);
        return sql.toString();
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

