package spark.gradle

import static spark.Spark.*

import groovy.json.JsonBuilder

service = new UserService()

port(7777)
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

post '/users', { req, res -> 
	service.createUser(req.params(":name"),req.params(":firstName"))
	new JsonBuilder([response: 'ok'])
}

