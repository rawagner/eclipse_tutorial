package cz.muni.fi.eclipsetutorial.core;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.pde.launching.IPDELauncherConstants;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

public class NewInstanceWizard extends Wizard implements INewWizard {
	private NewInstanceWizardPage firstPage;

	@Override
	public void addPages() {
		setWindowTitle("New instance");
		firstPage = new NewInstanceWizardPage();
		addPage(firstPage);
	}
	
	@Override
	public boolean performFinish() {
		ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfigurationType type = manager.getLaunchConfigurationType
				(IPDELauncherConstants.ECLIPSE_APPLICATION_LAUNCH_CONFIGURATION_TYPE);
		try {
			String configName = firstPage.getConfigurationName();
			if(configName == null || configName.equals("")){
				configName = "New Instance";
			}
			ILaunchConfigurationWorkingCopy workingCopy = type.newInstance(null, configName);
			//we can alter the configuration here
			DebugUITools.openLaunchConfigurationDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
					workingCopy.doSave(),"org.eclipse.debug.ui.launchGroup.run", null);
		} catch (CoreException ex) {
			ex.printStackTrace();
		}
		return true;
	}
	
	public void init(IWorkbench arg0, IStructuredSelection arg1) {
	}
}