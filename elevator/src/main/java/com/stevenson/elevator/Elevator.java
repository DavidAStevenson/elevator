package com.stevenson.elevator;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Elevator {

	public enum Status {
		OPENING(0),
		OPEN(1),
		CLOSING(2),
        CLOSED(3);
		
		private int statusValue;

		private Status(int statusValue) {
			this.statusValue = statusValue;
		}
	}

	private Status doorState = Status.CLOSED;
	private Set<Integer> destinationFloors = new TreeSet<Integer>();
	private int _currentFloor = 0;
	
	public void openDoors() {
		doorState = Status.OPEN;
	}
	
	public void closeDoors() {
		doorState = Status.CLOSED;
	}
	
	public boolean isDoorsOpen() {
		switch (doorState) {
		case OPEN:
			return true;
		default:
			return false;
		}
	}

	public boolean isDoorsClosed() {
		switch (doorState) {
		case CLOSED:
			return true;
		default:
			return false;
		}
	}

	public void floorButtonPressed(int i) {
		destinationFloors.add(i);
		// TODO Auto-generated method stub
		
	}

	public boolean isStoppingAt(int floorNo) {
		// TODO Auto-generated method stub
		return destinationFloors.contains(floorNo);
	}

	public int currentFloor() {
		return _currentFloor;
	}
	
	public void transitAll() {
		Iterator<Integer> iterator = destinationFloors.iterator();
		while (iterator.hasNext()) {
			Integer nextDestination = iterator.next();
			System.out.println("We'll stop at Floor No. " + 
					nextDestination + " next\n");
			iterator.remove();
			_currentFloor = nextDestination;
			openDoors();
			closeDoors();
		}		
	}
	
	public void transitOnce() {
		Iterator<Integer> iterator = destinationFloors.iterator();
		if (iterator.hasNext()) {
			Integer nextDestination = iterator.next();
			System.out.println("We'll stop at Floor No. " + 
					nextDestination + " next\n");
			iterator.remove();
			_currentFloor = nextDestination;
			openDoors();
			closeDoors();
		}
	}

}
