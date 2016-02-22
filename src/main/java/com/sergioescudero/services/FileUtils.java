package com.sergioescudero.services;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileUtils {

	/**
	 * Copia el contenido del fichero 'fileSource' en el fichero 'newFile'
	 * 
	 * @param fileSource
	 * @param newFile
	 * @return
	 * @throws Exception
	 */
	public static boolean copyFile(File fileSource, File newFile) throws Exception {

		FileChannel source = null;
		FileChannel destination = null;
		boolean copyOk = true;

		try {

			source = new FileInputStream(fileSource).getChannel();
			destination = new FileOutputStream(newFile).getChannel();

			long count = 0;
			long size = source.size();

			do {

				count += destination.transferFrom(source, 0, size - count);

			} while (count < size);

		} catch (IOException e) {
			copyOk = false;
			throw new Exception(e);

		} finally {
			if (source != null)
				source.close();

			if (destination != null)
				destination.close();
		}
		return copyOk;
	}

	/**
	 * Borra un directorio de manera recursiva, para borrar un directorio este
	 * debe existir
	 * 
	 * @param directory
	 * @return
	 */
	public static void deleteDirectoryRecursive(File directory) throws IOException {
		if (!directory.exists())
			throw new IOException("directory: ".concat(directory.getAbsolutePath().concat(" can't be deleted because it doesn't exit")));
		if (!directory.isDirectory())
			throw new IOException("file: ".concat(directory.getAbsolutePath().concat(" can't be deleted because it doesn't exit")));
		File files[] = directory.listFiles();
		for (File file : files) {
			if (file.isFile())
				file.delete();
			else
				deleteDirectoryRecursive(file);
		}
		directory.delete();

	}

	public static File createTempFile(String tmpFilePrefix, String tmpFileSuffix, File tmpFileDir, String report) {
		File tmpFile = null;
		try {
			tmpFile = File.createTempFile(tmpFilePrefix, tmpFileSuffix, tmpFileDir);
			BufferedWriter out = new BufferedWriter(new FileWriter(tmpFile));
			out.write(report);
			out.close();
			tmpFile.deleteOnExit();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tmpFile;
	}

	public static boolean copyFile(ByteArrayInputStream streamSource, File newFile) throws IOException {

		boolean copyOk = true;

		FileOutputStream fos = new FileOutputStream(newFile);
		int data;
		while ((data = streamSource.read()) != -1) {
			char ch = (char) data;
			fos.write(ch);
		}
		fos.flush();
		fos.close();
		return copyOk;
	}

	/**
	 * Metodo que comprueba si un fichero o directorio existe y si puede ser
	 * leido
	 * 
	 * @param fileSource
	 *            - archivo a procesar
	 * @throws IOException
	 *             - Excepcion lanzada si el fichero o directorio no existe o si
	 *             no puede ser leido
	 */
	public static void preProcessFileSource(File fileSource) throws IOException {
		if (!fileSource.exists())
			throw new IOException("file: ".concat(fileSource.getAbsolutePath()).concat(" does not exists"));
		if (!fileSource.canRead())
			throw new IOException("file: ".concat(fileSource.getAbsolutePath()).concat(" cannot be read, please check file permissions"));

	}

	public static void createDirectory(File directory) throws IOException {
		if (!isDirectoryByName(directory))
			throw new IOException("file ".concat(directory.getAbsolutePath()).concat(" is not a directory"));
		createFileOrDirectoryIfNotExists(directory);
	}

	public static void createFileOrDirectoryIfNotExists(File file) throws IOException {
		if (!file.exists()) {
			String fileOrDirectory;
			String errorMessage;
			boolean create = false;
			if (isDirectoryByName(file)) {
				fileOrDirectory = "directory";
				errorMessage = "cannot be created, please check file permissions";
				create = file.mkdirs();
			} else {
				fileOrDirectory = "file";
				errorMessage = "cannot be created, please check directory permissions";
				create = file.createNewFile();
			}
			if (!create)
				throw new IOException(fileOrDirectory.concat(" ").concat(file.getAbsolutePath()).concat(" ").concat(errorMessage));

		}
	}

	private static boolean isDirectoryByName(File file) throws IOException {
		String name = file.getName();
		if (name.length() == 0)
			throw new IOException("file name must not be empty");

		if (name.indexOf(".") == -1)
			return true; // isDirectory
		else
			return false; // isFile

	}

}
