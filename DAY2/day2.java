

abstract class SmartDevice{
    protected String deviceId;
    protected String deviceName;
    SmartDevice(String deviceId, String deviceName){
        this.deviceId = deviceId;
        this.deviceName = deviceName;
    }

    public abstract void runDiagnostic();
}

interface BatteryOperated{
    int getBatteryLevel();
    void triggerRechargeAlert();

}
class SmartLight extends SmartDevice {
    SmartLight(String deviceId, String deviceName){
        super(deviceId, deviceName);
    }

    @Override
    public void runDiagnostic() {
        System.out.println("Running diagnostic for Smart Light: " + deviceName);
    }
}

class SmartCamera extends SmartDevice implements BatteryOperated{
    protected int batteryLevel;

    SmartCamera(String deviceId, String deviceName, int batteryLevel){
        super(deviceId, deviceName);
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void runDiagnostic() {
        System.out.println("Running diagnostic for Smart Camera: " + deviceName);
    }

    @Override
    public int getBatteryLevel() {
        return batteryLevel; 
    }

    @Override
    public void triggerRechargeAlert() {
        if(getBatteryLevel() < 20){
            System.out.println("Battery low for " + deviceName + ". Please recharge.");
        }
    }
}

class SmartLock extends SmartDevice implements BatteryOperated{

    protected int batteryLevel;
    SmartLock(String deviceId, String deviceName, int batteryLevel){
        super(deviceId, deviceName);
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void runDiagnostic() {
        System.out.println("Running diagnostic for Smart Lock: " + deviceName);
    }

    @Override
    public int getBatteryLevel() {
        return batteryLevel; 
    }

    @Override
    public void triggerRechargeAlert() {
        if(getBatteryLevel() < 20){
            System.out.println("Battery low for " + deviceName + ". Please recharge.");
        }
    }
}

class HomeHub{
    public void executeNightlyRoutine(SmartDevice[] devices){
        for(SmartDevice device : devices){
            device.runDiagnostic();
            if(device instanceof BatteryOperated){
                BatteryOperated batteryDevice = (BatteryOperated) device;
                batteryDevice.triggerRechargeAlert();
            }
        }
    }
}

public class day2 {
    public static void main(String[] args) {
        SmartDevice[] devices = {
            new SmartLight("SL001", "Living Room Light"),
            new SmartCamera("SC001", "Front Door Camera", 15),
            new SmartLock("SLK001", "Main Door Lock", 25)
        };

        HomeHub homeHub = new HomeHub();
        homeHub.executeNightlyRoutine(devices);
    }
}
