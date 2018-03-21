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
 * This implementation of the Selector interface prints all options in columns,
 * the selected text and the default option (if any) and then prompt the user to
 * select an option. An ID is selected for all options, that is the option index
 * inside the option list plus one.
 */
public class ColumnSelector implements Selector {
	private TerminalPrinter tp;
	private String text;
	private List<String> options;
	private int defaultOption;
	private boolean lineBreakBetweenOptions;
	
	/**
	 * Creates a default instance of this selector. When fresh created,
	 * the instance have the {@code lineBreakBetweenOptions} value as true.
	 * @param tp Terminal printer used to print text on screen.
	 */
	public ColumnSelector(TerminalPrinter tp) {
		this.tp = tp;
		defaultOption = -1;
		lineBreakBetweenOptions = true;
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
	
	/**
	 * If the value is true, when {@link #askSelector() askSelector} is called,
	 * an extra line break is placed between options, otherwise just the
	 * separation line break is used.
	 * @param lineBreakBetweenOptions If options will have a line break between them.
	 */
	public void setLineBreakBetweenOptions(boolean lineBreakBetweenOptions) {
		this.lineBreakBetweenOptions = lineBreakBetweenOptions;
	}
	
	@Override
	public int askSelector() {
		String extraLB = "";
		String selectorText = System.lineSeparator() + text + ": ";
		if(defaultOption >= 0) {
			selectorText += "[" + (defaultOption - 1) + "]: ";
		}
		if(lineBreakBetweenOptions) {
			extraLB = System.lineSeparator();
		}
		tp.println();
		for(int i = 0; i < options.size(); i++) {
			tp.print("[" + (i + 1) + "] " + options.get(i) + System.lineSeparator() + extraLB);
		}
		tp.println();
		tp.print(selectorText);
		Scanner scanner = new Scanner(System.in);
		return Integer.parseInt(scanner.nextLine()) - 1;
			// Conversion from string to int from nextLine to prevent
			// errors when reading other data.
	}
}
