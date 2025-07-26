package util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import model.*;
import view.TelaMsg;

import java.io.*;
import java.util.ArrayList;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.filechooser.*;

public class GerarPDF 
{
    public GerarPDF(ArrayList<Cliente> lista) 
    {
        // Criar o FileChooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar Relatório PDF");
        fileChooser.setSelectedFile(new File("Relatorio_BeForward_MZ.pdf"));
        
        // Filtro para arquivos PDF
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos PDF (*.pdf)", "pdf");
        fileChooser.setFileFilter(filtro);
        fileChooser.setAcceptAllFileFilterUsed(false);
        
        // Mostrar o diálogo de salvar
        int resultado = fileChooser.showSaveDialog(null);
        
        if (resultado == JFileChooser.APPROVE_OPTION) 
        {
            File arquivoSelecionado = fileChooser.getSelectedFile();
            String nomeArquivo = arquivoSelecionado.getAbsolutePath();
            
            // Garantir que o arquivo tenha extensão .pdf
            if (!nomeArquivo.toLowerCase().endsWith(".pdf")) 
            {
                nomeArquivo += ".pdf";
            }
            
            // Chamar o método para gerar o PDF
            gerarPDF(lista, nomeArquivo);
        }
        else 
        {
        	new TelaMsg("Gerar PDF", "Operação cancelada pelo usuário.", "Cancelado");
        }
    }
    
    private void gerarPDF(ArrayList<Cliente> lista, String nomeArquivo)
    {
        DecimalFormat mt, tel, cil; 
        mt = new DecimalFormat("###,###,###,###.00 MZN");
        tel = new DecimalFormat("+258 #########");
        cil = new DecimalFormat("#### cc");
        
        Document documento = new Document(PageSize.A4.rotate());
        
        try 
        {
            PdfWriter.getInstance(documento, new FileOutputStream(nomeArquivo));
            documento.open();
            
            // Criar tabela para o cabeçalho com logo e título
            PdfPTable cabecalhoTable = new PdfPTable(2);
            cabecalhoTable.setWidthPercentage(100);
            cabecalhoTable.setWidths(new float[]{15f, 85f}); 
            
            // Adicionar logo
            try 
            {
                Image logo = Image.getInstance("./resources/imagens/BeForward_LOGO.png");
                logo.scaleToFit(60, 40); 
                PdfPCell logoCell = new PdfPCell(logo);
                logoCell.setBorder(Rectangle.NO_BORDER);
                logoCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                logoCell.setPadding(5);
                cabecalhoTable.addCell(logoCell);
            } catch (Exception e) 
            {
                // Se não conseguir carregar o logo, adicionar célula vazia
                PdfPCell logoCell = new PdfPCell(new Phrase(""));
                logoCell.setBorder(Rectangle.NO_BORDER);
                cabecalhoTable.addCell(logoCell);
            }
            
            // Criar célula para título e subtítulo
            Font tituloFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Font subtituloFont = new Font(Font.FontFamily.HELVETICA, 12, Font.ITALIC);
            
            Paragraph titulo = new Paragraph("RELATÓRIO DE COMPRAS - BEFORWARD MZ", tituloFont);
            titulo.setAlignment(Element.ALIGN_CENTER);
            
            Paragraph subtitulo = new Paragraph("Compras com Entrega Concluída e Em Trânsito", subtituloFont);
            subtitulo.setAlignment(Element.ALIGN_CENTER);
            subtitulo.setSpacingBefore(5);
            
            PdfPCell tituloCell = new PdfPCell();
            tituloCell.addElement(titulo);
            tituloCell.addElement(subtitulo);
            tituloCell.setBorder(Rectangle.NO_BORDER);
            tituloCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tituloCell.setPadding(5);
            cabecalhoTable.addCell(tituloCell);
            
            // Adicionar tabela do cabeçalho ao documento
            documento.add(cabecalhoTable);
            documento.add(new Paragraph("\n\n")); 
            
            // Configurações das tabelas
            String[] colunas = {"Tipo Cliente", "Telefone", "Nome", "Data Compra", "Estado", 
                               "Código", "Marca", "Modelo", "Cilindrada", "Preço"};
            float[] larguras = {15f, 12f, 18f, 10f, 12f, 8f, 10f, 10f, 8f, 12f};
            Font fonteCabecalho = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD, BaseColor.WHITE);
            Font fonteConteudo = new Font(Font.FontFamily.HELVETICA, 8);
            
            // Cor laranja para cabeçalhos das tabelas
            BaseColor corLaranja = new BaseColor(243, 156, 18);
            
            // Separar clientes por estado
            ArrayList<Cliente> entregaConcluida = new ArrayList<>();
            ArrayList<Cliente> emTransito = new ArrayList<>();
            
            for (int i = 0; i < lista.size(); i++) 
            {
                Cliente cliente = lista.get(i);
                String estado = cliente.getEstadoCompra().toLowerCase();
                
                if (estado.contains("entrega concluída") || estado.contains("entrega concluida")) 
                {
                    entregaConcluida.add(cliente);
                } else if (estado.contains("em trânsito") || estado.contains("em transito")) 
                {
                    emTransito.add(cliente);
                }
            }
            
            // TABELA 1: ENTREGA CONCLUÍDA
            if (entregaConcluida.size() > 0) 
            {
                Font tituloTabela = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
                Paragraph tituloEntregaConcluida = new Paragraph("ENTREGAS CONCLUÍDAS", tituloTabela);
                tituloEntregaConcluida.setAlignment(Element.ALIGN_LEFT);
                tituloEntregaConcluida.setSpacingAfter(10);
                documento.add(tituloEntregaConcluida);
                
                PdfPTable tabelaConcluida = new PdfPTable(colunas.length);
                tabelaConcluida.setWidthPercentage(100);
                tabelaConcluida.setWidths(larguras);
                
                // Cabeçalho da tabela de entrega concluída com cor laranja
                for (int i = 0; i < colunas.length; i++) 
                {
                    PdfPCell celula = new PdfPCell(new Phrase(colunas[i], fonteCabecalho));
                    celula.setBackgroundColor(corLaranja); 
                    celula.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celula.setPadding(8);
                    tabelaConcluida.addCell(celula);
                }
                
                // Adicionar dados dos clientes com entrega concluída
                for (int i = 0; i < entregaConcluida.size(); i++) 
                {
                    Cliente cliente = entregaConcluida.get(i);
                    
                    // Determinar tipo de cliente
                    String tipoCliente;
                    if (cliente instanceof Doutorado)
                        tipoCliente = "PART. DOUTORADO";
                    else if (cliente instanceof Normal) 
                    		tipoCliente = "PART. NORMAL";
                    else if (cliente instanceof Revendedor) 
                        	tipoCliente = "EMPR. REVENDEDOR";
                    else if (cliente instanceof Estado) 
                    		tipoCliente = "EMPR. ESTADO";
                    else 
                       tipoCliente = "DESCONHECIDO";
                    
                    
                    // Adicionar linha na tabela
                    String[] dados = 
                    {
                        tipoCliente,
                        tel.format(cliente.getTel()),
                        cliente.getNome(),
                        cliente.getDataCompra(),
                        cliente.getEstadoCompra(),
                        String.valueOf(cliente.getCodigo()),
                        cliente.getMarca(),
                        cliente.getModelo(),
                        cil.format(cliente.getCilindrada()),
                        mt.format(cliente.getPreco())
                    };
                    
                    for (int j = 0; j < dados.length; j++) 
                    {
                        PdfPCell celula = new PdfPCell(new Phrase(dados[j], fonteConteudo));
                        celula.setPadding(5);
                        celula.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabelaConcluida.addCell(celula);
                    }
                }
                
                documento.add(tabelaConcluida);
                documento.add(new Paragraph("\n"));
            }
            
            // TABELA 2: EM TRÂNSITO
            if (emTransito.size() > 0) 
            {
                // Adicionar espaço suficiente para forçar nova página se necessário
                documento.add(new Paragraph("\n\n\n\n\n\n\n"));
                
                Font tituloTabela = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
                Paragraph tituloEmTransito = new Paragraph("ENTREGAS EM TRÂNSITO", tituloTabela);
                tituloEmTransito.setAlignment(Element.ALIGN_LEFT);
                tituloEmTransito.setSpacingAfter(10);
                tituloEmTransito.setKeepTogether(true);
                documento.add(tituloEmTransito);
                
                PdfPTable tabelaTransito = new PdfPTable(colunas.length);
                tabelaTransito.setWidthPercentage(100);
                tabelaTransito.setWidths(larguras);
                tabelaTransito.setKeepTogether(true);
                
                // Cabeçalho da tabela em trânsito com cor laranja
                for (int i = 0; i < colunas.length; i++) 
                {
                    PdfPCell celula = new PdfPCell(new Phrase(colunas[i], fonteCabecalho));
                    celula.setBackgroundColor(corLaranja);
                    celula.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celula.setPadding(8);
                    tabelaTransito.addCell(celula);
                }
                
                // Adicionar dados dos clientes em trânsito
                for (int i = 0; i < emTransito.size(); i++) 
                {
                    Cliente cliente = emTransito.get(i);
                    
                    // Determinar tipo de cliente
                    String tipoCliente;
                    if (cliente instanceof Doutorado) 
                        tipoCliente = "PART. DOUTORADO";
                    else if (cliente instanceof Normal) 
                        tipoCliente = "PART. NORMAL";
                    else if (cliente instanceof Revendedor) 
                        tipoCliente = "EMPR. REVENDEDOR";
                    else if (cliente instanceof Estado) 
                        tipoCliente = "EMPR. ESTADO";
                    else 
                        tipoCliente = "DESCONHECIDO";
                    
                    
                    // Adicionar linha na tabela
                    String[] dados = 
                    {
                        tipoCliente,
                        tel.format(cliente.getTel()),
                        cliente.getNome(),
                        cliente.getDataCompra(),
                        cliente.getEstadoCompra(),
                        String.valueOf(cliente.getCodigo()),
                        cliente.getMarca(),
                        cliente.getModelo(),
                        cil.format(cliente.getCilindrada()),
                        mt.format(cliente.getPreco())
                    };
                    
                    for (int j = 0; j < dados.length; j++) 
                    {
                        PdfPCell celula = new PdfPCell(new Phrase(dados[j], fonteConteudo));
                        celula.setPadding(5);
                        celula.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabelaTransito.addCell(celula);
                    }
                }
                
                documento.add(tabelaTransito);
            }
            
            // Verificar se encontrou dados
            if (entregaConcluida.size() == 0 && emTransito.size() == 0) 
            {
                Paragraph semDados = new Paragraph("Nenhuma compra encontrada com os critérios especificados.");
                documento.add(semDados);
            }
            
            new TelaMsg("Gerar PDF", "PDF criado com sucesso!", "Verifique sua pasta de Documentos");
            
        } catch (DocumentException | IOException e) 
        {
        	new TelaMsg("Gerar PDF", "Erro ao gerar PDF!", e.getMessage());
            e.printStackTrace();
        } finally 
        {
            documento.close();
        }
    }
}