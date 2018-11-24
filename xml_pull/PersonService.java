package study.ch.Service;

import android.icu.util.Output;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import study.ch.domain.Person;

public class PersonService {

    public static List<Person> getPersons(InputStream xml) throws XmlPullParserException, IOException {
       List<Person>  persons =null;
       Person person = null;
        XmlPullParser pullParser = Xml.newPullParser();
        pullParser.setInput(xml,"utf-8");
        int event = pullParser.getEventType();
        while(XmlPullParser.END_DOCUMENT != event){
            switch (event){
                case XmlPullParser.START_DOCUMENT:
                    persons = new ArrayList<>();
                    break;
                case XmlPullParser.START_TAG:
                    if("person".equals(pullParser.getName())){
                        int id = Integer.valueOf(pullParser.getAttributeValue(0));
                        person = new Person();
                        person.setId(id);
                    }
                    if("name".equals(pullParser.getName())){
                       String name  = pullParser.nextText();
                        person.setName(name);
                    }
                    if("age".equals(pullParser.getName())){
                        int age = Integer.valueOf(pullParser.nextText());
                        person.setAge(age);
                    }
                    break;
                case XmlPullParser.END_TAG:
                    if("person".equals(pullParser.getName())){
                        persons.add(person);
                        person =null;
                    }
                    break;
            }
            event = pullParser.next();
        }
        return persons;
    }
    public static void  save(List<Person> persons, OutputStream out) throws IOException {
        XmlSerializer serializer = Xml.newSerializer();
        serializer.setOutput(out,"utf-8");
        serializer.startDocument("utf-8", true);
        serializer.startTag(null, "persons");
        for(Person person :persons) {
            serializer.startTag(null,"person");
            serializer.attribute(null, "id", person.getId().toString());

            serializer.startTag(null, "name");
            serializer.text(person.getName());
            serializer.endTag(null, "name");

            serializer.startTag(null, "age");
            serializer.text(person.getAge().toString());
            serializer.endTag(null, "age");

            serializer.endTag(null,"person");
        }
        serializer.endTag(null, "persons");
        serializer.endDocument();
        out.flush();
        out.close();
    }
        
}
