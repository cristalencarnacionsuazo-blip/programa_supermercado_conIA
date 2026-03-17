# Java Console Login Program with MySQL

## Setup Instructions (Windows)

### 1. Install MySQL Server
- Download from https://dev.mysql.com/downloads/installer/
- Install MySQL Server 8.0+, set root password to 'password' (or edit code).
- Start MySQL service or use XAMPP/WAMP.

### 2. Create Database
```
mysql -u root -p
```
Run:
```
source sql/create_database.sql
```
Or paste the SQL from `sql/create_database.sql`.

### 3. Download JDBC Driver
- Download https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-j-9.1.0.zip
- Extract `mysql-connector-j-9.1.0.jar` to `lib/` folder (create if needed).

### 4. Compile & Run
```
cd programa_log_in
javac -cp "lib/*" src/*.java
java -cp "lib/*;src" Main
```
- Menu: 1=Register, 2=Login, 3=Exit.
- Test register 'testuser' / 'testpass', then login.

## Edit DB Config
In `src/DatabaseManager.java`: URL, USER, PASS.

## Troubleshooting
- Java JDK 8+: `javac -version`
- MySQL port 3306 open.
- Firewall allows localhost.

Enjoy!

