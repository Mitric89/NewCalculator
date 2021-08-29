package calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {

	public static void main(String[] args) throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] line = null;
		try {
			line = reader.readLine().replaceAll("\\s+", " ").split(" ");
			String a = line[0];
			String op = line[1];
			String b = line[2];
			if (line.length != 3)
				throw new Exception("Что-то пошло не так, попробуйте еще раз");
			String result = Numbers.calculating(a, op, b); 

			System.out.println(result);
 
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
