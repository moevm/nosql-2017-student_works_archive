import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Properties;

/**
 * Java + MongoDB Hello world Example
 *
 */
public class WorkWithMongo {
    // это клиент который обеспечит подключение к БД
    private MongoClient mongoClient;

    // В нашем случае, этот класс дает
// возможность аутентифицироваться в MongoDB
    private DB db;

    // тут мы будем хранить состояние подключения к БД
    private boolean authenticate;

    // И класс который обеспечит возможность работать
// с коллекциями / таблицами MongoDB
    private DBCollection tableStud;
    private DBCollection tableArchive;

    public WorkWithMongo(Properties prop) throws UnknownHostException {
        try {
            // Создаем подключение
            mongoClient = new MongoClient( prop.getProperty("host"), Integer.valueOf(prop.getProperty("port")) );

            // Выбираем БД для дальнейшей работы
            db = mongoClient.getDB(prop.getProperty("dbname"));

            // Входим под созданным логином и паролем
            authenticate = db.authenticate(prop.getProperty("login"), prop.getProperty("password").toCharArray());

            // Выбираем коллекцию/таблицу для дальнейшей работы
            tableStud = db.getCollection(prop.getProperty("studentsTable"));
            tableArchive = db.getCollection(prop.getProperty("archiveTable"));
        } catch (UnknownHostException e) {
            // Если возникли проблемы при подключении сообщаем об этом
            System.err.println("Don't connect!");
        }
    }



    public void addStudent(Student student){
        BasicDBObject document = new BasicDBObject();

        // указываем поле с объекта User
        // это поле будет записываться в коллекцию/таблицу
        document.put("studentID", student.getStudentID());
        document.put("name", student.getName());
        document.put("surname", student.getSurname());
        document.put("group", student.getGroup());

        // записываем данные в коллекцию/таблицу
        tableStud.insert(document);
    }

    public Student getStudentByStudentID(String studentID){
        BasicDBObject query = new BasicDBObject();

        // задаем поле и значение поля по которому будем искать
        query.put("studentID", studentID);

        // осуществляем поиск
        DBObject result = tableStud.findOne(query);

        // Заполняем сущность полученными данными с коллекции
        Student student = new Student();
        student.setStudentID(String.valueOf(result.get("studentID")));
        student.setId(String.valueOf(result.get("_id")));
        student.setName(String.valueOf("name"));
        student.setSurname(String.valueOf("surname"));
        student.setGroup(String.valueOf("group"));

        // возвращаем полученного пользователя
        return student;
    }

    // login - это старый логин пользователя
// newLogin - это новый логин который мы хотим задать
    /*public void updateStudentByStudentID(String studentID, Student newStudent){
        BasicDBObject newData = new BasicDBObject();

        // задаем новый логин
        newData.put("studentID", newStudent.getStudentID());

        // указываем обновляемое поле и текущее его значение
        BasicDBObject searchQuery = new BasicDBObject().append("studentID", studentID);

        // обновляем запись
        tableStud.update(searchQuery, newData);

        newData.put("name", newStudent.getName());
        newData.put("surname", newStudent.getSurname());
        newData.put("group", newStudent.getGroup());
    }*/

    public void deleteByStudentID(String studentID){
        BasicDBObject query = new BasicDBObject();

        // указываем какую запись будем удалять с коллекции
        // задав поле и его текущее значение
        query.put("studentID", studentID);

        // удаляем запись с коллекции/таблицы
        tableStud.remove(query);
    }
}