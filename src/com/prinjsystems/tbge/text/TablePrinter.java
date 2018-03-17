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

import java.util.ArrayList;
import java.util.List;

/**
 * Formats an array of data to an table.
 */
public class TablePrinter {
	/**
	 * Creates a table with the data.
	 * @param columnNames Names of all columns. Must have size equals or greater to all data lines.
	 * @param data List of arrays, containing data. Each array at the list is a line.
	 * @param allignRight IF true, all the values will appear at cell right, and not left.
	 * @return String containing the created table.
	 */
	public static String createTable(Object[] columnNames, List<Object[]> data, boolean allignRight) {
		if(data == null || columnNames == null || data.isEmpty() || columnNames.length == 0) {
			throw new IllegalStateException("Data and column name arrays cannot be empty!");
		}
		
		StringBuilder table = new StringBuilder();
		List<Integer> sizes = new ArrayList<>();
		String header = null;
		
		table.append("+");
		for(int i = 0; i < columnNames.length; i++) {
			String cn = columnNames[i].toString();
			int maxSize = cn.length();
			
			for(Object[] line : data) {
				if(line[i].toString().length() > maxSize) {
					maxSize = line[i].toString().length();
				}
			}
			
			sizes.add(maxSize);
			table.append("--");
			for(int j = 0; j < maxSize; j++) {
				table.append("-");
			}
			table.append("+");
		}
		table.append("\n");
		header = table.toString(); // The current state of table is just the header
		String  allignFormat = "| %";
		String left = allignRight ? "" : "-";
		for(Integer i : sizes) {
			allignFormat += left + i + "s | %";
		}
		allignFormat = allignFormat.substring(0, allignFormat.length() - 2) + "%n"; // To remove the ' %' created on last iteration
		table.append(String.format(allignFormat, columnNames));
		table.append(header); // To separate the table header from data.
		
		for(Object[] line : data) {
			table.append(String.format(allignFormat, line));
		}
		
		table.append(header); // After all table creation, will add the bottom of the table
		
		return table.toString();
	}
	
	/**
	 * Creates a table and prints it on screen using println method of TerminalPrinter.
	 * @param columnNames Names of all table columns.
	 * @param data List of arrays, containing data. Each array at the list is a line. 
	 * @param allignRight IF true, all the values will appear at cell right, and not left.
	 * @param tp {@code TerminalPrinter} instance where the table should be output.
	 */
	public static void printTable(Object[] columnNames, List<Object[]> data, boolean allignRight, TerminalPrinter tp) {
		tp.print(createTable(columnNames, data, allignRight)); // createTable method already places a '\n' character. No need for 'println'
	}
}
