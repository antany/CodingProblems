package CodeJamPractice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SaveUniverseProblem {

	public static void main(String[] args) throws Exception {
		File inputFile = new File("d:/input.in");
		BufferedReader buffReader = new BufferedReader(new FileReader(inputFile));
		PrintWriter pw = new PrintWriter(new File("d:/output.ot"));
		String str = buffReader.readLine();
		int caseCount = Integer.valueOf(str);
		for (int i = 1; i <= caseCount; i++) {
			int searchEngineCount = Integer.valueOf(buffReader.readLine());
			String[] searchEngines = new String[searchEngineCount];
			Integer[] noOfOccurences = new Integer[searchEngineCount];
			for (int j = 0; j < searchEngineCount; j++) {
				searchEngines[j] = buffReader.readLine();
				noOfOccurences[j] = 0;
			}
			int queryCount = Integer.valueOf(buffReader.readLine());
			List<String> list = Arrays.asList(searchEngines);
			int counter = 0;
			for (int j = 0; j < queryCount; j++) {
				String query = buffReader.readLine();
				int index = list.indexOf(query);

				if (index != -1) {
					noOfOccurences[index] = noOfOccurences[index] + 1;
				}

				Integer min = Arrays.asList(noOfOccurences).stream().min(Comparator.comparing(Integer::valueOf)).get();
				if (min == 1) {
					counter++;
					for (int l = 0; l < noOfOccurences.length; l++) {
						if (l != index)
							noOfOccurences[l] = 0;
					}
				}
			}

			pw.println("Case #" + i + ": " + counter);
		}
		buffReader.close();
		pw.close();
	}
}
