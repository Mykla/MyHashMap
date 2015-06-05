import java.util.*;

/**
 * Пользователь вводит набор чисел в виде одной строки (“1, 2, 3, 4, 4, 5, 5
 * 5”). Избавиться от повторяющихся элементов в строке и вывести
 * результат на экран.
 * Created by user on 05.06.2015.
 */
public class CustomerInputFigures {
    public static void main(String[] args) {
        Set<Integer> list = new HashSet<>();

        Scanner scr = new Scanner(System.in);

        System.out.print("Введите набор чисел: ");
        String customerString = scr.nextLine();

        //используем класс StringTokenizer для разбития строки на слова
        StringTokenizer stk=new StringTokenizer(customerString,"[, ]"); //"[, ]" определяется в качестве разделителя

        while(stk.hasMoreTokens()){
            String symbol = stk.nextToken();
            list.add(Integer.parseInt(symbol));
        }

        System.out.println(list);

    }
}
