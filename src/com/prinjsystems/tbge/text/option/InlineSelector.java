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
package com.prinjsystems.tbge.text.option;

import com.prinjsystems.tbge.text.TerminalPrinter;
import java.util.List;
import java.util.Scanner;

/**
 * This implementation of Selector interface prints the helping text, and then
 * all the options in lowercase, inside brackets, and the default option is printed
 * in uppercase.
 */
public class InlineSelector implements Selector {
	private List<String> options;
	private TerminalPrinter tp;
	private int defaultOption;
	private String text;
	
	/**
	 * Creates a default instance of InlineSelector, that should have
	 * a {@code TerminalPrinter} as argument, to be used as the print
	 * tool.
	 * @param tp Print tool used to print the text and the options on the screen.
	 */
	public InlineSelector(TerminalPrinter tp) {
		this.tp = tp;
		defaultOption = 0;
	}
	
	@Override
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public void setOptions(List<String> options) {
		this.options = options;
	}
	
	@Override
	public void setDefaultOption(int optionIndex) {
		defaultOption = optionIndex;
	}
	
	@Override
	public int askSelector() {
		String separator = "";
		Scanner s = new Scanner(System.in);
		tp.println();
		tp.print(text + ": [");
		for(int i = 0; i < options.size(); i++) {
			if(i == defaultOption) {
				tp.print(separator + options.get(i).toUpperCase());
			} else {
				tp.print(separator + options.get(i).toLowerCase());
			}
			separator = ", ";
		}
		tp.print("]: ");
		return Integer.parseInt(s.nextLine());
	}
}
