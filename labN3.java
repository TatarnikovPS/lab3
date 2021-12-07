package com.metanit;
import java.util.regex.*;
import java.util.Scanner;
/*Task:
*Пользователь вводит с клавиатуры строчку, являющуюся паролем.
*Проверить, надежно ли составлен пароль.
*Пароль считается надежным, если он состоит из 8 или более символов.
*Символом может быть цифра,английская буква, знак подчеркивания.
*Пароль должен содержать хотя бы одну заглавную букву, одну маленькую букву и одну цифру.
*/
public class labN3 {
    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
        String pattern = "[_a-z0-9A-Z]++";
        //String underlining = "[_]";
        String small_letters = "[a-z]";
        String digits = "[0-9]";
        String capital_letters = "[A-Z]";
        System.out.println("Введите надёжный пароль:");
        String password = in.nextLine();
        in.close();

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(password);
        Pattern D = Pattern.compile(digits);
        Matcher mD = D.matcher(password);
        Pattern SL = Pattern.compile(small_letters);
        Matcher mSL = SL.matcher(password);
        Pattern CL = Pattern.compile(capital_letters);
        Matcher mCL = CL.matcher(password);
        //В задании не было указано, что обработка исключительных ситуаций должна быть циклической, так что:
        if (password.length() >= 8)
            if (m.matches() && password.substring(m.start(), m.end()).equals(password))
                if (mD.find() && mSL.find() && mCL.find())
                    System.out.println("Пароль составлен надёжно :)");
                else {
                    System.out.println("Ошибка: пароль должен содержать хотя бы одну заглавную букву, одну маленькую букву и одну цифру!");
                }
            else {
                System.out.println("Ошибка: допустимыми символами для пароля являются цифры, английских буквы и знаки подчёркивания!");
            }
        else {
            System.out.println("Ошибка: пароль должен состоять из 8 или более символов!");
        }
    }
}
