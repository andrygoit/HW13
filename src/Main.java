import java.io.IOException;
import java.net.URI;
import java.util.List;
public class Main {
    private static final String POSTS = "https://jsonplaceholder.typicode.com/posts";
    private static final String USERS = "https://jsonplaceholder.typicode.com/users";


    public static void main(String[] args) throws IOException, InterruptedException {
        User defaultUser = new User(1, "Andrew Mikaylenko", "malloy",
                "andrew@gmail.com", new Address("Borshchagivska", "Apt. 156", "Kyiv",
                "45654-6543", new Geo("-45.5678", "malloy.com")),
                "380509434","hildegard.org",
                new Company("GoIT", "Something",
                        "Something"));
        User createdUser = HttpUtil.putUser(URI.create(USERS), defaultUser);
        System.out.println(createdUser);
        User updatedUser = HttpUtil.postUser(URI.create(USERS), defaultUser);
        System.out.println(updatedUser);
        HttpUtil.deleteUser(URI.create(USERS), 11);
        List<User> allUsers = HttpUtil.getUsers(URI.create(USERS));
        System.out.println(allUsers);
        User userById = HttpUtil.getUserById(URI.create(USERS),1);
        System.out.println(userById);
        User userName = HttpUtil.getUserByUserName(URI.create(USERS), "Antonette");
        System.out.println(userName);
        HttpUtil.getUserComments(2);
        List<Todo> allTodos = HttpUtil.getUserTodos(URI.create(USERS), 1);
        System.out.println(allTodos);

    }
}
