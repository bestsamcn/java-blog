package me.best.main.dao;

import me.best.main.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;


/**
 * @Author: Sam
 * @Date: 2018/9/12 21:39
 */
public class BaseDao<T> {
    private Class<T> clazz;
    QueryRunner queryRunner = new QueryRunner();

    //获取调用者父类类型
    public BaseDao(){
        Type superType = this.getClass().getGenericSuperclass();
        if(superType instanceof ParameterizedType){
            ParameterizedType pt = (ParameterizedType) superType;
            Type[] tarry = pt.getActualTypeArguments();
            if(tarry[0] instanceof Class){
                clazz = (Class<T>) tarry[0];
            }
        }
    }

    /**
     * 查询一条数据
     * @param sql
     * @param args
     * @return
     */
    public T get(String sql, Object...args){
        T entity = null;
        Connection conn = null;
        try{
            conn = JdbcUtils.getConnection();
            entity = queryRunner.query(conn, sql, new BeanHandler<T>(clazz), args);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return entity;
    }

    /**
     * 唯一性约束
     * @param sql
     * @param args
     * @return
     */
    public Object getValue(String sql, Object...args){
        Connection conn = null;
        Object obj =null;
        try{
            conn = JdbcUtils.getConnection();
            obj = queryRunner.query(conn, sql, new ScalarHandler(), args);
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return obj;
    }

    /**
     * 分页
     * @param sql
     * @param args
     * @return
     */
    public List<T> getList(String sql, Object...args){
        Connection conn = null;
        List<T> list = null;
        try {
            conn = JdbcUtils.getConnection();
            list = queryRunner.query(conn, sql, new BeanListHandler<T>(clazz), args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return list;
    }

    /**
     * 获取全部
     * @param sql
     * @return
     */
    public List<T> getAll(String sql){
        Connection conn = null;
        List<T> list = null;
        try {
            conn = JdbcUtils.getConnection();
            list = queryRunner.query(conn, sql, new BeanListHandler<T>(clazz));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return list;
    }

    /**
     * 新增，修改，删除
     * @param sql
     * @param args
     * @return
     */
    public int update(String sql, Object...args){
        Connection conn = null;
        int row = 0;
        try {
            conn = JdbcUtils.getConnection();
            row = queryRunner.update(conn, sql, args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return row;
    }

}
