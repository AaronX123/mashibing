package 快排;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class no1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String str = bufferedReader.readLine();
        String[] strings = str.split(" ");
        System.out.println(Integer.parseInt(strings[0]) + Integer.parseInt(strings[1]));
    }
}
