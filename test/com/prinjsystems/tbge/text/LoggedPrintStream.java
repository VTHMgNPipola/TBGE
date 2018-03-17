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

/**
 * Redirects all the outputs from any PrintStream to a StringBuilder.
 */
public class LoggedPrintStream extends PrintStream {

	private final StringBuilder buf;
	private final PrintStream underlying;

	LoggedPrintStream(StringBuilder sb, OutputStream os, PrintStream ul) {
		super(os);
		this.buf = sb;
		this.underlying = ul;
	}

	/**
	 * Creates a new instance of {@code LoggedPrintStream}, with all it's
	 * components being already defined.
	 * @param toLog PrintStream to be redirected.
	 * @return The new LoggedPrintStream instance.
	 */
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
		} catch(NoSuchFieldException | IllegalArgumentException | IllegalAccessException shouldNotHappen) {}
		return null;
	}

	@Override
	public String toString() {
		return buf.toString();
	}
	
	/**
	 * Removes all text from internal buffer.
	 */
	public void clear() {
		buf.setLength(0);
	}
}
