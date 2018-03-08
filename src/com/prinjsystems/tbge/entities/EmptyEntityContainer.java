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
 * This class can be used when no inventory is wanted in some place of the game.
 */
public class EmptyEntityContainer implements EntityContainer {
	@Override
	public void add(Entity e) {
		return;
	}
	
	@Override
	public void add(int p, Entity e) {
		return;
	}
	
	@Override
	public Entity get(int i) {
		return null;
	}
	
	@Override
	public Entity remove(int i) {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}
}
