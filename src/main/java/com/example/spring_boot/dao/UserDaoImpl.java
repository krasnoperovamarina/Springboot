package com.example.spring_boot.dao;
import com.example.spring_boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
@Component
public class UserDaoImpl implements UserDao{

    private final EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    public void save(User user) {
        entityManager.persist(user);
        entityManager.close();
    }

    public void update(int id, User updatedUser) {
        User userToBeUpdated =  entityManager.getReference(User.class,id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setId(updatedUser.getId());
    }

    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    public User getUserByName(String name) {
        return entityManager.createQuery(
                        "SELECT u from User u WHERE u.name = :name", User.class).
                setParameter("name", name).getSingleResult();
}
}
