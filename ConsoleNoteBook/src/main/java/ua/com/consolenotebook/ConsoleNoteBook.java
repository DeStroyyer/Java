package ua.com.consolenotebook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by TAI on 06.02.14.
 */
public class ConsoleNoteBook {
    public void consoleNoteBook() {
        System.out.println("Внесение нового контакта - нажмите 1, Вывод на экран всех ранее внесенных контактов - " +
                "нажмите 2, Поиск контакта по имени - нажмите 3,  Удаление контакта - нажмите 4.");
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader bis = new BufferedReader(is);
        String menuInput;
        int menuItem = 0;
        try {
            menuInput = bis.readLine();
            menuItem = Integer.parseInt(menuInput);
        } catch (NumberFormatException n) {
            System.out.print("Вы ввели неправильный пункт меню. Попробуйте еще раз.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (menuItem) {
            case 1:
                InputStreamReader isName = new InputStreamReader(System.in);
                BufferedReader bisName = new BufferedReader(isName);
                String UserName = null;
                System.out.println("Введите имя");
                try {
                    UserName = bisName.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                InputStreamReader isPhone = new InputStreamReader(System.in);
                BufferedReader bisPhone = new BufferedReader(isPhone);
                String UserPhone = null;
                System.out.println("Введите телефон");
                try {
                    UserPhone = bisPhone.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                AddContact add = new AddContact();
                add.abstractCommand(UserName, UserPhone);
                break;
            case 2:
                ShowContacts show = new ShowContacts();
                show.abstractCommand();
                break;
            case 3:
                System.out.println("Введите имя контакта");
                InputStreamReader isFind = new InputStreamReader(System.in);
                BufferedReader bisFind = new BufferedReader(isFind);
                String FindPhone = null;
                try {
                    FindPhone = bisFind.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                FindContacts find = new FindContacts();
                find.abstractCommand(FindPhone);
                break;
            case 4:
                System.out.println("Введите имя контакта");
                InputStreamReader isDelete = new InputStreamReader(System.in);
                BufferedReader bisDelete = new BufferedReader(isDelete);
                String DeleteContact = null;
                try {
                    DeleteContact = bisDelete.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                DeleteContact del = new DeleteContact();
                del.abstractCommand(DeleteContact);
                break;
        }
    }
}
