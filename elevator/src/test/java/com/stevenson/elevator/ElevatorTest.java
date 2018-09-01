/**
 * 
 */
package com.stevenson.elevator;

//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author David
 *
 */
class ElevatorTest {

	private Elevator elevator;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		elevator = new Elevator();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testDoorsOpen() {
		elevator.openDoors();
		assertTrue(elevator.isDoorsOpen());
		assertFalse(elevator.isDoorsClosed());
	}

	@Test
	void testDoorsClosed() {
		elevator.closeDoors();
		assertTrue(elevator.isDoorsClosed());
		assertFalse(elevator.isDoorsOpen());
	}

	@Test
	void testFloorDestinations() {
		int floorNo = 8;
		assertFalse(elevator.isStoppingAt(floorNo));
		elevator.floorButtonPressed(floorNo);
		assertTrue(elevator.isStoppingAt(floorNo), "Expected to stop at Fl. "+ floorNo);
		int floorNo2 = 7;
		elevator.floorButtonPressed(floorNo2);
		assertTrue(elevator.isStoppingAt(floorNo), "Expected to stop at Fl. "+ floorNo);
		assertTrue(elevator.isStoppingAt(floorNo2));
	}

	@Test
	void testFromGroundLevelToFirst() {
		int origin = 0;
		int[] destinations = {1,2};
		assertTrue(origin == elevator.currentFloor());
		for (int d = 0; d < destinations.length; d++)
			elevator.floorButtonPressed(destinations[d]);
		elevator.closeDoors();
		elevator.transitOnce();
		assertTrue(destinations[0] == elevator.currentFloor());
	}

	@Test
	void testFromGroundLevelToSecond() {
		int origin = 0;
		int[] destinations = {1,2};
		assertTrue(origin == elevator.currentFloor());
		for (int d = 0; d < destinations.length; d++)
			elevator.floorButtonPressed(destinations[d]);
		elevator.closeDoors();
		for (int i = 0; i < destinations.length; i++) {
			elevator.transitOnce();
		}
		assertTrue(destinations[1] == elevator.currentFloor());
	}

	
	@Test
	void testFromGroundLevelToTenth() {
		int origin = 0; 
		int finaldestination = 10;
		int[] destinations = {1,3,6,7,10};
		for (int d = destinations.length-1; d >= 0; d--)
			elevator.floorButtonPressed(destinations[d]);
		elevator.closeDoors();
		elevator.transitAll();
		assertTrue(finaldestination == elevator.currentFloor());
	}

	
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

	@Test
	void helloJUnit5() {
		System.out.println("Hello, JUnit 5 - Elevator version.");
	}	
	
}
