package examples.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExam01 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyBean myBean = (MyBean) context.getBean("myBean");
        myBean.print();

        MyBean myBean1 = (MyBean)context.getBean(MyBean.class);
        myBean1.print();

        if(myBean == myBean1){
            System.out.println("myBean == myBean1");
        }
    }
}
