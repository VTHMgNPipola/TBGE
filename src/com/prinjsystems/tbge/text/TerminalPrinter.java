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

/**
 * Prints text on System.out as fast as it can, using BufferedOutputStream.
 * If you want to use GUI with a JTextArea or JTextPane as output, define a PrintStream to
 * System.out before creating a {@code TerminalPrinter} instance.
 */
public interface TerminalPrinter {
	/*
	 *
	 * PRINT START
	 *
	 */
	
	/**
	 * Prints a string on screen.
	 * @param text Text to print.
	 */
	public void print(String text);
	
	/**
	 * Prints a int on screen.
	 * @param i Integer to print.
	 */
	public void print(int i);
	
	/**
	 * Prints a long on screen.
	 * @param l Long to print.
	 */
	public void print(long l);
	
	/**
	 * Prints a float on screen.
	 * @param f Float to print.
	 */
	public void print(float f);
	
	/**
	 * Prints a double on screen.
	 * @param d Double to print.
	 */
	public void print(double d);
	
	/**
	 * Prints a boolean on screen.
	 * @param b Boolean to print.
	 */
	public void print(boolean b);
	
	/**
	 * Prints a char on screen.
	 * @param c Character to print.
	 */
	public void print(char c);
	
	/*
	 *
	 * PRINTLN START
	 *
	 */
	
	/**
	 * Prints a string on screen and goes to new line.
	 * @param text 
	 */
	public void println(String text);
	
	/**
	 * Prints a int on screen and goes to new line.
	 * @param i Integer to print.
	 */
	public void println(int i);
	
	/**
	 * Prints a long on screen and goes to new line.
	 * @param l Long to print.
	 */
	public void println(long l);
	
	/**
	 * Prints a float on screen and goes to new line.
	 * @param f Float to print.
	 */
	public void println(float f);
	
	/**
	 * Prints a double on screen and goes to new line.
	 * @param d Double to print.
	 */
	public void println(double d);
	
	/**
	 * Prints a boolean on screen and goes to new line.
	 * @param b Boolean to print.
	 */
	public void println(boolean b);
	
	/**
	 * Prints a char on screen and goes to new line.
	 * @param c Character to print.
	 */
	public void println(char c);
}
