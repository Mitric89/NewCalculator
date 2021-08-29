package calc;

public class RomanNumbers {

	public static int romanToArabic(String symbol) {
		int sum = 0, i;
		char romans[] = symbol.toCharArray();
		for (i = 0; i < romans.length; i++) {
			if (romans[i] == 'I')
				sum += 1;
			if (romans[i] == 'V') {
				if (i != 0 && romans[i - 1] == 'I')
					sum += 4 - 1; // и вычесть последнее накопленное сложение
				else
					sum += 5;
			}
			if (romans[i] == 'X') {
				if (i != 0 && romans[i - 1] == 'I')
					sum += 9 - 1;
				else
					sum += 10;
			}
			if (romans[i] == 'L') {
				if (i != 0 && romans[i - 1] == 'X')
					sum += 40 - 10;
				else
					sum += 50;
			}
			if (romans[i] == 'C') {
				if (i != 0 && romans[i - 1] == 'X')
					sum += 90 - 10;
				else
					sum += 100;
			}
			if (romans[i] == 'D') {
				if (i != 0 && romans[i - 1] == 'C')
					sum += 400 - 100;
				else
					sum += 500;
			}
			if (romans[i] == 'M') {
				if (i != 0 && romans[i - 1] == 'C')
					sum += 900 - 100;
				else
					sum += 1000;
			}
		}
		return sum;
	}

	public static String arabicToRoman(int symbol) {
		if (symbol < 1 || symbol > 3999)
			return "Неверное римское число";
		String s = "";
		while (symbol >= 1000) {
			s += "M";
			symbol -= 1000;
		}
		while (symbol >= 900) {
			s += "CM";
			symbol -= 900;
		}
		while (symbol >= 500) {
			s += "D";
			symbol -= 500;
		}
		while (symbol >= 400) {
			s += "CD";
			symbol -= 400;
		}
		while (symbol >= 100) {
			s += "C";
			symbol -= 100;
		}
		while (symbol >= 90) {
			s += "XC";
			symbol -= 90;
		}
		while (symbol >= 50) {
			s += "L";
			symbol -= 50;
		}
		while (symbol >= 40) {
			s += "XL";
			symbol -= 40;
		}
		while (symbol >= 10) {
			s += "X";
			symbol -= 10;
		}
		while (symbol >= 9) {
			s += "IX";
			symbol -= 9;
		}
		while (symbol >= 5) {
			s += "V";
			symbol -= 5;
		}
		while (symbol >= 4) {
			s += "IV";
			symbol -= 4;
		}
		while (symbol >= 1) {
			s += "I";
			symbol -= 1;
		}
		return s;
	}

}
