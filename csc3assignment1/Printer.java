//This class defines the printer object used in the Quick Inking Application

public class Printer {

    //Data Elements
    private String deviceName;
    private String IPAddress;
    private String lastCommunicationTime;
    private String serialNumber;
    private int pageCount;
    private int blackCartridge;
    private int colorCartridge;
    private boolean lowInkBlack;
    private boolean lowInkColor;

    //Constructor
    public Printer(){}

    //set methods
    public void setDeviceName(String deviceName){
        this.deviceName = deviceName;
    }
    public void setIPAddress(String IPAddress){
        this.IPAddress = IPAddress;
    }
    public void setLastCommunicationTime(String lastCommunicationTime){
        this.lastCommunicationTime = lastCommunicationTime;
    }
    public void setSerialNumber(String serialNumber){
        this.serialNumber = serialNumber;
    }
    public void setPageCount(int pageCount){
        this.pageCount = pageCount;
    }
    public void setBlackCartridge(int blackCartridge){
        this.blackCartridge = blackCartridge;
    }
    public void setColorCartridge(int colorCartridge){
        this.colorCartridge = colorCartridge;
    }
    public void setLowInkBlack(int blackCartridge){
        lowInkBlack = blackCartridge < 10;
    }
    public void setLowInkColor(int colorCartridge) {
        lowInkColor = colorCartridge < 10;
    }

    //get methods
    public String getDeviceName(){return deviceName;}
    public String getIPAddress(){return IPAddress;}
    public String getLastCommunicationTime(){return lastCommunicationTime;}
    public String getSerialNumber(){return serialNumber;}
    public int getPageCount(){return pageCount;}
    public int getBlackCartridge(){return blackCartridge;}
    public int getColorCartridge(){return colorCartridge;}
    public boolean getLowInkBlack(){return lowInkBlack;}
    public boolean getLowInkColor(){return lowInkColor;}

    //toString Method
    public String toString() {
        return "Device Name: " + getDeviceName() + "\nIP Address: " + getIPAddress() + "\nLast Communication Time: " +
                getLastCommunicationTime() + "\nSerial Number: " + getSerialNumber() + "\nPage Count: " +
                getPageCount() + "\nBlack Cartridge: " + getBlackCartridge() + "\nColor Cartridge: "
                + getColorCartridge();
    }
}
