package HeiMa;

import java.io.File;
import java.io.FileFilter;

public class FileFilterImpl implements FileFilter{
	@Override
	public boolean accept(File pathname) {
//		if(pathname.isDirectory())
//			return true;
//		return pathname.getName().toLowerCase().endsWith(".xml");
		return pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".xml");
	}
}
