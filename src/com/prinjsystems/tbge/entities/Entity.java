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

/**
 * Base class for all entities in the game (including items). They always
 * have a name and a {@link EntityContainer}.
 */
public abstract class Entity {
	private String name;
	private EntityContainer inventory;
	
	/**
	 * Creates a new Entity, with the required name and inventory parameters.
	 * @param name Name of the entity.
	 * @param inventory Inventory of the entity.
	 */
	public Entity(String name, EntityContainer inventory) {
		this.name = name;
		this.inventory = inventory;
	}
	
	public final String getName() {
		return name;
	}
	
	public final EntityContainer getInventory() {
		return inventory;
	}
}
