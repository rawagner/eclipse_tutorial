package cz.muni.fi.eclipsetutorial.core;


import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class NewInstanceWizardPage extends WizardPage {
	
	private Text text;
	
	protected NewInstanceWizardPage() {
		super("New Instance");
		setTitle("New Instance");
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		setMessage("This wizard opens new eclipse launch configuration");
		
		Label label = new Label(container, SWT.NONE);
		label.setText("Configuration name: ");
		
		text = new Text(container, SWT.SINGLE | SWT.BORDER);
		
		setControl(container);
		setPageComplete(true);
	}
	
	public String getConfigurationName(){
		return text.getText();
	}
}