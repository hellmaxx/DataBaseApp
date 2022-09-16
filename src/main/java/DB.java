import java.sql.*;
import java.util.Calendar;
import java.util.Scanner;

public class DB {
    public static void start() {
        try {
            String url = "jdbc:mysql://localhost:3306/gibdd?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String username = "root";
            String password = "RootRoot";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                System.out.println("Connection to Store DB succesfull!");

                mainMenu(conn);
                //addOwner(conn);
                //printOwnerInfo(conn);
                //printCarsNotReg(conn);


            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }

    /*Меню программы*/
    private static void mainMenu(Connection conn) {
        System.out.println("Выберите действие\n" +
                "1. Добавление\n" +
                "2. Удаленние\n" +
                "3. Поиск\n" +
                "4. Вывод результатов\n" +
                "5. Сортировка\n" +
                "6. Обновление\n" +
                "7. Работа с таблицами");

        int choice = new Scanner(System.in).nextInt();

        switch (choice) {
            case 1:
                addMenu(conn);
                break;
            case 2:
                deleteMenu(conn);
                break;
            case 3:
                searchMenu(conn);
                break;
            case 4:
                printMenu(conn);
                break;
            case 5:
                sortMenu(conn);
                break;
            case 6:
                updateMenu(conn);
                break;
            case 7:
                tableMenu(conn);
                break;
            default:
                System.out.println("Неверный выбор");
                mainMenu(conn);
                break;
        }

    }

    private static void addMenu(Connection conn) {
        System.out.println("Выберите действие\n" +
                "1. Добавление машины\n" +
                "2. Добавление водительских прав\n" +
                "3. Добавление угнанной машины\n" +
                "4. Выдача талона технической инспекции\n" +
                "5. Регистрация машины\n" +
                "6. Добовление информации о штрафе\n" +
                "7. Добовление информации о лишении прав\n" +
                "8. Добовление информации о владельце автомобиля\n");

        int choice = new Scanner(System.in).nextInt();

        switch (choice) {
            case 1:
                addCarInfo(conn);
                break;
            case 2:
                addRights(conn);
                break;
            case 3:
                addHijackedCar(conn);
                break;
            case 4:
                addTehInsp(conn);
                break;
            case 5:
                addCarReg(conn);
                break;
            case 6:
                addFineInfo(conn);
                break;
            case 7:
                addDepRights(conn);
                break;
            case 8:
                addOwner(conn);
                break;
            default:
                System.out.println("Неверный выбор");
                addMenu(conn);
                break;
        }
    }

    private static void deleteMenu(Connection conn) {
        System.out.println("Выберите действие\n" +
                "1. Удаление машины\n" +
                "2. Удаление угнанной машины\n" +
                "3. Снятие машины с учета");

        int choice = new Scanner(System.in).nextInt();

        switch (choice) {
            case 1:
                deleteCarInfo(conn);
                break;
            case 2:
                delHijackedCar(conn);
                break;
            case 3:
                delCarReg(conn);
                break;
            default:
                System.out.println("Неверный выбор");
                deleteMenu(conn);
                break;
        }
    }

    private static void searchMenu(Connection conn) {
        System.out.println("Выберите действие\n" +
                "1. Поиск машины\n" +
                "2. Поиск постановки на учет машины\n" +
                "3. Поиск данных водителя\n" +
                "4. Поиск лишения прав по номеру протокола\n" +
                "5. Поиск информации о штрафах по номеру протокола\n");

        int choice = new Scanner(System.in).nextInt();

        switch (choice) {
            case 1:
                searchCarInfo(conn);
                break;
            case 2:
                searchTehEndDate(conn);
                break;
            case 3:
                searchDriverInfo(conn);
                break;
            case 4:

                searchDepRights(conn);
                break;
            case 5:
                searchFineInfo(conn);
                break;
            default:
                System.out.println("Неверный выбор");
                searchMenu(conn);
                break;
        }
    }

    private static void printMenu(Connection conn) {
        System.out.println("Выберите действие\n" +
                "1. Вывод информации о водительских правах\n" +
                "2. Вывод информации о угнанных машинах\n" +
                "3. Вывод информации о выданых талонах технической инспекции\n" +
                "4. Вывод информации о регистрации машины\n" +
                "5. Вызов группировки колличества машин по водителям\n" +
                "6. Вывести колличество зарегистрированных машин\n" +
                "7. Вывести информацию о списке изъятых прав\n" +
                "8. Вывести информацию о штрафах\n"+
                "9. Вывести информацию владельцах\n"+
                "10. Вывести информацию о незарегистрированных автомобилях\n");

        int choice = new Scanner(System.in).nextInt();

        switch (choice) {
            case 1:
                printRights(conn);
                break;
            case 2:
                printHijCar(conn);
                break;
            case 3:
                printTehInsp(conn);
                break;
            case 4:
                printRegCar(conn);
                break;
            case 5:
                groupCars(conn);
                break;
            case 6:
                countCars(conn);
                break;
            case 7:
                printDepRights(conn);
                break;
            case 8:
                printFines(conn);
                break;
            case 9:
                printOwnerInfo(conn);
                break;
            case 10:
                printCarsNotReg(conn);
                break;
//printOwnerInfo(conn);
            //printCarsNotReg(conn);
            default:
                System.out.println("Неверный выбор");
                printMenu(conn);
                break;
        }
    }

    private static void sortMenu(Connection conn) {
        sortCarInfo(conn);
    }

    private static void updateMenu(Connection conn) {
        updateCarInfo(conn);
    }

    private static void tableMenu(Connection conn) {
        System.out.println("Выберите действие\n" +
                "1. Создание таблицы\n" +
                "2. Удаление таблицы");

        int choice = new Scanner(System.in).nextInt();

        switch (choice) {
            case 1:
                createNewTestTable(conn);
                break;
            case 2:
                dropNewTestTable(conn);
                break;
            default:
                System.out.println("Неверный выбор");
                tableMenu(conn);
                break;
        }
    }

    private static void addCarInfo(Connection conn) {

        try {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO car_info (Model, Year_realise, Color) values(?,?,?)");
            System.out.println("Меню добавления машины в справочник. Введите модель автомобиля, год выпуска, цвет");
            Scanner scanner = new Scanner(System.in);
            preparedStatement.setString(1, scanner.nextLine());
            preparedStatement.setString(2, scanner.nextLine());
            preparedStatement.setString(3, scanner.nextLine());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private static void addFineInfo(Connection conn) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO `fines` (`VIN`,`Owner`,`fine_text`, `data`) VALUES ( ?, ?,?,?)");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Меню добавления штрафа в справочник. VIN, Владельца, Информацию о правонарушении, и дату");
            preparedStatement.setString(1, scanner.nextLine());
            preparedStatement.setString(2, scanner.nextLine());
            preparedStatement.setString(3, scanner.nextLine());
            preparedStatement.setString(4, scanner.nextLine());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void addDepRights(Connection conn) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO `rigts_dep` (`right_id`,`owner_id`,`data_start`, `data_end`)  VALUES (?, ?,?,?)");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Изъятие прав. Введите номер прав, владельца и даты начала и конца штрафных санкций");
            preparedStatement.setString(1, scanner.nextLine());
            preparedStatement.setString(2, scanner.nextLine());
            preparedStatement.setString(3, scanner.nextLine());
            preparedStatement.setString(4, scanner.nextLine());


            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void addRights(Connection conn) {

        try {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO rights_give (owner, data_start, data_end, category) values(?,?,?,?)");
            System.out.println("Меню выдачи прав. Для выдачи прав введите ID, дату выдачи, дату смены и категорию");
            Scanner scanner = new Scanner(System.in);
            preparedStatement.setInt(1, scanner.nextInt());
            preparedStatement.setDate(2, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            preparedStatement.setDate(3, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            preparedStatement.setInt(4, scanner.nextInt());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private static void addOwner(Connection conn) {

        try {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO owner_info(initials,phone_number,date_born,address) values(?,?,?,?)");
            System.out.println("Меню добавления владельца. Для добавления владельца введите ФИО водителя, номер телефона, дату рождения и адрес");
            Scanner scanner = new Scanner(System.in);
            preparedStatement.setString(1, scanner.nextLine());
            preparedStatement.setString(2, scanner.nextLine());
            preparedStatement.setDate(3, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            preparedStatement.setString(4, scanner.nextLine());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private static void deleteCarInfo(Connection conn) {

        try {
            Statement statement = conn.createStatement();
            System.out.println("Для удаления VIN автомобиля");
            String vin_id = new Scanner(System.in).nextLine().trim();
            statement.executeUpdate("DELETE FROM car_info WHERE VIN_ID=" + vin_id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void updateCarInfo(Connection conn) {

        try {
            Statement statement = conn.createStatement();
            System.out.println("Для обновления информации о цвете машины введите цвет и VIN автомобиля");
            String color = new Scanner(System.in).nextLine().trim();
            String vin_id = new Scanner(System.in).nextLine().trim();
            statement.executeUpdate("UPDATE car_info SET Color=" + "'" + color + "'" + " WHERE VIN_ID= " + vin_id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void searchCarInfo(Connection conn) {

        try {
            Statement statement = conn.createStatement();
            System.out.println("Для поиска автомобиля ввидете его VIN");
            String vin_id = new Scanner(System.in).nextLine().trim();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM car_info WHERE VIN_ID=" + vin_id);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) +
                        " " + resultSet.getInt(3) + " " + resultSet.getString(4));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void searchFineInfo(Connection conn) {

        try {
            Statement statement = conn.createStatement();
            System.out.println("Для поиска штрафа введите номер протокола");
            String fine_id = new Scanner(System.in).nextLine().trim();

            ResultSet resultSet = statement.executeQuery("SELECT f.id_fines, f.VIN, o.initials, f.fine_text, f.data FROM fines AS f LEFT JOIN owner_info AS o ON (o.id_owner = f.Owner) WHERE id_fines=" + fine_id);

            //SELECT f.id_fines, f.VIN, o.initials, f.fine_text, f.data FROM fines AS f LEFT JOIN owner_info AS
            // o ON (o.id_owner = f.Owner) WHERE id_fines=2
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) +
                        " " + resultSet.getString(3) + " " + resultSet.getString(4) +
                        " " + resultSet.getString(5));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private static void searchDepRights(Connection conn) {
        try {
            Statement statement = conn.createStatement();
            System.out.println("Для поиска изъятых прав введите номер протокола");
            String dep_id = new Scanner(System.in).nextLine().trim();

            ResultSet resultSet = statement.executeQuery("SELECT r.id_dep, r.right_id, o.initials, r.data_start, r.data_end FROM rigts_dep AS r  LEFT JOIN owner_info AS o ON (o.id_owner = r.owner_id) WHERE id_dep=" + dep_id);

            //SELECT f.id_fines, f.VIN, o.initials, f.fine_text, f.data FROM fines AS f LEFT JOIN owner_info AS
            // o ON (o.id_owner = f.Owner) WHERE id_fines=2
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) +
                        " " + resultSet.getString(3) + " " + resultSet.getString(4) +
                        " " + resultSet.getString(5));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void printFines(Connection conn) {
        //SELECT f.id_fines, f.VIN, o.initials, f.fine_text, f.data FROM fines AS f LEFT JOIN owner_info AS o ON (o.id_owner = f.Owner)
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT f.id_fines, f.VIN, o.initials, f.fine_text, f.data FROM fines AS f LEFT JOIN owner_info AS o ON (o.id_owner = f.Owner)");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) +
                        " " + resultSet.getString(3) + " " + resultSet.getString(4) +
                        " " + resultSet.getString(5));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //SELECT * FROM gibdd.owner_info;
    private static void printOwnerInfo(Connection conn) {
        //SELECT f.id_fines, f.VIN, o.initials, f.fine_text, f.data FROM fines AS f LEFT JOIN owner_info AS o ON (o.id_owner = f.Owner)
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM gibdd.owner_info;");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) +
                        " " + resultSet.getString(3) + " " + resultSet.getString(4) +
                        " " + resultSet.getString(5));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void printCarsNotReg(Connection conn) {
        //SELECT f.id_fines, f.VIN, o.initials, f.fine_text, f.data FROM fines AS f LEFT JOIN owner_info AS o ON (o.id_owner = f.Owner)
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM gibdd.car_info;");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) +
                        " " + resultSet.getInt(3) + " " + resultSet.getString(4));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    private static void printDepRights(Connection conn) {
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT r.id_dep, r.right_id, o.initials, r.data_start, r.data_end FROM rigts_dep AS r LEFT JOIN owner_info AS o ON (o.id_owner = r.owner_id)");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) +
                        " " + resultSet.getString(3) + " " + resultSet.getString(4) +
                        " " + resultSet.getString(5));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void sortCarInfo(Connection conn) {

        try {
            Statement statement = conn.createStatement();
            System.out.println("Сортировка машин по году выпуска");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM car_info ORDER BY Year_realise ASC");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) +
                        " " + resultSet.getString(3) + " " + resultSet.getString(4) );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void searchDriverInfo(Connection conn) {

        try {
            Statement statement = conn.createStatement();
            System.out.println("Для поиска водителя по номеру прав введите номер прав");
            int id = new Scanner(System.in).nextInt();

            ResultSet resultSet = statement.executeQuery("SELECT initials FROM owner_info WHERE id_owner = (SELECT owner FROM rights_give WHERE rights_id =  " + id + ")");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //метод добавления машины в угон
    private static void addHijackedCar(Connection conn) {
        try {
            System.out.println("Для постановки машины в угон введите её VIN и дату угона");
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO hijacked_car ( VIN, Date_hij) values(?,?)");
            Scanner scanner = new Scanner(System.in);
            preparedStatement.setString(1, scanner.nextLine());
            preparedStatement.setString(2, scanner.nextLine());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private static void delHijackedCar(Connection conn) {
        try {
            Statement statement = conn.createStatement();


            System.out.println("Для снятия машины с угона введите её VIN");
            String vin_id = new Scanner(System.in).nextLine().trim();

            statement.executeUpdate("DELETE FROM hijacked_car WHERE VIN=" + vin_id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Сложный запрос получения списка угннанных машин с сортировкой по VIN
     *
     * @param conn
     */
    private static void printHijCar(Connection conn) {
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT h.VIN, c.Model, h.Date_hij FROM hijacked_car AS h LEFT JOIN car_info AS c ON (c.VIN_ID = h.VIN) ORDER BY h.VIN");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) +
                        " " + resultSet.getString(3));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    /**
     * Сложный запрос вывода прав из нескольких таблиц
     *
     * @param conn
     */
    private static void printRights(Connection conn) {
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT r.rights_id, o.initials, r.data_start, r.data_end, c.category FROM rights_give AS r LEFT JOIN owner_info AS o ON (o.id_owner = r.owner) LEFT JOIN categorys AS c ON (c.categorys_id = r.category)");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) +
                        " " + resultSet.getString(3) + " " + resultSet.getString(4) +
                        " " + resultSet.getString(5));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void addTehInsp(Connection conn) {

        try {
            System.out.println("Для введения машины в таблицу технического осмотра ведите ее VIN, и даты начала и конца действия технического осмотра");
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO technical_inspection (VIN, Date_start, Date_end) values(?,?,?)");
            Scanner scanner = new Scanner(System.in);
            preparedStatement.setInt(1, scanner.nextInt());
            preparedStatement.setDate(2, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            preparedStatement.setDate(3, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //   private static void deleteTehInsp(Connection conn){

//        try {
//            String vin_id = new Scanner(System.in).nextLine().trim();
//            statement.executeUpdate("DELETE FROM technical_inspection WHERE VIN=" + vin_id);
//       } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }

    private static void searchTehEndDate(Connection conn) {
        try {
            Statement statement = conn.createStatement();
            System.out.println("Для поиска даты окончания технического осмотра введите VIN автомобиля");
            int id = new Scanner(System.in).nextInt();

            ResultSet resultSet = statement.executeQuery("SELECT Date_end FROM technical_inspection WHERE VIN = " + id);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void printTehInsp(Connection conn) {
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT t.technical_inspection_id, t.VIN, c.Model, t.Date_start, t.Date_end FROM technical_inspection AS t LEFT JOIN car_info AS c ON (c.VIN_ID = t.VIN)");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) +
                        " " + resultSet.getString(3) + " " + resultSet.getString(4) +
                        " " + resultSet.getString(5));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void printRegCar(Connection conn) {
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT r.reg_car_id, c.Model, o.initials, r.Date_start, r.gos_number FROM registered_ca AS r LEFT JOIN owner_info AS o ON (r.owner = o.id_owner) LEFT JOIN car_info AS c ON (r.VIN = c.VIN_ID)");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) +
                        " " + resultSet.getString(3) + " " + resultSet.getString(4));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void addCarReg(Connection conn) {

        try {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO registered_ca (VIN, Owner, Date_start, gos_number) values(?,?,?,?)");
            System.out.println("Постановка машины на учет. Для постановки автомобиля на учет введите VIN, владельца и дату постановки на учет");
            Scanner scanner = new Scanner(System.in);
            preparedStatement.setString(1, scanner.nextLine());
            preparedStatement.setString(2, scanner.nextLine());
            preparedStatement.setDate(3, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            preparedStatement.setString(4, scanner.nextLine());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void delCarReg(Connection conn) {
        try {
            Statement statement = conn.createStatement();
            System.out.println("Для снятия автомобиля с учета введите его VIN");
            String vin_id = new Scanner(System.in).nextLine().trim();
            statement.executeUpdate("DELETE FROM registered_ca WHERE VIN=" + vin_id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void createNewTestTable(Connection conn) {
        try {
            Statement statement = conn.createStatement();
            System.out.println("Демонстрация метода CREATE. Создание таблицы");
            statement.executeUpdate("CREATE TABLE `test_table` (\n" +
                    "  `testID` int unsigned NOT NULL AUTO_INCREMENT,\n" +
                    "  `testText` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,\n" +
                    "  PRIMARY KEY (`testID`)\n" +
                    ") ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci");

            System.out.println("create");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void dropNewTestTable(Connection conn) {
        try {
            Statement statement = conn.createStatement();
            System.out.println("Удаление тестовой таблицы");
            statement.executeUpdate("DROP TABLE test_table");
            System.out.println("delete");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void groupCars(Connection conn) {
        try {
            Statement statement = conn.createStatement();
            System.out.println("Группировка колличества автомобилей по водителям");
            ResultSet resultSet = statement.executeQuery("SELECT o.initials, COUNT(r.VIN) AS car_count FROM registered_ca AS r LEFT JOIN owner_info AS o ON (r.owner = o.id_owner) GROUP BY VIN");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getInt(2));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    private static void countCars(Connection conn) {
        try {
            Statement statement = conn.createStatement();
            System.out.println("Колличество зарегистрированных автомобилей: ");
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM car_info");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
