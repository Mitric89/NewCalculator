package calc;

public class Numbers {

	public static String calculating(String first, String operand, String second) throws ValidateException {
		String result = "������";
		int a;
		int b;
		if (type(first) == type(second)) {
			if (type(first) == "Arabic") {
				// ��������� �������� �����
				a = Integer.parseInt(first);
				b = Integer.parseInt(second);
				try {
					Numbers.ValidateNumbers(a);
					Numbers.ValidateNumbers(b);
					result = String.valueOf(Operators.operators(a, operand, b)); // ������� ��������
				} catch (Exception e) {
					e.printStackTrace();
				}
				return result;
			} else {
				// ��������� ������� �����
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
						throw new ValidateException("��������� ������ 0. ���������� ��� ���");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				return result;
			}
		}
		throw new ValidateException("������");

	}

	public static void ValidateNumbers(int num) throws ValidateException {
		if (num < 1 || num > 10 || num % 1 != 0) {
			throw new ValidateException("����� ������ ���� ������, � �������� �� 1 �� 10");
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
