package Test.Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnayzer implements IRetryAnalyzer {
	
	int i = 1;
	int count = 2;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(!result.isSuccess()){
			i++;
			if(i < count) {
				System.out.println(result.getTestName() + "  Retry  "+ i);
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}

}
