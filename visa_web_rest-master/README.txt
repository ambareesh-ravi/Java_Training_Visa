
Spring MVC
----------	
	Model View Controller Architectural Pattern
	-------------------------------------------

	Servlet URL Pattern : @WebServlet("*.do") or @WebServlet("*.action")

	action="hotels.action"
	action="booking.action"
	action="login.action"

	With Spring MVC it simplifies building MVC based web applicaiton

	DispatcherServlet reads the URI: String uri = request.getRequestURI();
		http://localhost:8080/addProduct.do
		Passes the URI to HandlerMapping
		HandlerMapping searchs all classes with @Controller or @RestController
		and searchs @RequestMapping annotatio

	@Controller
	class ProductController {

		@RequestMapping("addProduct.do", method=RequestMethod.POST)
		fun1() {

		}


		@RequestMapping("deleteProduct.do", method=RequestMethod.GET)
		fun2() {
			
		}


		@RequestMapping("getProducts.do", method=RequestMethod.GET)
		fun1() {
			
		}
	}
==========================================================

IDEMPOTENT
	GET
	DELETE
NOT IDEMPOTENT
	POST
	PUT
============

index.jsp ==> Search Hotels ===> searchResults.jsp
		

	class Address {
		houseNo;
		street;
		city;
		zip;
	}


	TextBox:
		5, 1 A Main, Bangalore, 5442221

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		 
		binder.registerCustomEditor(Address.class, new AddressEditorSupport());
	}
	==============

	https://github.com/BanuPrakash/visa_web_rest

	===========================================================

	RESTful Web Services

	REST
		==> Representational State Transfer
		A resource [database, files, tangible things like printer] reside in server
		This resource can be served to clients in various formats.

		General formats used are :
			a) XML
			b) JSON
			c) CSV
		products served using XML format:
			<products>
				<product id ="1">
					<name>HP</name>
					<price>135000.00</price>
				</product>
				<product id ="2">
					<name>iPhone</name>
					<price>135000.00</price>
				</product>
			</products>
		JSON:
			JavaScript Object Notation:
				[] for collection
				{} object

			[  
			   {  
			      "id":1,
			      "name":"iPhone XR",
			      "category":"mobile",
			      "price":45000.0,
			      "count":100
			   },
			   {  
			      "id":2,
			      "name":"Samsung Joy",
			      "category":"tv",
			      "price":135000.0,
			      "count":100
			   },
			   {  
			      "id":7,
			      "name":"Logitech Mouse ",
			      "category":"computer",
			      "price":400.0,
			      "count":497
			   }]

			  JSON understands number, string, boolean, null, object, date, undefined
			  var y = 10;
			  var p = "Smith"; 
			  var flag = true;

			  var x;
	===========
	REST is limited to HTTP protocol ==> Stateless
		REST uses URI [plural NOUNS] to identify resources
		uses HTTP methods [ VERBS] for actions on those resources

	GET
		http://server.com/products
		get all products
		No Payload

	GET
		http://server.com/products/3
		get a product whose id is "3"
		extra path parameter should be used for "PRIMARY KEY"

	GET
		http://server.com/products?category=mobile
		get all mobile products
		http://server.com/products?page=3&size=10
		Query Parameter is for filter

	POST
		http://server.com/products
		Payload contains the new product which has to be added to "products" main resource

	DELETE
		http://server.com/products/4
		delete a product whose id is 4

	PUT 
		http://server.com/products/4
		payload contains the product details which has to be updated for product
		whose id is 4


	CRUD
		GET --> READ
		POST --> CREATE
		PUT --> Update
		DELETE --> DELETE

	====================================

	REST depends on the following HTTP headers
		"accept": application/json
			to inform the server that client need "json" data
		"content-type": application/json
			to inform that the client is sending "json" data in payload

		====

		Spring Provides ContentNegotiationHandler
			whose job is convert Resource <---> Representation

			for JSON it can use any of these libraries:
				a) Jackson
				b) Jettison
				c) GSON
				d) Moxy

	=================================

	Spring Boot
		Spring boot is a layer on top of Spring Framework.
		Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".

 		It comes with lots of configuration which is ready to
 			like 
 				a) AppConfig
 					DataSource
 					EntityManagerFactory
 					TransactionManager
 				b) AppInitializer
 					DispactherServlet
 		It is higly opiniated, it assumes development is done using "Hibernate" as ORM framework and Tomcat as Servlet Container.

 		Spring boot is apt for building MicroServices

 		--------------------------------------------------

 		List<Product> findByCategoryAndPrice(String category, double price);

 		select * from products where category = ? and price = ?

				 

 		[
   {
      "orderId":1,
      "orderDate":"2019-07-18 11:18:27",
      "total":136200.0,
      "customer":{
         "email":"a@visa.com",
         "firstName":"Ashok"
      },
      "items":[
         {
            "itemId":1,
            "product":{
               "id":4,
               "name":"Hp Spectre Laptop ",
               "category":"computer",
               "price":135000.0,
               "count":499
            },
            "amount":135000.0,
            "qty":1
         },
         {
            "itemId":2,
            "product":{
               "id":7,
               "name":"Logitech Mouse ",
               "category":"computer",
               "price":400.0,
               "count":497
            },
            "amount":1200.0,
            "qty":3
         }
      ]
   }
]


============

place Order:
{
	"total": 19999,
	"customer" : {
		"email": "a@visa.com"
	},
	"items" : [
		{
			"product" : {
					"id" : 2
			},
			"qty": 3,
			"amount" : 65344
		},
		{
			"product" : {
					"id" : 1
			},
			"qty": 1,
			"amount" :63434
		}
		
	]
}
-----------------------------------------------------------------------

	RESTful Web Services using Spring Boot.
		Spring Boot simplifies using Spring Framework 5.x
		Can run as standalone
		Highly opiniated
			-> tomcat as servlet container
			-> Hibernate as ORM provider

		By using Spring boot we don't need to configure
			a) DispatcherServlet [ By default url-pattern is configured as *]
			b) DataSource ==> Pool of Database Connection is configured for [Hikari Connection Pool]
			c) Creates EntityManagerFactory
		Spring-Data-JPA can be used without Spring Boot
			Spring-data-JPA simplies Spring JPA integration.
			We just need to create a interface extends JPARepositroy or MongoRepository
				The implementation classes are provided by Spring-data-jpa
				MEthods if it starts with findByXXXX --> XXXX should be field on which where clause will  be used

				Any other method other than "findBy" should have @Query on top of it

				@Query("from Product where p.price between :low and :high")
				List<Product> getByRange(@param("low") double low, @Param("high") double high);

				start.spring.io
==================================================
	Spring Boot RESTFul app for HotelApp
	Entity reuse


	public interface HotelDao extends JpaRepository<Hotel,Integer> {

	}







