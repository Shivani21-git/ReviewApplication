# ReviewApplication
Review Application project is using Spring boot MVC
Review Application is a monolithic application using Spring MVC.

Step 1 : Generate the spring boot project fro start.spring.io
Step 2 : Add the below dependencies:
i) Spring boot starter web
ii) <!-- to build jsp -->
<dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
			<scope>provided</scope>
		</dependency>

	iii)	<!-- jstl for jsp -->
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>jstl</artifactId>
		</dependency>

	iV)	<!--Enables us for Spring Data -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

	V)	<!-- help our project to become client -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
		</dependency>
	</dependencies>

Step 2: Configure application.properties :-

spring.mvc.view.prefix: /WEB-INF/jsp/
spring.mvc.view.suffix: .jsp

server.port = 8084
spring.application.name=Spring-boot

spring.datasource.url=jdbc:mysql://localhost:3306/review_application
spring.datasource.username=root
spring.datasource.password=mypass

logging.level.org.springframework.web=DEBUG

Step 3 : Extend SpringBootServletInitializer class to the main class and override configure method.

Step 4: Keep the Jsp files under main --> webapp --> WEB-INF --> Jsp

Step 5 : localhost:8084/reviewapplication

Page will open which will ask user for Name and email id and then there is continue button in the form.
After clicking on Continue, flow will come to /continue and it will save the name and email to the user repository.And get the list of products and add it in the model attribute
Then it will return mainpage index that will show list of products. And then the flow will come to either read review or write review.

Clicking on write review will take the flow to the /writereview and clicking on post review will take the flow to the /postreview

Clicking on read review will take the flow to the /readreview and will show the reviews
