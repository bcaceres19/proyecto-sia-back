package com.gov.project.sia.service;


import com.gov.project.sia.dto.ReportePedidosDto;
import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;

public interface IGenerarReporteService {

    String generarReportePedidos(String codigoReporte) throws JRException, FileNotFoundException;

}
