class GridSystem{

    byte sectorState;

    public GridSystem(byte sectorState){
        this.sectorState = sectorState;
    }

    public void turnSectorOn(int sector){
        byte mask = (byte)(1 << sector);
        sectorState |= mask;
    }

    public void turnSectorOff(int sector){
        byte mask = (byte)(1 << sector);
        sectorState &= ~mask;
    }

    public boolean isSectorOn(int sector){
        byte mask = (byte)(1 << sector);
        return (sectorState & mask) != 0;
    }
}

public class Grid {

    public static void main(String[] args) {
        GridSystem grid = new GridSystem((byte)0);

        grid.turnSectorOn(2);
        grid.turnSectorOn(5);

        System.out.println("Sector 2 is on: " + grid.isSectorOn(2)); // true
        System.out.println("Sector 5 is on: " + grid.isSectorOn(5)); // true
        System.out.println("Sector 3 is on: " + grid.isSectorOn(3)); // false

        grid.turnSectorOff(2);
        System.out.println("Sector 2 is on: " + grid.isSectorOn(2)); // false
    }
}