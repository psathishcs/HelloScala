package org.hello

import java.sql.Connection
import java.sql.DriverManager

object HelloScalaOracleJDBC {
  def main(args : Array[String]){
    var url = "jdbc:oracle:thin:@localhost:1521:orcl";
	  var userName = "scott";
	  var password = "tiger";
	  var sqlQuery = "select * from emp";
    var driver = "oracle.jdbc.driver.OracleDriver";
    
    var connection:Connection  = null;
    try {
      Class.forName(driver);
      connection = DriverManager.getConnection(url, userName, password);
      var statement = connection.createStatement();
      var resultSet = statement.executeQuery(sqlQuery);
      while (resultSet.next()){
        print(resultSet.getString(1) + "\t")
        print(resultSet.getString(2) + "\t")
        print(resultSet.getString(3) + "\t")
        print(resultSet.getString(4) + "\t")
        print(resultSet.getString(5) + "\t")
        print(resultSet.getString(6) + "\t")
        print(resultSet.getString(7) + "\t")
        print(resultSet.getString(8) + "\n")
      }
      
    } catch {
      case t: Throwable => t.printStackTrace() // TODO: handle error
    }
    connection.close();
  }
}