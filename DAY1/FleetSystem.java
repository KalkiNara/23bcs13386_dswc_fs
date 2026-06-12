abstract class SpaceVessel{
    short shipId;
    boolean isActive;
    char fleetClass;

    public SpaceVessel(short shipId, boolean isActive, char fleetClass) {
        this.shipId = shipId;
        this.isActive = isActive;
        this.fleetClass = fleetClass;
    }
}

class MiningShip extends SpaceVessel{
    
    float[][] cargoHold;
    
    public MiningShip(short shipId, boolean isActive, char fleetClass,byte numBays, short containerCapacity) {
        super(shipId, isActive, fleetClass);
        this.cargoHold = new float[numBays][containerCapacity];
    }

    public void loadOre(byte bay, short container, float weight){
        cargoHold[bay][container] = weight;
    }

    public float calculateTotalOreWeight(){
        float totalWeight = 0.0f;

        for(int i = 0; i < cargoHold.length; i++){
            for(int j = 0; j < cargoHold[i].length; j++){
                totalWeight += cargoHold[i][j];
            }
        }
        return totalWeight;
    }

    public float findHeaviestContainer(){
        float heaviestWeight = 0.0f;

        for(int i = 0; i < cargoHold.length; i++){
            for(int j = 0; j < cargoHold[i].length; j++){
                if(cargoHold[i][j] > heaviestWeight){
                    heaviestWeight = cargoHold[i][j];
                }
            }
        }
        return heaviestWeight;
    }
}

public class FleetSystem{
    public static void main(String[] args) {
        MiningShip miningShip = new MiningShip((short) 101, true, 'A', (byte) 5, (short) 10);
        
        miningShip.loadOre((byte) 0, (short) 0, 500.0f);
        miningShip.loadOre((byte) 0, (short) 1, 300.0f);
        miningShip.loadOre((byte) 1, (short) 0, 700.0f);
        miningShip.loadOre((byte) 1, (short) 1, 200.0f);

        float totalWeight = miningShip.calculateTotalOreWeight();
        System.out.println("Total Ore Weight: " + totalWeight);

        float heaviestContainer = miningShip.findHeaviestContainer();
        System.out.println("Heaviest Container Weight: " + heaviestContainer);
    }
}