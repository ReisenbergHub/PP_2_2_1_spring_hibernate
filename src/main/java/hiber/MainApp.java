package hiber;

import hiber.model.Car;
import hiber.config.AppConfig;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("Car1", 111111);
      Car car2 = new Car("Car2", 333333);
      Car car3 = new Car("Car3", 333333);
      Car car4 = new Car("Car4", 444444);

      User user1 = new User("User1", "Lastname1", "user1@mail.ru", car1);
      User user2 = new User("User2", "Lastname2", "user2@mail.ru", car2);
      User user3 = new User("User3", "Lastname3", "user3@mail.ru", car3);
      User user4 = new User("User4", "Lastname4", "user4@mail.ru", car4);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      List<User> users = userService.listUsers();
      System.out.println("-----");
      for (User user : users) {
         System.out.println(user);
         System.out.println(user.getCar());
         System.out.println();
      }
      System.out.println("-----");
      System.out.println(userService.getUser("Car4",444444));
      System.out.println("-----");

      context.close();
   }
}
