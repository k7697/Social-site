package com.project.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import java.sql.Statement;

public class UserDbUtil {

private DataSource dataSource;

public UserDbUtil(DataSource dataSource) {
this.dataSource=dataSource;

}




public void  signup(String fname,String lname, String email,String password) throws SQLException {

Connection conn=null ;
Statement stm = null;
ResultSet res = null;

try {
conn = this.dataSource.getConnection();
String sql=String.format("INSERT INTO user VALUES('%s','%s','%s','%s')",fname,lname,email,password);
stm= conn.createStatement();
stm.executeUpdate(sql);

} finally {
close(conn,stm,res);
}

}

private void close(Connection conn,Statement smt,ResultSet res) {
try {
if(res != null) {
res.close();
}
if(smt != null) {
smt.close();
}
if(conn != null ) {
conn.close();
}
}
catch(Exception exe) {
exe.printStackTrace();
}
}

}
