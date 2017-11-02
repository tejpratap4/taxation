# Taxation Reference

* Unit testing using **Spock**
* Building the project with **Gradle**

# Building the Servers

### Pre-requisites
For using taxaction - tax calculation functionality we need to store the product detail data first. that we can achive using below rest API once the server get started-

*    POST http://localhost:8081/dataStore

Assumptions
•	"Tax calculator" will only responsible for tax related calculation.
•	Product and Tax Types mapping will be persist with our application. E.g.		
		
		Productname	                 TaxType
		-------------------------------------
        "Book"	                     GENERAL
        "music cd"	                 GENERAL and ENTERTAIMENT 
        "box of tooth ache pills"	 No tax
        "bottle of wine"             GENERAL
        "box of pins"                GENERAL
        "chocolate snack"            GENERAL
•     TaxTypes – 	GENERAL (17.5%) ,  ENTERTAIMENT(1.25 addition)

# What is Taxation?

Taxation is a small Spring boot application. That accepts a single payload and apply the respective tax on that and return the response with tax details. e.g.

Reuest Payload-

{
  "purchaseItems": [
    {
      "itemName": "bottle of wine",
      "quantity": 1,
      "chargeAmount": 20.99
    },
    {
      "itemName": "box of tooth ache pills",
      "quantity": 2,
      "chargeAmount": 4.15
    },
    {
      "itemName": "box of pins",
      "quantity": 1,
      "chargeAmount": 11.25
    },
    {
      "itemName": "music CD",
      "quantity": 1,
      "chargeAmount": 14.99
    }
  ]
}

Response-

{
    "taxImpacts": [
        {
            "itemName": "bottle of wine",
            "quantity": 1,
            "chargeAmount": 24.69
        },
        {
            "itemName": "box of tooth ache pills",
            "quantity": 2,
            "chargeAmount": 4.15
        },
        {
            "itemName": "box of pins",
            "quantity": 1,
            "chargeAmount": 13.25
        },
        {
            "itemName": "music cd",
            "quantity": 1,
            "chargeAmount": 18.89
        }
    ],
    "salesTax": 9.6,
    "totalAmount": 60.98
}

The operations supported are:

 * ```POST http://localhost:8081/dataStore ``` - Pre configure the Master Product data. That will heplful when we apply the tax for that product.
 * ```POST http://localhost:8081/calculate ``` - Calculate the tax for defined product.
 
 
### Cloning the Project

Decide where your will keep your amplify projects and create a directory for them.

```
$ cd ~

```

Check out the ```/taxation``` project.

```
$ cd ~
$ git clone --recursive https://github.com/tejpratap4/taxation.git

```
$ cd taxation
$ ./gradlew build

### Build project- 
./gradlew build

### Clean project build
./gradlew clean

### Run project
$ ./gradlew bootRun

### Run umit test command -
./gradlew ut

### Code quality Strategy
./gradlew sonarQube


# Understanding the Code

The best way of understanding the code is to read the the code! Here is an outline of the project structure.

* ```build/``` -- gradle build output
* ```gradle/``` -- directory for gradle wrapper
* ```src/main/java``` -- Java classes
* ```src/main/resources/application.yml``` -- Spring boot application configuration
* ```src/test/groovy/``` -- Spock test
* ```.gitignore``` -- GIT ignore file
* ```build.gradle``` -- Gradle build file
* ```gradle.properties``` -- Gradle build properties
* ```gradlew```	-- gradle wrapper
* ```gradlew.bat``` -- gradle wrapper for windows
* ```settings.gradle``` -- settings for Gradle


