## **1. What is a POJO?**
- **POJO** = **Plain Old Java Object**  
- A simple Java class that **does not depend on any framework-specific** (like `javax`, Spring, Hibernate) interfaces or annotations.
- Follows standard Java conventions:
  - Has **private fields**.
  - Provides **getters & setters** (or public access methods).
  - May override `toString()`, `equals()`, `hashCode()`.
- Used for **data encapsulation**, **serialization**, and **modeling business objects**.

---

## **2. Basic POJO Example**
### **Example 1: Simple User POJO**
```java
public class User {
    // Private fields
    private String name;
    private int age;
    private String email;

    // Default constructor (required for frameworks like Jackson, Hibernate)
    public User() {}

    // Parameterized constructor
    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Optional: Override toString()
    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + ", email='" + email + "'}";
    }
}
```

### **Usage of the `User` POJO**
```java
public class Main {
    public static void main(String[] args) {
        // Create a User object
        User user = new User("Alice", 25, "alice@example.com");

        // Access fields using getters
        System.out.println(user.getName()); // Alice
        System.out.println(user.getAge()); // 25

        // Modify fields using setters
        user.setAge(26);
        System.out.println(user); // User{name='Alice', age=26, email='alice@example.com'}
    }
}
```

---

## **3. Advanced POJO Example (With `equals()` & `hashCode()`)**
For proper **comparison** (e.g., in `HashSet`, `HashMap`), we should override `equals()` and `hashCode()`.

### **Example 2: Employee POJO with `equals()` & `hashCode()`**
```java
import java.util.Objects;

public class Employee {
    private int id;
    private String name;

    // Constructors, Getters, Setters (omitted for brevity)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
```

### **Why Override `equals()` & `hashCode()`?**
- **`equals()`**: Ensures two objects are compared by **content**, not memory reference.
- **`hashCode()`**: Needed for **hash-based collections** (`HashSet`, `HashMap`).

---

## **4. POJO vs JavaBean**
| Feature        | POJO                          | JavaBean                     |
|---------------|-------------------------------|-----------------------------|
| **Definition** | Any simple Java class         | POJO with **strict conventions** |
| **Constructor** | Can have any constructor      | Must have a **no-arg constructor** |
| **Fields**     | Can be `public`/`private`     | Must be `private`            |
| **Accessors**  | Optional getters/setters      | **Must have getters/setters** |
| **Serializable** | Optional `Serializable`      | Often implements `Serializable` |

### **JavaBean Example**
```java
import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;

    // No-arg constructor (MUST for JavaBean)
    public Product() {}

    // Getters & Setters (MUST for JavaBean)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
```

---

## **5. POJO in Real-World Use Cases**
### **a) JSON Serialization (Using Jackson)**
```java
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonExample {
    public static void main(String[] args) throws Exception {
        User user = new User("Bob", 30, "bob@example.com");
        
        // Convert POJO → JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        System.out.println(json); 
        // Output: {"name":"Bob","age":30,"email":"bob@example.com"}

        // Convert JSON → POJO
        User parsedUser = mapper.readValue(json, User.class);
        System.out.println(parsedUser.getName()); // Bob
    }
}
```

### **b) Database Entity (Using Hibernate)**
```java
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity // Hibernate annotation (but still a POJO)
public class Student {
    @Id
    private Long id;
    private String name;

    // Getters, Setters, Constructors...
}
```
- Even with annotations, it’s still a **POJO** (just enhanced for Hibernate).

---

## **6. Best Practices for POJOs**
1. **Use `private` fields** (encapsulation).
2. **Provide getters/setters** (if mutable).
3. **Override `toString()`** for debugging.
4. **Override `equals()` & `hashCode()`** if used in collections.
5. **Consider immutability** (use `final` fields + no setters).
6. **Keep it simple** (avoid business logic in POJOs).

---

## **7. Immutable POJO Example**
```java
public final class ImmutableUser {
    private final String name;
    private final int age;

    public ImmutableUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // No setters (immutable)
    public String getName() { return name; }
    public int getAge() { return age; }
}
```

---

### **Summary**
- **POJO** = Simple Java class (no framework dependencies).
- Used for **data modeling**, **serialization**, **database entities**.
- Can be enhanced into **JavaBeans** (strict conventions) or **JPA/Hibernate entities**.
- Best practices: **encapsulation, immutability, proper `equals/hashCode`**.
