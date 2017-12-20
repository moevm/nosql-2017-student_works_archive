package com.data;


import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class Application {

    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        prop.setProperty("host", "localhost");
        prop.setProperty("port", "27017");
        prop.setProperty("dbname", "Archive");
        prop.setProperty("login", "admin1");
        prop.setProperty("password", "111");
        prop.setProperty("Archive", "Archive");
        WorkWithMongo mongo = new WorkWithMongo(prop);
        Archive student = new Archive("Лабораторная работа 1","Параллельные алгоритмы","4",LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE),"Миронов Владимир Владимирович",
                "438309","Сидоров Владимир Егорович","4383","d:\\Lab1.doc");
        mongo.addElement(student);
        student = new Archive("Лабораторная работа 2","Параллельные алгоритмы","4",LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE),"Миронов Владимир Владимирович",
                "438309","Сидоров Владимир Егорович","4383","d:\\Lab2.doc");
        mongo.addElement(student);
        student = new Archive("Лабораторная работа 2","Разработка программного обеспечения","5",LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE),"Фролов Виктор Иванович",
                "438309","Сидоров Владимир Егорович","4383","d:\\Lab3.doc");
        mongo.addElement(student);


        student = new Archive("Лабораторная работа 3","Параллельные алгоритмы","3",LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE),"Миронов Владимир Владимирович",
                "438115","Егоров Павел Юобевич","4381","d:\\Lab4.doc");
        mongo.addElement(student);
        student = new Archive("Лабораторная работа 2","Параллельные алгоритмы","4",LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE),"Миронов Владимир Владимирович",
                "438115","Егоров Павел Юобевич","4381","d:\\Lab5.doc");
        mongo.addElement(student);
        student = new Archive("Лабораторная работа 2","Разработка программного обеспечения","4",LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE),"Фролов Виктор Иванович",
                "438115","Егоров Павел Юобевич","4381","d:\\Lab6.doc");
        mongo.addElement(student);

        student = new Archive("Лабораторная работа 1","Параллельные алгоритмы","5",LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE),"Миронов Владимир Владимирович",
                "436211","Клен Елизавета Павловна","4362","d:\\Lab1.doc");
        mongo.addElement(student);
        student = new Archive("Лабораторная работа 3","Параллельные алгоритмы","5",LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE),"Миронов Владимир Владимирович",
                "436211","Клен Елизавета Павловна","4362","d:\\Lab2.doc");
        mongo.addElement(student);
        student = new Archive("Лабораторная работа 3","Разработка программного обеспечения","5",LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE),"Фролов Виктор Иванович",
                "436211","Клен Елизавета Павловна","4362","d:\\Lab3.doc");
        mongo.addElement(student);
    }
}
