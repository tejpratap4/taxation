
### How to Run

1- Clone the project or copy taxation.jar (taxation\ExecutableProjectJar\taxation.jar).

2- Run the project
  
  java -jar taxation.jar


Once the server got started trigger the below curl command or URL from postman.

Command prompt-

i-  ```  curl -X POST http://localhost:8081/taxation/1.0/dataStore -v --header "Content-Type: application/json"  ```

ii-  ```  curl http://localhost:8081/taxation/1.0/calculate/ -v --header "Content-Type: application/json" --data @input1.json   ```

iii- ```  curl http://localhost:8081/taxation/1.0/calculate/ -v --header "Content-Type: application/json" --data @input2.json   ```


``` From POSTman ```

i- 	Method - POST

	URL -   http://localhost:8081/dataStore

	No input output. It will populate the master data (product and tax type relationship.)

ii-  Mathod    POST

	URL -   http://localhost:8081/calculate

	Input JSON - input1.json or input2.json
	
