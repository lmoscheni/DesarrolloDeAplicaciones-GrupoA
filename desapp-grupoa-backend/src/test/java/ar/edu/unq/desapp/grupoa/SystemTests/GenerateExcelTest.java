package ar.edu.unq.desapp.grupoa.SystemTests;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import junit.framework.TestCase;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import ar.edu.unq.desapp.grupoa.helpers.exportation.GenerateExcel;

public class GenerateExcelTest extends TestCase {

    public void testExportExcel() throws Exception {

        String excelFile = "./demo.xls";
        List<String> fila1 = new ArrayList<String>();
        fila1.add("Nombre");
        fila1.add("Apellido");
        fila1.add("Edad ");
        List<String> fila2 = new ArrayList<String>();
        fila2.add("Julian");
        fila2.add("Skalic");
        fila2.add("22 ");
        @SuppressWarnings("rawtypes")
        List filas = new ArrayList<ArrayList>();
        filas.add(fila1);
        filas.add(fila2);

        Vector<String> v = new Vector<String>();
        Vector<String> vTest = new Vector<String>();
        v.addElement("Nombre,Apellido,Edad");
        v.addElement("Julian,Skalic,22");

        GenerateExcel.crearExcel(v, "Ejemplo", excelFile);

        FileInputStream input = new FileInputStream(excelFile);
        POIFSFileSystem fs = new POIFSFileSystem(input);
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow row;
        String s = "";

        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
            int numberRows = row.getLastCellNum();
            for (int j = 0; j < numberRows; j++) {
                if (2 != j) {
                    s = s + row.getCell(j).getStringCellValue() + ",";
                } else {
                    s = s + row.getCell(j).getStringCellValue();
                }

            }
            vTest.addElement(s);
            s = "";
        }

        for (int x = 0; x < v.size(); x++) {

            String[] s1 = vTest.get(x).toString().split(" ,");
            @SuppressWarnings("unchecked")
            ArrayList<String> s2 = (ArrayList<String>) filas.get(x);

            for (int k = 0; k < s1.length; k++) {
                assertEquals(s2.get(k), s1[k]);
            }
        }
    }

}
