package org.myStudy.config;

import org.myStudy.dao.StudentDao;
import org.myStudy.entity.Address;
import org.myStudy.entity.Student;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(value= "org.myStudy")

/*2 excludeFilters 后面的是排除某某类*/

/*2.1 ANNOTATION大范围，所有注解了@Controller的类等*/
/*@ComponentScan(value="org.myStudy",excludeFilters = {  @ComponentScan.Filter(type= FilterType.ANNOTATION,classes ={Controller.class} )}  )*/

/*2.2 ASSIGNABLE_TYPE具体的类*/
/*@ComponentScan(value="org.myStudy",excludeFilters = {  @ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE,classes ={StudentDao.class} )}  )*/

/*3 包含*/

/*3.1 includeFilters包含，需要后面改运用默认 false */
//@ComponentScan(value="org.myStudy",includeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION,classes ={Controller.class})},useDefaultFilters = false)

/*3.2  自定义FilterType.CUSTOM 需要创建MyFilter继承FilterType，实现方法*/
//@ComponentScan(value="org.myStudy",includeFilters = {@ComponentScan.Filter(type= FilterType.CUSTOM,classes ={ MyFilter.class  })},useDefaultFilters = false)
public class myConfig {
    /*No1*/
    @Bean(value = "stu")   /*stu是ID  如果没stu   方法名是ID   */
    @Scope("singleton")      /*singleton单例 程序一开始就会创建  原型prototype   你get的时候才会创建*/
    @Lazy /*懒加载*/
    public Student myStudent(Address address){
        Student student =new Student(10,"zs",23,address);
        return student;
    }
    @Bean
    public Address myAddress(){
        Address address =new Address("北京","天安门");
        return address;
    }
}
