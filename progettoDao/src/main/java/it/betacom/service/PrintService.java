package it.betacom.service;

import java.sql.SQLException;
import java.util.List;

import model.Libro;

public interface PrintService<T> {
	void saveListAsPdf();
	void saveListAsCsv();
	void saveListAsTxt();
	void saveAsPdf(T t);
	void saveAsCsv(T t);
	void saveAsTxt(T t);
}