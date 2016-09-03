package org.hello.hbase

import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.hbase.client.{HBaseAdmin, HTable, Put, Get, Scan}
import org.apache.hadoop.hbase.util.Bytes
import org.apache.hadoop.hbase.client.Result



object HelloHBase extends App {
  val conf = new HBaseConfiguration()
  val admin = new HBaseAdmin(conf);
  
  // listof tables
  val listOFTables = admin.listTables();
  println("+++++++++++++++++++++List of HBase Table+++++++++++++++++++++");
  listOFTables.foreach(println);
  val table = new HTable(conf, "employees");
  var put = new Put(Bytes.toBytes("row6"));
	put.add(Bytes.toBytes("personal"), Bytes.toBytes("name"), Bytes.toBytes("Thilagavathy CJ"));
	put.add(Bytes.toBytes("personal"), Bytes.toBytes("city"), Bytes.toBytes("Coimbatore"));
	put.add(Bytes.toBytes("professional"), Bytes.toBytes("designation"), Bytes.toBytes("HR"));
	put.add(Bytes.toBytes("professional"), Bytes.toBytes("salary"), Bytes.toBytes("70000"));
  
  this.put = new Put(Bytes.toBytes("row7"));
	put.add(Bytes.toBytes("personal"), Bytes.toBytes("name"), Bytes.toBytes("Nathiya Thivagaran"));
	put.add(Bytes.toBytes("personal"), Bytes.toBytes("city"), Bytes.toBytes("Pondicherry"));
	put.add(Bytes.toBytes("professional"), Bytes.toBytes("designation"), Bytes.toBytes("HR"));
	put.add(Bytes.toBytes("professional"), Bytes.toBytes("salary"), Bytes.toBytes("69000"));
  
}