package spark.gradle

import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import groovy.util.slurpersupport.GPathResult
import groovyx.net.http.RESTClient
import spark.Spark

class TestMainGroovy {
	
	@Test
	void testGetAllUsers() {
		
		
		
		
		
	}
	
	@Test
	void testPostRest() {
		
	//Testing REST POST Web Service. Use POSTMAN instead
//		try {
//			def http = new RESTClient("http://localhost:4567")
//			def map = [name: 'fischer', firstName: 'bobby']
//			def resp = http.post(path: '/users',
//								contentType: 'text/plain',
//								requestContentType : 'text/plain',
//								body : [name:'fischer',
//								firstName:'bobby'])
//						println "XML POST Success: ${resp.statusLine}"
//				assert resp.data instanceof GPathResult
//					assert resp.data.name() == 'user'
//					assert resp.data.@name == 'fischer'
//					assert resp.data.@firstName == 'bobby'
//		}
//		catch (groovyx.net.http.HttpResponseException ex) {
//			println "Had response exception ...."
//			ex.printStackTrace()	
//			return null}
//	}
	}	
}
