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
    private DBCollection table;

    public WorkWithMongo(Properties prop) throws UnknownHostException {
        try {
            // Создаем подключение
            mongoClient = new MongoClient( prop.getProperty("host"), Integer.valueOf(prop.getProperty("port")) );

            // Выбираем БД для дальнейшей работы
            db = mongoClient.getDB(prop.getProperty("dbname"));

            // Входим под созданным логином и паролем
            authenticate = db.authenticate(prop.getProperty("login"), prop.getProperty("password").toCharArray());

            // Выбираем коллекцию/таблицу для дальнейшей работы
            table = db.getCollection(prop.getProperty("table"));
        } catch (UnknownHostException e) {
            // Если возникли проблемы при подключении сообщаем об этом
            System.err.println("Don't connect!");
        }
    }



    public void add(User user){
        BasicDBObject document = new BasicDBObject();

        // указываем поле с объекта User
        // это поле будет записываться в коллекцию/таблицу
        document.put("login", user.getLogin());

        // записываем данные в коллекцию/таблицу
        table.insert(document);
    }

    public User getByLogin(String login){
        BasicDBObject query = new BasicDBObject();

        // задаем поле и значение поля по которому будем искать
        query.put("login", login);

        // осуществляем поиск
        DBObject result = table.findOne(query);

        // Заполняем сущность полученными данными с коллекции
        User user = new User();
        user.setLogin(String.valueOf(result.get("login")));
        user.setId(String.valueOf(result.get("_id")));

        // возвращаем полученного пользователя
        return user;
    }

    // login - это старый логин пользователя
// newLogin - это новый логин который мы хотим задать
    public void updateByLogin(String login, String newLogin){
        BasicDBObject newData = new BasicDBObject();

        // задаем новый логин
        newData.put("login", newLogin);

        // указываем обновляемое поле и текущее его значение
        BasicDBObject searchQuery = new BasicDBObject().append("login", login);

        // обновляем запись
        table.update(searchQuery, newData);
    }

    public void deleteByLogin(String login){
        BasicDBObject query = new BasicDBObject();

        // указываем какую запись будем удалять с коллекции
        // задав поле и его текущее значение
        query.put("login", login);

        // удаляем запись с коллекции/таблицы
        table.remove(query);
    }
}