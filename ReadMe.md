1. Unzip the application persona-service.zip
2. Run Command to run spring boot app on 8080. Make sure your port is opened

  ./gradlew bootRun

3. Rest Apis can be accessed by importing this file Persona API.postman_collection.json in the root in PostMan (Rest Client App) or Curl 

#APIS

1. Create Persona
Method : POST
http://localhost:8080/persona

{
	"id" : 1,
	"name" : "Sarath",
	"lastName" : "Devarakonda",
	"address" : "Eclat Homes 501",
	"hairColor" : "black",
	"mobileNumber" : "8008948101"
}


2. Get Persona by Id

http://localhost:8080/persona/1

3. Update Persona
Method : PATCH

http://localhost:8080/persona

{
	"id" : 1,
	"name" : "Sarath",
	"lastName" : "Devarakonda",
	"address" : "Eclat Homes 501",
	"hairColor" : "black",
	"mobileNumber" : "8008948101"
}

4. Get all personas
Method : Get

http://localhost:8080/persona


[{
	"id" : 1,
	"name" : "Sarath",
	"lastName" : "Devarakonda",
	"address" : "Eclat Homes 501",
	"hairColor" : "black",
	"mobileNumber" : "8008948101"
}]


5. Delete Persona
Method : Delete

http://localhost:8080/persona/1


## Unit Tests

1. Invalid Green color sent in the request for creating the Persona

## Github Link
https://github.com/sarathkrrish/persona-service.git