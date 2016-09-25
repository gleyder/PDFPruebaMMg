import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


/**
 * Created by gleyd on 25/9/2016.
 */
public class main {

    public static void main(String[] args) throws IOException, FileNotFoundException, DocumentException {




        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("sample1.pdf"));
        document.open();

        //Cambiar estilo de letras para crear parrafos(estilo y tamano)
        Font f=new Font(Font.FontFamily.TIMES_ROMAN,18.0f,Font.BOLD);
        Paragraph TituloJornada = new Paragraph("Los Colores de la Jornada X Son:\n\n",f);

        TituloJornada.setAlignment(1);


        //Llamar funcion para poner headers con titulo y logos

        DrawLogos(document);




        document.add(TituloJornada);
        //Crear Tabla
        PdfPTable table = new PdfPTable(2);


        //---------------------------------------------------------------------------------------------------

        PdfPCell cellOne = new PdfPCell(new Phrase("Ejemplo Full VIP"));
        PdfPCell cellTwo = new PdfPCell(RetornarColorImagen("Verde"));

        //   cellOne.setBorder(Rectangle.NO_BORDER);
        cellOne.setPadding(7);
        //   cellTwo.setBorder(Rectangle.NO_BORDER);
        cellTwo.setPadding(5);
        table.addCell(cellOne);
        table.addCell(cellTwo);


        //---------------------------------------------------------------------------------------------------
        cellOne = new PdfPCell(new Phrase("Ejemplo Patinaje Limitado"));
        cellTwo = new PdfPCell(RetornarColorImagen("Rojo"));

        //   cellOne.setBorder(Rectangle.NO_BORDER);
        cellOne.setPadding(7);
        //   cellTwo.setBorder(Rectangle.NO_BORDER);
        cellTwo.setPadding(5);

        table.addCell(cellOne);
        table.addCell(cellTwo);


        //---------------------------------------------------------------------------------------------------




        cellOne = new PdfPCell(new Phrase("Ejemplo Patinaje Ilimitado"));
        cellTwo = new PdfPCell(RetornarColorImagen("Azul"));

        //   cellOne.setBorder(Rectangle.NO_BORDER);
        cellOne.setPadding(7);
        //   cellTwo.setBorder(Rectangle.NO_BORDER);
        cellTwo.setPadding(5);

        table.addCell(cellOne);
        table.addCell(cellTwo);



        //---------------------------------------------------------------------------------------------------

        cellOne = new PdfPCell(new Phrase("Ejemplo Inflables Ilimitado"));
        cellTwo = new PdfPCell(RetornarColorImagen("Naranja"));

        //   cellOne.setBorder(Rectangle.NO_BORDER);
        cellOne.setPadding(7);
        //   cellTwo.setBorder(Rectangle.NO_BORDER);
        cellTwo.setPadding(5);

        table.addCell(cellOne);
        table.addCell(cellTwo);



        //---------------------------------------------------------------------------------------------------

        cellOne = new PdfPCell(new Phrase("Ejemplo Inflables limitado"));
        cellTwo = new PdfPCell(RetornarColorImagen("Rosado"));

        //   cellOne.setBorder(Rectangle.NO_BORDER);
        cellOne.setPadding(7);
        //   cellTwo.setBorder(Rectangle.NO_BORDER);
        cellTwo.setPadding(5);

        table.addCell(cellOne);
        table.addCell(cellTwo);



        //---------------------------------------------------------------------------------------------------


        document.add(table);





        document.add(new Paragraph("\nReporte de la Jornada:\n\n",f));
        DatosReporte(document);



        document.close();
        System.out.println("Done");





    }

    //Funcion para obtener la imagen dependiendo del color introducido

    public static Image RetornarColorImagen(String Color) throws IOException, BadElementException{
        Image img;
        if(Color == "Rojo"){
            Image img2 = Image.getInstance("Images/Colors/red.png");
            img = img2;
        }
        else if (Color =="Azul"){
            Image img2 = Image.getInstance("Images/Colors/blue.png");
            img = img2;
        }
        else if (Color =="Negro"){
            Image img2 = Image.getInstance("Images/Colors/black.png");
            img = img2;
        }
        else if (Color =="Blanco"){
            Image img2 = Image.getInstance("Images/Colors/white.png");
            img = img2;
        }
        else if (Color =="Amarillo"){
            Image img2 = Image.getInstance("Images/Colors/yellow.png");
            img = img2;
        }
        else if (Color =="Azul Celeste"){
            Image img2 = Image.getInstance("Images/Colors/cyan.png");
            img = img2;
        }
        else if (Color =="Rosado"){
            Image img2 = Image.getInstance("Images/Colors/pink.png");
            img = img2;
        }
        else if (Color =="Naranja"){
            Image img2 = Image.getInstance("Images/Colors/orange.png");
            img = img2;
        }
        else if (Color =="Morado"){
            Image img2 = Image.getInstance("Images/Colors/purple.png");
            img = img2;
        }
        else if (Color =="Dorado"){
            Image img2 = Image.getInstance("Images/Colors/gold.png");
            img = img2;
        }
        else if (Color =="Plateado"){
            Image img2 = Image.getInstance("Images/Colors/silver.png");
            img = img2;
        }
        else{
            Image img2 = Image.getInstance("Images/Colors/Green.png");
            img = img2;
        }

        img.scaleAbsoluteHeight(35);
        img.scaleAbsoluteWidth(200);

        return img;
    }


    //Funcion para definir la cabecera de los Reportes
    public static void DrawLogos(Document doc) throws DocumentException, BadElementException, IOException{

        //Crear Tabla
        PdfPTable table = new PdfPTable(new float[] { 5, 3 });
        table.setWidthPercentage(100);


        Image Header = Image.getInstance("Images/logos/KMPark.fw.png");
        Header.scaleAbsolute(150,130);

        PdfPCell cellOne = new PdfPCell(new Paragraph("Lo que Dewyn Tiene que pensar para agregar"));
        PdfPCell CellLogo = new PdfPCell(Header);
        CellLogo.setBorder(Rectangle.NO_BORDER);
        cellOne.setBorder(Rectangle.NO_BORDER);

        cellOne.setPadding(5);

        table.addCell(CellLogo);
        table.addCell(cellOne);

        doc.add(table);
        doc.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------\n"));
    }



    //Funcion Para Generar Datos para el reporte
    public static void DatosReporte(Document doc) throws DocumentException, BadElementException, IOException{

        //Crear Tabla
        PdfPTable table = new PdfPTable(new float[] { 3, 1 });
        table.setWidthPercentage(100);


        PdfPCell cellOne = new PdfPCell(new Paragraph("Cantidad de Boletas de Inflables Ilimitadas Vendidas:"));

        cellOne.setPadding(5);
        table.addCell(cellOne);
        table.addCell(new Paragraph("25"));

        cellOne = new PdfPCell(new Paragraph("Cantidad de Boletas de Inflables limitadas Vendidas:"));
        cellOne.setPadding(5);
        table.addCell(cellOne);
        table.addCell(new Paragraph("24"));

        cellOne = new PdfPCell(new Paragraph("Cantidad de Boletas de Patinaje Ilimitadas Vendidas:"));
        cellOne.setPadding(5);
        table.addCell(cellOne);
        table.addCell(new Paragraph("2534"));

        cellOne = new PdfPCell(new Paragraph("Cantidad de Boletas de Patinaje limitadas Vendidas:"));
        cellOne.setPadding(5);
        table.addCell(cellOne);
        table.addCell(new Paragraph("2225"));

        cellOne = new PdfPCell(new Paragraph("Cantidad de Boletas Full VIP Vendidas:"));
        cellOne.setPadding(5);
        table.addCell(cellOne);
        table.addCell(new Paragraph("60"));

        cellOne = new PdfPCell(new Paragraph("Cantidad de Facturas generadas:"));
        cellOne.setPadding(5);
        table.addCell(cellOne);
        table.addCell(new Paragraph("150"));

        cellOne = new PdfPCell(new Paragraph("Cantidad de Clientes en la Jornada:"));
        cellOne.setPadding(5);
        table.addCell(cellOne);
        table.addCell(new Paragraph("150"));

        cellOne = new PdfPCell(new Paragraph("Ganancias Generadas en la Jornada:"));
        cellOne.setPadding(5);
        table.addCell(cellOne);
        table.addCell(new Paragraph("15800"));



        doc.add(table);
    }
}
