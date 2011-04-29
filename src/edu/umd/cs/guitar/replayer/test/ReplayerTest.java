package edu.umd.cs.guitar.replayer.test;

import org.junit.Test;

import edu.umd.cs.guitar.replayer.Replayer;
import edu.umd.cs.guitar.replayer.SWTReplayer;
import edu.umd.cs.guitar.replayer.SWTReplayerConfiguration;
import edu.umd.cs.guitar.ripper.SWTGuitarRunner;
import edu.umd.cs.guitar.ripper.test.aut.SWTMultiWindowDynamicApp;

/**
 * Runs a replayer test that opens a few windows and closes them. 
 * 
 * @author Gabe Gorelick-Feldman
 */

public class ReplayerTest {

	/**
	 * This test can't fail
	 * We just make sure it doesn't crash. We need a better 
	 * way of assuring the outputs are correct
	 * 
	 * @return nothing
	 */
	@Test
	public void testReplayer() {
		SWTReplayerConfiguration config = new SWTReplayerConfiguration();
		
		String autName = SWTMultiWindowDynamicApp.class.getSimpleName();
		
		config.setMainClass(SWTMultiWindowDynamicApp.class.getName());
		config.setGuiFile("guistructures/" + autName + ".GUI.xml");
		config.setEfgFile("efgs/" + autName + ".EFG.xml");
		config.setTestcase("testcases/" + autName + "/t_e1819273420_e1819273420_e1819273420_e1819273420_e1819273420.tst");
		
		Thread guiThread = Thread.currentThread();
		final SWTReplayer replayer = new SWTReplayer(config, guiThread);
		
		new SWTGuitarRunner(replayer).run();		
	}
}
