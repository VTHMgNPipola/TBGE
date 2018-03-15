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
package com.prinjsystems.tbge.entities;

import com.prinjsystems.tbge.entities.items.Item;
import java.util.ArrayList;
import java.util.List;

/**
 * Uses a ArrayList to store entities.
 */
public class ListEntityContainer implements EntityContainer {
	private List<Entity> entities;
	
	/**
	 * Creates a new empty ListEntityContainer, ready to be used.
	 */
	public ListEntityContainer() {
		entities = new ArrayList<>();
	}
	
	@Override
	public void add(Entity e) {
		entities.add(e);
		if(e instanceof Item) {
			((Item) e).onPick();
		}
	}
	
	@Override
	public void add(int p, Entity e) {
		entities.add(p, e);
		if(e instanceof Item) {
			((Item) e).onPick();
		}
	}
	
	@Override
	public Entity get(int i) throws IndexOutOfBoundsException {
		if(entities.get(i) instanceof Item) {
			((Item) entities.get(i)).onHandle();
		}
		return entities.get(i);
	}
	
	@Override
	public Entity remove(int i) throws IndexOutOfBoundsException {
		if(entities.get(i) instanceof Item) {
			((Item) entities.get(i)).onDrop();
		}
		return entities.remove(i);
	}

	@Override
	public int size() {
		return entities.size();
	}
}
