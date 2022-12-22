package hiber.dao;

import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public List<User> listUsers() {
       String hql = "FROM User";
       TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql);
       return query.getResultList();
   }

    @Override
    public Optional<User> getUser(String model, int series) {
       String hql = "FROM User user WHERE user.car.model = :parameterModel AND user.car.series = :parameterSeries";
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery(hql);
        query.setParameter("parameterModel", model);
        query.setParameter("parameterSeries", series);
        Optional<User> user = query.getResultStream().findAny();
        return user;
    }
}
