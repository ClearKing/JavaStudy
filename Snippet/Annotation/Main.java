import java.lang.annotation.Annotation;

@Vip(leavel = "A")
class Employee {

}

//注解可以贴在类上，方法上，字段上， 构造器上
//我们可以通过Class Method Field Constructor 对象来获取注解
public class Main {

    //
    public static void main(String[] args) {
        //1.获取Employedd类上的所有注解
       Annotation[] as = Employee.class.getAnnotations();
       System.out.println(as.length);

       //
        if (Employee.class.isAnnotationPresent(Vip.class)){
           Vip v =  Employee.class.getAnnotation(Vip.class);
           String i =  v.leavel();
            System.out.println("xxx = "+ i);
        }
    }
}
