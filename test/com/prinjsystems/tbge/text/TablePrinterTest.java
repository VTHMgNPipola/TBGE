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
		FastTerminalPrinterTest.LoggedPrintStream lps = FastTerminalPrinterTest.LoggedPrintStream.create(System.out);
		System.setOut(lps);
		Object[] columnNames = new Object[] { "Nothing", "Not Nothing" };
		List<Object[]> data = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			data.add(new Object[] { "Data " + i, i * i});
		}
		TerminalPrinter tp = new FastTerminalPrinter();
		TablePrinter.printTable(columnNames, data, false, tp);
		String expResult = 
				  "+---------+-------------+\n"
				+ "| Nothing | Not Nothing |\n"
				+ "+---------+-------------+\n"
				+ "| Data 0  | 0           |\n"
				+ "| Data 1  | 1           |\n"
				+ "| Data 2  | 4           |\n"
				+ "| Data 3  | 9           |\n"
				+ "| Data 4  | 16          |\n"
				+ "+---------+-------------+\n";
		assertEquals(expResult, lps.toString());
	}
}
