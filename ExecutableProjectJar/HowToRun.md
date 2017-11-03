
### How to Run

1-  java -jar taxation.jar

Once the server got started trigger the below curl command or URL from postman.

Command prompt-

1-  ```  curl -X POST http://localhost:8081/taxation/1.0/dataStore -v --header "Content-Type: application/json"  ```

2-  ```  curl http://localhost:8081/taxation/1.0/calculate/ -v --header "Content-Type: application/json" --data @input1.json   ```

3- ```  curl http://localhost:8081/taxation/1.0/calculate/ -v --header "Content-Type: application/json" --data @input2.json   ```


``` From POSTman ```

1- 	Method - POST

	URL -   http://localhost:8081/dataStore

	No input output. It will populate the master data (product and tax type relationship.)


2-  Mathod    POST

	URL -   http://localhost:8081/calculate

	Input JSON - input1.json or input2.json
	
