package SpringBoot.dao;

import SpringBoot.model.User;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void add(User user) {
        em.persist(user);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> listUsers() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    @Transactional
    public void deleteUserById(int id) {
        User u = em.find(User.class, id);
        em.remove(u);
    }

    @Override
    @Transactional
    public void updateUser(int id, User user) {
        User userToBeUpdated = em.find(User.class, id);
        userToBeUpdated.setAge(user.getAge());
        userToBeUpdated.setFirstName(user.getFirstName());
        userToBeUpdated.setSecondName(user.getSecondName());
        em.merge(userToBeUpdated);
    }
}
