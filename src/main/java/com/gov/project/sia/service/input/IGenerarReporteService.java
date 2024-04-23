package com.gov.project.sia.service.input;


import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;

public interface IGenerarReporteService {

    String generarReportePedidos(String codigoReporte) throws JRException, FileNotFoundException;

}
