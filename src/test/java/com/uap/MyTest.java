package com.uap;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MyTest {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		System.out.println(encoder.encode("admin"));
//		LinkedList operands = new LinkedList();
//
//		String acceptedOperators = "+-*/";
//
//		try {
//
//			BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
//			String inCalcs = rdr.readLine();
//			String[] inTokens = inCalcs.split(" ");
//
//			for (String string : inTokens) {
//				// try and parse the number and add to operands.
//				try {
//					Double operand = Double.parseDouble(string);
//					operands.push(operand);
//				}
//				// not a double, try and add it to operators…
//				catch (NumberFormatException e) {
//					// if string is one character, and is an accepted operator.
//					if (string.length() == 1 && acceptedOperators.contains(string)) {
//						Double op2 = (Double) operands.pop();
//						Double op1 = (Double) operands.pop();
//
//						switch (string) {
//						case "+":
//							operands.push(op1 + op2);
//							break;
//						case "-":
//							operands.push(op1 - op2);
//							break;
//						case "*":
//							operands.push(op1 * op2);
//							break;
//						case "/":
//							operands.push(op1 / op2);
//							break;
//						default:
//							break;
//						}
//						System.out.format("%s %s %s operandQueue: %s\r\n", op1, op2, string, operands);
//					}
//				}
//				// do nothing.
//				catch (NullPointerException e) {
//				}
//			}
//
//		} catch (IOException e) {
//			System.out.println(e.toString());
//		}
	}
}
