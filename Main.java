import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        System.out.println(ReverseConverter("1 1 + 1 + 1 +"));
        System.out.println(ReverseConverter("1 2 * 3 +"));
        System.out.println(ReverseConverter("5 9 2 * +"));
        System.out.println(ReverseConverter("1 2 * 3 4 * +"));
    }

    private static String ReverseConverter(String input) {

        Stack<Double> stack = new Stack<>(); /* Double for .0 numbers exp */
        String[] inputArr = input.split("\\s+"); /* string split '' and circle */

        for (String inputChar : inputArr) {

            switch (inputChar) { /* type switch */
                case "+":
                    stack.push(stack.pop() + stack.pop()); /* push method */
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    double divisor = stack.pop();
                    stack.push(stack.pop() / divisor);
                    break;
                default:
                    stack.push(Double.parseDouble(inputChar));
                    break;
            }
        }
        return String.valueOf(stack.pop().intValue());
    }
}

