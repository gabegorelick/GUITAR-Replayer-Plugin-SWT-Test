/*	
 *  Copyright (c) 2011-@year@. The GUITAR group at the University of Maryland. Names of owners of this group may
 *  be obtained by sending an e-mail to atif@cs.umd.edu
 * 
 *  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 *  documentation files (the "Software"), to deal in the Software without restriction, including without 
 *  limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 *	the Software, and to permit persons to whom the Software is furnished to do so, subject to the following 
 *	conditions:
 * 
 *	The above copyright notice and this permission notice shall be included in all copies or substantial 
 *	portions of the Software.
 *
 *	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
 *	LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO 
 *	EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER 
 *	IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR 
 *	THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
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
