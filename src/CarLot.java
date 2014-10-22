import java.util.Arrays;
class CarLot implements Inventory<Car> {
	private int index = 0;
	private int numVehicles = 0;
	Car[] inventory;

	public CarLot (int capacity) {
		inventory = new Car[capacity];
	}
	@Override
	public int capacity() {
		return inventory.length;
	}

	@Override
	public int numVehicles() {
		return numVehicles;
	}

	@Override
	public boolean add(Car vehicle) {
		if (numVehicles < capacity()) {
			inventory[index] = vehicle;
			setIndex();
			numVehicles++;
		} else {
			return false;
		}
		return true;
	}

	private void setIndex() {
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] == null) {
				index = i;
				return;
			}
		}
	}

	@Override
	public Car get(int location) {
		try {
			return inventory[location];
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override
	public Car remove(int location) {
		try {
			Car tmp = inventory[location];
			inventory[location] = null;
			setIndex();
			return tmp;
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	//TODO remove
	public void printInventory() {
		System.out.println(Arrays.toString(inventory));
	}

	@Override
	public boolean[] searchByMake(String make) {
		boolean[] results = new boolean[capacity()];
		for (int i = 0; inventory[i] != null && i < results.length; i++) {
			if (inventory[i].getMake().equals(make)) {
				results[i] = true;
			}
		}
		return results;
	}
}