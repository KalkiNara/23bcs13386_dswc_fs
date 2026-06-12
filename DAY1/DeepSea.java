class HardwareLockExcepption extends Exception{
    public HardwareLockExcepption(String message) {
        super(message);
    }
}

class SensorCourruptionException extends RuntimeException{
    public SensorCourruptionException(String message) {
        super(message);
    }
}

class TelemetryStream implements AutoCloseable{
    public TelemetryStream() {
        System.out.println("Telemetry Stream Opened"); 
    }

    public void readSensor(int simulatedState) throws HardwareLockExcepption {
        if(simulatedState == 0) {
            throw new HardwareLockExcepption("Hardware Lock Detected");
        } else if(simulatedState == 1) {
            throw new SensorCourruptionException("Sensor Courruption Detected");
        } else {
            System.out.println("Sensor Reading: " + simulatedState);
        }
    }
    @Override
    public void close() {
        System.out.println("Telemetry Stream Closed");
    }
}

public class DeepSea{
    public static void main(String[] args) {
        try(TelemetryStream telemetryStream = new TelemetryStream()) {
            telemetryStream.readSensor(0);
        } catch (HardwareLockExcepption e) {
            System.out.println("Caught HardwareLockExcepption: " + e.getMessage());
        } catch (SensorCourruptionException e) {
            System.out.println("Caught SensorCourruptionException: " + e.getMessage());
        }
    }
}