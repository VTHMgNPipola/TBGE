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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Make tests of the class ListEntityContainer.
 */
public class ListEntityContainerTest {
	/**
	 * Test of add method, of class ListEntityContainer.
	 */
	@Test
	public void testAdd_Entity() {
		System.out.println("Testing add");
		Entity e = null;
		ListEntityContainer instance = new ListEntityContainer();
		instance.add(e);
		assertEquals(e, instance.get(0));
	}

	/**
	 * Test of add method, of class ListEntityContainer.
	 */
	@Test
	public void testAdd_int_Entity() {
		System.out.println("Testing add");
		int p = 0; // Need to be 0, since list will not have following indices
		Entity e = new Entity("E1", null) {};
		ListEntityContainer instance = new ListEntityContainer();
		instance.add(p, e);
		assertEquals(e, instance.get(p));
	}

	/**
	 * Test of get method, of class ListEntityContainer.
	 */
	@Test
	public void testGet() {
		System.out.println("Testing get");
		int i = 0; // Need to be 0, since list will not have following indices
		ListEntityContainer instance = new ListEntityContainer();
		Entity expResult = null;
		instance.add(i, expResult);
		Entity result = instance.get(i);
		assertEquals(expResult, result);
	}

	/**
	 * Test of remove method, of class ListEntityContainer.
	 */
	@Test
	public void testRemove() {
		System.out.println("Testing remove");
		ListEntityContainer instance = new ListEntityContainer();
		Entity expResult = new Entity("E1", null) {};
		instance.add(expResult);
		Entity result = instance.remove(0);
		assertEquals(expResult, result);
		assertEquals(0, instance.size());
	}

	/**
	 * Test of size method, of class ListEntityContainer.
	 */
	@Test
	public void testSize() {
		System.out.println("Testing size");
		ListEntityContainer instance = new ListEntityContainer();
		for(int i = 0; i < 50; i++) {
			instance.add(new Entity("E" + i, null) {});
		}
		assertEquals(50, instance.size());
	}
}
