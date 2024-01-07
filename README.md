# SA57_ChanKianMun_fibonacci

## General Information
1. This project is build with Java Spring Boot Framework.
2. POSTMAN is used for testing the REST api.
3. The api maps to: ```http://localhost:8080/fibonacci```.
4. The docker file is name ```DockerFile```
5. React application is in folder ```fib-app```

## Docker build and test
1. Run docker.
2. Navigate to the project folder in the terminal.
3. Run this in the terminal: ```docker build -t name-of-your-docker-image-file``` , replace ```name-of-your-docker-image-file``` with the name you want to name the image file.
4. Run ```docker run -p 8080:8080 name-of-your-docker-image-file```, replace ```name-of-your-docker-image-file``` with the name given to the image file in step 3.
5. Test using POSTMAN
  - navigate to ```http://localhost:8080/fibonacci```
  - set to GET request
  - test by pasting ```{"elements": 6}``` on the body. In this example, we are retrieving a fibonacci sequence of 6 integers
6. The response will display the fibonacci sequence and the sorted fibonacci sequence. 

## AWS Deployment and test
1. Test using POSTMAN
  - navigate to ```http://ec2-13-229-64-134.ap-southeast-1.compute.amazonaws.com:8080/fibonacci```
  - set to GET request
  - test by pasting ```{"elements": 6}``` on the body. In this example, we are retrieving a fibonacci sequence of 6 integers
2. The response will display the fibonacci sequence and the sorted fibonacci sequence. 

   
