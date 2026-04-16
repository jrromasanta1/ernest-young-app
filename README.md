**Run the application using ernst-young-app\src\main\java\com\StartSpringApplication.java**
https://github.com/jrromasanta1/ernest-young-app/blob/main/src/main/java/com/StartSpringApplication.java

**if you want to bypass s3upload since there is no actual AWS account comment out **
https://github.com/jrromasanta1/ernest-young-app/blob/b95722773f1114cb6c14500555e957ba351d72cb/src/main/java/com/ernstyoung/service/MetadataService.java#L30

**if you want to test with AWS S3bucket, update configurations at application.properties**
https://github.com/jrromasanta1/ernest-young-app/blob/main/src/main/resources/application.properties

POST http://localhost:8080/process
Body
[
  "file1",
  "file2",
  "file3",
  "file4",
  "file5",
  "file6",
  "file7",
  "file8"
]



Thank you,
**Jose Romasanta**
