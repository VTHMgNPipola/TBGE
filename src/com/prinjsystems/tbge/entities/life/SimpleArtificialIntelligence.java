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
 * This is the simplest implementation of {@code ArtificialIntelligence} interface.
 * The only thing it does, is checking the input object on the {@link #think(java.lang.Object) think} method,
 * and if it conrresponds to the trigger object, the output action is launched.
 */
public class SimpleArtificialIntelligence implements ArtificialIntelligence {
	private Map<Object, EntityAction> actions;
	
	@Override
	public void setActions(Map<Object, EntityAction> actions) {
		this.actions = actions;
	}
	
	@Override
	public Map<Object, EntityAction> getActions() {
		return actions;
	}
	
	/**
	 * Receives an input signal that is processed and analyzed it to define
	 * if the output action will be triggered, or not. This implementation
	 * never change his trigger object.
	 * @param input Object to be analyzed.
	 */
	@Override
	public void think(Object input) {
		actions.keySet().stream().filter((o) -> (input.equals(o))).forEachOrdered((o) -> actions.get(o).run());
	}
}
