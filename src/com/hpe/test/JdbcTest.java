package com.hpe.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
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
		pstmt.setInt(1, 41);
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

}
