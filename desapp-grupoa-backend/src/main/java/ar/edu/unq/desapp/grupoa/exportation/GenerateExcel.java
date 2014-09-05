package ar.edu.unq.desapp.grupoa.exportation;
import java.io.FileOutputStream;
import java.util.Vector;
import java.util.StringTokenizer;
 
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
 
/**
 * Para generar una hoja Excel Simple
 *
 * @author jose
 *
 */
public class GenerateExcel {
 
    /**
     * Para escribir el contenido de una celda.
     *
     * @param row Row.
     * @param i posicion en la fila.
     * @param value texto a escribir.
     * @param style estilo de la celda.
     */
    public static void createCell(Row row, int positionOfRow, String text, CellStyle style) {
        Cell cell = row.createCell(positionOfRow);
        text = text + " ";
        cell.setCellValue(text);
        if (style != null)
            cell.setCellStyle(style);
    }
    //-------------
 
    /**
     * Crea una hoja Excel con el contenido especificado.
     * @param v Vector con los datos a escribir en la hoja.
     * @param namesheet nombre de la hoja.
     * @param filename path del fichero donde se escribe.
     */
    public static void crearExcel(Vector v, String namesheet, String filename)
            throws Exception {
        try {
            Workbook wb = new HSSFWorkbook();
            CreationHelper createHelper = wb.getCreationHelper();
            Sheet sheet = wb.createSheet(namesheet);
            int filas = v.size();
            for (int i = 0; i < filas; i++) {
                String fila = (String) v.elementAt(i);
                StringTokenizer st = new StringTokenizer(fila, ",");
                Row row = sheet.createRow((short) i);
                int j = 0;
                while (st.hasMoreTokens()) {
                    String token = st.nextToken();
                    // para la cabecera, la primera fila, aplicamos un estilo (negrita y color de fondo azul)
                    if (i == 0) {
                        CellStyle style = wb.createCellStyle();
                        style.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex());
                        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
                        Font font = wb.createFont();
                        font.setFontName("Courier New");
                        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
                        font.setColor(IndexedColors.WHITE.getIndex());
                        style.setFont(font);
                        createCell(row, j, token, style);
                    } else
                        createCell(row, j, token, null);
 
                    j = j + 1;
 
                }
 
            }
 
            // Asignar automaticamente el tamaño de las celdas en funcion del contenido
            for (int i = 0; i < filas; i++) {
                sheet.autoSizeColumn((short) i);
            }
 
            // Escribir el fichero.
            FileOutputStream fileOut = new FileOutputStream(filename);
            wb.write(fileOut);
            fileOut.close();
 
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    // ------------------
// 
//    /**
//     * Para probar el correcto funcionamiento de la clase.
//     * @param args argumentos de entrada.
//     */
//    public static void main(String[] args) {
//        try {
// 
//            //Datos a escribir
//            Vector v = new Vector();
//            v.addElement("IDENTIFICADOR ,ID_CODIGO ,ESTADO ,DESCRIPCION");
//            v.addElement("34567,CODIGO_00,Critica,Esto es un texto muy largo \r\n Esto es un texto muy largo");
//            v.addElement("34568,CODIGO_01,Baja,Esto es un texto muy largo \r\n Esto es un texto muy largo");
//            v.addElement("34569,CODIGO_02,Media,Esto es un texto muy largo \r\n Esto es un texto muy largo");
// 
//            // Generar el fichero
//            GenerateExcel.crearExcel(v, "Ejemplo", "/home/julian/Escritorio/demo.xls");
// 
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    // ----
// 
}