package com.java1234.util;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

/**
 * ��дEXCEL�ļ�
 */
public class POIUtils {
	
	
	private static final String position_title = "title";
	private static final String position_body = "body";
	
	
	/**
	 * �ж�excel�汾
	 * @param in
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	private static Workbook openWorkbook(InputStream in, String filename)
			throws IOException {
		Workbook wb = null;
		if (filename.endsWith(".xlsx")) {
			wb = new XSSFWorkbook(in);// Excel 2007
		} else {
			wb = new HSSFWorkbook(in);// Excel 2003
		}
		return wb;
	}

	/**
	 * �����ļ�·���͹������±굼��Excel����
	 * @param fileName �ļ���
	 * @param sheetIndex �������±�
	 * @return
	 * @throws Exception
	 */
	public static List<List<String>> getExcelData(MultipartFile file , String fileName,int sheetIndex) throws Exception {
		List<List<String>> dataLst = new ArrayList<List<String>>();
		Workbook wb = openWorkbook(file.getInputStream(), fileName);
		Sheet sheet = (Sheet) wb.getSheetAt(sheetIndex);// �л�������
		Row row = null;
		Cell cell = null;

		int totalRows = sheet.getPhysicalNumberOfRows();
		/** �õ�Excel������ */
		int totalCells = totalRows >= 1 && sheet.getRow(0) != null ? sheet
				.getRow(0).getPhysicalNumberOfCells() : 0;
		for (int r = 0; r < totalRows; r++) {
			row = sheet.getRow(r);
			if (row == null || curRowInsideNull(row, totalCells))
				continue;
			List<String> rowLst = new ArrayList<String>();
			for (int c = 0; c < totalCells; c++) {
				cell = row.getCell(c);
				String cellValue = "";
				if (null != cell) {
					// �������ж����ݵ�����
					switch (cell.getCellType()) {
					case HSSFCell.CELL_TYPE_NUMERIC: // ����
						int cellStyle = cell.getCellStyle().getDataFormat();
						String cellStyleStr = cell.getCellStyle().getDataFormatString();
						if ("0.00_);[Red]\\(0.00\\)".equals(cellStyleStr)) {
							NumberFormat f = new DecimalFormat("#.##");
							cellValue = (f.format((cell.getNumericCellValue())) + "")
									.trim();
						} else if (HSSFDateUtil.isCellDateFormatted(cell)) {
							cellValue = HSSFDateUtil.getJavaDate(
									cell.getNumericCellValue()).toString();
						} else if ( cellStyle == 58 || cellStyle == 179 || "m\"��\"d\"��\";@".equals(cellStyleStr)) {
							// �����Զ������ڸ�ʽ��m��d��(ͨ���жϵ�Ԫ��ĸ�ʽid�����id��ֵ��58)
							SimpleDateFormat sdf = new SimpleDateFormat(
									"yyyy-MM-dd");
							double value = cell.getNumericCellValue();
							Date date = org.apache.poi.ss.usermodel.DateUtil
									.getJavaDate(value);
							cellValue = sdf.format(date);
//						} else if ((cellStyle == 181 || cellStyle == 177|| cellStyle == 176)&& cellStyleStr.endsWith("@")) { 
							//���ڼ� Excel�е������Զ����ʽ cellStyle���̶����ʲ���  "[$-804]aaaa;@"���ж�							
						} else if ("[$-804]aaaa;@".equals(cellStyleStr)) {
							SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
							double value = cell.getNumericCellValue();
							Date date = org.apache.poi.ss.usermodel.DateUtil
									.getJavaDate(value);
							cellValue = sdf.format(date);

						} else {
							NumberFormat f = new DecimalFormat("#.##");
							cellValue = (f.format((cell.getNumericCellValue())) + "")
									.trim();
						}
						break;
					case HSSFCell.CELL_TYPE_STRING: // �ַ���
						cellValue = cell.getStringCellValue();
						break;
					case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
						cellValue = cell.getBooleanCellValue() + "";
						break;
					case HSSFCell.CELL_TYPE_FORMULA: // ��ʽ
						try {
							cellValue = String.valueOf(cell.getNumericCellValue());
						} catch (IllegalStateException e) {
							try {
								cellValue = String.valueOf(cell.getRichStringCellValue());
							} catch (Exception e1) {
								cellValue="";
							}
						}
						break;
					case HSSFCell.CELL_TYPE_BLANK: // ��ֵ
//						cellValue = "";
						break;

					case HSSFCell.CELL_TYPE_ERROR: // ����
//						cellValue = "�Ƿ��ַ�";
						break;
					default:
//						cellValue = "δ֪����";
						break;
					}
				}
				rowLst.add(cellValue);
			}
			dataLst.add(rowLst);
		}
		return dataLst;
	}

	/**
	 * �жϵ�ǰ�������е�Ԫ���Ƿ�Ϊ��
	 * 
	 * @param row
	 * @param totalCells
	 * @return
	 */
	private static boolean curRowInsideNull(Row row, int totalCells) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < totalCells; i++) {
			row.getCell(i, HSSFRow.RETURN_BLANK_AS_NULL);
			Cell cell = row.getCell(i, HSSFRow.RETURN_BLANK_AS_NULL);
			if (cell != null) {
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					sb.append(cell.getStringCellValue().trim());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					sb.append(String.valueOf(cell.getNumericCellValue()));
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					sb.append(String.valueOf(cell.getBooleanCellValue()));
					break;
				case Cell.CELL_TYPE_FORMULA://�жϹ�ʽ���ɵĽ��
					String value = "";
					try {
						value = String.valueOf(cell.getNumericCellValue());
					} catch (IllegalStateException e) {
						try {
							value = String.valueOf(cell.getRichStringCellValue());
						} catch (Exception e1) {
							value="";
						}
					}
					sb.append(value);
					break;
				default:
					break;
				}
			}
		}
		if (sb.toString().trim().equals(""))
			return true;
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public static HSSFWorkbook handleDataToExcel(List list,Class clazz,String sheetName,int pageSize) throws Exception{
		
		HSSFWorkbook workbook = null;
		workbook = new HSSFWorkbook();
		// ��ȡExcel����
		List<ExcelHeader> headers = getHeaderList(clazz);
		Collections.sort(headers);
		// 
		if(null != list && list.size() > 0 ){
			int sheetCount = list.size() % pageSize == 0 ? list.size() / pageSize : list.size() / pageSize + 1;
			for(int i = 1; i <= sheetCount; i++){
				HSSFSheet sheet = null;
				if(!StringUtils.isEmpty(sheetName)){
					sheet = workbook.createSheet(sheetName + i);
				}else{
					sheet = workbook.createSheet();
				}
				
				HSSFRow row = sheet.createRow(0);
				// д����
				CellStyle titleStyle = setCellStyle(workbook,position_title);
				for(int j = 0; j < headers.size();j++){
					HSSFCell cell = row.createCell(j);
					cell.setCellStyle(titleStyle);
					cell.setCellValue(headers.get(j).getTitle());
					sheet.setColumnWidth(j, headers.get(j).getWidth()*256);
				}
				
				// д����
				Object obj = null;
				CellStyle bodyStyle = setCellStyle(workbook, position_body);
				int begin = (i - 1) * pageSize;
				int end = (begin + pageSize) > list.size() ? list.size() : (begin + pageSize);
				int rowCount = 1;
				for(int n = begin; n < end; n++){
					row = sheet.createRow(rowCount);
					rowCount++;
					obj = list.get(n);
					for(int x = 0; x < headers.size(); x++){
						Cell cell = row.createCell(x);
						cell.setCellStyle(bodyStyle);
						@SuppressWarnings("unchecked")
						Method method = clazz.getDeclaredMethod(headers.get(x).getMethodName());
						Object value = method.invoke(obj);
						if(value instanceof Date){
							 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							 String formattedDate = dateFormat.format(new Date());
							 cell.setCellValue((String)formattedDate);
						}else if(value instanceof Double){
							cell.setCellValue((Double)value);
						}else if(value instanceof String){
							cell.setCellValue((String)value);								
							/*if(((String)value).trim().length()>0 && isNumeric((String)value)){
								cell.setCellType(Cell.CELL_TYPE_STRING);		
								cell.setCellValue((String)value);
							}else{
							}*/
						}else if(value instanceof Integer){
							cell.setCellValue((Integer) value);
						}
						
//						cell.setCellValue(org.apache.commons.beanutils.BeanUtils.getProperty(obj,getPropertyName(headers.get(x))));
					}
				}
			}
		}		
		return workbook;
	}
	
	/**
	 * ע����ʽ����Excel
	 * @author lanyuan
	 * @Email��mmm333zzz520@163.com
	 * @date��2014-4-18
	 * @param response HttpServletResponse
	 * @param fileName ����Excel���ļ���
	 * @param List<T> objs ĳһ��ʵ�������ݼ���
	 * @param clazz <T> ĳһ��ʵ����
	 * @param sheetName sheet������
	 * @param pageSize sheet��ʾ����������
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static void exportToExcel(HttpServletResponse response,String fileName,List objs, Class clazz,
			String sheetName, int pageSize){
		OutputStream out = null;
		try {
			String tempName = new String(fileName.getBytes(), "ISO8859-1");
			response.setHeader("content-disposition", "attachment;filename=" + tempName + ".xls");
			response.setContentType("application/vnd.ms-excel");
			HSSFWorkbook workbook = handleDataToExcel(objs, clazz, "sheet", pageSize);
			out = response.getOutputStream();
			workbook.write(out);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				out.flush();
				out.close();
			} catch (IOException e) {
			}
		}
	}
	
	/**
	 * ���ݷ�����ȡ�ֶ���
	 * @param excelHeader
	 * @return
	 */
	private static String getPropertyName(ExcelHeader excelHeader) {
		String temp = excelHeader.getMethodName().substring(3);
		return temp.substring(0, 1).toLowerCase() + temp.substring(1);
	}

	/**
	 * ���ñ����ʽ
	 * @param workbook
	 * @param position
	 * @return
	 */
	private static CellStyle setCellStyle(HSSFWorkbook workbook,
			String position) {
		
		CellStyle style = workbook.createCellStyle();
		// ���õ�Ԫ������ˮƽ����ֱ����
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// ���õ�Ԫ��߿�
		style.setBorderBottom((short)1);
		style.setBorderLeft((short)1);
		style.setBorderRight((short)1);
		style.setBorderTop((short)1);
		// ���õ�Ԫ������
		HSSFFont font = workbook.createFont();
		font.setFontName("����");
		if(position_title.equals(position)){
			font.setFontHeightInPoints((short)11);
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		}else{
			font.setFontHeightInPoints((short)10);
		}
		style.setFont(font);
		style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index); 
		style.setWrapText(true);
		return style;
	}

	/**
	 * ��ȡexcel�����б�
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private static List<ExcelHeader> getHeaderList(Class clazz) {
		
		List<ExcelHeader> headers = new ArrayList<ExcelHeader>();
		java.lang.reflect.Method [] ms = clazz.getDeclaredMethods();
		for(java.lang.reflect.Method m : ms){
			String mn = m.getName();
			if(mn.startsWith("get")){
				if(m.isAnnotationPresent(ExcelDataMapper.class)){
					ExcelDataMapper dataMapper = m.getAnnotation(ExcelDataMapper.class);
					headers.add(new ExcelHeader(dataMapper.title(), dataMapper.order(),dataMapper.width(), mn));
				}
			}
		}
		return headers;
	}
	

	private static boolean isNumeric(String str){
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if(!isNum.matches()){
			return false;			
		}else{
			return true;
		}
			
	}
}