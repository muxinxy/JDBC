package com.hpe.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.hpe.po.Dept;

public class MyTest {

	@Test
	public void test() throws ClassNotFoundException, SQLException {
		//导入Java包
		//四大参数
		String driverName="com.mysql.jdbc.Driver";//驱动名
		String url="jdbc:mysql://localhost:3306/mytest";//url
		String username="root";//用户名
		String password="root";//密码
		//加载驱动
		Class.forName(driverName);
		//建立连接
		Connection conn=DriverManager.getConnection(url, username, password);
		System.out.println(conn);
		//准备SQL语句
		String sql="insert into dept values(?,?,?)";
		//创建PreparedStatement
		PreparedStatement pstmt=conn.prepareStatement(sql);
		//设置参数
		pstmt.setInt(1, 42);
		pstmt.setString(2, "法务部");
		pstmt.setString(3, "北京");
		//发送SQL语句
		int result=pstmt.executeUpdate();
		//处理结果
		if(result==1)
			System.out.println("发送成功");
		else
			System.out.println("发送失败");
		//关闭资源
		pstmt.close();
		conn.close();
	}
	@Test
	public void testDel() throws ClassNotFoundException, SQLException{
		//四大参数
		String driverName="com.mysql.jdbc.Driver";//驱动名
		String url="jdbc:mysql://localhost:3306/mytest";//url
		String username="root";//用户名
		String password="root";//密码
		//加载驱动
		Class.forName(driverName);
		//建立连接
		Connection conn=DriverManager.getConnection(url, username, password);
		System.out.println(conn);
		//准备SQL语句
		String sql="delete from dept where deptno=?";
		//创建PreparedStatement
		PreparedStatement pstmt=conn.prepareStatement(sql);
		//设置参数
		pstmt.setInt(1, 41);
		//发送SQL语句
		int result=pstmt.executeUpdate();
		//处理结果
		if(result==1)
			System.out.println("删除成功");
		else
			System.out.println("删除失败");
		//关闭资源
		pstmt.close();
		conn.close();		
	}
	@Test
	public void testUpdate() throws ClassNotFoundException, SQLException{
		//四大参数
		String driverName="com.mysql.jdbc.Driver";//驱动名
		String url="jdbc:mysql://localhost:3306/mytest";//url
		String username="root";//用户名
		String password="root";//密码
		//加载驱动
		Class.forName(driverName);
		//建立连接
		Connection conn=DriverManager.getConnection(url, username, password);
		System.out.println(conn);
		//准备SQL语句
		String sql="update dept set dname=? where deptno=?";
		//创建PreparedStatement
		PreparedStatement pstmt=conn.prepareStatement(sql);
		//设置参数
		pstmt.setString(1, "宣传部");
		pstmt.setInt(2, 41);
		//发送SQL语句
		int result=pstmt.executeUpdate();
		//处理结果
		if(result==1)
			System.out.println("修改成功");
		else
			System.out.println("修改失败");
		//关闭资源
		pstmt.close();
		conn.close();
	}
	@Test
	public void testFindAll() throws ClassNotFoundException, SQLException{
		//四大参数
		String driverName="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/mytest";
		String username="root";
		String password="root";
		//加载驱动
		Class.forName(driverName);
		//建立连接
		Connection conn=DriverManager.getConnection(url,username,password);
		//SQL语句
		String sql="select * from dept";
		//创建PreparedStatement
		PreparedStatement pstmt=conn.prepareStatement(sql);
		//发送SQL
		ResultSet rSet=pstmt.executeQuery();
		//处理结果
		while (rSet.next()) {
			int deptno=rSet.getInt(1);
			String dname=rSet.getString(2);
			String loc=rSet.getString(3);
			//System.out.println(deptno+" "+dname+" "+loc);
			Dept dept=new Dept();
			dept.setDeptno(deptno);
			dept.setDname(dname);
			dept.setLoc(loc);
			System.out.println(dept);
		}
		//关闭资源
		rSet.close();
		pstmt.close();
		conn.close();
	}
}
