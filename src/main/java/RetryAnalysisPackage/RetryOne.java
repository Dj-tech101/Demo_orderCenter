package RetryAnalysisPackage;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryOne implements IRetryAnalyzer {
	private int count = 0;

	private int maxCount = 2;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if (count < maxCount) {

			count++;

			return true;

		}
		return false;
	}


}