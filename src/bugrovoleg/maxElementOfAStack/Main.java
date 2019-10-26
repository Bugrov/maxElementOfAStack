package bugrovoleg.maxElementOfAStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Write a program simulating a stack that can effectively return the current max element.
 * Your program should read a sequence of commands of different types from the standard input.
 *
 * There are three types of commands:
 *
 * push v - add an element (v) to a top of the stack;
 * pop - remove the top element of the stack;
 * max - return the current max in the stack.
 * The time complexity of these operations should not depend on the stack size (constant time, O(1)).
 *
 * Hint: you may use several standard stacks to write a solution.
 *
 * Input data format
 *
 * The first line contains the number of commands. Next lines contain one of the following commands: push v, pop, max.
 *
 * Output data format
 *
 * The program must output the current max for each command max.
 */

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCommand = sc.nextInt();
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> stackMax = new ArrayDeque<>();
        int count = 0;
        while (count <= numOfCommand) {
            int value = 0;
            String command = sc.nextLine();
            if (command.startsWith("push")) {
                value = Integer.parseInt(command.substring(command.indexOf(" ") + 1));
                command = "push";
            }
            switch (command) {
                case "push":
                    stack.offerLast(value);
                    if (stackMax.isEmpty() || value >= stackMax.peekLast()) {
                        stackMax.offerLast(value);
                    }
                    break;
                case "pop":
                    if (stack.peekLast().equals(stackMax.peekLast())) {
                        stackMax.pollLast();
                    }
                    stack.pollLast();
                    break;
                case "max":
                    System.out.println(stackMax.peekLast());
                    break;
            }
            count++;
        }
    }
}
