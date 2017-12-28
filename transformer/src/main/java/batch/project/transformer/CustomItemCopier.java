package batch.project.transformer;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * @author ib3d68bn
 *
 */
public class CustomItemCopier {
	
	public void copier() {
		File source = new File("\\transformer\\src\\ressouces\\csv\\input.csv");
		File dest = new File("\\transformer\\src\\ressouces\\csv\\output.csv");
		try {
		    FileUtils.copyDirectory(source, dest);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
}
