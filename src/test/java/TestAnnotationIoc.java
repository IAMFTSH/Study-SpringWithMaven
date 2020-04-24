import org.myStudy.config.myConfig;
import org.myStudy.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotationIoc {
    public static void main(String[] args) {
 /*       ApplicationContext contextXML= new ClassPathXmlApplicationContext("applicationContext.xml");  *//* xml用这个ClassPathXmlApplicationContext*/
        ApplicationContext context = new AnnotationConfigApplicationContext(myConfig.class);
        Student student = (Student) context.getBean("stu");
        System.out.println("--------"+student);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
/*
        String[] beanDefinitionNamesXML = contextXML.getBeanDefinitionNames();  */
/*实验XML配置与注解配置是否同一个IOC容器*//*

        for (String name : beanDefinitionNamesXML) {
            System.out.println("XML------"+name);
        }
*/

//        ((ClassPathXmlApplicationContext) context).close();

    }
}
