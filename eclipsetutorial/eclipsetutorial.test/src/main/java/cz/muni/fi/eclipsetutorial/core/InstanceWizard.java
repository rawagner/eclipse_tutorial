package cz.muni.fi.eclipsetutorial.core;

import org.jboss.reddeer.eclipse.jface.wizard.NewWizardDialog;
import org.jboss.reddeer.swt.impl.text.LabeledText;


public class InstanceWizard extends NewWizardDialog{
	
	public InstanceWizard(){
		super("Other","New Instance");
	}
	
	public void setConfigurationName(String text){
		new LabeledText("Configuration name: ").setText(text);
	}
	
	public void getConfigurationName(){
		new LabeledText("Configuration name:").getText();
	}
	
}
