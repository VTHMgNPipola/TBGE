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

import java.io.BufferedOutputStream;
import java.io.IOException;

/**
 * This implementation of TerminalPrinter is created to print text as fast as possible, using BufferedOutputStream
 * as output.
 */
public class FastTerminalPrinter implements TerminalPrinter {
	private final BufferedOutputStream printer;
	
	/**
	 * Creates a default instance of FastTerminalPrinter.
	 */
	public FastTerminalPrinter() {
		printer = new BufferedOutputStream(System.out);
	}
	
	/*
	 *
	 * PRINT START
	 *
	 */
	
	@Override
	public void print(String text) {
		try {
			printer.write(text.getBytes());
			printer.flush();
		} catch (IOException ex) {
			System.err.println("Unexpected IOException occured when writing to terminal with"
					+ " high speed printer.");
			System.exit(-1);
		}
	}
	
	@Override
	public void print(int i) {
		print(String.valueOf(i));
	}
	
	@Override
	public void print(long l) {
		print(String.valueOf(l));
	}
	
	@Override
	public void print(float f) {
		print(String.valueOf(f));
	}
	
	@Override
	public void print(double d) {
		print(String.valueOf(d));
	}
	
	@Override
	public void print(boolean b) {
		print(String.valueOf(b));
	}
	
	@Override
	public void print(char c) {
		print(String.valueOf(c));
	}
	
	/*
	 *
	 * PRINTLN START
	 *
	 */
	
	@Override
	public void println() {
		print(System.lineSeparator());
	}
	
	@Override
	public void println(String text) {
		print(text + System.lineSeparator());
	}
	
	@Override
	public void println(int i) {
		print(i + System.lineSeparator());
	}
	
	@Override
	public void println(long l) {
		print(l + System.lineSeparator());
	}
	
	@Override
	public void println(float f) {
		print(f + System.lineSeparator());
	}
	
	@Override
	public void println(double d) {
		print(d + System.lineSeparator());
	}
	
	@Override
	public void println(boolean b) {
		print(b + System.lineSeparator());
	}
	
	@Override
	public void println(char c) {
		print(c + System.lineSeparator());
	}
}
