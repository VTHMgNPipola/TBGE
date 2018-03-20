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
package com.prinjsystems.tbge.entities.items;

import com.prinjsystems.tbge.entities.EmptyEntityContainer;
import com.prinjsystems.tbge.entities.Entity;
import com.prinjsystems.tbge.entities.actions.EntityAction;
import com.prinjsystems.tbge.entities.EntityContainer;
import java.util.List;

/**
 * An item is an special type of entity, that has more specific features.
 */
public abstract class Item extends Entity {
	private List<EntityAction> actions;
	
	/**
	 * Creates a new instance, without having storage.
	 * @param name Name of the item.
	 */
	public Item(String name) {
		super(name, new EmptyEntityContainer());
	}
	
	/**
	 * Creates a new instance, with storage.
	 * @param name Name of the item.
	 * @param inventory Inventory of the item.
	 */
	public Item(String name, EntityContainer inventory) {
		super(name, inventory);
	}
	
	/**
	 * Creates a new instance, with storage and actions.
	 * @param name Name of the item.
	 * @param inventory Inventory of the item.
	 * @param actions Actions that the item can run.
	 */
	public Item(String name, EntityContainer inventory, List<EntityAction> actions) {
		super(name, inventory);
		for(int i = 0; i < actions.size(); i++) {
			actions.get(i).setEntity(this);
		}
		this.actions = actions;
	}
	
	/**
	 * Runs the action at the index {@code index}.
	 * @param index Index of the action in the actions list.
	 */
	public void use(int index) {
		beforeUse();
		actions.get(index).run();
		afterUse();
	}
	
	/**
	 * Runned when item picked.
	 */
	public abstract void onPick();
	
	/**
	 * Runned when item droped.
	 */
	public abstract void onDrop();
	
	/**
	 * Runned when item selected on entity inventory.
	 */
	public abstract void onHandle();
	
	/**
	 * Runned before action.
	 */
	public abstract void beforeUse();
	
	/**
	 * Runned after action.
	 */
	public abstract void afterUse();
}
