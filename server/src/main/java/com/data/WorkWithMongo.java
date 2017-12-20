package com.data;
import com.mongodb.*;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Properties;
import com.mongodb.gridfs.*;
import org.bson.types.ObjectId;

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

    public WorkWithMongo(Properties prop) throws UnknownHostException {
        try {
            // Создаем подключение
            mongoClient = new MongoClient( prop.getProperty("host"), Integer.valueOf(prop.getProperty("port")) );

            // Выбираем БД для дальнейшей работы
            db = mongoClient.getDB(prop.getProperty("dbname"));

            // Входим под созданным логином и паролем
            authenticate = db.authenticate(prop.getProperty("login"), prop.getProperty("password").toCharArray());

            // Выбираем коллекцию/таблицу для дальнейшей работы
            tableStud = db.getCollection(prop.getProperty("Archive"));
        } catch (UnknownHostException e) {
            // Если возникли проблемы при подключении сообщаем об этом
            System.err.println("Don't connect!");
        }
    }



    public void addElement(Archive student) {
        try {
            BasicDBObject document = new BasicDBObject();
            // указываем поле с объекта User
            // это поле будет записываться в коллекцию/таблицу
            document.put("_id", student.getId());
            document.put("title", student.getTitle());
            document.put("subject", student.getSubject());
            document.put("grade", student.getGrade());
            document.put("date", student.getDate());
            document.put("teacherName", student.getTeatcherName());
            document.put("studentId", student.getStudentId());
            document.put("studentName", student.getStudentName());
            document.put("group", student.getGroup());
            document.put("file", student.getId());
            // подгружаем файл и заносим его в базу
            File file = new File(student.getFile());
            GridFS gfsPhoto = new GridFS(db, "fs");
            GridFSInputFile gfsFile = gfsPhoto.createFile(file);
            gfsFile.setId(student.getId());
            gfsFile.setFilename(student.getFile().split("\\\\")[student.getFile().split("\\\\").length-1]);
            gfsFile.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
            gfsFile.save();
            // записываем данные в коллекцию/таблицу
            tableStud.insert(document);
        }catch(IOException e){
            System.out.println("Ошибка записи, файл не загружен");
        }
    }
}