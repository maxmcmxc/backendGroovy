package spark.gradle

import static spark.Spark.*
import groovy.json.JsonBuilder
import groovy.sql.Sql

import java.security.Provider.Service
import java.sql.Connection
import java.sql.Statement
import java.sql.DriverManager

service = new UserService()
dbTest = new DBtest()

port(7777)

//webSocket("/echo", EchoWeb.class);
//init(); // Needed if you don't define any HTTP routes after your WebSocket routes

//Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432", "postgres", "");
//Statement statement = c.createStatement();
//statement.executeUpdate("CREATE DATABASE dibi");


get '/users', { req, res -> 
	res.type("application/json")
	service.getAllUsers() }

get '/user/:id', { req, res -> 
	res.type("application/json")
	User u = service.getUser(req.params(":id")) 
	if (u != null) new JsonBuilder([response: u])
	else {'{"error":"not found" }'
		}
}

get '/db/create', { req, res ->
	res.type("application/json")
	dbTest.createDatabase()
	dbTest.createTablePGUserz()
	dbTest.insertPGUserIntoPGUserz()
 }
 
get '/db/all', { req, res ->
	 res.type("text/html")
	 dbTest.selectAll()
}

post '/users', { req, res -> 
	service.createUser(req.params(":name"),req.params(":firstName"))
	new JsonBuilder([response: 'ok'])
}

