# Session 8: Quiz Questions & Concept Questions Solutions

---

## Part 1: Quiz Questions (Multiple-Choice Solutions)

### Question 1
**Scenario:** A ticketing system processes tickets for any event type (`Concert`, `Play`, `SportsMatch`) through a common `TicketProcessor`.
- **Correct Option:** `C Polymorphism`
- **Explanation:** Polymorphism allows `TicketProcessor` to execute event-specific ticketing operations dynamically through a common interface or abstract superclass reference without needing conditional logic for each event type.

### Question 2
**Scenario:** `UserProfile` makes `dateOfBirth` private and requires updates to go through `updateProfileInfo` with validation logic.
- **Correct Option:** `C Encapsulation`
- **Explanation:** Encapsulation hides the internal state of an object and enforces access and mutation through public methods that perform validation, maintaining object invariant integrity.

### Question 3
**Scenario:** An `Author` can write 1 or more `Book`s (`1..*`), but a `Book` has 1 `Author`. If an author is removed, their books still exist.
- **Correct Option:** `C Author 1 --- 1..* Book`
- **Explanation:** The multiplicity from `Author` to `Book` is 1 to `1..*` (one author to one or more books). The independent lifecycle points to an aggregation relationship.

### Question 4
**Scenario:** `ShoppingCart` manages a collection of `CartItem` objects. If `ShoppingCart` is deleted, all `CartItem` objects are destroyed.
- **Correct Option:** `D Composition`
- **Explanation:** Composition represents a strong "has-a" relationship with shared lifecycle dependency where child objects cannot exist without the parent.

### Question 5
**Scenario:** `ProgrammingCourse` and `DesignCourse` extend general `Course` ('is-a' relationship).
- **Correct Option:** `D Generalization`
- **Explanation:** In UML modeling, inheritance ('is-a' relationship) between a subclass and a superclass is represented as Generalization.

### Question 6
**Scenario:** `PdfDocument` implements the `Printable` contract defining `print()`.
- **Correct Option:** `C Realization`
- **Explanation:** Realization represents a class implementing the contract specified by an interface.

### Question 7
**Scenario:** `Customer` places an `Order`. Both can exist independently without strong ownership or shared lifecycle.
- **Correct Option:** `B Association`
- **Explanation:** A standard binary relationship between two independent objects linked by transactional interactions is modeled as an Association.

### Question 8
**Scenario:** Modeling valid state transitions for a `Task` (Pending -> InProgress -> Completed/Blocked).
- **Correct Option:** `C State diagram`
- **Explanation:** State machine/state diagrams explicitly visualize states, transitions, guard conditions, and events governing an object's lifecycle.

### Question 9
**Scenario:** Reporting module interacts with a generic `ReportGenerator` interface defining `generate()`.
- **Correct Option:** `B Abstraction`
- **Explanation:** Abstraction hides complex underlying creation details behind a simplified uniform interface contract.

### Question 10
**Scenario:** Visualizing the chronological sequence of message exchanges between `User`, `AuthenticationService`, and `UserRepository` during login.
- **Correct Option:** `C Sequence diagram`
- **Explanation:** Sequence diagrams illustrate object interactions arranged in time sequence.

---

## Part 2: Concept Questions

### Question 1: Encapsulation in User Object Design
- **State Control:** The `email` field is declared `private` within `User`.
- **Why Unrestricted Access Leads to Invalid States:** Direct public field access allows external code to set invalid, malformed, or blank strings (e.g. `user.email = "invalid-email"` or `null`), bypassing data validation and causing runtime bugs or database constraint failures.
- **How Controlled Access Helps:** Providing a controlled `changeEmail(String newEmail)` method allows embedding validation checks (e.g. regex format validation, null checks, and uniqueness checks). If valid, the state is updated; otherwise, an exception or error is raised, ensuring the `User` object remains in a valid state.

### Question 2: Inheritance vs Composition in ReportingService
- **Inheritance Rigidity:** Forcing optional capabilities (`DataExport`, `DataVisualization`) into an inheritance hierarchy leads to class explosion (e.g. `VisualizedExportableReport`, `VisualizedOnlyReport`, `ExportableOnlyReport`). Because Java supports single inheritance, adding new orthogonal capabilities makes subclasses rigid, duplicated, and fragile.
- **Composition Advantage:** Composition delegates export and visualization responsibilities to separate interface strategy objects (`DataExporter`, `DataVisualizer`). A `Report` object holds references to these interfaces and delegates tasks at runtime. New export formats or chart visualizers can be added without modifying the report class hierarchy.

### Question 3: Abstraction & Polymorphism in NotificationService
- **Mechanism:** An abstraction (`NotificationChannel` interface or abstract class) declares a `send(User user, String message)` method. Concrete classes (`EmailNotification`, `SMSNotification`, `PushNotification`) implement/override this method with channel-specific delivery logic.
- **Polymorphism:** `NotificationService` holds a collection of `NotificationChannel` references and calls `.send(...)` uniformly. At runtime, Java invokes the appropriate overridden method based on the concrete instance.
- **Extensibility (Open-Closed Principle):** Adding a new channel like `InAppNotification` requires creating a new class implementing `NotificationChannel`. `NotificationService` requires zero code modifications.

### Question 4: Composition vs Aggregation in Organization, Department, and Employee
- **Organization and Department (Composition):** A `Department` is a structural part of an `Organization`. If the `Organization` is dissolved, its `Department`s cease to exist as organizational entities. This strong lifecycle dependency is modeled as **Composition**.
- **Department and Employee (Aggregation):** An `Employee` is associated with a `Department` but maintains an independent lifecycle. If a `Department` is dissolved, `Employee`s continue to exist in the system and can be reassigned. This loose relationship is modeled as **Aggregation**.

### Question 5: Student-Course Multiplicity vs Business Rules
- **UML Multiplicity:** The relationship between `Student` and `Course` is Many-to-Many (`*` to `*` or `0..*` to `0..*`). A student can enroll in multiple courses, and a course can have multiple students.
- **Business Rule vs Multiplicity:** Multiplicity only specifies structural bounds on associations. It does not prevent duplicate enrollments (e.g. enrolling Student A in Math 101 twice). Preventing duplicate enrollment is a domain business rule enforced logically via a `Set` collection in code, unique composite keys in a database join table (`student_id`, `course_id`), or validation logic in an `EnrollmentService`.
