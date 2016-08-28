package org.hello

import com.datastax.driver.core.Cluster
import com.datastax.driver.core.Session
import com.datastax.driver.core.ResultSet
import com.datastax.driver.core.Row
object HelloScalaCassandra extends App {
  
  var cluster : Cluster = null;
  private var session : Session = null;
  var resultSet : ResultSet = null;
  var cql = "SELECT * FROM tp.emp"; 
    
  
  def connect(node: String) {
    cluster = Cluster.builder().addContactPoint(node).build();
    session =  cluster.connect();
    var metaData = cluster.getMetadata();
    printf ("Connected to cluster: %s\n",
        metaData.getClusterName())
    var metaMap = metaData.getAllHosts();
//    metaMap map ({ case host =>
//        printf("Databasecenter:%s; Host: %s; Rack: %s\n",
//            host.getDataCenter(), host.getAddress(), host.getRack())
//    })
  }
 
     
  def close() {
    cluster.close()
  }
  this.connect("127.0.0.1");
  resultSet = session.execute(cql);
  var rows = resultSet.all();
  this.close();
}