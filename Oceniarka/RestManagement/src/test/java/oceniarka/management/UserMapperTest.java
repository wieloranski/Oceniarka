package oceniarka.management;

import com.google.common.collect.Lists;
import oceniarka.Domain.User;
import oceniarka.framework.DateTruncator;
import oceniarka.framework.Pair;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by eryk on 09.12.15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testApplicationContext.xml")
@Transactional
public class UserMapperTest {

    @Autowired
    UserMgmt userMgmt;

    private Pair<String, Integer> filter = new Pair<>("Zdzichu", 1);

    private List<User> insertedList;

    private User defaultObject;

    @Before
    public void initialize() {

        Date currentTime = DateTruncator.trancuateMilliseconds(new Date());
        defaultObject = new User("Zdzichu", "asd", true, false, currentTime, currentTime);

        insertedList = new ArrayList<>();
        insertedList.add(defaultObject);
        insertedList.add(new User("Zdzichu2", "dsa", false, true, currentTime, currentTime));
        insertedList.add(new User("Ktos inny", "dsa", false, true, currentTime, currentTime));

        for (User user : insertedList) {
            userMgmt.addUserWithCustomDate(user);
        }

        insertedList = Lists.reverse(insertedList);
        List<User> userListActual = findNLastUsers(userMgmt.getAllUsers(), 3);
        userListActual = Lists.reverse(userListActual);
        for (int i = 0; i < insertedList.size(); ++i) {
            assertEquals(insertedList.get(i), userListActual.get(i));
        }
    }

    private List<User> findNLastUsers(List<User> users, int n) {
        return users.subList(
                users.size() - n, users.size());
    }

    @Test
    public void getAllUsers() {
        List<User> users = userMgmt.getAllUsers();
        assertTrue("User list size: " + users.size(), users.size() > 0);
    }

    @Test
    public void findUserByUsername() {
        User userList = userMgmt.findUserByUsername(filter.getKey());
        assertEquals(defaultObject, userList);
    }

}
