package calc;

public class Numbers {

	public static String calculating(String first, String operand, String second) throws ValidateException {
		String result = "Ошибка";
		int a;
		int b;
		if (type(first) == type(second)) {
			if (type(first) == "Arabic") {
				// обработка арабских чисел
				a = Integer.parseInt(first);
				b = Integer.parseInt(second);
				try {
					Numbers.ValidateNumbers(a);
					Numbers.ValidateNumbers(b);
					result = String.valueOf(Operators.operators(a, operand, b)); // считает значения
				} catch (Exception e) {
					e.printStackTrace();
				}
				return result;
			} else {
				// обработка римских чисел
				a = RomanNumbers.romanToArabic(first);
				b = RomanNumbers.romanToArabic(second);
				try {
					if (a >= b) {
						Numbers.ValidateNumbers(a);
						Numbers.ValidateNumbers(b);

						int symbol = Operators.operators(a, operand, b);
						result = RomanNumbers.arabicToRoman(symbol);
						return result;
					} else {
						throw new ValidateException("Результат меньше 0. Попробуйте еще раз");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				return result;
			}
		}
		throw new ValidateException("Ошибка");

	}

	public static void ValidateNumbers(int num) throws ValidateException {
		if (num < 1 || num > 10 || num % 1 != 0) {
			throw new ValidateException("Числа должны быть целыми, в пределах от 1 до 10");
		}
	}

	public static String type(String num) {

		try {
			Integer.parseInt(num);
			return "Arabic";
		} catch (NumberFormatException e) {

			return "Roman";
		}
	}
}
