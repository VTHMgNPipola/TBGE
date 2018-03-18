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
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Make tests of the class TablePrinter.
 */
public class TablePrinterTest {
	/**
	 * Test of createTable method, of class TablePrinter.
	 */
	@Test
	public void testCreateTable() {
		System.out.println("\nTesting createTable");
		Object[] columnNames = new Object[] { "Sample Data", "Data ID", "Some Other Column" };
		List<Object[]> data = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			data.add(new Object[] { "Data " + i, i, i * i * i });
		}
		String leftExpResult = 
				  "+-------------+---------+-------------------+\n"
				+ "| Sample Data | Data ID | Some Other Column |\n"
				+ "+-------------+---------+-------------------+\n"
				+ "| Data 0      | 0       | 0                 |\n"
				+ "| Data 1      | 1       | 1                 |\n"
				+ "| Data 2      | 2       | 8                 |\n"
				+ "| Data 3      | 3       | 27                |\n"
				+ "| Data 4      | 4       | 64                |\n"
				+ "+-------------+---------+-------------------+\n";
		String rightExpResult = 
				  "+-------------+---------+-------------------+\n"
				+ "| Sample Data | Data ID | Some Other Column |\n"
				+ "+-------------+---------+-------------------+\n"
				+ "|      Data 0 |       0 |                 0 |\n"
				+ "|      Data 1 |       1 |                 1 |\n"
				+ "|      Data 2 |       2 |                 8 |\n"
				+ "|      Data 3 |       3 |                27 |\n"
				+ "|      Data 4 |       4 |                64 |\n"
				+ "+-------------+---------+-------------------+\n";
		String leftResult = TablePrinter.createTable(columnNames, data, false);
		String rightResult = TablePrinter.createTable(columnNames, data, true);
		assertEquals(leftExpResult, leftResult);
		assertEquals(rightExpResult, rightResult);
	}
	
	/**
	 * Test of printTable method, of class TablePrinter.
	 */
	@Test
	public void testPrintTable() {
		System.out.println("\nTesting printTable");
		LoggedPrintStream lps = LoggedPrintStream.create(System.out);
		System.setOut(lps);
		Object[] columnNames = new Object[] { "Nothing", "Not Nothing" };
		List<Object[]> data = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			data.add(new Object[] { "Data " + i, i * i});
		}
		TerminalPrinter tp = new FastTerminalPrinter();
		TablePrinter.printTable(columnNames, data, false, tp);
		String leftResult = lps.toString();
		lps.clear();
		TablePrinter.printTable(columnNames, data, true, tp);
		String rightResult = lps.toString();
		String leftExpResult = 
				  "+---------+-------------+\n"
				+ "| Nothing | Not Nothing |\n"
				+ "+---------+-------------+\n"
				+ "| Data 0  | 0           |\n"
				+ "| Data 1  | 1           |\n"
				+ "| Data 2  | 4           |\n"
				+ "| Data 3  | 9           |\n"
				+ "| Data 4  | 16          |\n"
				+ "+---------+-------------+\n";
		String rightExpResult = 
				  "+---------+-------------+\n"
				+ "| Nothing | Not Nothing |\n"
				+ "+---------+-------------+\n"
				+ "|  Data 0 |           0 |\n"
				+ "|  Data 1 |           1 |\n"
				+ "|  Data 2 |           4 |\n"
				+ "|  Data 3 |           9 |\n"
				+ "|  Data 4 |          16 |\n"
				+ "+---------+-------------+\n";
		assertEquals(leftExpResult, leftResult);
		assertEquals(rightExpResult, rightResult);
	}
	
	/**
	 * This test will test (obviously) the createTable method with a empty
	 * column name and data array.
	 */
	@Test(expected = IllegalStateException.class)
	public void canCreateEmptyTable() {
		System.out.println("\nTesting if createTable can create empty table");
		Object[] columnNames = new Object[] {}; // Empty column name array
		List<Object[]> data = new ArrayList<>(); // Should be empty
		TablePrinter.createTable(columnNames, data, false); // Should throw exception
	}
	
	/**
	 * This test will test (obviously) the createTable method with a null
	 * column name and data array.
	 */
	@Test(expected = IllegalStateException.class)
	public void canCreateNullTable() {
		System.out.println("\nTesting if createTable can create null table");
		TablePrinter.createTable(null, null, false); // Should throw exception
	}
	
	/**
	 * This test tries to create a table just with empty strings.
	 */
	@Test
	public void canCreateEmptyStringsTable() {
		System.out.println("\nTesting if createTable can create table with array of empty strings");
		Object[] columnNames = new Object[] { "", "" };
		List<Object[]> data = new ArrayList<>();
		data.add(new Object[] { "", "" }); // Reference to 'columnNames' cause unwanted behaviour
		data.add(new Object[] { "", "" });
		String expResult = 
				  "+---------+---------+\n"
				+ "| UNNAMED | UNNAMED |\n"
				+ "+---------+---------+\n"
				+ "| EMPTY   | EMPTY   |\n"
				+ "| EMPTY   | EMPTY   |\n"
				+ "+---------+---------+\n";
		String result = TablePrinter.createTable(columnNames, data, false);
		assertEquals(expResult, result);
	}
	
	/**
	 * Test if the {@code createTable} method can create a table with only one column.
	 */
	@Test
	public void canCreateOneColumnArray() {
		System.out.println("\nTesting if createTable can create a table with only one column");
		Object[] columnNames = new Object[] { "Column 1" };
		List<Object[]> data = new ArrayList<>();
		data.add(new Object[] { "Data 1" });
		data.add(new Object[] { "Data 2" });
		String expResult = 
				  "+----------+\n"
				+ "| Column 1 |\n"
				+ "+----------+\n"
				+ "| Data 1   |\n"
				+ "| Data 2   |\n"
				+ "+----------+\n";
		String result = TablePrinter.createTable(columnNames, data, false);
		assertEquals(expResult, result);
	}
}
