package org.example;


import org.apache.commons.codec.digest.DigestUtils;

public class brute implements Runnable{
//    1115dd800feaacefdf481f1f9070374a2a81e27880f187396db67958b207cbad
//    3a7bd3e2360a3d29eea436fcfb7e44c735d117c42d1c1835420b6b9942dd4f1b
//    74e1bb62f8dabb8125a58852b63bdf6eaef667cb56ac7f7cdba6d7305c50a22f
    private static String password = "3a7bd3e2360a3d29eea436fcfb7e44c735d117c42d1c1835420b6b9942dd4f1b";


    private static StringBuilder string = new StringBuilder("");
    //значения в таблице ASCI всех строчных букв
    private static int min = 97, max = 123;
    private static long start;

    public static void loop(int index) {
        for(int i = min; i < max; i++) {
            //Изменяет символ строки, заданный индексом на переданный
            string.setCharAt(index, (char) i);
            //берём следующий символ
            if(index < string.length() - 1)
                loop(index + 1);
            //перводим строку в sha-256
            System.out.println(string);
            String result = DigestUtils.sha256Hex(string.toString());


            //Сравнивае sha строку со строкой пароля
            if(result.equals(password)) {

                System.err.println("password found: " + string);
                System.err.println("It took: " + convertmillis(System.currentTimeMillis() - start));
                System.exit(0);
            }
        }
    }



    public static String convertmillis(long input) {
        int days = 0, hours = 0, minutes = 0, seconds = 0, millis = 0;

        int day = 86400000;
        int hour = 3600000;
        int minute = 60000;
        int second = 1000;


        if(input >= day) {
            days = (int) (input / day);
            millis = (int) (input % day);
        } else
            millis = (int) input;

        if(millis >= hour) {
            hours = millis / hour;
            millis = millis% hour;
        }

        if(millis >= minute) {
            minutes = millis / minute;
            millis = millis % minute;
        }

        if(millis >= second) {
            seconds = millis / second;
            millis = millis % second;
        }

        return (days  + " day(s), " + hours + "h, " + minutes + "min, " + seconds + "s and " + millis + "ms");
    }

    @Override
    public void run() {

        start = System.currentTimeMillis();
        while(true) {
            string.append((char) min);

            for(int i = 0; i < string.length() - 1; i++) {
                for(int j = min; j  < max; j++) {
                    string.setCharAt(i, (char) j);
                    loop(i + 1);
                }
            }
        }
    }
}
