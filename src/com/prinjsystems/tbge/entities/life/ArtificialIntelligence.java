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
package com.prinjsystems.tbge.entities.life;

import com.prinjsystems.tbge.entities.actions.EntityAction;
import java.util.Map;

/**
 * An artificial intelligence has a trigger and a output action. When
 * the AI receives a input, and this input is equals to the trigger, then the
 * output action is run.
 */
public interface ArtificialIntelligence {
	/**
	 * Define the actions. An action is the combination of a trigger (an {@code Object})
	 * and a output action (an {@code EntityAction}).
	 * @param actions Map containing all the triggers and output actions.
	 */
	public void setActions(Map<Object, EntityAction> actions);
	
	/**
	 * Returns the current action list.
	 * @return Current action list.
	 */
	public Map<Object, EntityAction> getActions();
	
	/**
	 * Receives an input signal that is processed and analyzed it to define
	 * if an output action will be triggered or not. Depending on the
	 * implementation of the interface, the trigger objects may change because
	 * external factors, without warning.
	 * @param input Object to be analyzed.
	 */
	public void think(Object input);
}
