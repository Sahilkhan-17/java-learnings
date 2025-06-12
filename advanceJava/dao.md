# DAO (Data Access Object)

## What is a DAO?

DAO stands for Data Access Object. It's a core design pattern in Java applications that provides an abstract interface to some type of database or persistence mechanism. The DAO pattern:

1. Separates low-level data accessing operations from high-level business services
2. Provides a clean, simple API to the rest of the application
3. Hides all the details of data storage and retrieval from the business logic

## Key Characteristics of DAO Pattern

- **Abstraction Layer**: Acts as an intermediary between the application and the database
- **CRUD Operations**: Typically provides Create, Read, Update, Delete operations
- **Domain-Specific**: Usually designed to work with a specific domain object or entity
- **Transaction Management**: Often handles transaction boundaries

## DAO Implementation in Java (Without Spring)

Here's a basic implementation of a DAO pattern in plain Java:

```java
public interface UserDao {
    User findById(long id);
    List<User> findAll();
    void save(User user);
    void update(User user);
    void delete(User user);
}

public class UserDaoImpl implements UserDao {
    private final Connection connection;
    
    public UserDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public User findById(long id) {
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE id = ?")) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getLong("id"), rs.getString("name"), rs.getString("email"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
    // Other method implementations...
}
```

## DAO in Spring Framework

Spring provides several ways to implement the DAO pattern with additional benefits:

1. **Exception Translation**: Converts JDBC SQLExceptions into Spring's DataAccessException hierarchy
2. **Resource Management**: Handles connection opening/closing automatically
3. **Transaction Management**: Provides declarative transaction management

### Spring DAO Approaches

1. **JdbcTemplate**: Simplifies JDBC operations
2. **HibernateTemplate**: Simplifies Hibernate operations (less common now)
3. **JPA Repository**: Modern approach using Spring Data JPA

### Spring DAO with JdbcTemplate Example

```java
@Repository
public class UserDaoImpl implements UserDao {
    
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public UserDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public User findById(long id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
            new User(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("email")
            ));
    }
    
    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
            new User(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("email")
            ));
    }
    
    // Other method implementations...
}
```

### Modern Approach: Spring Data JPA

With Spring Data JPA, you can create DAOs (called Repositories) with minimal code:

```java
public interface UserRepository extends JpaRepository<User, Long> {
    // Basic CRUD operations are provided automatically
    List<User> findByName(String name);
    List<User> findByEmailContaining(String domain);
}
```

Spring Data JPA will implement these methods automatically at runtime!

## Benefits of DAO Pattern in Spring

1. **Reduced Boilerplate**: Spring templates handle resource management
2. **Consistent Exception Hierarchy**: All data access exceptions are runtime exceptions
3. **Testability**: Easy to mock DAO interfaces for testing
4. **Flexibility**: Can switch persistence technologies without changing business logic
5. **Transaction Management**: Works seamlessly with Spring's @Transactional

## Best Practices for DAO in Spring

1. **Use Interfaces**: Always program to DAO interfaces, not implementations
2. **Layer-Specific Exceptions**: Convert persistence exceptions to application-specific ones
3. **Avoid Business Logic**: DAOs should only handle data access
4. **Use Spring Stereotypes**: Annotate DAO classes with @Repository
5. **Consider Spring Data**: For new projects, prefer Spring Data JPA repositories

## Transaction Management

Spring makes it easy to add transactions to your DAO operations:

```java
@Service
public class UserService {
    
    private final UserDao userDao;
    
    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }
    
    @Transactional
    public void updateUserEmail(Long userId, String newEmail) {
        User user = userDao.findById(userId);
        user.setEmail(newEmail);
        userDao.update(user);
    }
}
```

The @Transactional annotation can be applied at class or method level.

## Conclusion

The DAO pattern is fundamental to creating maintainable data access layers in Java applications. Spring Framework provides powerful tools to implement this pattern while reducing boilerplate code and adding important features like transaction management and exception translation. Modern Spring applications often use Spring Data JPA repositories which implement the DAO pattern with even less code.
