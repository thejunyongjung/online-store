# 🛒 Online Store — Java CLI Application

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=java)
![Maven](https://img.shields.io/badge/Build-Maven-blue?style=flat-square&logo=apachemaven)
![Status](https://img.shields.io/badge/Status-Complete-brightgreen?style=flat-square)

> A fully functional command-line shopping application built in Java.  
> Users can browse a product catalog, search for items, manage a shopping cart, and complete purchases with a generated receipt.

---

## 📸 Preview

```
==============================
     Welcome to the Store!
==============================
1. Display Products
2. Display Cart
3. Exit
==============================
Enter your choice:
```

---

## 📋 Table of Contents

- [About the Project](#about-the-project)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Classes](#classes)
- [How to Run](#how-to-run)
- [How to Use](#how-to-use)
- [Sample Receipt](#sample-receipt)
- [Future Improvements](#future-improvements)
- [Author](#author)

---

## 📖 About the Project

The **Online Store** is a Java-based CLI (Command Line Interface) application that simulates a real-world retail shopping experience entirely through the terminal. This project was built as part of the **Pluralsight Java Development Program (Workshop 3w)** to demonstrate core Java programming concepts including:

- Object-Oriented Programming (OOP)
- File I/O (reading CSV files, writing receipt files)
- Data structures (ArrayList)
- User input handling (Scanner)
- Clean code architecture with separation of concerns

---

## ✅ Features

### 🏠 Home Screen
- Clean and intuitive main menu
- Navigate to Products, Cart, or Exit

### 📦 Products Screen
- Loads product inventory dynamically from `products.csv`
- Displays all products in a neatly formatted table
- **Search by Name** — partial, case-insensitive search
- **Search by Price** — filter products under a maximum price
- **Search by Department** — partial, case-insensitive department filter
- Add products to cart using SKU code
- Handles invalid input gracefully

### 🛒 Cart Screen
- View all items currently in the cart
- Real-time running total that updates after every change
- Remove products from cart by SKU
- Proceed to checkout

### 💳 Checkout (Bonus Feature)
- Displays full order summary before payment
- Accepts cash payment input
- Validates that payment amount covers the total
- Calculates and displays change owed
- Prints a formatted receipt to the screen

### 🧾 Receipt File (Bonus Feature)
- Automatically saves receipt to the `Receipts/` folder
- File name is a **date-time timestamp** (e.g., `202604241148.txt`)
- Auto-creates the `Receipts/` folder if it doesn't exist
- Receipt includes: date, all line items, total, amount paid, and change

---

## 🛠 Technologies Used

| Technology | Purpose |
|------------|---------|
| Java 17 | Core programming language |
| Maven | Project build and structure |
| BufferedReader | Reading product data from CSV |
| BufferedWriter | Writing receipt files |
| Scanner | Handling user input |
| ArrayList | Storing product and cart data |
| LocalDate / LocalDateTime | Date and timestamp for receipts |
| DateTimeFormatter | Formatting timestamp for file names |
| IntelliJ IDEA | Development environment |

---

## 📁 Project Structure

```
online-store/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/pluralsight/
│       │       ├── Main.java             # Application entry point & all screens
│       │       ├── Product.java          # Product data model
│       │       └── ShoppingCart.java     # Shopping cart logic
│       └── resources/
│           └── products.csv              # Product inventory data
├── Receipts/                             # Auto-generated receipt files
│   └── 202604241148.txt                  # Example receipt
├── pom.xml                               # Maven configuration
└── README.md
```

---

## 🏗 Classes

### `Product.java`
Represents a single product in the store.

| Field | Type | Description |
|-------|------|-------------|
| `sku` | `String` | Unique product identifier |
| `name` | `String` | Product name |
| `price` | `double` | Product price |
| `department` | `String` | Product department |

Key methods:
- `toString()` — formats product for display in Products/Cart screens
- `toReceiptString()` — formats product for receipt (no department)

---

### `ShoppingCart.java`
Manages the customer's shopping cart.

| Method | Description |
|--------|-------------|
| `addProduct(Product)` | Adds a product to the cart |
| `removeProduct(Product)` | Removes a product from the cart |
| `getCart()` | Returns the list of products in the cart |
| `getTotal()` | Calculates and returns the total price |
| `clearCart()` | Empties the cart after checkout |

---

### `Main.java`
Contains the application entry point and all screen logic.

| Method | Description |
|--------|-------------|
| `main()` | Launches the app and displays Home Screen |
| `displayProducts()` | Shows product catalog and search menu |
| `displayCart()` | Shows cart contents and checkout option |
| `searchByName()` | Searches products by name |
| `searchByPrice()` | Filters products under a max price |
| `searchByDepartment()` | Filters products by department |
| `checkOut()` | Handles payment and receipt display |
| `saveReceipt()` | Saves receipt to file |
| `loadProducts()` | Reads and parses products.csv |
| `continueSearch()` | Reusable prompt to continue or exit search |

---

## ▶️ How to Run

### Prerequisites
- Java 17 or higher
- Maven
- IntelliJ IDEA (or any Java IDE)

### Steps

1. **Clone the repository:**
```bash
git clone https://github.com/thejunyongjung/online-store.git
cd online-store
```

2. **Open in IntelliJ IDEA:**
   - File → Open → Select the `online-store` folder
   - Wait for Maven to load dependencies

3. **Run the application:**
   - Navigate to `src/main/java/com/pluralsight/Main.java`
   - Click the green ▶️ Run button
   - Or run via terminal:
```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.pluralsight.Main"
```

---

## 📖 How to Use

### Step 1 — Browse Products
```
Enter your choice: 1
→ View all products with SKU, name, price, and department
```

### Step 2 — Search for a Product
```
Enter your choice: 1  (Search by Name)
Enter the product name to search: bluetooth
→ Shows all products containing "bluetooth"
```

### Step 3 — Add to Cart
```
Enter your choice: 4  (Add to Cart)
Enter the SKU of the product to add: AV1051
→ "AV1051" has been added to the cart!
```

### Step 4 — View Cart
```
Enter your choice: 2  (from Home Screen)
→ Shows all items in cart with total
```

### Step 5 — Checkout
```
Enter your choice: 1  (Check Out)
Enter payment amount: $500
→ Change: $259.89
→ Receipt printed to screen
→ Receipt saved to Receipts/202604241148.txt
```

---

## 🧾 Sample Receipt

```
===================================================
                     Receipt                       
---------------------------------------------------
                                  Date:  2026-04-24
---------------------------------------------------
PW1001   Solar Powered Battery Charger    $   19.99
AV1312   Mini 1000 Lumens Projector       $  149.95
AV1051   JBL Bluetooth Speaker            $   89.95
---------------------------------------------------
                                  Total:  $  259.89
                            Amount Paid:  $  500.00
                                 Change:  $  240.11
===================================================
```

---

## 🚀 Future Improvements

- [ ] Add user login and account management
- [ ] Track purchase history per user
- [ ] Add product quantity support in cart
- [ ] Export receipt as PDF
- [ ] Add inventory management (reduce stock after purchase)
- [ ] Build a GUI version using JavaFX

---

## 👤 Author

**Junyong Jung**

- GitHub: [@thejunyongjung](https://github.com/thejunyongjung)

---

*Built as part of the Pluralsight Java Development Program — Workshop 3w, Version 7.1Y*
