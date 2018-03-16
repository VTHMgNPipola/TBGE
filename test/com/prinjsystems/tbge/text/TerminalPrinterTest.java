/*
 * Copyright (C) 2018 PrinJ Systems
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.prinjsystems.tbge.text;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Make tests on class {@code TerminalPrinter}.
 */
public class TerminalPrinterTest {
	public static class LoggedPrintStream extends PrintStream {
		private final StringBuilder buf;
		private final PrintStream underlying;
		
		LoggedPrintStream(StringBuilder sb, OutputStream os, PrintStream ul) {
		super(os);
			this.buf = sb;
			this.underlying = ul;
		}
		
		public static LoggedPrintStream create(PrintStream toLog) {
			try {
				final StringBuilder sb = new StringBuilder();
				Field f = FilterOutputStream.class.getDeclaredField("out");
				f.setAccessible(true);
				OutputStream psout = (OutputStream) f.get(toLog);
				return new LoggedPrintStream(sb, new FilterOutputStream(psout) {
					@Override
					public void write(int b) throws IOException {
						super.write(b);
						sb.append((char) b);
					}
				}, toLog);
			} catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException shouldNotHappen) {}
			return null;
		}
		
		@Override
		public String toString() {
			return buf.toString();
		}
	}
	
	/**
	 * Test of print method, of class TerminalPrinter.
	 */
	@Test
	public void testPrint_String() {
		System.out.println("\nTesting print");
		LoggedPrintStream lps = LoggedPrintStream.create(System.out);
		System.setOut(lps);
		String text = "hi world";
		TerminalPrinter instance = new TerminalPrinter();
		instance.print(text);
		assertEquals(text, lps.toString());
	}

	/**
	 * Test of print method, of class TerminalPrinter.
	 */
	@Test
	public void testPrint_int() {
		System.out.println("\nTesting print");
		LoggedPrintStream lps = LoggedPrintStream.create(System.out);
		System.setOut(lps);
		int i = 27;
		TerminalPrinter instance = new TerminalPrinter();
		instance.print(i);
		assertEquals(String.valueOf(i), lps.toString());
	}

	/**
	 * Test of print method, of class TerminalPrinter.
	 */
	@Test
	public void testPrint_long() {
		System.out.println("\nTesting print");
		LoggedPrintStream lps = LoggedPrintStream.create(System.out);
		System.setOut(lps);
		long l = 4768123132L;
		TerminalPrinter instance = new TerminalPrinter();
		instance.print(l);
		assertEquals(String.valueOf(l), lps.toString());
	}

	/**
	 * Test of print method, of class TerminalPrinter.
	 */
	@Test
	public void testPrint_float() {
		System.out.println("\nTesting print");
		LoggedPrintStream lps = LoggedPrintStream.create(System.out);
		System.setOut(lps);
		float f = 32.94F;
		TerminalPrinter instance = new TerminalPrinter();
		instance.print(f);
		assertEquals(String.valueOf(f), lps.toString());
	}

	/**
	 * Test of print method, of class TerminalPrinter.
	 */
	@Test
	public void testPrint_double() {
		System.out.println("\nTesting print");
		LoggedPrintStream lps = LoggedPrintStream.create(System.out);
		System.setOut(lps);
		double d = 18.15613218562;
		TerminalPrinter instance = new TerminalPrinter();
		instance.print(d);
		assertEquals(String.valueOf(d), lps.toString());
	}

	/**
	 * Test of print method, of class TerminalPrinter.
	 */
	@Test
	public void testPrint_boolean() {
		System.out.println("\nTesting print");
		LoggedPrintStream lps = LoggedPrintStream.create(System.out);
		System.setOut(lps);
		boolean b = true;
		TerminalPrinter instance = new TerminalPrinter();
		instance.print(b);
		assertEquals(String.valueOf(b), lps.toString());
	}

	/**
	 * Test of print method, of class TerminalPrinter.
	 */
	@Test
	public void testPrint_char() {
		System.out.println("\nTesting print");
		LoggedPrintStream lps = LoggedPrintStream.create(System.out);
		System.setOut(lps);
		char c = ' ';
		TerminalPrinter instance = new TerminalPrinter();
		instance.print(c);
		assertEquals(String.valueOf(c), lps.toString());
	}

	/**
	 * Test of println method, of class TerminalPrinter.
	 */
	@Test
	public void testPrintln_String() {
		System.out.println("\nTesting println");
		LoggedPrintStream lps = LoggedPrintStream.create(System.out);
		System.setOut(lps);
		String text = "hi world";
		TerminalPrinter instance = new TerminalPrinter();
		instance.println(text);
		assertEquals(String.valueOf(text) + System.lineSeparator(), lps.toString());
	}

	/**
	 * Test of println method, of class TerminalPrinter.
	 */
	@Test
	public void testPrintln_int() {
		System.out.println("\nTesting println");
		LoggedPrintStream lps = LoggedPrintStream.create(System.out);
		System.setOut(lps);
		int i = 27;
		TerminalPrinter instance = new TerminalPrinter();
		instance.println(i);
		assertEquals(String.valueOf(i) + System.lineSeparator(), lps.toString());
	}

	/**
	 * Test of println method, of class TerminalPrinter.
	 */
	@Test
	public void testPrintln_long() {
		System.out.println("\nTesting println");
		LoggedPrintStream lps = LoggedPrintStream.create(System.out);
		System.setOut(lps);
		long l = 4768123132L;
		TerminalPrinter instance = new TerminalPrinter();
		instance.println(l);
		assertEquals(String.valueOf(l) + System.lineSeparator(), lps.toString());
	}

	/**
	 * Test of println method, of class TerminalPrinter.
	 */
	@Test
	public void testPrintln_float() {
		System.out.println("\nTesting println");
		LoggedPrintStream lps = LoggedPrintStream.create(System.out);
		System.setOut(lps);
		float f = 32.94F;
		TerminalPrinter instance = new TerminalPrinter();
		instance.println(f);
		assertEquals(String.valueOf(f) + System.lineSeparator(), lps.toString());
	}

	/**
	 * Test of println method, of class TerminalPrinter.
	 */
	@Test
	public void testPrintln_double() {
		System.out.println("\nTesting println");
		LoggedPrintStream lps = LoggedPrintStream.create(System.out);
		System.setOut(lps);
		double d = 18.15613218562;
		TerminalPrinter instance = new TerminalPrinter();
		instance.println(d);
		assertEquals(String.valueOf(d) + System.lineSeparator(), lps.toString());
	}

	/**
	 * Test of println method, of class TerminalPrinter.
	 */
	@Test
	public void testPrintln_boolean() {
		System.out.println("\nTesting println");
		LoggedPrintStream lps = LoggedPrintStream.create(System.out);
		System.setOut(lps);
		boolean b = true;
		TerminalPrinter instance = new TerminalPrinter();
		instance.println(b);
		assertEquals(String.valueOf(b) + System.lineSeparator(), lps.toString());
	}

	/**
	 * Test of println method, of class TerminalPrinter.
	 */
	@Test
	public void testPrintln_char() {
		System.out.println("\nTesting println");
		LoggedPrintStream lps = LoggedPrintStream.create(System.out);
		System.setOut(lps);
		char c = 'f';
		TerminalPrinter instance = new TerminalPrinter();
		instance.println(c);
		assertEquals(String.valueOf(c) + System.lineSeparator(), lps.toString());
	}
}
