/**
 *  APN autoconfigurarion applet
 *
 * 		Author: Diego Leñero Ramírez 
 *				diego.lenero@podgroup.com
 *		 
 */

/*
*		This applet has been tested with mkr gsm 1400 hardware with unconclusive results.
*	
*/


package APNautoconf;

import sim.toolkit.*;
import javacard.framework.*;

public class APNautoconf extends Applet implements ToolkitInterface, ToolkitConstants {

	private ToolkitRegistry reg;

	// Menu text
	static 	byte[] 	menuItemText = new byte[] {'S','E','N','D',' ','A','T',' ','C','O','M','M','A','N','D'};
	private byte 	menuItem;

	// AT command to be sent
	// It should configure the APN, in this case "data641003" is chosen as example.
	static byte[] cgdcont = new byte[] {'a','t','+','c','g','d','c','o','n','t','=',
										'1',','
										,'"','I','P','"',','
										,'"','d','a','t','a','6','4','1','0','0','3','"'};		

 	/**
 	*	Constructor of the applet
	*/
	private APNautoconf() {
		reg = ToolkitRegistry.getEntry();							// register to the SIM Toolkit Framework

		// Define the applet Menu Entry
		menuItem = reg.initMenuEntry(menuItemText, (short)0, (short)menuItemText.length,
				PRO_CMD_SELECT_ITEM, false, (byte)0, (short)0);

	}

    /**
    * Method called by the JCRE at the installation of the applet
    */
	public static void install(byte[] bArray, short bOffset, byte bLength) {
		APNautoconf applet = new APNautoconf();
		applet.register();
	}


	public void process(APDU apdu) throws ISOException {
		if (selectingApplet())
		return;
	}
	
    /**
    * Method called by the SIM Toolkit Framework
    */
	public void processToolkit(byte event) throws ToolkitException {



		EnvelopeHandler envHdlr = EnvelopeHandler.getTheHandler();

		if (event == EVENT_MENU_SELECTION) {
			byte selectedItemId = envHdlr.getItemIdentifier();

			if (selectedItemId == menuItem) {
				
				// This sends the AT command to the terminal
				ProactiveHandler proHdlr = ProactiveHandler.getTheHandler();
				proHdlr.init(PRO_CMD_RUN_AT_COMMAND,(byte)0,DEV_ID_ME);
				proHdlr.appendTLV((byte)(TAG_AT_COMMAND | TAG_SET_CR), cgdcont, (short)0, (short)cgdcont.length);
				proHdlr.send();
			}
		}
	
	}
}