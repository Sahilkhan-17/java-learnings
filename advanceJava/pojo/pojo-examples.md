Let’s explore more advanced **POJO examples**, including:  
1. **POJO with Collections (`List`, `Map`)**  
2. **POJO with Nested Objects**  
3. **POJO as a DTO (Data Transfer Object)**  
4. **POJO with `Builder` Pattern** (for immutability)  
5. **POJO with `Record` (Java 14+)**  

---

## **1. POJO with Collections (`List`, `Map`)**
### **Example: `Student` with `List<String>` (Courses) and `Map<String, Integer>` (Grades)**
```java
import java.util.List;
import java.util.Map;

public class Student {
    private String name;
    private List<String> courses;  // List of enrolled courses
    private Map<String, Integer> grades;  // Course -> Grade mapping

    // Constructors
    public Student() {}

    public Student(String name, List<String> courses, Map<String, Integer> grades) {
        this.name = name;
        this.courses = courses;
        this.grades = grades;
    }

    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<String> getCourses() { return courses; }
    public void setCourses(List<String> courses) { this.courses = courses; }

    public Map<String, Integer> getGrades() { return grades; }
    public void setGrades(Map<String, Integer> grades) { this.grades = grades; }

    @Override
    public String toString() {
        return "Student{name='" + name + "', courses=" + courses + ", grades=" + grades + "}";
    }
}
```

### **Usage**
```java
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(
            "Alice",
            Arrays.asList("Math", "Physics"),
            Map.of("Math", 90, "Physics", 85)
        );

        System.out.println(student);
        // Output: Student{name='Alice', courses=[Math, Physics], grades={Math=90, Physics=85}}
    }
}
```

---

## **2. POJO with Nested Objects**
### **Example: `Department` and `Employee` (One-to-Many Relationship)**
```java
import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employees = new ArrayList<>();  // Nested POJO

    // Constructors, Getters, Setters
    public Department(String name) {
        this.name = name;
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    // Getters & Setters
    public String getName() { return name; }
    public List<Employee> getEmployees() { return employees; }
}

// Nested POJO
class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters & Setters
    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "'}";
    }
}
```

### **Usage**
```java
public class Main {
    public static void main(String[] args) {
        Department dept = new Department("Engineering");
        dept.addEmployee(new Employee(1, "Alice"));
        dept.addEmployee(new Employee(2, "Bob"));

        System.out.println("Department: " + dept.getName());
        dept.getEmployees().forEach(System.out::println);
    }
}
```
**Output:**  
```
Department: Engineering
Employee{id=1, name='Alice'}
Employee{id=2, name='Bob'}
```

---

## **3. POJO as a DTO (Data Transfer Object)**
### **Example: `UserDTO` for API Responses**
```java
public class UserDTO {
    private String username;
    private String email;
    private boolean isActive;

    // Constructor (often used with frameworks like Spring)
    public UserDTO(String username, String email, boolean isActive) {
        this.username = username;
        this.email = email;
        this.isActive = isActive;
    }

    // Getters (DTOs are often immutable)
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public boolean isActive() { return isActive; }
}
```

### **Usage in a REST API (Spring Boot Example)**
```java
@RestController
public class UserController {
    @GetMapping("/user/{id}")
    public UserDTO getUser(@PathVariable int id) {
        // Fetch from DB and convert to DTO
        // Currently returns hardcoded data 
        return new UserDTO("alice", "alice@example.com", true);
    }
}
```

---

## **4. Immutable POJO with `Builder` Pattern**
### **Example: `Product` with `Builder`**
```java
public final class Product {
    private final String id;
    private final String name;
    private final double price;

    // Private constructor (only Builder can create instances)
    private Product(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.price = builder.price;
    }

    // Getters (no setters = immutable)
    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    // Static Builder class
    public static class Builder {
        private String id;
        private String name;
        private double price;

        public Builder id(String id) { this.id = id; return this; }
        public Builder name(String name) { this.name = name; return this; }
        public Builder price(double price) { this.price = price; return this; }

        public Product build() {
            return new Product(this);
        }
    }
}
```

### **Usage**
```java
Product product = new Product.Builder()
    .id("P100")
    .name("Laptop")
    .price(999.99)
    .build();

System.out.println(product.getName()); // Laptop
```

---

## **5. POJO with Java `Record` (Java 14+)**
### **Example: `Person` as a `Record`**
```java
// Equivalent to a final class with private final fields + getters + equals/hashCode/toString
public record Person(String name, int age) {}

// Usage
Person person = new Person("Alice", 30);
System.out.println(person.name());  // Alice (no getXXX() needed!)
System.out.println(person.age());   // 30
```

### **Key Features of `Record`:**
- **Immutable by default** (fields are `final`).  
- **Auto-generated**: `equals()`, `hashCode()`, `toString()`, getters (`name()` instead of `getName()`).  
- **Reduces boilerplate** (ideal for DTOs).  

---

## **Summary Table: POJO Use Cases**
| **Use Case**               | **Example**                     | **Key Feature**                     |
|----------------------------|---------------------------------|-------------------------------------|
| Collections                | `Student` with `List<String>`   | Stores dynamic data (e.g., courses) |
| Nested Objects             | `Department` → `Employee`       | Models relationships                |
| DTO (API Responses)        | `UserDTO`                       | Decouples internal/external data    |
| Immutable + Builder        | `Product` with `Builder`        | Thread-safe, clean construction     |
| Java `Record`              | `Person` record                 | Minimal boilerplate                 |

---

### **When to Use Which?**
1. **Standard POJO**: General-purpose data modeling.  
2. **JavaBean**: Needed for frameworks (e.g., JPA, JSF).  
3. **DTO**: When transferring data across layers (e.g., API responses).  
4. **Builder Pattern**: For complex immutable objects.  
5. **Record**: For simple data carriers (Java 14+).  
