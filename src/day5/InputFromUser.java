package day5;

import java.util.Scanner;

class InputFromUser implements Input {
    @Override
    public Integer invoke() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please insert a number");
        return scanner.nextInt();
    }
}
