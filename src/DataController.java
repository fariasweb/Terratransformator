import java.io.*;

/**
 * 
 * @author farias
 * 
 */

public class DataController {

	/**
	 * 
	 */
	public void DataController() {

	}

	/**
	 * TODO: Cachee??
	 * @param path
	 * @throws Exception 
	 */
	public String read(String path) throws Exception {

		File f = new File(path);

		if (!f.exists())
			throw new Exception(path + " does not exist");
		if (!f.isFile())
			throw new Exception(path + " is not a file");
		if (!f.canRead())
			throw new Exception("The file " + path + " can not write");

		FileReader fr = new FileReader(path);
		BufferedReader bf = new BufferedReader(fr);
		String cad, data = "";

		while ((cad = bf.readLine()) != null) {
			data += cad;
		}

		return data;
	}

	/**
	 * 
	 * @param path
	 * @param file
	 * @param data
	 * @param append
	 * @throws Exception 
	 */
	public void write(String path, String file, String data, boolean append) throws Exception {

			if (data == null || data.length() == 0)
				throw new Exception("No information to write");

			File f = new File(path);
			f.mkdir();

			File fichero = new File(f, file);
			if (!fichero.exists()) {
				fichero.createNewFile();
			}

			if (!fichero.canWrite())
				throw new Exception("The file " + file + " cant' write");

			FileWriter fw = new FileWriter(fichero, append);
			PrintWriter out = new PrintWriter(fw);

			// Write
			out.println(data);

			out.flush();
			out.close();

	}

}
