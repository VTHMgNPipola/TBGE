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
 * Make tests of the class ArrayEntityContainer.
 */
public class ArrayEntityContainerTest {
	/**
	 * Test of setFixedSize method, of class ArrayEntityContainer.
	 */
	@Test
	public void testSetFixedSize() {
		System.out.println("Testing setFixedSize");
		boolean fixedSize = true;
		ArrayEntityContainer instance = new ArrayEntityContainer(5);
		instance.setFixedSize(fixedSize);
		assertEquals(true, instance.isFixedSize());
	}

	/**
	 * Test of isFixedSize method, of class ArrayEntityContainer.
	 */
	@Test
	public void testIsFixedSize() {
		System.out.println("Testing isFixedSize");
		ArrayEntityContainer instance = new ArrayEntityContainer(5, true);
		boolean result = instance.isFixedSize();
		assertEquals(true, result);
	}

	/**
	 * Test of add method, of class ArrayEntityContainer.
	 */
	@Test
	public void testAdd_Entity() {
		System.out.println("Testing add");
		Entity e = null;
		ArrayEntityContainer instance = new ArrayEntityContainer(5);
		instance.add(e);
		assertEquals(e, instance.get(0));
	}

	/**
	 * Test of add method, of class ArrayEntityContainer.
	 */
	@Test
	public void testAdd_int_Entity() {
		System.out.println("Testing add");
		int p = 2;
		Entity e = new Entity("E1", null) {};
		ArrayEntityContainer instance = new ArrayEntityContainer(5);
		instance.add(p, e);
		assertEquals(e, instance.get(p));
	}

	/**
	 * Test of get method, of class ArrayEntityContainer.
	 */
	@Test
	public void testGet() {
		System.out.println("Testing get");
		int i = 3;
		ArrayEntityContainer instance = new ArrayEntityContainer(5);
		Entity expResult = null;
		instance.add(i, expResult);
		Entity result = instance.get(i);
		assertEquals(expResult, result);
	}

	/**
	 * Test of remove method, of class ArrayEntityContainer.
	 */
	@Test
	public void testRemove() {
		System.out.println("Testing remove");
		int i = 0;
		ArrayEntityContainer instance = new ArrayEntityContainer(5);
		Entity expResult = new Entity("E1", null) {};
		instance.add(expResult);
		Entity result = instance.remove(i);
		assertEquals(expResult, result);
		assertEquals(0, instance.size());
	}

	/**
	 * Test of size method, of class ArrayEntityContainer.
	 */
	@Test
	public void testSize() {
		System.out.println("Testing size");
		ArrayEntityContainer instance = new ArrayEntityContainer(5);
		for(int i = 0; i < 50; i++) {
			instance.add(new Entity("E" + i, null) {});
		}
		assertEquals(50, instance.size());
	}
}
