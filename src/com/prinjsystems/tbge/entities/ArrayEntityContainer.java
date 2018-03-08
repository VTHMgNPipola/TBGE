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
 * Uses a common array to store entites. Can be fixed size or extendable.
 */
public class ArrayEntityContainer implements EntityContainer {
	private Entity[] entities;
	private boolean fixedSize;
	
	public ArrayEntityContainer(int startSize, boolean fixedSize) {
		entities = new Entity[startSize];
		this.fixedSize = fixedSize;
	}
	
	public ArrayEntityContainer(int startSize) {
		entities = new Entity[startSize];
		this.fixedSize = false;
	}
	
	public void setFixedSize(boolean fixedSize) {
		this.fixedSize = fixedSize;
	}
	
	public boolean isFixedSize() {
		return fixedSize;
	}
	
	@Override
	public void add(Entity e) {
		if(fixedSize) {
			for(int i = 0; i < entities.length; i++) {
				if(entities[i] == null) {
					entities[i] = e;
					break;
				}
			}
		} else {
			for(int i = 0; i < entities.length; i++) {
				if(entities[i] == null) {
					if(entities.length <= i + 1) {
						Entity[] tmp = entities;
						entities = new Entity[entities.length + 5];
						for(int j = 0; j < tmp.length; j++) {
							entities[j] = tmp[j];
						}
					}
					entities[i] = e;
					break;
				}
			}
		}
	}
	
	@Override
	public void add(int p, Entity e) {
		if(entities.length <= p) {
			Entity[] tmp = entities;
			entities = new Entity[p + 5];
			for(int j = 0; j < tmp.length; j++) {
				entities[j] = tmp[j];
			}
		}
		
		entities[p] = e;
	}
	
	@Override
	public Entity get(int i) throws IndexOutOfBoundsException {
		return entities[i];
	}
	
	@Override
	public Entity remove(int i) throws IndexOutOfBoundsException {
		Entity tmp = entities[i];
		entities[i] = null;
		for(int j = i + 1; j < entities.length; j++) { // Iterates over entities array
			entities[j - 1] = entities[j]; // Swap entity on position J to J - 1
			entities[j] = null; // Makes position J null, worth at last operation.
		}
		return tmp;
	}
	
	@Override
	public int size() {
		int size = 0;
		for(int i = 0; i < entities.length; i++) { // Iterates over entities array
			if(entities[i] == null) { // Checks if the current position is null
				boolean isEnding = true;
				if(i != entities.length - 1) { // If current position is not last index
					for(int j = i; j < entities.length; j++) { // Iterates over entities array with offset
						if(entities[i] != null) { // If a entity is not null, the operation fails
							isEnding = false; // The array is not ending
							size++; // Size increases
							break; // For loop breaked, because nothing more to do
						}
					}
				}
				if(isEnding) { // If array ending
					break; // Break the main array, because operation successful
				}
			} else { // If current position not null
				size++; // Size increases
			}
		}
		return size;
	}
}
