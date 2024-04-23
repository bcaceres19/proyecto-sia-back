package com.gov.project.sia.service.input.impl;

import com.google.gson.Gson;
import com.gov.project.sia.dto.ReportePedidosDto;
import com.gov.project.sia.repository.PedidoRepository;
import com.gov.project.sia.service.input.IGenerarReporteService;
import com.gov.project.sia.utils.mapper.PedidoMapper;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JsonDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.*;

@Service
@RequiredArgsConstructor
public class GenerarReportePedidos implements IGenerarReporteService {

    private final PedidoRepository pedidoRepository;

    private final PedidoMapper pedidoMapper;

   private String armarPdf(ReportePedidosDto reportePedidosDto) throws FileNotFoundException, JRException {
       File file = ResourceUtils.getFile("src/main/resources/reports/ReportePedido.jrxml");
       JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
       Gson gson = new Gson();
       String data = gson.toJson(reportePedidosDto);
       try (FileWriter fileWriter = new FileWriter("src/main/resources/reports/informacion.json")) {
           fileWriter.write(data);
       } catch (IOException e) {
           e.printStackTrace();
       }
       File datas = ResourceUtils.getFile("src/main/resources/reports/informacion.json");
       JRDataSource dataSource = new JsonDataSource(datas);
       JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
       final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
       JRExporter exporter = new JRPdfExporter();
       exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
       exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
       exporter.exportReport();
       byte[] output = outputStream.toByteArray();
       String pdfbase64 = Base64.getEncoder().encodeToString(output);
       return pdfbase64;
   }

    @Override
    public String generarReportePedidos(String codigoPedido) throws JRException, FileNotFoundException {
       ReportePedidosDto dataReporte = pedidoRepository.buscarDataRepore(codigoPedido).stream().map(pedidoMapper::objectToReportePedidoDto).toList().get(0);
       dataReporte.setDataSource(pedidoRepository.buscarDataSubReporte(codigoPedido).stream().map(pedidoMapper::objectToReportePedidosSubInfoDto).toList());
       return armarPdf(dataReporte);
    }

}
