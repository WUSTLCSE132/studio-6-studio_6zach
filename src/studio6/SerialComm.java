package studio6;

import java.util.Arrays;

import jssc.*;

public class SerialComm {

	SerialPort port;
	


	private boolean debug;  // Indicator of "debugging mode"
	
	// This function can be called to enable or disable "debugging mode"
	void setDebug(boolean mode) {
		debug = mode;
	}	
	

	// Constructor for the SerialComm class
	public SerialComm(String name) throws SerialPortException {
		port = new SerialPort(name);		
		port.openPort();
		port.setParams(SerialPort.BAUDRATE_9600,
			SerialPort.DATABITS_8,
			SerialPort.STOPBITS_1,
			SerialPort.PARITY_NONE);
		
		debug = false; // Default is to NOT be in debug mode
	}
		
	// TODO: Add writeByte() method from Studio 5
	public void writeByte(byte change) throws SerialPortException {
		port.writeByte(change);
		if(debug) {
			System.out.println(change);
		}
	}
		
	// TODO: Add available() method
	public boolean available() throws SerialPortException {
		int count = port.getInputBufferBytesCount();
		if(count != 0) {
			return true;
		}
		else {
			return false;
		}
	}
	// TODO: Add readByte() method	
	public int readByte() throws SerialPortException{
		byte[] bytes = port.readBytes();
		return bytes[0];
	}
	
	// TODO: Add a main() method
	
	public static void main(String[] args) throws SerialPortException {
		SerialComm port = new SerialComm("COM4");
		while (true){
			boolean test = port.available();
			if(test) {
				port.readByte();
			}
		}	
	}
}
