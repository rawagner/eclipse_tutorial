package cz.muni.fi.eclipsetutorial.core;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.jboss.reddeer.junit.runner.RedDeerSuite;
import org.jboss.reddeer.swt.impl.text.LabeledText;

@RunWith(RedDeerSuite.class)
public class WizardTest {
	
	@Test
	public void testNewInstanceWizard() throws InterruptedException{
		InstanceWizard wizard = new InstanceWizard();
		wizard.open();
		wizard.setConfigurationName("myTestConfiguration");
		wizard.finish();
		assertEquals("myTestConfiguration",new LabeledText("Name:").getText());	
	}
}
