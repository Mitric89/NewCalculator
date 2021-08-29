package calc;

public class Operators {

	public static int operators(int a, String operand, int b) throws Exception {
		int result;

		switch (operand) {
		case "+":
			result = a + b;
			break;
		case "-":
			result = a - b;
			break;
		case "*":
			result = a * b;
			break;
		case "/":
			result = a / b;
			break;
		default:
			throw new Exception("Неправильно введен символ операции, используйте только +, -, *, /");
		}
		return result;

	}
}
