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

import java.util.List;

/**
 * Any class that implements this interface will have the purpose of select
 * one between multiple options, being good for selecting between actions,
 * items or entities.
 */
public interface Selector {
	/**
	 * Defines the helping text of the selector.
	 * @param text Helping text of the selector.
	 */
	public void setText(String text);
	
	/**
	 * Defines all the options of the selector.
	 * @param options Options of the selector.
	 */
	public void setOptions(List<String> options);
	
	/**
	 * Defines the option that will be select when no input is given.
	 * If this method is not called, or no constructor injection is used, the selector
	 * will fail if no option is given.
	 * @param optionIndex Index of the option at the options list given.
	 */
	public void setDefaultOption(int optionIndex);
	
	/**
	 * Will show up the selector options, the text and, if defined, the default option.
	 */
	public void askSelector();
}
