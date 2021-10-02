package file;

import dto.MovieDTO;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Iterator;

public class ReadMovie {
    public static final int COLUMN_INDEX_MOVIE_ID = 0;
    public static final int COLUMN_INDEX_ACTOR = 1;
    public static final int COLUMN_INDEX_CONTENT = 2;
    public static final int COLUMN_INDEX_DIRECTOR = 3;
    public static final int COLUMN_INDEX_DURATION = 4;
    public static final int COLUMN_INDEX_FROM_DATE = 5;
    public static final int COLUMN_INDEX_TO_DATE = 6;
    public static final int COLUMN_INDEX_MOVIE_PRODUCTION_COMPANY = 7;
    public static final int COLUMN_INDEX_VERSION = 8;
    public static final int COLUMN_INDEX_NAME_ENG = 9;
    public static final int COLUMN_INDEX_NAME_VN = 10;
    public static final int COLUMN_INDEX_LARGE_IMAGE = 11;
    public static final int COLUMN_INDEX_SMALL_IMAGE = 12;

    public static MovieDTO readExcel() throw IOException {
        String excelFilePath = "Data.xlsx";
        InputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = getWorkbook(inputStream, excelFilePath);
        Sheet sheet = workbook.getSheet("MOVIE");
        MovieDTO  movieDTO = new MovieDTO();
        // Get all rows
        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            if (nextRow.getRowNum() == 0) {
                // Ignore header
                continue;
            }
            // Get all cells
            Iterator<Cell> cellIterator = nextRow.cellIterator();

            // Read cells and set value for book object
            while (cellIterator.hasNext()) {
                //Read cell
                Cell cell = cellIterator.next();
                Object cellValue = getCellValue(cell);
                if (cellValue == null || cellValue.toString().isEmpty()) {
                    continue;
                }
                // Set value for book object
                int columnIndex = cell.getColumnIndex();
                switch (columnIndex) {
                    case COLUMN_INDEX_MOVIE_ID:
                        movieDTO.setMovieId(String.valueOf(getCellValue(cell)));
                        break;
                    case COLUMN_INDEX_ACTOR:
                        movieDTO.setActor(String.valueOf(getCellValue(cell)));
                        break;
                    case COLUMN_INDEX_CONTENT:
                        movieDTO.setContent(String.valueOf(getCellValue(cell)));
                        break;
                    case COLUMN_INDEX_DIRECTOR:
                        movieDTO.setDirector(String.valueOf(getCellValue(cell)));
                        break;
                    case COLUMN_INDEX_DURATION:
                        movieDTO.setDuration(new BigDecimal((double) cellValue).intValue());
                        break;
                    case COLUMN_INDEX_FROM_DATE:
                        movieDTO.setFromDate();
                        break;
                    case COLUMN_INDEX_TO_DATE:
                        movieDTO.setToDate();
                        break;

                    case COLUMN_INDEX_MOVIE_PRODUCTION_COMPANY:
                        movieDTO.setMovieProductionCompany(String.valueOf(getCellValue(cell)));
                        break;
                    case COLUMN_INDEX_VERSION:
                        movieDTO.setVersion(String.valueOf(getCellValue(cell)));
                        break;
                    case COLUMN_INDEX_NAME_ENG:
                        movieDTO.setMovieNameEn(String.valueOf(getCellValue(cell)));
                        break;
                    case COLUMN_INDEX_NAME_VN:
                        movieDTO.setMovieNameVn(String.valueOf(getCellValue(cell)));
                        break;
                    case COLUMN_INDEX_LARGE_IMAGE:
                        movieDTO.setLargeImage(String.valueOf(getCellValue(cell)));
                        break;
                    case COLUMN_INDEX_SMALL_IMAGE:
                        movieDTO.setSmallImage(String.valueOf(getCellValue(cell)));
                        break;
                    default:
                }

            }
        }

        workbook.close();
        inputStream.close();

        return movieDTO;
    }

    private static Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook = null;
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }

        return workbook;
    }

    private static Object getCellValue(Cell cell) {
        CellType cellType = cell.getCellTypeEnum();
        Object cellValue = null;
        switch (cellType) {
            case BOOLEAN:
                cellValue = cell.getBooleanCellValue();
                break;
            case FORMULA:
                Workbook workbook = cell.getSheet().getWorkbook();
                FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                cellValue = evaluator.evaluate(cell).getNumberValue();
                break;
            case NUMERIC:
                cellValue = cell.getNumericCellValue();
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            default:
                break;
        }

        return cellValue;
    }

}
