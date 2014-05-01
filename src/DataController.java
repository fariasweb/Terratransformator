import java.io.*;

/**
 * 
 * @author farias
 * 
 */

public class DataController {

	File f;
	FileReader fr;
	BufferedReader bf;
	FileWriter fw;
	PrintWriter out;

	/**
	 * 
	 */
	public void DataController() {
		f = null;
		fr = null;
		bf = null;
		fw = null;
		out = null;
	}

	/**
	 * Pre: Tener permisos para aceder al directorio y al archivo Poder
	 * escribir/leer del fichero Ser un fichero Post: El fichero en caso de no
	 * existir se crea
	 * 
	 * @param path
	 * @throws Exception
	 */
	public void open(String path) throws Exception {

		f = new File(path);

		if (!f.exists())
			f.createNewFile();
		if (!f.exists())
			throw new Exception(path + " does not exist");
		if (!f.isFile())
			throw new Exception(path + " is not a file");
		if (!f.canRead())
			throw new Exception("The file " + path + " can not write");
		if (!f.canWrite())
			throw new Exception("The file " + path + " cant' write");

		fr = new FileReader(path);
		bf = new BufferedReader(fr);

		fw = new FileWriter(f);
		out = new PrintWriter(fw);
	}

	/**
	 * Pre: El archivo debe estar abierto
	 * Post: Devuelve parte de la informaci�n, en caso de ser null
	 * 		 es que el archivo a finalizado
	 * @param path
	 * @throws Exception
	 */
	public String read() throws Exception {

		if (f == null)
			throw new Exception("Any file indicated");

		return bf.readLine();
	}

	/**
	 * Pre: El fichero debe estar abierto
	 * Post: A�ade al final de archivo la informacion
	 * @param path
	 * @param file
	 * @param data
	 * @param append
	 * @throws Exception
	 */
	public void write(String data) throws Exception {

		if (f == null)
			throw new Exception("Any file indicated");

		if (data == null || data.length() == 0)
			throw new Exception("No information to write");

		// Write
		out.println(data);

		out.flush();

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void close() throws Exception {

		f = null;

		fr.close();
		fr = null;
		bf.close();
		bf = null;
		fw.close();
		fw = null;
		out.close();
		out = null;

	}

}
