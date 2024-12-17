Spring boot Setup:
==================
1. Creating a Spring boot application.
2. there are multiple packages are there.
   A.Controller:
   Here the end point is defined which will accept the request from front end.
   B.Dto :
   It will transfer the object from Controller to service and send the response from service to Controller.
   C. entity :
   It is used to represent the Database table info.
   D. Exception:
   It will handle the exception.
   E. Service :
   It is used to handle the business logic.
   D.Validator.
   It is used to handle the custom validation for query parameter.
3. Config the H2 Database table for storing the data
4. application.properties file is used to config the database.
   For Run the application.
1. Go to the TrackingApplication.java file and right click on this class
   and run.
2. After succeefully run, go the postman and give the
   the below url .
   URL : http://localhost:8080/api/v1/track?origin_country_id=IN&destination_country_id=BD&weight=111.999&created_at=2025-10-12T14:20:50Z&customer_id=de619854-b59b-425e-9db4-943979e1bd49&customer_name=Suresh Behera&customer_slug=etreyrwyetr-jhgfs
