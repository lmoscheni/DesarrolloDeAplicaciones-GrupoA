package ar.edu.unq.desapp.grupoa.parser;

import java.util.Date;

import org.codehaus.jackson.JsonGenerationException;

import ar.edu.unq.desapp.grupoa.model.Accounts.AccountEnum;
import ar.edu.unq.desapp.grupoa.model.Bills.BillA;
import ar.edu.unq.desapp.grupoa.model.Bills.BillB;
import ar.edu.unq.desapp.grupoa.model.Bills.BillC;
import ar.edu.unq.desapp.grupoa.model.Bills.BillD;
import ar.edu.unq.desapp.grupoa.model.Bills.BillX;
import ar.edu.unq.desapp.grupoa.model.Category.Category;
import ar.edu.unq.desapp.grupoa.model.Operation.Operation;
import ar.edu.unq.desapp.grupoa.model.Operation.OperationTypeEnum;
import ar.edu.unq.desapp.grupoa.model.System.Shift;
import ar.edu.unq.desapp.grupoa.model.System.Voucher;
import ar.edu.unq.desapp.grupoa.services.CategoryService;

public class Parser {

    public static Operation parseOperation(Operation o,final String jsonOperation, CategoryService categoryService) throws Exception {
        String[] tokens = getTokens(jsonOperation);
        
        o.setAmount(Double.parseDouble(tokens[2]));
        o.setShift(Shift.create(tokens[4]));
        Category category = categoryService.findByName(tokens[6]);
        o.setCategory(category);
        OperationTypeEnum operationType = null;
        
        if(tokens[8].equals("true")){
            operationType = OperationTypeEnum.INCOME;
        }else{
            operationType = OperationTypeEnum.EGRESS;
        }
        
        o.setSubcategory(tokens[10]);
        o.setOperationTypeEnum(operationType);
        o.setConcept(tokens[12]);
        o.setAccount(AccountEnum.create(tokens[14]));
        return o;
    }
    
    public static Operation parseUpdateOperation(Operation o,final String jsonOperation, CategoryService categoryService) throws Exception {
        String[] tokens = getTokens(jsonOperation);
        
        o.setAmount(Double.parseDouble(tokens[2]));
        o.setShift(Shift.create(tokens[4]));
        Category category = categoryService.findByName(tokens[6]);
        o.setCategory(category);
        OperationTypeEnum operationType = null;
        
        if(tokens[8].equals("true")){
            operationType = OperationTypeEnum.INCOME;
        }else{
            operationType = OperationTypeEnum.EGRESS;
        }
        
        o.setSubcategory(tokens[10]);
        o.setOperationTypeEnum(operationType);
        o.setConcept(tokens[12]);
        o.setAccount(AccountEnum.create(tokens[14]));
        return o;
    }
    
    @SuppressWarnings("deprecation")
    public static Voucher parseVoucher(Voucher voucher,final String jsonVoucher) throws Exception {
        String[] tokens = getTokens(jsonVoucher);
        String[] date = tokens[2].split("-");
        System.out.println(date[0]);
        System.out.println(date[1]);
        System.out.println(date[2]);
        Date d = new Date();
        d.setDate(Integer.parseInt(date[2]));
        d.setMonth(Integer.parseInt(date[1]));
        d.setYear(Integer.parseInt(date[0]));
        
        voucher.setDateOfIssue(d);
        voucher.setSocialReason(tokens[4]);
        voucher.setCuit(tokens[6]);
        voucher.setConcept(tokens[8]);
        voucher.setAmount(Integer.parseInt(tokens[10]));
        
        if(tokens[12].equals("Bill A")){
            BillA billA = new BillA();
            billA.setTaxed(Integer.parseInt(tokens[14]));
            billA.setNoTaxed(Integer.parseInt(tokens[16]));
            billA.setIIBBPerception(Integer.parseInt(tokens[18]));
            billA.setIVA(Integer.parseInt(tokens[20]));
            voucher.setBillType(billA);
        }
        if(tokens[12].equals("Bill B")){
            BillB billB = new BillB();
            voucher.setBillType(billB);
        }
        if(tokens[12].equals("Bill C")){
            BillC billC = new BillC();
            voucher.setBillType(billC);
        }
        if(tokens[12].equals("Bill D")){
            BillD billD = new BillD();
            voucher.setBillType(billD);
        }
        if(tokens[12].equals("Bill X")){
            BillX billX = new BillX();
            voucher.setBillType(billX);
        }
        return voucher;
    }
    
    public static Category parseCategory(final String json, CategoryService categoryService) throws Exception{
        String[] tokens = getTokens(json);
        for(String s : tokens){
            System.out.println(s);
        }
        Category category = categoryService.findByName(tokens[2]);
        for(String subcategory : category.subcategories){
            if(subcategory.equals(tokens[4])){
                throw new Exception("Ya existe subcategoria");
            }
        }
        category.addSubcategory(tokens[4]);
        return category;
    }
    
    private static String[] getTokens(String json){
        String delims = "[\",:{}]+";
        String[] tokens = json.split(delims);
        return tokens;
    }
}
