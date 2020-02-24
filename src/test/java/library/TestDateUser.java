package library;


import library.model.Role;
import library.model.User;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static library.model.AbstractBaseEntity.START_SEQ;

public class TestDateUser {


        public static final int USER_ID = START_SEQ;
        public static final int ADMIN_ID = START_SEQ + 1;

        public static final User USER = new User(USER_ID, "User", "user@google.ua",Role.ROLE_USER);
        public static final User ADMIN = new User(ADMIN_ID, "Admin", "admin@google.ua", Role.ROLE_ADMIN);



        public static void assertMatch(User actual, User expected) {
                assertThat(actual).isEqualToIgnoringGivenFields(expected,"books");

//                assertThat(actual).isEqualTo(expected);
        }

        public static void assertMatch(Iterable<User> actual, User... expected) {
                assertMatch(actual, List.of(expected));
        }

        public static void assertMatch(Iterable<User> actual, Iterable<User> expected) {
                assertThat(actual).usingElementComparatorIgnoringFields("books").isEqualTo(expected);
        }


}


//public class UserServiceTest extends AbstractServiceTest {
//
//        @Autowired
//        private UserService service;
//
////    @Test
////    public void create(){
////        User newUser = new User(null, "newSuperUser", "newUser@google.ua", Role.ROLE_USER);
////        User created = service.create(newUser);
////        newUser.setId(created.getId());
////        assertMatchUser(created, newUser);
////    }
//
//        @Test
//        public void delete() {
//                service.delete(USER_ID);
//                User user = service.get(USER_ID);
//                assertMatchUser(user , null);
//        }
//
//        @Test
//        public void get() {
//                User user = service.get(ADMIN_ID);
//                assertMatchUser(user, ADMIN);
//        }
//
//        @Test
//        public void getByEmail(){
//                User user = service.getByEmail("user@google.ua");
//                assertMatchUser(user, USER);
//        }
//
//
//        @Test
//        public void getAll() {
//                List<User> all = service.getAll();
//                assertMatchUser(all, List.of(ADMIN, USER));
//        }
//
//        @Test
//        public void update() {
//                User user = USER;
//                user.setEmail("newEmail@google.ua");
//                User updater = service.update(user);
//                assertMatchUser(updater, user);
//        }
//
//}
//
