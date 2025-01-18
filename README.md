# Product Management Thymeleaf

A web application for managing products, including the ability to add, edit, delete, and list products. The system supports pagination and sorting based on product price.

## Features

- **Product List**: Displays all products with their details such as ID, name, description, price, and quantity.
- **Pagination**: Allows browsing through products in different pages, reducing the load time and providing a better user experience.
- **Sorting**: Products can be sorted by price in ascending or descending order.
- **CRUD Operations**: 
  - **Create**: Add new products to the system.
  - **Read**: View products with detailed information.
  - **Update**: Edit existing product details.
  - **Delete**: Remove products from the system.
  
## Technologies Used

- **Frontend**:
  - HTML5
  - CSS3
  - Bootstrap 5
  - Thymeleaf (for dynamic rendering)
  
- **Backend**:
  - Java
  - Spring Boot
  - JDBC for database connectivity
  
- **Database**:
  - MySQL

## Installation

### Prerequisites

Before running the application, ensure you have the following installed:
- **Java**: JDK 8 or higher
- **Maven**: For building and managing the project dependencies
- **MySQL**: For database management
- **IDE**: IntelliJ IDEA, Eclipse, or any other Java IDE

### Steps

1. Clone the repository:
    ```bash
    git clone https://github.com/MissionXOR/Product-Management-Thymeleaf.git
    ```

2. Navigate to the project folder:
    ```bash
    cd Product-Management-Thymeleaf
    ```

3. Update database configuration in `application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/product_db
    spring.datasource.username=root
    spring.datasource.password=yourpassword
    ```

4. Build the project using Maven:
    ```bash
    mvn clean install
    ```

5. Run the application:
    ```bash
    mvn spring-boot:run
    ```

6. Open your browser and navigate to `http://localhost:8080`.

## Usage

1. **Homepage**: The homepage displays a list of products with options to add, edit, or delete.
2. **Add Product**: To add a new product, click the "Add product" button, fill in the product details, and save.
3. **Edit Product**: To modify an existing product, click the "Edit" button next to the product and make the necessary changes.
4. **Delete Product**: To delete a product, click the "Delete" button.


## Future Enhancements

- Add product categories for better classification.
- Implement product search functionality.
- Add user authentication (login and registration) for role-based access control.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgements

- Bootstrap 5 for the responsive design.
- Spring Boot for easy and fast development of the application.
- MySQL for the database management system.
- Thymeleaf for dynamic content rendering.

