Комментарий от ментора №1: внедрение зависимостей сделать через конструктор
Полагаю, речь про MainApp
Было:
      userService.add(new User("User1", "Lastname1", "user1@mail.ru", car1));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", car2));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", car3));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", car4));

Стало:
      User user1 = new User("User1", "Lastname1", "user1@mail.ru", car1);
      User user2 = new User("User2", "Lastname2", "user2@mail.ru", car2);
      User user3 = new User("User3", "Lastname3", "user3@mail.ru", car3);
      User user4 = new User("User4", "Lastname4", "user4@mail.ru", car4);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);



Комментарий от ментора №2: @SuppressWarnings("unchecked") - избавиться
Класс UserDaoImp, метод listUsers().
Аннотация удалена.



Комментарий от ментора №3: параметризуй квери - не работай с сырым типом
Класс UserDaoImp, методы listUsers() и getUser().
Параметризовал Query.



Комментарий от ментора №4: закомментированого кода не должно быть
Done!



Комментарий от ментора №5: читающие методы не должны проходить в транзакциях
Полагаю, здесь речь о методе getUser() в классе UserService.
Дополнил аннотацию @Transactional
Стало: 
@Transactional(readOnly = true)


Комментарий от ментора №6: сократи код при выводе пользователей
Полагаю, речь об MainApp. Пользователь выводился в 4 строки.
Было:
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
         System.out.println(user.getCar());
      }

Стало:
      for (User user : users) {
         System.out.println(user);
         System.out.println(user.getCar());
         System.out.println();
      }
