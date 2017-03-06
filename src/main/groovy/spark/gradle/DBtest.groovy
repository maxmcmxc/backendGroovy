package spark.gradle

import java.util.List
import java.util.concurrent.atomic.DoubleAdder

import groovy.json.JsonBuilder
import groovy.sql.Sql

class DBtest {

	String url
	String user
	String password
	String driver
	
	boolean connexion = false
	
	Sql sql
	
	DBtest(url,user,password,driver){
		
		try{sql = Sql.newInstance(url, user, password, driver);
			 connexion=true}
		catch(e){
			 connexion=false}
		
	}
	
	DBtest(){
		
		 url = 'jdbc:postgresql://localhost:5432'
		 user = 'postgres'
		 password = ''
		 driver = 'org.postgresql.Driver'
		
		 try{sql = Sql.newInstance(url, user, password, driver);
			 connexion=true}
		catch(e){
			 connexion=false}
	
	}
	
	
	def createDatabase(){
		try{sql.execute('CREATE DATABASE dibi')
			 println "create db done"
		}
		catch(e){
			 println e
		}
	}
	
	def createTablePGUserz(){
		try{sql.execute("CREATE TABLE PGUSERZ (ID INT NOT NULL, USERZ varchar(20), PASSWORD varchar(20), PRIMARY KEY(ID) )")
			println "create table done"
		}
		catch(e){
			 println e
		}
	}

	def insertPGUserIntoPGUserz(){
		try{
			sql.execute("INSERT INTO PGUSERZ (ID, USERZ, PASSWORD) VALUES ('1', 'max','mad')")
			println "insert user done"
		}
		catch(e){
			 println e
		}
		
		new JsonBuilder([response: "create db, table, insert into, : DONE"])
	}	
	
	def selectAll(){
		try{
			def listA = sql.rows('select * from PGUSERZ') 
			return listA
//			sql.eachRow{ 
//				row ->
//				println "${row.ID} ${row.USERZ} ${row.PASSWORD}"}
		}
		catch(e){
			println e
			return "error"
		}		
	}

	def closeConnexion(){
		sql.close()
	}

}
