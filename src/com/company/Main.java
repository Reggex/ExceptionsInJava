package com.company;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Введите логин: ");
        String login = scanner.nextLine();
        try {
            checkLogin(login);
        } catch (WrongLoginException e){
            System.out.println(e.getMessage());
        }
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        System.out.print("Повторите пароль: ");
        String confirmPassword = scanner.nextLine();
        try {
            checkPasswords(password,confirmPassword);
        } catch (WrongPasswordException e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * Метод проверки логина.
     * @param login - логин
     * @throws WrongLoginException - вызов исключения по ошибке ввода логина.
     */
    public static void checkLogin(String login) throws WrongLoginException{
        if(login.length() >= 20){
            throw new WrongLoginException("Ошибка! Превышена длина логина.");
        }

        CharacterIterator it = new StringCharacterIterator(login);
        while (it.current() != CharacterIterator.DONE)
        {
            if(it.current() < '0' | it.current() > '9' & it.current() < 'A' |
                    it.current() > 'Z' & it.current() < 'a' & it.current() != '_' | it.current() > 'z'){
                throw new WrongLoginException();
            }
            it.next();
        }
    }

    /**
     * Метод проверки пароля.
     * @param password - пароль
     * @param confirmPassword - повторный пароль
     * @throws WrongPasswordException - вызов исключения по ошибке ввода пароля.
     */
    public static void checkPasswords(String password, String confirmPassword) throws WrongPasswordException{

        if(!password.equals(confirmPassword)){
            throw new WrongPasswordException("Ошибка! Пароли не одинаковые.");
        }

        if(password.length() >= 20){
            throw new WrongPasswordException("Ошибка! Превышена длина логина.");
        }

        char[] character = password.toCharArray();
        for (char ch: character) {
            if(ch < '0' | ch > '9' & ch < 'A' |
                    ch > 'Z' & ch < 'a' & ch != '_' | ch > 'z'){
                throw new WrongPasswordException();
            }
        }

    }
}

/* for(int i = 65; i <= 122; i++)
        {
            System.out.println(" The ASCII value of " + (char)i + "  =  " + i);
        }
        char a = 'a';
        System.out.println('a' > 'b' | '_' == 'b' | '0' > 'b');*/
//ограничить с 0 по 9 - 48-57
//ограничить с A по Z - 65-90
//ограничить с a по z - 97 -122
// "или равно _" - 95