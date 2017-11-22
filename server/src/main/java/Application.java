import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.net.UnknownHostException;
import java.util.Properties;



@SpringBootApplication
public class Application  extends WebMvcConfigurerAdapter{

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication.run(Application.class, args);
//        Properties prop = new Properties();
//        prop.setProperty("host", "localhost");
//        prop.setProperty("port", "27017");
//        prop.setProperty("dbname", "studArchive");
//        prop.setProperty("login", "admin1");
//        prop.setProperty("password", "111");
//        prop.setProperty("studentsTable", "students");
//        prop.setProperty("archiveTable", "archive");
//        WorkWithMongo mongo = new WorkWithMongo(prop);
//        Student student = new Student("4381","Ivan","Petrov","1321");
//        System.out.println(student);
//        mongo.addStudent(student);
//        System.out.println(mongo.getStudentByStudentID("4381"));
    }
}
