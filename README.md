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
5. Go to the TrackingApplication.java file and right click on this class
   and run. 
6. After succeefully run, go the postman and give the
   the below url .
   URL : http://localhost:8080/api/v1/track?origin_country_id=IN&destination_country_id=BD&weight=111.999&created_at=2025-10-12T14:20:50Z&customer_id=de619854-b59b-425e-9db4-943979e1bd49&customer_name=Suresh Behera&customer_slug=etreyrwyetr-jhgfs

For Free Service , I am using Railway App
Steps: to run
1. First push the code into Github.
2. open Railaway App and register.
3. Click on create.
4. Select GithubRepo
5. select send2sureshbehera/tracking-number
6. Again click tracking-number then the app will take care for build and deployed.
7. Go to the settings->click on Custome domains->copy the domain
8. At the end of the domain add the below end point and test. 
   This is my Url:
   https://tracking-number-production.up.railway.app

 This is my end point:
  /api/v1/track?origin_country_id=IN&destination_country_id=BD&weight=111.999&created_at=2025-10-12T14:20:50Z&customer_id=de619854-b59b-425e-9db4-943979e1bd49&customer_name=Suresh%20Behera&customer_slug=etreyrwyetr-jhgfs
 
Full URL :
https://tracking-number-production.up.railway.app/api/v1/track?origin_country_id=IN&destination_country_id=BD&weight=111.999&created_at=2025-10-12T14:20:50Z&customer_id=de619854-b59b-425e-9db4-943979e1bd49&customer_name=Suresh%20Behera&customer_slug=etreyrwyetr-jhgfs